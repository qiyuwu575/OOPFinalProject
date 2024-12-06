package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The AuthenticationFilter class is a servlet filter that handles authentication and authorization
 * for requests to professional and institution-specific endpoints. It checks whether the user is
 * logged in and has the correct user type for the requested resource.
 */
@WebFilter(urlPatterns = {
    "/professional/*",
    "/institution/*"
})
public class AuthenticationFilter implements Filter {

    /**
     * Filters incoming requests to ensure the user is authenticated and authorized.
     * Redirects to the login page if the user is not logged in or does not have the appropriate access rights.
     *
     * @param request  the ServletRequest object containing the client's request
     * @param response the ServletResponse object containing the filter's response
     * @param chain    the FilterChain for invoking the next filter or resource
     * @throws IOException      if an I/O error occurs during the filter process
     * @throws ServletException if an error occurs while processing the filter
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        if (isLoggedIn) {
            String userType = (String) session.getAttribute("userType");
            String requestURI = httpRequest.getRequestURI();

            // Redirect if the user type does not match the endpoint being accessed
            if (requestURI.contains("/professional/") && !"AcademicProfessional".equals(userType)) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
                return;
            }

            if (requestURI.contains("/institution/") && !"AcademicInstitution".equals(userType)) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
                return;
            }

            chain.doFilter(request, response);
        } else {
            // Redirect to login page if not logged in
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }

    /**
     * Initializes the filter. This method is called by the servlet container when the filter is first initialized.
     *
     * @param filterConfig the FilterConfig object containing filter configuration and initialization parameters
     * @throws ServletException if an error occurs during initialization
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    /**
     * Destroys the filter. This method is called by the servlet container when the filter is taken out of service.
     */
    @Override
    public void destroy() {}
}
