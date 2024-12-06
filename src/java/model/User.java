package model;

/**
 * The User class represents a user in the system.
 * It supports both Academic Professionals and Academic Institutions with distinct constructors.
 * Includes details such as name, email, password, user type, and other relevant attributes.
 */
public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String userType;
    private String currentInstitution;
    private String academicPosition;
    private String createdAt;

    /**
     * Default constructor for the User class.
     */
    public User() {
    }

    /**
     * Constructor for creating an Academic Professional user.
     *
     * @param name              the name of the academic professional
     * @param email             the email of the academic professional
     * @param password          the password of the academic professional
     * @param currentInstitution the current institution of the academic professional
     * @param academicPosition  the academic position of the professional
     */
    public User(String name, String email, String password, String currentInstitution, String academicPosition) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = "AcademicProfessional";
        this.currentInstitution = currentInstitution;
        this.academicPosition = academicPosition;
    }

    /**
     * Constructor for creating an Academic Institution user.
     *
     * @param institutionName the name of the academic institution
     * @param email           the email of the academic institution
     * @param password        the password of the academic institution
     */
    public User(String institutionName, String email, String password) {
        this.name = institutionName;
        this.email = email;
        this.password = password;
        this.userType = "AcademicInstitution";
    }

    // Getters and Setters

    /**
     * Gets the user ID.
     *
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the name of the user.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the user's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the user.
     *
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the user's email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the user's password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the type of the user (e.g., AcademicProfessional, AcademicInstitution).
     *
     * @return the user type
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the type of the user.
     *
     * @param userType the user type to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Gets the current institution of the user.
     *
     * @return the current institution
     */
    public String getCurrentInstitution() {
        return currentInstitution;
    }

    /**
     * Sets the current institution of the user.
     *
     * @param currentInstitution the current institution to set
     */
    public void setCurrentInstitution(String currentInstitution) {
        this.currentInstitution = currentInstitution;
    }

    /**
     * Gets the academic position of the user (if applicable).
     *
     * @return the academic position
     */
    public String getAcademicPosition() {
        return academicPosition;
    }

    /**
     * Sets the academic position of the user.
     *
     * @param academicPosition the academic position to set
     */
    public void setAcademicPosition(String academicPosition) {
        this.academicPosition = academicPosition;
    }

    /**
     * Gets the account creation timestamp.
     *
     * @return the creation timestamp
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the account creation timestamp.
     *
     * @param createdAt the creation timestamp to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
