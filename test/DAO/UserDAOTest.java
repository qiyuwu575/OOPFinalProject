/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import java.util.List;
import model.User;
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
public class UserDAOTest {
    
    public UserDAOTest() {
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
     * Test of registerUser method, of class UserDAO.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        User user = null;
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.registerUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class UserDAO.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String email = "";
        String password = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.loginUser(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmailExists method, of class UserDAO.
     */
    @Test
    public void testIsEmailExists() {
        System.out.println("isEmailExists");
        String email = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.isEmailExists(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInstitutions method, of class UserDAO.
     */
    @Test
    public void testGetAllInstitutions() {
        System.out.println("getAllInstitutions");
        UserDAO instance = new UserDAO();
        List<User> expResult = null;
        List<User> result = instance.getAllInstitutions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
