<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Courses</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/professional/search-courses" method="get">
    <div class="form-group">
        <label for="courseCode">Course Code:</label>
        <input type="text" id="courseCode" name="courseCode">
    </div>
    <div class="form-group">
        <label for="courseName">Course Name:</label>
        <input type="text" id="courseName" name="courseName">request
    <div class="form-group">
        <label for="term">Term:</label>
        <select id="term" name="term">
            <option value="">Select Term</option>
            <option value="24W">Winter 2024</option>
            <option value="24S">Summer 2024</option>
            <option value="24F">Fall 2024</option>
        </select>
    </div>
    <div class="form-actions">
        <button type="submit" class="btn btn-primary">Search Courses</button>
        <a href="${pageContext.request.contextPath}/professional/dashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
    </div>
    <button type="submit" class="btn btn-primary">Search Courses</button>
</form>
    
    <h2>Search Results</h2>
    <c:if test="${empty courses}">
        <p>No courses found.</p>
    </c:if>
    <c:forEach items="${courses}" var="course">
        <div class="course-item">
            <h3>${course.courseName} (${course.courseCode})</h3>
            <p><strong>Term:</strong> ${course.term}</p>
            <p><strong>Schedule:</strong> ${course.schedule}</p>
            <p><strong>Compensation:</strong> $${course.compensation}</p>
        </div>
    </c:forEach>
</body>
</html>