<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Professional Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dashboard-card {
            border: 1px solid #ddd;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1>Welcome, ${user.name}</h1>
        
        <div class="row mt-4">
            <div class="col-md-6">
                <div class="dashboard-card">
                    <h2>Quick Actions</h2>
                    <div class="d-grid gap-2">
                        <a href="${pageContext.request.contextPath}/professional/search-courses" class="btn btn-primary">Search for Courses</a>
                        <a href="${pageContext.request.contextPath}/professional/applications" class="btn btn-secondary">My Applications</a>
                        <a href="${pageContext.request.contextPath}/profile" class="btn btn-outline-primary">Edit Profile</a>
                    </div>
                </div>
            </div>
            
            <div class="col-md-6">
                            <div class="dashboard-card">
                                <h2>Notifications</h2>
                                <c:forEach items="${notifications}" var="notification">
                                    <div class="alert alert-info">
                                        ${notification.message}
                                        <small class="d-block text-muted">
                                            ${notification.createdAt}
                                        </small>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>