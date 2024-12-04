package Servlet;

import DAO.CourseDAO;
import model.Course;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/professional/search-courses")
public class CourseSearchServlet extends HttpServlet {
    private CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 检查用户是否登录
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 获取用户类型
        User user = (User) session.getAttribute("user");
        if (!"AcademicProfessional".equals(user.getUserType())) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        try {
            // 获取搜索参数
            String courseCode = request.getParameter("courseCode");
            String courseName = request.getParameter("courseName");
            String term = request.getParameter("term");
            String schedule = request.getParameter("schedule");
            String deliveryMethod = request.getParameter("deliveryMethod");
            
            // 执行搜索
            List<Course> courses;
            if (courseCode == null && courseName == null && term == null && 
                schedule == null && deliveryMethod == null) {
                // 如果没有搜索条件，获取所有课程
                courses = courseDAO.getAllCourses();
            } else {
                // 根据条件搜索课程
                courses = courseDAO.searchCourses(courseCode, courseName, term);
            }

            // 设置搜索结果
            request.setAttribute("courses", courses);
            
            // 保持搜索条件
            request.setAttribute("courseCode", courseCode);
            request.setAttribute("courseName", courseName);
            request.setAttribute("term", term);
            request.setAttribute("schedule", schedule);
            request.setAttribute("deliveryMethod", deliveryMethod);
            
            // 设置搜索已执行标志
            request.setAttribute("searchPerformed", true);
            
            // 转发到搜索结果页面
            request.getRequestDispatcher("/professional/search.jsp").forward(request, response);
            
        } catch (Exception e) {
            // 处理错误
            request.setAttribute("error", "An error occurred while searching courses: " + e.getMessage());
            request.getRequestDispatcher("/professional/search.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // POST 请求也使用 doGet 方法处理
        doGet(request, response);
    }
}