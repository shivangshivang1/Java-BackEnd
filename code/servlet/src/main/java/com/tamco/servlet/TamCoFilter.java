package com.tamco.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TamCoFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String password = servletRequest.getParameter("password");
        if ("tamco".equalsIgnoreCase(password)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setContentType("text/html");
            PrintWriter out = servletResponse.getWriter();
            out.println("<html><body>");
            out.println("<h1>Only TamCO can get there!</h1>");
            out.println("</body></html>");
        }
    }

    public void destroy() {

    }
}
