<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

<header class="main-header">
    <div class="logo">
        <a href="${pageContext.request.contextPath}/dashboard">Academic Employment Platform</a>
    </div>
    
    <nav class="main-nav">
        <c:choose>
            <%-- For non-logged in users --%>
            <c:when test="${empty sessionScope.user}">
                <div class="nav-group">
                    <a href="${pageContext.request.contextPath}/login.jsp" class="nav-link">Login</a>
                    <a href="${pageContext.request.contextPath}/registration.jsp" class="nav-link">Register</a>
                </div>
            </c:when>
            
            <%-- For logged in users --%>
            <c:otherwise>
                <div class="nav-group">
                    <%-- For Academic Institution users --%>
                    <c:if test="${sessionScope.userType == 'AcademicInstitution'}">
                        <div class="dropdown">
                            <a href="#" class="nav-link dropdown-toggle">Course Management</a>
                            <div class="dropdown-content">
                                <a href="${pageContext.request.contextPath}/institution/course">Manage Courses</a>
                                <a href="${pageContext.request.contextPath}/institution/applications">View Applications</a>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/profile.jsp" class="nav-link">Institution Profile</a>
                    </c:if>
                    
                    <%-- For Academic Professional users --%>
                    <c:if test="${sessionScope.userType == 'AcademicProfessional'}">
                        <div class="dropdown">
                            <a href="#" class="nav-link dropdown-toggle">Job Search</a>
                            <div class="dropdown-content">
                                <a href="${pageContext.request.contextPath}/professional/search-courses">Search Courses</a>
                                <a href="${pageContext.request.contextPath}/professional/applications">My Applications</a>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/profile.jsp" class="nav-link">Professional Profile</a>
                    </c:if>
                    
                    <%-- Common links for all logged-in users --%>
                    <a href="${pageContext.request.contextPath}/dashboard" class="nav-link">Dashboard</a>
                </div>
                
                <div class="user-info">
                    <span class="user-name">Welcome, ${sessionScope.user.name}</span>
                    <div class="dropdown">
                        <a href="#" class="nav-link dropdown-toggle">
                            <i class="fas fa-user"></i>
                        </a>
                        <div class="dropdown-content">
                            <a href="${pageContext.request.contextPath}/profile.jsp">Edit Profile</a>
                            <a href="${pageContext.request.contextPath}/settings.jsp">Settings</a>
                            <a href="${pageContext.request.contextPath}/logout">Logout</a>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </nav>
</header>