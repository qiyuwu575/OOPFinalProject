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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userDAO.loginUser(email, password);
            
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("userType", user.getUserType());
                session.setMaxInactiveInterval(30 * 60); // 30分钟会话超时
                
                // 根据用户类型重定向到不同的仪表板
                if ("AcademicProfessional".equals(user.getUserType())) {
                    response.sendRedirect(request.getContextPath() + "/professional/dashboard.jsp");
                } else if ("AcademicInstitution".equals(user.getUserType())) {
                    response.sendRedirect(request.getContextPath() + "/institution/dashboard.jsp");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp?error=Invalid credentials");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=" + e.getMessage());
        }
    }
}