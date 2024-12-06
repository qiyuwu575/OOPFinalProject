package DAO;

import model.Application;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The ApplicationDAO class provides methods for managing applications in the database.
 * It allows retrieving, creating, and processing applications as well as generating notifications.
 */
public class ApplicationDAO {

    /**
     * Retrieves a list of applications for a given professional by their ID.
     * 
     * @param professionalId the ID of the professional
     * @return a list of applications associated with the given professional
     */
    public List<Application> getApplicationsByProfessionalId(int professionalId) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT a.*, c.course_name, c.course_code " +
                    "FROM Applications a " +
                    "JOIN Courses c ON a.course_id = c.course_id " +
                    "WHERE a.professional_id = ? " +
                    "ORDER BY a.application_date DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, professionalId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Application app = new Application();
                app.setApplicationId(rs.getInt("application_id"));
                app.setCourseId(rs.getInt("course_id"));
                app.setProfessionalId(rs.getInt("professional_id"));
                app.setStatus(rs.getString("status"));
                app.setApplicationDate(rs.getTimestamp("application_date"));
                app.setCourseName(rs.getString("course_name"));
                app.setCourseCode(rs.getString("course_code"));
                applications.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    /**
     * Creates a new application in the database with a pending status.
     * 
     * @param courseId the ID of the course
     * @param professionalId the ID of the professional
     * @throws SQLException if a database access error occurs or the creation fails
     */
    public void createApplication(int courseId, int professionalId) throws SQLException {
        String sql = "INSERT INTO Applications (course_id, professional_id, status, application_date) " +
                    "VALUES (?, ?, 'PENDING', NOW())";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            stmt.setInt(2, professionalId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Creating application failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Retrieves a limited number of the most recent applications for a given professional.
     * 
     * @param professionalId the ID of the professional
     * @param limit the maximum number of applications to retrieve
     * @return a list of the most recent applications
     */
    public List<Application> getRecentApplications(int professionalId, int limit) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT a.*, c.course_name, c.course_code " +
                    "FROM Applications a " +
                    "JOIN Courses c ON a.course_id = c.course_id " +
                    "WHERE a.professional_id = ? " +
                    "ORDER BY a.application_date DESC LIMIT ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, professionalId);
            stmt.setInt(2, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Application app = new Application();
                app.setApplicationId(rs.getInt("application_id"));
                app.setStatus(rs.getString("status"));
                app.setApplicationDate(rs.getTimestamp("application_date"));
                app.setCourseName(rs.getString("course_name"));
                app.setCourseCode(rs.getString("course_code"));
                applications.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    /**
     * Processes an application by updating its status and generating a notification.
     * 
     * @param applicationId the ID of the application to process
     * @param status the new status of the application (e.g., APPROVED, REJECTED)
     * @param institutionId the ID of the institution managing the application
     * @throws SQLException if a database access error occurs or the process fails
     */
    public void processApplication(int applicationId, String status, int institutionId) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            // Update application status
            String updateSql = "UPDATE Applications SET status = ? WHERE application_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(updateSql)) {
                stmt.setString(1, status);
                stmt.setInt(2, applicationId);
                stmt.executeUpdate();
            }

            // Retrieve application details for notification
            String selectSql = "SELECT a.professional_id, c.course_code, c.term, i.name as institution_name " +
                              "FROM Applications a " +
                              "JOIN Courses c ON a.course_id = c.course_id " +
                              "JOIN Institutions i ON c.institution_id = i.institution_id " +
                              "WHERE a.application_id = ?";

            int professionalId = 0;
            String courseCode = "";
            String term = "";
            String institutionName = "";

            try (PreparedStatement stmt = conn.prepareStatement(selectSql)) {
                stmt.setInt(1, applicationId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    professionalId = rs.getInt("professional_id");
                    courseCode = rs.getString("course_code");
                    term = rs.getString("term");
                    institutionName = rs.getString("institution_name");
                }
            }

            // Create notification
            String message = String.format("Your request to teach %s for %s has been %s by %s",
                                         courseCode, term, status.toLowerCase(), institutionName);

            NotificationDAO notificationDAO = new NotificationDAO();
            notificationDAO.createNotification(professionalId, message, "APPLICATION_STATUS", applicationId);

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}
