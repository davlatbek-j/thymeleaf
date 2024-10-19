package uz.blacknet.thymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor

@Controller
@RequestMapping("/")
public class HomeController
{
    @GetMapping
    public String home()
    {
        return "home/land";
    }

}
