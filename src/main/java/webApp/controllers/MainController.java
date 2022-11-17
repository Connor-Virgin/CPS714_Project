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
public class MainController {
    
    //Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

     //Deals with the HTML get request '/main'
     @GetMapping("/main")
     public String main(Model model, SessionUser sessionUser, Appt appt) {
         //Thymeleaf looks for main.html in resources/templates/
         return "main";
     }

     @PostMapping("/Availabilty")
     public String getAvailableAppts(Model model, SessionUser sessionUser, Appt appt){
        //TODO

        //Use services to return the list of available appointments to be displayed on the page
        System.out.println("Test " + appt.getDoctor_id());
        //refreshes page, now with appointments added
        return "main";
     }
}
