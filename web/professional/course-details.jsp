<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="container">
        <h2>Course Details</h2>
        
        <div class="course-details">
            <h3>${course.courseName} (${course.courseCode})</h3>
            <p><strong>Institution:</strong> ${course.institutionName}</p>
            <p><strong>Term:</strong> ${course.term}</p>
            <p><strong>Schedule:</strong> ${course.schedule}</p>
            <p><strong>Delivery Method:</strong> ${course.deliveryMethod}</p>
            <p><strong>Compensation:</strong> $${course.compensation}</p>
            <p><strong>Course Outline:</strong></p>
            <div class="course-outline">
                ${course.courseOutline}
            </div>
            <p><strong>Preferred Qualifications:</strong></p>
            <div class="qualifications">
                ${course.preferredQualifications}
            </div>
            
            <c:if test="${not applied}">
                <form action="${pageContext.request.contextPath}/professional/request-to-teach" method="post">
                    <input type="hidden" name="courseId" value="${course.courseId}">
                    <button type="submit" class="btn btn-primary">Request to Teach</button>
                </form>
            </c:if>
            
            <div class="form-actions">
                <a href="${pageContext.request.contextPath}/professional/search.jsp" 
                   class="btn btn-secondary">Back to Search</a>
            </div>
        </div>
    </div>
</body>
</html>