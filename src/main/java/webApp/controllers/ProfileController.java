package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webApp.models.SessionUser;

@Controller
public class ProfileController {

     //Deals with the HTML get request '/profile'
     @GetMapping("/profile")
     public String profile(Model model, SessionUser sessionUser) {
         //Thymeleaf looks for profile.html in resources/templates/
         return "profile";
     }
}