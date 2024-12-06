/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.sql.Timestamp;
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
public class NotificationTest {
    
    public NotificationTest() {
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
     * Test of getNotificationId method, of class Notification.
     */
    @Test
    public void testGetNotificationId() {
        System.out.println("getNotificationId");
        Notification instance = new Notification();
        int expResult = 0;
        int result = instance.getNotificationId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotificationId method, of class Notification.
     */
    @Test
    public void testSetNotificationId() {
        System.out.println("setNotificationId");
        int notificationId = 0;
        Notification instance = new Notification();
        instance.setNotificationId(notificationId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class Notification.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Notification instance = new Notification();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class Notification.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        Notification instance = new Notification();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class Notification.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Notification instance = new Notification();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class Notification.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        Notification instance = new Notification();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRead method, of class Notification.
     */
    @Test
    public void testIsRead() {
        System.out.println("isRead");
        Notification instance = new Notification();
        boolean expResult = false;
        boolean result = instance.isRead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRead method, of class Notification.
     */
    @Test
    public void testSetRead() {
        System.out.println("setRead");
        boolean read = false;
        Notification instance = new Notification();
        instance.setRead(read);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedAt method, of class Notification.
     */
    @Test
    public void testGetCreatedAt() {
        System.out.println("getCreatedAt");
        Notification instance = new Notification();
        Timestamp expResult = null;
        Timestamp result = instance.getCreatedAt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedAt method, of class Notification.
     */
    @Test
    public void testSetCreatedAt() {
        System.out.println("setCreatedAt");
        Timestamp createdAt = null;
        Notification instance = new Notification();
        instance.setCreatedAt(createdAt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Notification.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Notification instance = new Notification();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Notification.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Notification instance = new Notification();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReferenceId method, of class Notification.
     */
    @Test
    public void testGetReferenceId() {
        System.out.println("getReferenceId");
        Notification instance = new Notification();
        int expResult = 0;
        int result = instance.getReferenceId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReferenceId method, of class Notification.
     */
    @Test
    public void testSetReferenceId() {
        System.out.println("setReferenceId");
        int referenceId = 0;
        Notification instance = new Notification();
        instance.setReferenceId(referenceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
