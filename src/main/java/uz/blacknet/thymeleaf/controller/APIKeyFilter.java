package uz.blacknet.thymeleaf.controller;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class APIKeyFilter extends OncePerRequestFilter
{
    @Value("${api.key}")
    String apiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String key = request.getHeader("API-Key");
//        logger.info("API-Key:" + key);
        if (request.getMethod().equalsIgnoreCase("GET"))
            filterChain.doFilter(request, response);
        else if (apiKey.equals(key))
            doFilter(request, response, filterChain);
        else if (request.getRequestURI().equals("/api/bot"))
            filterChain.doFilter(request, response);
        else
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
