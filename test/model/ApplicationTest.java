/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

class ApplicationTest {
    @Test
    void testGettersAndSetters() {
        Application application = new Application();
        application.setApplicationId(1);
        application.setCourseId(100);
        application.setProfessionalId(200);
        application.setStatus("Pending");
        Date date = new Date();
        application.setApplicationDate(date);
        
        assertEquals(1, application.getApplicationId());
        assertEquals(100, application.getCourseId());
        assertEquals(200, application.getProfessionalId());
        assertEquals("Pending", application.getStatus());
        assertEquals(date, application.getApplicationDate());
    }
}
