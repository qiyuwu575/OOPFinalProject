<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <title>Register</title>
    <style>
        .error { color: red; }
        .success { color: green; }
        .hidden { display: none; }
    </style>
</head>
<body>
    <h2>Registration Form</h2>
    
    <c:if test="${param.error != null}">
        <p class="error">${param.error}</p>
    </c:if>

    <form action="register" method="post">
        <select name="user_type" id="user_type" onchange="toggleFields()">
            <option value="AcademicProfessional">Academic Professional</option>
            <option value="AcademicInstitution">Academic Institution</option>
        </select>

        <!-- Common Fields -->
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <!-- Academic Professional Fields -->
        <div id="professionalFields">
            <div>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name">
            </div>
            <div>
                <label for="current_institution">Current Institution:</label>
                <input type="text" id="current_institution" name="current_institution">
            </div>
            <div>
                <label for="academic_position">Academic Position:</label>
                <input type="text" id="academic_position" name="academic_position">
            </div>
        </div>

                <!-- Academic Institution Fields -->
        <div id="institutionFields" class="hidden">
            <div>
                <label for="institution_name">Institution Name:</label>
                <select name="institution_name" id="institution_name">
                    <option value="Algonquin College">Algonquin College</option>
                    <option value="Ottawa University">Ottawa University</option>
                    <option value="Carleton University">Carleton University</option>
                </select>
            </div>
        </div>

        <button type="submit">Register</button>
    </form>

    <script>
        function toggleFields() {
            const userType = document.getElementById('user_type').value;
            const professionalFields = document.getElementById('professionalFields');
            const institutionFields = document.getElementById('institutionFields');

            if (userType === 'AcademicProfessional') {
                professionalFields.classList.remove('hidden');
                institutionFields.classList.add('hidden');
            } else {
                professionalFields.classList.add('hidden');
                institutionFields.classList.remove('hidden');
            }
        }
    </script>
</body>
</html>