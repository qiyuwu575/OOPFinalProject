/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import java.util.List;
import model.Notification;
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
public class NotificationDAOTest {
    
    public NotificationDAOTest() {
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
     * Test of createNotification method, of class NotificationDAO.
     */
    @Test
    public void testCreateNotification() throws Exception {
        System.out.println("createNotification");
        int userId = 0;
        String message = "";
        String type = "";
        int referenceId = 0;
        NotificationDAO instance = new NotificationDAO();
        instance.createNotification(userId, message, type, referenceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnreadNotifications method, of class NotificationDAO.
     */
    @Test
    public void testGetUnreadNotifications() {
        System.out.println("getUnreadNotifications");
        int userId = 0;
        NotificationDAO instance = new NotificationDAO();
        List<Notification> expResult = null;
        List<Notification> result = instance.getUnreadNotifications(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of markAsRead method, of class NotificationDAO.
     */
    @Test
    public void testMarkAsRead() throws Exception {
        System.out.println("markAsRead");
        int notificationId = 0;
        NotificationDAO instance = new NotificationDAO();
        instance.markAsRead(notificationId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
