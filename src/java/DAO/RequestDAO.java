package DAO;

import model.Request;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The RequestDAO class provides methods for managing requests in the database.
 * It supports creating new requests.
 */
public class RequestDAO {

    /**
     * Creates a new request in the database.
     * The status of the request is set to 'Pending' by default.
     *
     * @param request the Request object containing the details of the request to be created
     * @throws RuntimeException if a database access error occurs
     */
    public void createRequest(Request request) {
        String sql = "INSERT INTO Requests (course_id, professional_id, status) VALUES (?, ?, 'Pending')";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, request.getCourseId());
            stmt.setInt(2, request.getProfessionalId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating request", e);
        }
    }
}
