package DAO;

import model.Application;
import model.Notification;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    // 获取专业人员的所有申请
    public List<Application> getApplicationsByProfessional(int professionalId) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT a.*, c.course_name, c.course_code, i.name as institution_name " +
                     "FROM Applications a " +
                     "JOIN Courses c ON a.course_id = c.course_id " +
                     "JOIN Users i ON c.institution_id = i.user_id " +
                     "WHERE a.professional_id = ?";

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
                app.setApplicationDate(rs.getDate("application_date"));
                app.setCourseName(rs.getString("course_name"));
                app.setCourseCode(rs.getString("course_code"));
                app.setInstitutionName(rs.getString("institution_name"));
                applications.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    // 更新申请状态并创建通知
    public void updateApplicationStatus(int applicationId, String status) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            // 更新申请状态
            String sql = "UPDATE Applications SET status = ? WHERE application_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, status);
                stmt.setInt(2, applicationId);
                stmt.executeUpdate();
            }

            // 获取申请相关信息
            String getSql = "SELECT a.professional_id, c.course_name FROM Applications a " +
                            "JOIN Courses c ON a.course_id = c.course_id WHERE a.application_id = ?";
            int professionalId = 0;
            String courseName = "";
            try (PreparedStatement stmt = conn.prepareStatement(getSql)) {
                stmt.setInt(1, applicationId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    professionalId = rs.getInt("professional_id");
                    courseName = rs.getString("course_name");
                }
            }

            // 创建通知
            NotificationDAO notificationDAO = new NotificationDAO();
            String message = String.format("Your application for course %s has been %s", 
                                           courseName, status.toLowerCase());
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

    // 获取机构的所有申请
    public List<Application> getApplicationsByInstitution(int institutionId) {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT a.*, c.course_name, c.course_code, p.name as professional_name, p.current_position " +
                     "FROM Applications a " +
                     "JOIN Courses c ON a.course_id = c.course_id " +
                     "JOIN Users p ON a.professional_id = p.user_id " +
                     "WHERE c.institution_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, institutionId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Application app = new Application();
                app.setApplicationId(rs.getInt("application_id"));
                app.setCourseId(rs.getInt("course_id"));
                app.setProfessionalId(rs.getInt("professional_id"));
                app.setStatus(rs.getString("status"));
                app.setApplicationDate(rs.getDate("application_date"));
                app.setCourseName(rs.getString("course_name"));
                app.setCourseCode(rs.getString("course_code"));
                app.setProfessionalName(rs.getString("professional_name"));
                app.setCurrentPosition(rs.getString("current_position"));
                applications.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }
}