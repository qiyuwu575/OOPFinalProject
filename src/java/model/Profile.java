package model;

/**
 * The Profile class represents a user's profile.
 * It includes details about the user's current position, institution, education background,
 * area of expertise, and institution address if applicable.
 */
public class Profile {

    private int profileId;
    private int userId;
    private String currentPosition;
    private String currentInstitution;
    private String educationBackground;
    private String areaOfExpertise;
    private String institutionAddress;

    /**
     * Gets the ID of the profile.
     *
     * @return the profile ID
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * Sets the ID of the profile.
     *
     * @param profileId the profile ID to set
     */
    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    /**
     * Gets the ID of the user associated with this profile.
     *
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user associated with this profile.
     *
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the current position of the user.
     *
     * @return the current position
     */
    public String getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Sets the current position of the user.
     *
     * @param currentPosition the current position to set
     */
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     * Gets the current institution where the user is working or associated.
     *
     * @return the current institution
     */
    public String getCurrentInstitution() {
        return currentInstitution;
    }

    /**
     * Sets the current institution where the user is working or associated.
     *
     * @param currentInstitution the current institution to set
     */
    public void setCurrentInstitution(String currentInstitution) {
        this.currentInstitution = currentInstitution;
    }

    /**
     * Gets the education background of the user.
     *
     * @return the education background
     */
    public String getEducationBackground() {
        return educationBackground;
    }

    /**
     * Sets the education background of the user.
     *
     * @param educationBackground the education background to set
     */
    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    /**
     * Gets the area of expertise of the user.
     *
     * @return the area of expertise
     */
    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    /**
     * Sets the area of expertise of the user.
     *
     * @param areaOfExpertise the area of expertise to set
     */
    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    /**
     * Gets the address of the institution associated with the profile.
     *
     * @return the institution address
     */
    public String getInstitutionAddress() {
        return institutionAddress;
    }

    /**
     * Sets the address of the institution associated with the profile.
     *
     * @param institutionAddress the institution address to set
     */
    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }
}
