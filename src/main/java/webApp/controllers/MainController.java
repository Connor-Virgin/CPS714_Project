package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

     //Deals with the HTML get request '/main'
     @GetMapping("/main")
     public String main(Model model) {
         //Thymeleaf looks for main.html in resources/templates/
         return "main";
     }
}
