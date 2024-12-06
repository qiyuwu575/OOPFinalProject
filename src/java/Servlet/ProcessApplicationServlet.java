package Servlet;

import DAO.ApplicationDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The ProcessApplicationServlet class handles requests for processing applications by academic institutions.
 * It allows institutions to approve or reject applications.
 */
@WebServlet("/institution/process-application")
public class ProcessApplicationServlet extends HttpServlet {

    private final ApplicationDAO applicationDAO = new ApplicationDAO();

    /**
     * Handles POST requests for processing applications.
     * Validates the user as an academic institution, retrieves the application ID and action,
     * updates the application status, and redirects to the applications page with a success or error message.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the current session and user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Validate that the user is logged in and is an academic institution
        if (user == null || !"AcademicInstitution".equals(user.getUserType())) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        try {
            // Retrieve application ID and action from the request parameters
            int applicationId = Integer.parseInt(request.getParameter("applicationId"));
            String action = request.getParameter("action");
            String status = "approve".equals(action) ? "APPROVED" : "REJECTED";

            // Process the application
            applicationDAO.processApplication(applicationId, status, user.getUserId());

            // Redirect to the applications page with a success message
            response.sendRedirect(request.getContextPath() +
                    "/institution/applications?success=Application " + status.toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect to the applications page with an error message
            response.sendRedirect(request.getContextPath() +
                    "/institution/applications?error=Failed to process application");
        }
    }
}
