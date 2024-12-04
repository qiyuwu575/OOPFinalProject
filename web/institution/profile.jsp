<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Institution Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="profile-container">
        <h2>Institution Profile</h2>
        
        <form action="${pageContext.request.contextPath}/profile" method="post">
            <div class="form-group">
                <label for="institution_name">Institution Name:</label>
                <input type="text" id="institution_name" name="institution_name" 
                       value="${sessionScope.user.name}" readonly>
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" 
                       value="${sessionScope.user.email}" readonly>
            </div>
            
            <div class="form-group">
                <label for="institution_address">Institution Address:</label>
                <textarea id="institution_address" name="institution_address" required>${profile.institutionAddress}</textarea>
            </div>
            
            <div class="form-group">
                <label for="current_courses">Current Course Offerings:</label>
                <div id="courses-container">
                    <c:forEach items="${profile.courses}" var="course" varStatus="status">
                        <div class="course-entry">
                            <input type="text" name="course_codes[]" value="${course.courseCode}" 
                                   placeholder="Course Code" required>
                            <input type="text" name="course_names[]" value="${course.courseName}" 
                                   placeholder="Course Name" required>
                            <select name="course_terms[]" required>
                                <option value="24W" ${course.term == '24W' ? 'selected' : ''}>Winter 2024</option>
                                <option value="24S" ${course.term == '24S' ? 'selected' : ''}>Summer 2024</option>
                                <option value="24F" ${course.term == '24F' ? 'selected' : ''}>Fall 2024</option>
                            </select>
                            <button type="button" onclick="removeCourse(this)">Remove</button>
                        </div>
                    </c:forEach>
                    
                    <c:if test="${empty profile.courses}">
                        <div class="course-entry">
                            <input type="text" name="course_codes[]" placeholder="Course Code" required>
                            <input type="text" name="course_names[]" placeholder="Course Name" required>
                            <select name="course_terms[]" required>
                                <option value="24W">Winter 2024</option>
                                <option value="24S">Summer 2024</option>
                                <option value="24F">Fall 2024</option>
                            </select>
                            <button type="button" onclick="removeCourse(this)">Remove</button>
                        </div>
                    </c:if>
                </div>
                <button type="button" onclick="addCourse()" class="btn btn-secondary">Add Another Course</button>
            </div>
            
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Update Profile</button>
                <a href="${pageContext.request.contextPath}/institution/dashboard.jsp" 
                   class="btn btn-secondary">Back to Dashboard</a>
            </div>
        </form>
    </div>

    <script>
        function addCourse() {
            const container = document.getElementById('courses-container');
            const courseEntry = document.createElement('div');
            courseEntry.className = 'course-entry';
            courseEntry.innerHTML = `
                <input type="text" name="course_codes[]" placeholder="Course Code" required>
                <input type="text" name="course_names[]" placeholder="Course Name" required>
                <select name="course_terms[]" required>
                    <option value="24W">Winter 2024</option>
                    <option value="24S">Summer 2024</option>
                    <option value="24F">Fall 2024</option>
                </select>
                <button type="button" onclick="removeCourse(this)">Remove</button>
            `;
            container.appendChild(courseEntry);
        }

        function removeCourse(button) {
            const container = document.getElementById('courses-container');
            if (container.children.length > 1) {
                button.parentElement.remove();
            }
        }
    </script>
</body>
</html>