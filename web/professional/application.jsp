<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Teaching Applications</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .application-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin-bottom: 15px;
            border-radius: 5px;
        }
        .status-pending { color: #f0ad4e; }
        .status-approved { color: #5cb85c; }
        .status-rejected { color: #d9534f; }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1>My Teaching Applications</h1>
        
        <!-- 显示成功/错误消息 -->
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">
                ${successMessage}
            </div>
        </c:if>
        
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">
                ${errorMessage}
            </div>
        </c:if>
        
        <!-- 显示申请列表或空状态 -->
        <c:choose>
            <c:when test="${empty applications}">
                <div class="alert alert-info">
                    <h4>No applications found</h4>
                    <p>You haven't submitted any teaching applications yet.</p>
                    <a href="${pageContext.request.contextPath}/professional/search-courses" 
                       class="btn btn-primary">Search for Courses</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="applications-list">
                    <c:forEach var="app" items="${applications}">
                        <div class="application-card">
                            <h3>${app.courseName}</h3>
                            <p>Course Code: ${app.courseCode}</p>
                            <p>Application Date: ${app.applicationDate}</p>
                            <p>Status: 
                                <span class="status-${app.status.toLowerCase()}">${app.status}</span>
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
        
        <div class="mt-4">
            <a href="${pageContext.request.contextPath}/professional/dashboard.jsp" 
               class="btn btn-secondary">Back to Dashboard</a>
            <a href="${pageContext.request.contextPath}/professional/search-courses" 
               class="btn btn-primary">Search More Courses</a>
        </div>
    </div>
</body>
</html>