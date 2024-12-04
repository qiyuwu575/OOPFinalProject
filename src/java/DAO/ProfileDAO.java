package DAO;

import model.Profile;
import model.Course;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

public class ProfileDAO {
    
    public boolean updateProfile(Profile profile) {
    String sql = "INSERT INTO Professional_Profiles (user_id, current_position, " +
                "current_institution, education_background, area_of_expertise) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "current_position = VALUES(current_position), " +
                "current_institution = VALUES(current_institution), " +
                "education_background = VALUES(education_background), " +
                "area_of_expertise = VALUES(area_of_expertise)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, profile.getUserId());
        stmt.setString(2, profile.getCurrentPosition());
        stmt.setString(3, profile.getCurrentInstitution());
        stmt.setString(4, profile.getEducationBackground());
        stmt.setString(5, profile.getAreaOfExpertise());

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public Profile getProfileByUserId(int userId) {
        String sql = "SELECT * FROM Professional_Profiles WHERE user_id = ?";
        Profile profile = null;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                profile = new Profile();
                profile.setProfileId(rs.getInt("profile_id"));
                profile.setUserId(rs.getInt("user_id"));
                profile.setCurrentPosition(rs.getString("current_position"));
                profile.setCurrentInstitution(rs.getString("current_institution"));
                profile.setEducationBackground(rs.getString("education_background"));
                profile.setAreaOfExpertise(rs.getString("area_of_expertise"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;
    }
    
    public void saveAcademicProfessionalProfile(Profile profile) {
        String sql = "INSERT INTO Professional_Profiles (user_id, current_position, " +
                    "current_institution, education_background, area_of_expertise) " +
                    "VALUES (?, ?, ?, ?, ?)";
                    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, profile.getUserId());
            stmt.setString(2, profile.getCurrentPosition());
            stmt.setString(3, profile.getCurrentInstitution());
            stmt.setString(4, profile.getEducationBackground());
            stmt.setString(5, profile.getAreaOfExpertise());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving professional profile", e);
        }
    }
    
    public void saveAcademicInstitutionProfile(Profile profile, List<Course> courses) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            
            // Save institution profile
            String profileSql = "INSERT INTO Institution_Profiles (user_id, address) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(profileSql)) {
                stmt.setInt(1, profile.getUserId());
                stmt.setString(2, profile.getInstitutionAddress());
                stmt.executeUpdate();
            }
            
            // Save courses
            String courseSql = "INSERT INTO Courses (institution_id, course_code, course_name, term) " +
                             "VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(courseSql)) {
                for (Course course : courses) {
                    stmt.setInt(1, profile.getUserId());
                    stmt.setString(2, course.getCourseCode());
                    stmt.setString(3, course.getCourseName());
                    stmt.setString(4, course.getTerm());
                    stmt.executeUpdate();
                }
            }
            
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw new RuntimeException("Error saving institution profile", e);
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}