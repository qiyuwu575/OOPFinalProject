package DAO;

import model.Request;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestDAO {

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