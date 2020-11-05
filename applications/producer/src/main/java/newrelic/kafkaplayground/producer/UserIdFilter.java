package newrelic.kafkaplayground.producer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebFilter("/*")
public class UserIdFilter implements Filter {

    final String userIdCookieName = "userId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Cookie[] cookies = req.getCookies();
        Cookie userIdCookie = null;

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equals(userIdCookieName)) {
                    userIdCookie = c;
                }
            }
        }

        if (userIdCookie == null) {
            String userId = UUID.randomUUID().toString();
            userIdCookie = new Cookie(userIdCookieName, userId);
            userIdCookie.setPath("/");
        }

        userIdCookie.setMaxAge(24 * 60 * 60);

        res.addCookie(userIdCookie);

        req.setAttribute("userId", userIdCookie.getValue());

        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }

}