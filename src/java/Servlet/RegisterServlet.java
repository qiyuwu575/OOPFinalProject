package Servlet;

import DAO.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The RegisterServlet class handles user registration requests.
 * It supports the registration of both academic professionals and institutions.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    /**
     * Handles POST requests for user registration.
     * Validates input, checks for duplicate email, and registers the user based on their type.
     * Redirects the user to the login page upon success or back to the registration page with an error message.
     *
     * @param request  the HttpServletRequest object containing the request details
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if an error occurs during request processing
     * @throws IOException      if an I/O error occurs during request processing
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userType = request.getParameter("user_type");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Basic validation
            if (!isValidEmail(email) || password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid email or password");
            }

            // Check if email already exists
            if (userDAO.isEmailExists(email)) {
                throw new IllegalArgumentException("Email already exists");
            }

            // Create user object based on user type
            User user = createUserByType(request);

            // Register user and redirect based on success or failure
            if (user != null && userDAO.registerUser(user)) {
                response.sendRedirect("login.jsp?success=Registration successful");
            } else {
                throw new RuntimeException("Registration failed");
            }
        } catch (Exception e) {
            response.sendRedirect("register.jsp?error=" + e.getMessage());
        }
    }

    /**
     * Creates a User object based on the user type specified in the request.
     *
     * @param request the HttpServletRequest object containing the user details
     * @return a User object representing the user to be registered
     */
    private User createUserByType(HttpServletRequest request) {
        String userType = request.getParameter("user_type");
        if ("AcademicProfessional".equals(userType)) {
            return createAcademicProfessional(request);
        } else if ("AcademicInstitution".equals(userType)) {
            return createAcademicInstitution(request);
        }
        return null;
    }

    /**
     * Creates a User object for an academic professional.
     *
     * @param request the HttpServletRequest object containing the professional's details
     * @return a User object for the academic professional
     * @throws IllegalArgumentException if required details are missing or invalid
     */
    private User createAcademicProfessional(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String currentInstitution = request.getParameter("current_institution");
        String academicPosition = request.getParameter("academic_position");

        if (name == null || currentInstitution == null || academicPosition == null ||
            name.trim().isEmpty() || currentInstitution.trim().isEmpty() ||
            academicPosition.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing professional details");
        }

        return new User(name, email, password, currentInstitution, academicPosition);
    }

    /**
     * Creates a User object for an academic institution.
     *
     * @param request the HttpServletRequest object containing the institution's details
     * @return a User object for the academic institution
     * @throws IllegalArgumentException if required details are missing or invalid
     */
    private User createAcademicInstitution(HttpServletRequest request) {
        String institutionName = request.getParameter("institution_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (institutionName == null || institutionName.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing institution name");
        }

        return new User(institutionName, email, password);
    }

    /**
     * Validates an email address format.
     *
     * @param email the email address to validate
     * @return true if the email is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
