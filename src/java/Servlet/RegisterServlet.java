package Servlet;

import DAO.UserDAO;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userType = request.getParameter("user_type");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // 基本验证
            if (!isValidEmail(email) || password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid email or password");
            }

            // 检查邮箱是否存在
            if (userDAO.isEmailExists(email)) {
                throw new IllegalArgumentException("Email already exists");
            }

            User user = createUserByType(request);
            
            if (user != null && userDAO.registerUser(user)) {
                response.sendRedirect("login.jsp?success=Registration successful");
            } else {
                throw new RuntimeException("Registration failed");
            }
        } catch (Exception e) {
            response.sendRedirect("register.jsp?error=" + e.getMessage());
        }
    }

    private User createUserByType(HttpServletRequest request) {
        String userType = request.getParameter("user_type");
        if ("AcademicProfessional".equals(userType)) {
            return createAcademicProfessional(request);
        } else if ("AcademicInstitution".equals(userType)) {
            return createAcademicInstitution(request);
        }
        return null;
    }

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

    private User createAcademicInstitution(HttpServletRequest request) {
        String institutionName = request.getParameter("institution_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (institutionName == null || institutionName.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing institution name");
        }

        return new User(institutionName, email, password);
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}