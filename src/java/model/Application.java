package model;

import java.util.Date;

/**
 * The Application class represents an application submitted by a professional for a course.
 * It includes details about the application, course, professional, and associated institution.
 */
public class Application {

    private int applicationId;
    private int courseId;
    private int professionalId;
    private String status;
    private Date applicationDate;
    private String courseName;
    private String courseCode;
    private String professionalName;
    private String currentPosition;
    private String institutionName;

    /**
     * Default constructor for the Application class.
     */
    public Application() {
    }

    /**
     * Gets the ID of the application.
     *
     * @return the application ID
     */
    public int getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the ID of the application.
     *
     * @param applicationId the application ID to set
     */
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Gets the ID of the course associated with the application.
     *
     * @return the course ID
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets the ID of the course associated with the application.
     *
     * @param courseId the course ID to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the ID of the professional who submitted the application.
     *
     * @return the professional ID
     */
    public int getProfessionalId() {
        return professionalId;
    }

    /**
     * Sets the ID of the professional who submitted the application.
     *
     * @param professionalId the professional ID to set
     */
    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * Gets the status of the application.
     *
     * @return the application status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the application.
     *
     * @param status the application status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the date the application was submitted.
     *
     * @return the application date
     */
    public Date getApplicationDate() {
        return applicationDate;
    }

    /**
     * Sets the date the application was submitted.
     *
     * @param applicationDate the application date to set
     */
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    /**
     * Gets the name of the course associated with the application.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course associated with the application.
     *
     * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the code of the course associated with the application.
     *
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the code of the course associated with the application.
     *
     * @param courseCode the course code to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the name of the professional who submitted the application.
     *
     * @return the professional's name
     */
    public String getProfessionalName() {
        return professionalName;
    }

    /**
     * Sets the name of the professional who submitted the application.
     *
     * @param professionalName the professional's name to set
     */
    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    /**
     * Gets the current position of the professional who submitted the application.
     *
     * @return the professional's current position
     */
    public String getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Sets the current position of the professional who submitted the application.
     *
     * @param currentPosition the professional's current position to set
     */
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     * Gets the name of the institution associated with the application.
     *
     * @return the institution name
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the name of the institution associated with the application.
     *
     * @param institutionName the institution name to set
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
