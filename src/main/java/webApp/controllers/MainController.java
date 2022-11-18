package webApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import objects.Appointment;
import objects.Doctor;

import org.springframework.web.bind.annotation.RequestBody;

import webApp.models.Appt;
import webApp.models.SessionUser;
import webApp.services.MainService;


@Controller
@SessionAttributes({"sessionUser"})
public class MainController {
    
    //Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

    //Instance Variables
    private MainService mainService;

    //Constructor (needed for Spring to use the LoginService)
    public MainController(MainService mainService){
        this.mainService = mainService;
    }

     //Deals with the HTML get request '/main'
     @GetMapping("/main")
     public String main(Model model, SessionUser sessionUser, Appt appt) {
         //Thymeleaf looks for main.html in resources/templates/
         return "main";
     }

    
     @PostMapping("/Availabilty")
     public String getAvailableAppts(Model model, SessionUser sessionUser, Appt appt){
        
        List<Appointment> appointments = mainService.checkAvailableAppointments(appt);
        model.addAttribute("appointments", appointments);

        //Use services to return the list of available appointments to be displayed on the page
        System.out.println("Test " + appt.getDoctor_id() + appt.getApp_datetime());

                //repopulates doctor list
                List<Doctor> allDoctors = mainService.getAllDoctors();
                model.addAttribute("allDoctors", allDoctors);
        //refreshes page, now with appointments added
        return "main";
}

/*@PostMapping("/CreateAppointment")
public String getAvailableAppts(Model model, SessionUser sessionUser, Appt appt){
   


}*/
    


    }