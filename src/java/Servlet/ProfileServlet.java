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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private ProfileDAO profileDAO = new ProfileDAO();

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

        // 根据用户类型转发到不同的profile页面
        String userType = user.getUserType();
        if ("AcademicProfessional".equals(userType)) {
            request.getRequestDispatcher("/professional/profile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/institution/profile.jsp").forward(request, response);
        }
        
    }
    
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
            // 获取表单数据
            String currentPosition = request.getParameter("current_position");
            String currentInstitution = request.getParameter("current_institution");
            String educationBackground = request.getParameter("education_background");
            String areaOfExpertise = request.getParameter("area_of_expertise");

            // 创建或更新档案
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