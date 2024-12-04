<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teaching Applications</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="container">
        <h2>Teaching Applications</h2>
        
        <c:forEach items="${applications}" var="app">
            <div class="application-item">
                <h3>${app.courseName} (${app.courseCode})</h3>
                <p><strong>Applicant:</strong> ${app.professionalName}</p>
                <p><strong>Current Position:</strong> ${app.currentPosition}</p>
                <p><strong>Applied Date:</strong> ${app.applicationDate}</p>
                <p><strong>Status:</strong> ${app.status}</p>
                
                <c:if test="${app.status == 'PENDING'}">
                    <form action="${pageContext.request.contextPath}/institution/process-application" method="post" style="display: inline;">
                        <input type="hidden" name="applicationId" value="${app.applicationId}">
                        <button type="submit" name="action" value="approve" class="btn btn-success">Approve</button>
                        <button type="submit" name="action" value="reject" class="btn btn-danger">Reject</button>
                    </form>
                </c:if>
                
                <a href="${pageContext.request.contextPath}/professional/profile?id=${app.professionalId}" 
                   class="btn btn-primary">View Profile</a>
            </div>
        </c:forEach>
        
        <div class="form-actions">
            <a href="${pageContext.request.contextPath}/institution/dashboard.jsp" 
               class="btn btn-secondary">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>