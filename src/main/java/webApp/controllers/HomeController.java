package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webApp.models.Login;

@Controller
public class HomeController {

     //Deals with the HTML get request '/home'
     @GetMapping("/home")
     public String home(Model model, Login login) {
         //Thymeleaf looks for home.html in resources/templates/
         return "home";
     }
}