/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import java.util.List;
import model.Course;
import model.Profile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author qiyuw
 */
public class ProfileDAOTest {
    
    public ProfileDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateProfile method, of class ProfileDAO.
     */
    @Test
    public void testUpdateProfile() {
        System.out.println("updateProfile");
        Profile profile = null;
        ProfileDAO instance = new ProfileDAO();
        boolean expResult = false;
        boolean result = instance.updateProfile(profile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfileByUserId method, of class ProfileDAO.
     */
    @Test
    public void testGetProfileByUserId() {
        System.out.println("getProfileByUserId");
        int userId = 0;
        ProfileDAO instance = new ProfileDAO();
        Profile expResult = null;
        Profile result = instance.getProfileByUserId(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAcademicProfessionalProfile method, of class ProfileDAO.
     */
    @Test
    public void testSaveAcademicProfessionalProfile() {
        System.out.println("saveAcademicProfessionalProfile");
        Profile profile = null;
        ProfileDAO instance = new ProfileDAO();
        instance.saveAcademicProfessionalProfile(profile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAcademicInstitutionProfile method, of class ProfileDAO.
     */
    @Test
    public void testSaveAcademicInstitutionProfile() {
        System.out.println("saveAcademicInstitutionProfile");
        Profile profile = null;
        List<Course> courses = null;
        ProfileDAO instance = new ProfileDAO();
        instance.saveAcademicInstitutionProfile(profile, courses);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
