/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import java.util.List;
import model.Application;
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
public class ApplicationDAOTest {
    
    public ApplicationDAOTest() {
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
     * Test of getApplicationsByProfessionalId method, of class ApplicationDAO.
     */
    @Test
    public void testGetApplicationsByProfessionalId() {
        System.out.println("getApplicationsByProfessionalId");
        int professionalId = 0;
        ApplicationDAO instance = new ApplicationDAO();
        List<Application> expResult = null;
        List<Application> result = instance.getApplicationsByProfessionalId(professionalId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createApplication method, of class ApplicationDAO.
     */
    @Test
    public void testCreateApplication() throws Exception {
        System.out.println("createApplication");
        int courseId = 0;
        int professionalId = 0;
        ApplicationDAO instance = new ApplicationDAO();
        instance.createApplication(courseId, professionalId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecentApplications method, of class ApplicationDAO.
     */
    @Test
    public void testGetRecentApplications() {
        System.out.println("getRecentApplications");
        int professionalId = 0;
        int limit = 0;
        ApplicationDAO instance = new ApplicationDAO();
        List<Application> expResult = null;
        List<Application> result = instance.getRecentApplications(professionalId, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processApplication method, of class ApplicationDAO.
     */
    @Test
    public void testProcessApplication() throws Exception {
        System.out.println("processApplication");
        int applicationId = 0;
        String status = "";
        int institutionId = 0;
        ApplicationDAO instance = new ApplicationDAO();
        instance.processApplication(applicationId, status, institutionId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
