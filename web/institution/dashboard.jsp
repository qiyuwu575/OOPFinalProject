<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Institution Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="dashboard-container">
        <header class="dashboard-header">
            <h1>Welcome, ${sessionScope.user.name}</h1>
            <div class="user-actions">
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-logout">Logout</a>
            </div>
        </header>

        <div class="dashboard-content">
            <div class="quick-actions">
                <h2>Quick Actions</h2>
                <a href="${pageContext.request.contextPath}/course?action=manage" class="action-link">Manage Courses</a>
                <a href="${pageContext.request.contextPath}/institution/view-applications" class="action-link">View Applications</a>
                <a href="${pageContext.request.contextPath}/profile" class="action-link">Edit Profile</a>
            </div>

            <div class="dashboard-main">
                <section class="active-courses">
                    <h2>Active Courses</h2>
                    <!-- Add your courses display logic here -->
                </section>
            </div>
        </div>
    </div>
</body>
</html>