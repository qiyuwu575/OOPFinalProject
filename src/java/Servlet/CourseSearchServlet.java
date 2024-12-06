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
 * The CourseSearchServlet class handles requests for searching courses.
 * It allows logged-in academic professionals to search for courses based on various filters or view all available courses.
 */
@WebServlet("/professional/search-courses")
public class CourseSearchServlet extends HttpServlet {

    private final CourseDAO courseDAO = new CourseDAO();

    /**
     * Handles GET requests for searching courses.
     * Checks if the user is authenticated and authorized, retrieves search parameters,
     * executes the course search, and forwards the results to the search results page.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Check user type
        User user = (User) session.getAttribute("user");
        if (!"AcademicProfessional".equals(user.getUserType())) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        try {
            // Retrieve search parameters
            String courseCode = request.getParameter("courseCode");
            String courseName = request.getParameter("courseName");
            String term = request.getParameter("term");
            String schedule = request.getParameter("schedule");
            String deliveryMethod = request.getParameter("deliveryMethod");

            // Execute search
            List<Course> courses;
            if (courseCode == null && courseName == null && term == null &&
                schedule == null && deliveryMethod == null) {
                // If no search filters are provided, retrieve all courses
                courses = courseDAO.getAllCourses();
            } else {
                // Search for courses based on the provided filters
                courses = courseDAO.searchCourses(courseCode, courseName, term);
            }

            // Set search results as a request attribute
            request.setAttribute("courses", courses);

            // Retain search parameters for display
            request.setAttribute("courseCode", courseCode);
            request.setAttribute("courseName", courseName);
            request.setAttribute("term", term);
            request.setAttribute("schedule", schedule);
            request.setAttribute("deliveryMethod", deliveryMethod);

            // Mark search as performed
            request.setAttribute("searchPerformed", true);

            // Forward to the search results page
            request.getRequestDispatcher("/professional/search.jsp").forward(request, response);

        } catch (Exception e) {
            // Handle errors
            request.setAttribute("error", "An error occurred while searching courses: " + e.getMessage());
            request.getRequestDispatcher("/professional/search.jsp").forward(request, response);
        }
    }

    /**
     * Handles POST requests for searching courses.
     * Forwards the request to the {@link #doGet(HttpServletRequest, HttpServletResponse)} method.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
