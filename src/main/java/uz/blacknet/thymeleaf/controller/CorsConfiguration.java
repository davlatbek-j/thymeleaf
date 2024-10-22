package uz.blacknet.thymeleaf.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CorsConfiguration implements Filter, WebMvcConfigurer
{

    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain filterChain) throws IOException, ServletException
    {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token, token, API-Key");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if (!(request.getMethod().equalsIgnoreCase("OPTIONS")))
        {
            filterChain.doFilter(request, response);
        } else
        {
            response.setHeader("Access-Control-Allowed-Methods", "POST, GET, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type,x-auth-token, " + "access-control-request-headers, access-control-request-method, accept, origin, token, authorization, x-requested-with,Accountcode,API-Key");

            response.setStatus(HttpServletResponse.SC_OK);
        }
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        doFilterInternal((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")  // Allow CORS for all endpoints
                .allowedOrigins(
                        "http://127.0.0.1:1984",
                        "https://nj.mrjtrade.uz") // Replace with the domain of your Swagger UI
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Methods you want to allow
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}

