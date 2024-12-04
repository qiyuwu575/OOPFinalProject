<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Applications</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    
</head>
<body>
    <div class="container">
        <h1 class="page-title">My Teaching Applications</h1>
        
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
        
        <c:choose>
            <c:when test="${empty applications}">
                <div class="no-applications">
                    <h3>No applications found</h3>
                    <p>You haven't submitted any teaching applications yet.</p>
                    <a href="${pageContext.request.contextPath}/professional/search.jsp" 
                       class="btn btn-primary">Search for Courses</a>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${applications}" var="app">
                    <div class="application-item">
                        <h3>${app.courseName} (${app.courseCode})</h3>
                        <div class="application-info">
                            <p><strong>Institution:</strong> ${app.institutionName}</p>
                            <p><strong>Term:</strong> ${app.term}</p>
                            <p>
                                <strong>Status:</strong> 
                                <span class="status-label status-${app.status.toLowerCase()}">
                                    ${app.status}
                                </span>
                            </p>
                            <p><strong>Applied Date:</strong> 
                                <fmt:formatDate value="${app.applicationDate}" 
                                              pattern="MMMM dd, yyyy"/>
                            </p>
                        </div>
                        <div class="application-actions">
                            <a href="${pageContext.request.contextPath}/professional/course-details?courseId=${app.courseId}" 
                               class="btn btn-primary">View Course Details</a>
                            <c:if test="${app.status == 'PENDING'}">
                                <form action="${pageContext.request.contextPath}/professional/withdraw-application" 
                                      method="post" style="display: inline;">
                                    <input type="hidden" name="applicationId" value="${app.applicationId}">
                                    <button type="submit" class="btn btn-secondary" 
                                            onclick="return confirm('Are you sure you want to withdraw this application?')">
                                        Withdraw Application
                                    </button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        
        <div class="form-actions">
            <a href="${pageContext.request.contextPath}/professional/dashboard.jsp" 
               class="btn btn-secondary">Back to Dashboard</a>
            <a href="${pageContext.request.contextPath}/professional/search.jsp" 
               class="btn btn-primary">Search More Courses</a>
        </div>
    </div>
</body>
</html>