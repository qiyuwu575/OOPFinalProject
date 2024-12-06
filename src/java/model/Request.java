package model;

/**
 * The Request class represents a request made by a professional for a course.
 * It includes details about the request, such as the course ID, professional ID, and request status.
 */
public class Request {

    private int requestId;
    private int courseId;
    private int professionalId;
    private String status;

    /**
     * Gets the ID of the request.
     *
     * @return the request ID
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Sets the ID of the request.
     *
     * @param requestId the request ID to set
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets the ID of the course associated with the request.
     *
     * @return the course ID
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets the ID of the course associated with the request.
     *
     * @param courseId the course ID to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the ID of the professional who made the request.
     *
     * @return the professional ID
     */
    public int getProfessionalId() {
        return professionalId;
    }

    /**
     * Sets the ID of the professional who made the request.
     *
     * @param professionalId the professional ID to set
     */
    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * Gets the status of the request.
     *
     * @return the request status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the request.
     *
     * @param status the request status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
