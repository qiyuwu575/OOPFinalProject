/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

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
public class RequestTest {
    
    public RequestTest() {
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
     * Test of getRequestId method, of class Request.
     */
    @Test
    public void testGetRequestId() {
        System.out.println("getRequestId");
        Request instance = new Request();
        int expResult = 0;
        int result = instance.getRequestId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequestId method, of class Request.
     */
    @Test
    public void testSetRequestId() {
        System.out.println("setRequestId");
        int requestId = 0;
        Request instance = new Request();
        instance.setRequestId(requestId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseId method, of class Request.
     */
    @Test
    public void testGetCourseId() {
        System.out.println("getCourseId");
        Request instance = new Request();
        int expResult = 0;
        int result = instance.getCourseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourseId method, of class Request.
     */
    @Test
    public void testSetCourseId() {
        System.out.println("setCourseId");
        int courseId = 0;
        Request instance = new Request();
        instance.setCourseId(courseId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfessionalId method, of class Request.
     */
    @Test
    public void testGetProfessionalId() {
        System.out.println("getProfessionalId");
        Request instance = new Request();
        int expResult = 0;
        int result = instance.getProfessionalId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfessionalId method, of class Request.
     */
    @Test
    public void testSetProfessionalId() {
        System.out.println("setProfessionalId");
        int professionalId = 0;
        Request instance = new Request();
        instance.setProfessionalId(professionalId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Request.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Request instance = new Request();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Request.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Request instance = new Request();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
