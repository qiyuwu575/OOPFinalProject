<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .course-card {
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
        <h1>Search Courses</h1>
        
        <form action="${pageContext.request.contextPath}/professional/search-courses" method="get" class="mb-4">
            <div class="row g-3">
                <div class="col-md-4">
                    <label for="courseCode" class="form-label">Course Code</label>
                    <input type="text" class="form-control" id="courseCode" name="courseCode" value="${courseCode}">
                </div>
                <div class="col-md-4">
                    <label for="courseName" class="form-label">Course Name</label>
                    <input type="text" class="form-control" id="courseName" name="courseName" value="${courseName}">
                </div>
                <div class="col-md-4">
                    <label for="term" class="form-label">Term</label>
                    <select class="form-select" id="term" name="term">
                        <option value="">Select Term</option>
                        <option value="24W" ${term == '24W' ? 'selected' : ''}>Winter 2024</option>
                        <option value="24S" ${term == '24S' ? 'selected' : ''}>Summer 2024</option>
                        <option value="24F" ${term == '24F' ? 'selected' : ''}>Fall 2024</option>
                    </select>
                </div>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Search</button>
                <a href="${pageContext.request.contextPath}/professional/dashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
            </div>
        </form>

        <c:if test="${searchPerformed}">
            <h2>Search Results</h2>
            <c:choose>
                <c:when test="${empty courses}">
                    <div class="alert alert-info">No courses found matching your criteria.</div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <c:forEach items="${courses}" var="course">
                            <div class="col-md-6 mb-4">
                                <div class="course-card">
                                    <h3>${course.courseName}</h3>
                                    <p class="text-muted">${course.courseCode}</p>
                                    <p><strong>Term:</strong> ${course.term}</p>
                                    <p><strong>Schedule:</strong> ${course.schedule}</p>
                                    <p><strong>Delivery Method:</strong> ${course.deliveryMethod}</p>
                                    <p><strong>Compensation:</strong> $${course.compensation}</p>
                                    <form action="${pageContext.request.contextPath}/professional/applications" method="POST">
                                        <input type="hidden" name="courseId" value="${course.courseId}">
                                        <button type="submit" class="btn btn-primary">Request to Teach</button>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:if>
    </div>
</body>
</html>