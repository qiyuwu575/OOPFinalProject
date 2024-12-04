package DAO;

import model.Course;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    
    // 创建新课程
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

    // 更新现有课程
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

    // 删除课程
    public void deleteCourse(int courseId, int institutionId) throws SQLException {
        String sql = "DELETE FROM Courses WHERE course_id = ? AND institution_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            stmt.setInt(2, institutionId);
            stmt.executeUpdate();
        }
    }

    // 根据ID获取课程
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

    // 获取机构的所有课程
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

    // 根据条件搜索课程
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