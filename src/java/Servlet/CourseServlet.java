package Servlet;

import DAO.CourseDAO;
import model.Course;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    private CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action");
        
        if ("manage".equals(action)) {
            List<Course> courses = courseDAO.getCoursesByInstitution(user.getUserId());
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("/institution/course_management.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            Course course = courseDAO.getCourseById(courseId);
            request.setAttribute("course", course);
            request.setAttribute("courseId", courseId);
            request.getRequestDispatcher("/institution/course_management.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action");

        try {
            Course course = new Course();
            course.setInstitutionId(user.getUserId());
            course.setCourseCode(request.getParameter("courseCode"));
            course.setCourseName(request.getParameter("courseName"));
            course.setTerm(request.getParameter("term"));
            course.setCourseOutline(request.getParameter("courseOutline"));
            course.setSchedule(request.getParameter("schedule"));
            course.setDeliveryMethod(request.getParameter("deliveryMethod"));
            course.setCompensation(Double.parseDouble(request.getParameter("compensation")));
            course.setPreferredQualifications(request.getParameter("preferredQualifications"));

            if ("create".equals(action)) {
                courseDAO.createCourse(course);
                response.sendRedirect(request.getContextPath() + 
                    "/course?action=manage&success=Course created successfully");
            } else if ("update".equals(action)) {
                course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
                courseDAO.updateCourse(course);
                response.sendRedirect(request.getContextPath() + 
                    "/course?action=manage&success=Course updated successfully");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + 
                "/course?action=manage&error=" + e.getMessage());
        }
    }
}