package dev.yassiraitelghari.maska.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Maps the root path to this method
    public String home() {
        return "index"; // This resolves to /WEB-INF/views/home.jsp
    }
}
