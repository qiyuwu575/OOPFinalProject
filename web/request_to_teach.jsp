<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="course-details-container">
        <h2>Course Details</h2>
        <div class="course-details">
            <p><strong>Course Code:</strong> ${course.courseCode}</p>
            <p><strong>Course Name:</strong> ${course.courseName}</p>
            <p><strong>Institution:</strong> ${course.institutionName}</p>
            <p><strong>Term:</strong> ${course.term}</p>
            <p><strong>Schedule:</strong> ${course.schedule}</p>
            <p><strong>Delivery Method:</strong> ${course.deliveryMethod}</p>
            <p><strong>Compensation:</strong> $${course.compensation}</p>
            <p><strong>Preferred Qualifications:</strong> ${course.preferredQualifications}</p>
            <p><strong>Course Outline:</strong> ${course.courseOutline}</p>
        </div>

        <form action="${pageContext.request.contextPath}/request-to-teach" method="post">
            <input type="hidden" name="courseId" value="${course.courseId}">
            <button type="submit" class="btn btn-primary">Request to Teach</button>
        </form>
    </div>
</body>
</html>