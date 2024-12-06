package Servlet;

import DAO.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The LoginServlet class handles user login requests.
 * It validates user credentials and redirects authenticated users to their respective dashboards
 * based on their user type.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    /**
     * Handles POST requests for user login.
     * Authenticates the user using the provided email and password, creates a session, and redirects
     * the user to the appropriate dashboard based on their user type.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve email and password from request parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Authenticate user
            User user = userDAO.loginUser(email, password);

            if (user != null) {
                // Create a session for the authenticated user
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("userType", user.getUserType());
                session.setMaxInactiveInterval(30 * 60); // Session timeout set to 30 minutes

                // Redirect to the appropriate dashboard based on user type
                if ("AcademicProfessional".equals(user.getUserType())) {
                    response.sendRedirect(request.getContextPath() + "/professional/dashboard.jsp");
                } else if ("AcademicInstitution".equals(user.getUserType())) {
                    response.sendRedirect(request.getContextPath() + "/institution/dashboard.jsp");
                }
            } else {
                // Redirect back to login page with an error message for invalid credentials
                response.sendRedirect(request.getContextPath() + "/login.jsp?error=Invalid credentials");
            }
        } catch (Exception e) {
            // Redirect back to login page with an error message for exceptions
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=" + e.getMessage());
        }
    }
}
