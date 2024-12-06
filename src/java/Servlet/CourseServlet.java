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

/**
 * The CourseServlet class handles requests related to course management for academic institutions.
 * It supports managing, editing, creating, and updating courses.
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    private final CourseDAO courseDAO = new CourseDAO();

    /**
     * Handles GET requests for managing and editing courses.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
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

        try {
            if ("manage".equals(action)) {
                // Retrieve and display courses for the institution
                List<Course> courses = courseDAO.getCoursesByInstitution(user.getUserId());
                request.setAttribute("courses", courses);
                request.getRequestDispatcher("/institution/course_management.jsp").forward(request, response);
            } else if ("edit".equals(action)) {
                // Retrieve and display a specific course for editing
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                Course course = courseDAO.getCourseById(courseId);
                request.setAttribute("course", course);
                request.setAttribute("courseId", courseId);
                request.getRequestDispatcher("/institution/course_management.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/institution/course_management.jsp").forward(request, response);
        }
    }

    /**
     * Handles POST requests for creating or updating courses.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
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
            // Populate course data from the request parameters
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
                // Create a new course
                courseDAO.createCourse(course);
                response.sendRedirect(request.getContextPath() +
                        "/course?action=manage&success=Course created successfully");
            } else if ("update".equals(action)) {
                // Update an existing course
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
