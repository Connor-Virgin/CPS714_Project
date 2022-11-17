package webApp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import objects.Appointment;
import objects.Doctor;
import webApp.models.Appt;
import webApp.models.SessionUser;
import webApp.services.AdminService;

@Controller
@SessionAttributes({"sessionUser"})
public class AdminController {
    
    //Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

    //Instance Variables
    private AdminService adminService;

    //Constructor (needed for Spring to use the LoginService)
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

     //Deals with the HTML get request '/admin'
     @GetMapping("/admin")
     public String main(Model model, SessionUser sessionUser, Appt appt) {
        //repopulates doctor list
        List<Doctor> allDoctors = adminService.getAllDoctors();
        model.addAttribute("allDoctors", allDoctors);

        //Thymeleaf looks for admin.html in resources/templates/
        return "admin";
     }

     @PostMapping("/getAppointsAdmin")
     public String getAvailableAppts(Model model, SessionUser sessionUser, Appt appt){

        System.out.println("Test " + appt.getDoctor_id());

        //Use services to return the list of appointments by doctor
        List<Appointment> appointments = adminService.displayAppointmentsByDoctor(appt);
        model.addAttribute("appointments", appointments);

        //repopulates doctor list
        List<Doctor> allDoctors = adminService.getAllDoctors();
        model.addAttribute("allDoctors", allDoctors);
        
        //refreshes page, now with appointments added
        return "admin";
     }


}
