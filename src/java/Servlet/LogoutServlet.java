package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The LogoutServlet class handles user logout requests.
 * It invalidates the current user session and redirects the user to the login page with a success message.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    /**
     * Handles GET requests for user logout.
     * Invalidates the user session if it exists and redirects the user to the login page with a logout success message.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the session if it exists
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Redirect to the login page with a logout success message
        response.sendRedirect(request.getContextPath() + "/login.jsp?message=Logged out successfully");
    }
}
