import org.junit.Test;
import static org.junit.Assert.*;


import model.Course;

class CourseTest {
    @Test
    void testFullConstructor() {
        Course course = new Course(1, 10, "CS101", "Intro to Programming", "Basic programming concepts", "Fall", "MWF", "Online", 1000.0, "Bachelor's Degree", "Active", "MIT");
        
        assertEquals(1, course.getCourseId());
        assertEquals("CS101", course.getCourseCode());
        assertEquals("Intro to Programming", course.getCourseName());
        assertEquals(1000.0, course.getCompensation());
    }
}
