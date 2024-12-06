package DAO;

import model.User;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The UserDAO class provides methods for managing user data in the database.
 * It supports operations such as user registration, login, checking email existence,
 * and retrieving a list of institutions.
 */
public class UserDAO {

    /**
     * Registers a new user in the database.
     *
     * @param user the User object containing the user's details
     * @return true if the registration was successful, false otherwise
     */
    public boolean registerUser(User user) {
        String sql = "INSERT INTO Users (name, email, password, user_type, current_institution, academic_position) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getUserType());
            stmt.setString(5, user.getCurrentInstitution());
            stmt.setString(6, user.getAcademicPosition());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Authenticates a user by verifying their email and password.
     *
     * @param email    the user's email
     * @param password the user's password
     * @return a User object if authentication is successful, or null if it fails
     */
    public User loginUser(String email, String password) {
        String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("user_type"));
                user.setCurrentInstitution(rs.getString("current_institution"));
                user.setAcademicPosition(rs.getString("academic_position"));
                user.setCreatedAt(rs.getString("created_at"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Checks if an email is already registered in the database.
     *
     * @param email the email to check
     * @return true if the email exists, false otherwise
     */
    public boolean isEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM Users WHERE email = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retrieves a list of all academic institutions from the database.
     *
     * @return a list of User objects representing academic institutions
     */
    public List<User> getAllInstitutions() {
        List<User> institutions = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE user_type = 'AcademicInstitution'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User institution = new User();
                institution.setUserId(rs.getInt("user_id"));
                institution.setName(rs.getString("name"));
                institution.setEmail(rs.getString("email"));
                institution.setUserType(rs.getString("user_type"));
                institutions.add(institution);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return institutions;
    }
}
