package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webApp.models.SessionUser;

@Controller
public class LoginTestController {

     //Deals with the HTML get request '/home'
     @GetMapping("/loginTest")
     public String home(Model model, SessionUser sessionUser) {
         //Thymeleaf looks for home.html in resources/templates/
         return "loginTest";
     }
}