package model;

public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String userType;
    private String currentInstitution;
    private String academicPosition;
    private String createdAt;

    // 默认构造函数
    public User() {
    }

    // Academic Professional 构造函数
    public User(String name, String email, String password, String currentInstitution, String academicPosition) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = "AcademicProfessional";
        this.currentInstitution = currentInstitution;
        this.academicPosition = academicPosition;
    }

    // Academic Institution 构造函数
    public User(String institutionName, String email, String password) {
        this.name = institutionName;
        this.email = email;
        this.password = password;
        this.userType = "AcademicInstitution";
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCurrentInstitution() {
        return currentInstitution;
    }

    public void setCurrentInstitution(String currentInstitution) {
        this.currentInstitution = currentInstitution;
    }

    public String getAcademicPosition() {
        return academicPosition;
    }

    public void setAcademicPosition(String academicPosition) {
        this.academicPosition = academicPosition;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}