package uz.blacknet.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController
{

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model)
    {
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");

        if (statusCode != null && statusCode == 404)
        {
            return "error/404"; // Return the 404.html template
        }
        model.addAttribute("code", statusCode);

        return "error/error"; // You can create a generic error.html page as well
    }

}
