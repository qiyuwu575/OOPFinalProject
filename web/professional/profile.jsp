<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Professional Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="profile-container">
        <h2>Your Profile</h2>
        
        <form action="${pageContext.request.contextPath}/profile" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${sessionScope.user.name}" required>
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${sessionScope.user.email}" readonly>
            </div>
            
            <div class="form-group">
                <label for="current_position">Current Position:</label>
                <input type="text" id="current_position" name="current_position" 
                       value="${profile.currentPosition}" required>
            </div>
            
            <div class="form-group">
                <label for="current_institution">Current Institution:</label>
                <input type="text" id="current_institution" name="current_institution" 
                       value="${profile.currentInstitution}" required>
            </div>
            
            <div class="form-group">
                <label for="education_background">Education Background:</label>
                <textarea id="education_background" name="education_background" required>${profile.educationBackground}</textarea>
            </div>
            
            <div class="form-group">
                <label for="area_of_expertise">Areas of Expertise:</label>
                <textarea id="area_of_expertise" name="area_of_expertise" required>${profile.areaOfExpertise}</textarea>
            </div>
            
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Update Profile</button>
                <a href="${pageContext.request.contextPath}/professional/dashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
            </div>
        </form>
    </div>
</body>
</html>