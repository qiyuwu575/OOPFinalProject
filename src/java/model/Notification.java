package model;

import java.sql.Timestamp;

/**
 * The Notification class represents a notification sent to a user.
 * It includes details such as the notification message, type, creation timestamp, and read status.
 */
public class Notification {

    private int notificationId;
    private int userId;
    private String message;
    private boolean isRead;
    private Timestamp createdAt;
    private String type;
    private int referenceId;

    /**
     * Gets the ID of the notification.
     *
     * @return the notification ID
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the ID of the notification.
     *
     * @param notificationId the notification ID to set
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Gets the ID of the user who received the notification.
     *
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who received the notification.
     *
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the message content of the notification.
     *
     * @return the notification message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the notification.
     *
     * @param message the notification message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Checks if the notification has been read.
     *
     * @return true if the notification has been read, false otherwise
     */
    public boolean isRead() {
        return isRead;
    }

    /**
     * Sets the read status of the notification.
     *
     * @param read the read status to set (true if read, false otherwise)
     */
    public void setRead(boolean read) {
        isRead = read;
    }

    /**
     * Gets the timestamp when the notification was created.
     *
     * @return the creation timestamp
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the timestamp when the notification was created.
     *
     * @param createdAt the creation timestamp to set
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the type of the notification (e.g., informational, warning, error).
     *
     * @return the notification type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the notification.
     *
     * @param type the notification type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the reference ID associated with the notification (e.g., application ID or other related entity).
     *
     * @return the reference ID
     */
    public int getReferenceId() {
        return referenceId;
    }

    /**
     * Sets the reference ID associated with the notification.
     *
     * @param referenceId the reference ID to set
     */
    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }
}
