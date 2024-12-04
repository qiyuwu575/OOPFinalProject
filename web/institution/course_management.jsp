<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"
</head>
<body>
    <div class="course-form">
        <h2>${empty courseId ? 'Create New Course' : 'Edit Course'}</h2>

        <c:if test="${not empty param.error}">
            <p class="error">${param.error}</p>
        </c:if>
        <c:if test="${not empty param.success}">
            <p class="success">${param.success}</p>
        </c:if>

        <form action="${pageContext.request.contextPath}/course" method="post">
            <input type="hidden" name="action" value="${empty courseId ? 'create' : 'update'}">
            <input type="hidden" name="courseId" value="${courseId}">

            <div class="form-group">
                <label for="courseCode">Course Code:</label>
                <input type="text" id="courseCode" name="courseCode" value="${course.courseCode}" required>
            </div>

            <div class="form-group">
                <label for="courseName">Course Name:</label>
                <input type="text" id="courseName" name="courseName" value="${course.courseName}" required>
            </div>

            <div class="form-group">
                <label for="term">Term:</label>
                <select id="term" name="term" required>
                    <option value="24W" ${course.term == '24W' ? 'selected' : ''}>Winter 2024</option>
                    <option value="24S" ${course.term == '24S' ? 'selected' : ''}>Summer 2024</option>
                    <option value="24F" ${course.term == '24F' ? 'selected' : ''}>Fall 2024</option>
                </select>
            </div>

            <div class="form-group">
                <label for="courseOutline">Course Outline:</label>
                <textarea id="courseOutline" name="courseOutline" required>${course.courseOutline}</textarea>
            </div>

            <div class="form-group">
                <label for="schedule">Schedule:</label>
                <input type="text" id="schedule" name="schedule" value="${course.schedule}" required>
            </div>

            <div class="form-group">
                <label for="deliveryMethod">Delivery Method:</label>
                <input type="text" id="deliveryMethod" name="deliveryMethod" value="${course.deliveryMethod}" required>
            </div>

            <div class="form-group">
                <label for="compensation">Compensation:</label>
                <input type="number" id="compensation" name="compensation" value="${course.compensation}" required>
            </div>

            <div class="form-group">
                <label for="preferredQualifications">Preferred Qualifications:</label>
                <textarea id="preferredQualifications" name="preferredQualifications" required>${course.preferredQualifications}</textarea>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn btn-primary">${empty courseId ? 'Create Course' : 'Update Course'}</button>
                <a href="${pageContext.request.contextPath}/institution/dashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
        </form>
    </div>

    <div class="course-list">
        <h2>Existing Courses</h2>
        <c:forEach items="${courses}" var="course">
            <div class="course-item">
                <h3>${course.courseName} (${course.courseCode})</h3>
                <p><strong>Term:</strong> ${course.term}</p>
                <p><strong>Schedule:</strong> ${course.schedule}</p>
                <p><strong>Compensation:</strong> $${course.compensation}</p>
                <a href="${pageContext.request.contextPath}/course?action=edit&courseId=${course.courseId}" class="btn btn-secondary">Edit</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>