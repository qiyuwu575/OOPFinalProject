package Servlet;

import DAO.ProfileDAO;
import model.Profile;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The ProfileServlet class handles requests for viewing and updating user profiles.
 * It supports both academic professionals and institutions.
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private final ProfileDAO profileDAO = new ProfileDAO();

    /**
     * Handles GET requests for viewing user profiles.
     * Retrieves the profile data for the logged-in user and forwards the request to the appropriate profile page
     * based on the user's type (Academic Professional or Institution).
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
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        Profile profile = profileDAO.getProfileByUserId(user.getUserId());

        if (profile != null) {
            request.setAttribute("profile", profile);
        }

        // Forward to the appropriate profile page based on user type
        String userType = user.getUserType();
        if ("AcademicProfessional".equals(userType)) {
            request.getRequestDispatcher("/professional/profile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/institution/profile.jsp").forward(request, response);
        }
    }

    /**
     * Handles POST requests for updating user profiles.
     * Retrieves form data, updates the user's profile, and redirects to the profile page with a success or error message.
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
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        try {
            // Retrieve form data
            String currentPosition = request.getParameter("current_position");
            String currentInstitution = request.getParameter("current_institution");
            String educationBackground = request.getParameter("education_background");
            String areaOfExpertise = request.getParameter("area_of_expertise");

            // Create or update the profile
            Profile profile = new Profile();
            profile.setUserId(user.getUserId());
            profile.setCurrentPosition(currentPosition);
            profile.setCurrentInstitution(currentInstitution);
            profile.setEducationBackground(educationBackground);
            profile.setAreaOfExpertise(areaOfExpertise);

            boolean success = profileDAO.updateProfile(profile);

            if (success) {
                response.sendRedirect(request.getContextPath() +
                        "/profile?success=Profile updated successfully");
            } else {
                response.sendRedirect(request.getContextPath() +
                        "/profile?error=Failed to update profile");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() +
                    "/profile?error=" + e.getMessage());
        }
    }
}
