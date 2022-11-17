package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import webApp.models.Appt;
import webApp.models.SessionUser;

@Controller
@SessionAttributes({"sessionUser"})
public class ProfileController {

    //Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

     //Deals with the HTML get request '/profile'
     @GetMapping("/profile")
     public String profile(Model model, SessionUser sessionUser,  Appt appt) {
         //Thymeleaf looks for profile.html in resources/templates/
         
         System.out.println(sessionUser);
         return "profile";
     }
}