package model;

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

    // 默认构造函数
    public Course() {
    }

    // 带参数的构造函数
    public Course(String courseCode, String courseName, String term) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.term = term;
    }

    // 完整的构造函数
    public Course(int courseId, int institutionId, String courseCode, String courseName, 
                 String courseOutline, String term, String schedule, String deliveryMethod, 
                 double compensation, String preferredQualifications, String status,String institutionName) {
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
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseOutline() {
        return courseOutline;
    }

    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public double getCompensation() {
        return compensation;
    }

    public void setCompensation(double compensation) {
        this.compensation = compensation;
    }

    public String getPreferredQualifications() {
        return preferredQualifications;
    }

    public void setPreferredQualifications(String preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }


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