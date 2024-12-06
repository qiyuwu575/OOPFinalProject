/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import java.util.List;
import model.Course;
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
public class CourseDAOTest {
    
    public CourseDAOTest() {
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
     * Test of createCourse method, of class CourseDAO.
     */
    @Test
    public void testCreateCourse() throws Exception {
        System.out.println("createCourse");
        Course course = null;
        CourseDAO instance = new CourseDAO();
        instance.createCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCourse method, of class CourseDAO.
     */
    @Test
    public void testUpdateCourse() throws Exception {
        System.out.println("updateCourse");
        Course course = null;
        CourseDAO instance = new CourseDAO();
        instance.updateCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCourse method, of class CourseDAO.
     */
    @Test
    public void testDeleteCourse() throws Exception {
        System.out.println("deleteCourse");
        int courseId = 0;
        int institutionId = 0;
        CourseDAO instance = new CourseDAO();
        instance.deleteCourse(courseId, institutionId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseById method, of class CourseDAO.
     */
    @Test
    public void testGetCourseById() {
        System.out.println("getCourseById");
        int courseId = 0;
        CourseDAO instance = new CourseDAO();
        Course expResult = null;
        Course result = instance.getCourseById(courseId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoursesByInstitution method, of class CourseDAO.
     */
    @Test
    public void testGetCoursesByInstitution() {
        System.out.println("getCoursesByInstitution");
        int institutionId = 0;
        CourseDAO instance = new CourseDAO();
        List<Course> expResult = null;
        List<Course> result = instance.getCoursesByInstitution(institutionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCourses method, of class CourseDAO.
     */
    @Test
    public void testGetAllCourses() {
        System.out.println("getAllCourses");
        CourseDAO instance = new CourseDAO();
        List<Course> expResult = null;
        List<Course> result = instance.getAllCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchCourses method, of class CourseDAO.
     */
    @Test
    public void testSearchCourses() {
        System.out.println("searchCourses");
        String courseCode = "";
        String courseName = "";
        String term = "";
        CourseDAO instance = new CourseDAO();
        List<Course> expResult = null;
        List<Course> result = instance.searchCourses(courseCode, courseName, term);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
