package model;

/**
 * The Course class represents a course offered by an academic institution.
 * It includes details about the course, such as its code, name, term, schedule, delivery method,
 * and the institution offering the course.
 */
public class Course {

    private int courseId;
    private int institutionId;
    private String courseCode;
    private String courseName;
    private String courseOutline;
    private String term;
    private String schedule;
    private String deliveryMethod;
    private double compensation;
    private String preferredQualifications;
    private String status;
    private String institutionName;

    /**
     * Default constructor for the Course class.
     */
    public Course() {
    }

    /**
     * Constructor for creating a course with minimal details.
     *
     * @param courseCode the course code
     * @param courseName the course name
     * @param term       the term when the course is offered
     */
    public Course(String courseCode, String courseName, String term) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.term = term;
    }

    /**
     * Full constructor for the Course class.
     *
     * @param courseId                the unique identifier of the course
     * @param institutionId           the unique identifier of the institution offering the course
     * @param courseCode              the course code
     * @param courseName              the course name
     * @param courseOutline           the course outline or syllabus
     * @param term                    the term when the course is offered
     * @param schedule                the course schedule
     * @param deliveryMethod          the method of course delivery (e.g., online, in-person)
     * @param compensation            the compensation for the instructor
     * @param preferredQualifications the preferred qualifications for the instructor
     * @param status                  the status of the course
     * @param institutionName         the name of the institution offering the course
     */
    public Course(int courseId, int institutionId, String courseCode, String courseName,
                  String courseOutline, String term, String schedule, String deliveryMethod,
                  double compensation, String preferredQualifications, String status, String institutionName) {
        this.courseId = courseId;
        this.institutionId = institutionId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseOutline = courseOutline;
        this.term = term;
        this.schedule = schedule;
        this.deliveryMethod = deliveryMethod;
        this.compensation = compensation;
        this.preferredQualifications = preferredQualifications;
        this.status = status;
        this.institutionName = institutionName;
    }

    // Getters and Setters

    /**
     * Gets the course ID.
     *
     * @return the course ID
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID.
     *
     * @param courseId the course ID to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the institution ID offering the course.
     *
     * @return the institution ID
     */
    public int getInstitutionId() {
        return institutionId;
    }

    /**
     * Sets the institution ID offering the course.
     *
     * @param institutionId the institution ID to set
     */
    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * Gets the course code.
     *
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code.
     *
     * @param courseCode the course code to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the course name.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     *
     * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the course outline.
     *
     * @return the course outline
     */
    public String getCourseOutline() {
        return courseOutline;
    }

    /**
     * Sets the course outline.
     *
     * @param courseOutline the course outline to set
     */
    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline;
    }

    /**
     * Gets the term of the course.
     *
     * @return the course term
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets the term of the course.
     *
     * @param term the course term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Gets the course schedule.
     *
     * @return the course schedule
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * Sets the course schedule.
     *
     * @param schedule the course schedule to set
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * Gets the course delivery method.
     *
     * @return the delivery method
     */
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Sets the course delivery method.
     *
     * @param deliveryMethod the delivery method to set
     */
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Gets the compensation for the instructor.
     *
     * @return the compensation
     */
    public double getCompensation() {
        return compensation;
    }

    /**
     * Sets the compensation for the instructor.
     *
     * @param compensation the compensation to set
     */
    public void setCompensation(double compensation) {
        this.compensation = compensation;
    }

    /**
     * Gets the preferred qualifications for the instructor.
     *
     * @return the preferred qualifications
     */
    public String getPreferredQualifications() {
        return preferredQualifications;
    }

    /**
     * Sets the preferred qualifications for the instructor.
     *
     * @param preferredQualifications the preferred qualifications to set
     */
    public void setPreferredQualifications(String preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }

    /**
     * Gets the status of the course.
     *
     * @return the course status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the course.
     *
     * @param status the course status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the name of the institution offering the course.
     *
     * @return the institution name
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the name of the institution offering the course.
     *
     * @param institutionName the institution name to set
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * Returns a string representation of the course object.
     *
     * @return a string representing the course object
     */
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", institutionId=" + institutionId +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseOutline='" + courseOutline + '\'' +
                ", term='" + term + '\'' +
                ", schedule='" + schedule + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", compensation=" + compensation +
                ", preferredQualifications='" + preferredQualifications + '\'' +
                ", status='" + status + '\'' +
                ", institutionName='" + institutionName + '\'' +
                '}';
    }
}
