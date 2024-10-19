package uz.blacknet.thymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api")
public class AuthController
{
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password)
    {
        return "success POST";
    }

//    @GetMapping("/login")
    public String login()
    {
        return "success GET";
    }

}
