/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.ApplicationDAO;

/**
 *
 * @author qiyuw
 */
@WebServlet("/institution/process-application")
public class ProcessApplicationServlet extends HttpServlet {
    private ApplicationDAO applicationDAO = new ApplicationDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        
        int applicationId = Integer.parseInt(request.getParameter("applicationId"));
        String action = request.getParameter("action");
        
        try {
            if ("approve".equals(action)) {
                applicationDAO.updateApplicationStatus(applicationId, "APPROVED");
            } else if ("reject".equals(action)) {
                applicationDAO.updateApplicationStatus(applicationId, "REJECTED");
            }
            response.sendRedirect(request.getContextPath() + 
                "/institution/applications?success=Application processed successfully");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + 
                "/institution/applications?error=" + e.getMessage());
        }
    }
}