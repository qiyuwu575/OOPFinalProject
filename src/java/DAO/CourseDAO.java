package DAO;

import model.Course;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The CourseDAO class provides methods for managing courses in the database.
 * It supports CRUD operations, fetching courses by various criteria, and searching for courses.
 */
public class CourseDAO {

    /**
     * Creates a new course in the database.
     *
     * @param course the Course object containing course details to be created
     * @throws SQLException if a database access error occurs
     */
    public void createCourse(Course course) throws SQLException {
        String sql = "INSERT INTO Courses (institution_id, course_code, course_name, term, " +
                     "course_outline, schedule, delivery_method, compensation, preferred_qualifications) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, course.getInstitutionId());
            stmt.setString(2, course.getCourseCode());
            stmt.setString(3, course.getCourseName());
            stmt.setString(4, course.getTerm());
            stmt.setString(5, course.getCourseOutline());
            stmt.setString(6, course.getSchedule());
            stmt.setString(7, course.getDeliveryMethod());
            stmt.setDouble(8, course.getCompensation());
            stmt.setString(9, course.getPreferredQualifications());
            stmt.executeUpdate();
        }
    }

    /**
     * Updates an existing course in the database.
     *
     * @param course the Course object containing updated course details
     * @throws SQLException if a database access error occurs
     */
    public void updateCourse(Course course) throws SQLException {
        String sql = "UPDATE Courses SET course_code = ?, course_name = ?, term = ?, " +
                     "course_outline = ?, schedule = ?, delivery_method = ?, " +
                     "compensation = ?, preferred_qualifications = ? " +
                     "WHERE course_id = ? AND institution_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getCourseCode());
            stmt.setString(2, course.getCourseName());
            stmt.setString(3, course.getTerm());
            stmt.setString(4, course.getCourseOutline());
            stmt.setString(5, course.getSchedule());
            stmt.setString(6, course.getDeliveryMethod());
            stmt.setDouble(7, course.getCompensation());
            stmt.setString(8, course.getPreferredQualifications());
            stmt.setInt(9, course.getCourseId());
            stmt.setInt(10, course.getInstitutionId());
            stmt.executeUpdate();
        }
    }

    /**
     * Deletes a course from the database.
     *
     * @param courseId      the ID of the course to be deleted
     * @param institutionId the ID of the institution associated with the course
     * @throws SQLException if a database access error occurs
     */
    public void deleteCourse(int courseId, int institutionId) throws SQLException {
        String sql = "DELETE FROM Courses WHERE course_id = ? AND institution_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            stmt.setInt(2, institutionId);
            stmt.executeUpdate();
        }
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param courseId the ID of the course to retrieve
     * @return a Course object representing the course, or null if not found
     */
    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM Courses WHERE course_id = ?";
        Course course = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setInstitutionId(rs.getInt("institution_id"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                course.setTerm(rs.getString("term"));
                course.setCourseOutline(rs.getString("course_outline"));
                course.setSchedule(rs.getString("schedule"));
                course.setDeliveryMethod(rs.getString("delivery_method"));
                course.setCompensation(rs.getDouble("compensation"));
                course.setPreferredQualifications(rs.getString("preferred_qualifications"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    /**
     * Retrieves all courses associated with a specific institution.
     *
     * @param institutionId the ID of the institution
     * @return a list of Course objects representing the courses
     */
    public List<Course> getCoursesByInstitution(int institutionId) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Courses WHERE institution_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, institutionId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setInstitutionId(rs.getInt("institution_id"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                course.setTerm(rs.getString("term"));
                course.setCourseOutline(rs.getString("course_outline"));
                course.setSchedule(rs.getString("schedule"));
                course.setDeliveryMethod(rs.getString("delivery_method"));
                course.setCompensation(rs.getDouble("compensation"));
                course.setPreferredQualifications(rs.getString("preferred_qualifications"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Retrieves all courses in the database.
     *
     * @return a list of Course objects representing all courses
     */
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Courses";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setInstitutionId(rs.getInt("institution_id"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                course.setTerm(rs.getString("term"));
                course.setCourseOutline(rs.getString("course_outline"));
                course.setSchedule(rs.getString("schedule"));
                course.setDeliveryMethod(rs.getString("delivery_method"));
                course.setCompensation(rs.getDouble("compensation"));
                course.setPreferredQualifications(rs.getString("preferred_qualifications"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Searches for courses based on optional filters such as course code, course name, and term.
     *
     * @param courseCode the course code to filter by (partial match), or null to ignore
     * @param courseName the course name to filter by (partial match), or null to ignore
     * @param term       the term to filter by (exact match), or null to ignore
     * @return a list of Course objects matching the search criteria
     */
    public List<Course> searchCourses(String courseCode, String courseName, String term) {
        List<Course> courses = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Courses WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (courseCode != null && !courseCode.isEmpty()) {
            sql.append(" AND course_code LIKE ?");
            params.add("%" + courseCode + "%");
        }
        if (courseName != null && !courseName.isEmpty()) {
            sql.append(" AND course_name LIKE ?");
            params.add("%" + courseName + "%");
        }
        if (term != null && !term.isEmpty()) {
            sql.append(" AND term = ?");
            params.add(term);
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setInstitutionId(rs.getInt("institution_id"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                course.setTerm(rs.getString("term"));
                course.setCourseOutline(rs.getString("course_outline"));
                course.setSchedule(rs.getString("schedule"));
                course.setDeliveryMethod(rs.getString("delivery_method"));
                course.setCompensation(rs.getDouble("compensation"));
                course.setPreferredQualifications(rs.getString("preferred_qualifications"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
