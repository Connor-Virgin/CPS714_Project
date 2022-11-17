package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webApp.models.SessionUser;

@Controller
public class AdminController {

     //Deals with the HTML get request '/admin'
     @GetMapping("/admin")
     public String main(Model model, SessionUser sessionUser) {
         //Thymeleaf looks for main.html in resources/templates/
         return "admin";
     }
}
