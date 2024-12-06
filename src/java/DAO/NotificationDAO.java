package DAO;

import model.Notification;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The NotificationDAO class provides methods for managing notifications in the database.
 * It supports creating new notifications, fetching unread notifications, and marking notifications as read.
 */
public class NotificationDAO {

    /**
     * Creates a new notification in the database.
     *
     * @param userId      the ID of the user to whom the notification is sent
     * @param message     the message content of the notification
     * @param type        the type of the notification (e.g., APPLICATION_STATUS, ALERT)
     * @param referenceId the ID of the related entity (e.g., application or course)
     * @throws SQLException if a database access error occurs
     */
    public void createNotification(int userId, String message, String type, int referenceId) throws SQLException {
        String sql = "INSERT INTO Notifications (user_id, message, type, reference_id, is_read, created_at) " +
                     "VALUES (?, ?, ?, ?, false, NOW())";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setString(2, message);
            stmt.setString(3, type);
            stmt.setInt(4, referenceId);
            stmt.executeUpdate();
        }
    }

    /**
     * Retrieves a list of unread notifications for a specific user.
     *
     * @param userId the ID of the user
     * @return a list of unread Notification objects, sorted by creation time in descending order
     */
    public List<Notification> getUnreadNotifications(int userId) {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM Notifications WHERE user_id = ? AND is_read = false ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotificationId(rs.getInt("notification_id"));
                notification.setMessage(rs.getString("message"));
                notification.setCreatedAt(rs.getTimestamp("created_at"));
                notification.setType(rs.getString("type"));
                notification.setReferenceId(rs.getInt("reference_id"));
                notifications.add(notification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }

    /**
     * Marks a notification as read in the database.
     *
     * @param notificationId the ID of the notification to mark as read
     * @throws SQLException if a database access error occurs
     */
    public void markAsRead(int notificationId) throws SQLException {
        String sql = "UPDATE Notifications SET is_read = true WHERE notification_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, notificationId);
            stmt.executeUpdate();
        }
    }
}
