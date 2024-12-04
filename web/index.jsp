<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Academic Teaching Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <style>
        .landing-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        
        .hero-section {
            text-align: center;
            padding: 50px 0;
            background-color: #f5f5f5;
            margin-bottom: 40px;
            border-radius: 8px;
        }
        
        .features-section {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 30px;
            margin-bottom: 40px;
        }
        
        .feature-card {
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            text-align: center;
        }
        
        .cta-section {
            text-align: center;
            margin: 40px 0;
        }
        
        .btn {
            display: inline-block;
            padding: 12px 24px;
            margin: 10px;
            border-radius: 4px;
            text-decoration: none;
            font-weight: bold;
        }
        
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="landing-container">
        <!-- Hero Section -->
        <div class="hero-section">
            <h1>Welcome to Academic Teaching Management System</h1>
            <p>Connect Academic Professionals with Teaching Opportunities</p>
        </div>

        <!-- Features Section -->
        <div class="features-section">
            <div class="feature-card">
                <h3>For Academic Professionals</h3>
                <p>Find teaching opportunities that match your expertise</p>
                <ul>
                    <li>Search available courses</li>
                    <li>Submit teaching requests</li>
                    <li>Manage your academic profile</li>
                </ul>
            </div>

            <div class="feature-card">
                <h3>For Academic Institutions</h3>
                <p>Find qualified professionals for your courses</p>
                <ul>
                    <li>Post course offerings</li>
                    <li>Manage course details</li>
                    <li>Review teaching requests</li>
                </ul>
            </div>
        </div>

        <!-- Call to Action Section -->
        <div class="cta-section">
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <h2>Get Started Today</h2>
                    <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-primary">Login</a>
                    <a href="${pageContext.request.contextPath}/registration.jsp" class="btn btn-secondary">Register</a>
                </c:when>
                <c:otherwise>
                    <h2>Welcome Back, ${sessionScope.user.name}!</h2>
                    <c:choose>
                        <c:when test="${sessionScope.userType == 'AcademicProfessional'}">
                            <a href="${pageContext.request.contextPath}/professional/search.jsp" 
                               class="btn btn-primary">Search Courses</a>
                        </c:when>
                        <c:when test="${sessionScope.userType == 'AcademicInstitution'}">
                            <a href="${pageContext.request.contextPath}/institution/course_management.jsp" 
                               class="btn btn-primary">Manage Courses</a>
                        </c:when>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <!-- Optional: Add a footer -->
    <footer style="text-align: center; padding: 20px; background-color: #f8f9fa; margin-top: 40px;">
        <p>&copy; 2024 Academic Teaching Management System. All rights reserved.</p>
    </footer>

    <script>
        // Add any JavaScript functionality if needed
        document.addEventListener('DOMContentLoaded', function() {
            // Example: Add smooth scrolling for anchor links
            document.querySelectorAll('a[href^="#"]').forEach(anchor => {
                anchor.addEventListener('click', function (e) {
                    e.preventDefault();
                    document.querySelector(this.getAttribute('href')).scrollIntoView({
                        behavior: 'smooth'
                    });
                });
            });
        });
    </script>
</body>
</html>