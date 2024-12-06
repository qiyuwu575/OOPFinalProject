package Servlet;

import DAO.ApplicationDAO;
import model.Application;
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
 * The ApplicationServlet class handles HTTP requests related to applications for academic professionals.
 * It supports viewing a list of applications (GET) and submitting new applications (POST).
 */
@WebServlet(urlPatterns = {
    "/professional/applications",
    "/professional/view-applications",
    "/professional/submit-application"
})
public class ApplicationServlet extends HttpServlet {

    private final ApplicationDAO applicationDAO = new ApplicationDAO();

    /**
     * Handles GET requests to retrieve and display the list of applications for the logged-in user.
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
        if (!"AcademicProfessional".equals(user.getUserType())) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        try {
            // Retrieve the list of applications for the user
            List<Application> applications = applicationDAO.getApplicationsByProfessionalId(user.getUserId());
            request.setAttribute("applications", applications);
            request.getRequestDispatcher("/professional/application.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to load applications: " + e.getMessage());
            request.getRequestDispatcher("/professional/application.jsp").forward(request, response);
        }
    }

    /**
     * Handles POST requests to submit a new application for the logged-in user.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !"AcademicProfessional".equals(user.getUserType())) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        try {
            // Retrieve the course ID from the request parameters
            String courseIdStr = request.getParameter("courseId");
            if (courseIdStr == null || courseIdStr.trim().isEmpty()) {
                throw new ServletException("Course ID is required");
            }

            int courseId = Integer.parseInt(courseIdStr);
            applicationDAO.createApplication(courseId, user.getUserId());

            // Set a success message
            request.setAttribute("successMessage", "Application submitted successfully!");

            // Retrieve the updated list of applications
            List<Application> applications = applicationDAO.getApplicationsByProfessionalId(user.getUserId());
            request.setAttribute("applications", applications);

            // Forward to the applications page
            request.getRequestDispatcher("/professional/application.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to submit application: " + e.getMessage());
            request.getRequestDispatcher("/professional/application.jsp").forward(request, response);
        }
    }
}
