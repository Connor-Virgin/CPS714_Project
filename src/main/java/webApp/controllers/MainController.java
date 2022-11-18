package webApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import objects.Appointment;
import objects.Doctor;

import org.springframework.web.bind.annotation.RequestBody;

import webApp.models.Appt;
import webApp.models.DisplayAppoint;
import webApp.models.SessionUser;
import webApp.services.MainService;

@Controller
@SessionAttributes({ "sessionUser"})
public class MainController {

    int selectedDoctor = 0;

    // Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser() {
        return new SessionUser();
    }

    // Instance Variables
    private MainService mainService;

    // Constructor (needed for Spring to use the MainService)
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    // Deals with the HTML get request '/main'
    @GetMapping("/main")
    public String main(Model model, SessionUser sessionUser, Appt appt) {
        // repopulates doctor list
        List<Doctor> allDoctors = mainService.getAllDoctors();
        model.addAttribute("allDoctors", allDoctors);

        // Thymeleaf looks for main.html in resources/templates/
        return "main";
    }

    @PostMapping("/Availabilty")
    public String getAvailableAppts(Model model, SessionUser sessionUser, Appt appt) {

        // Use services to return the list of available appointments to be displayed on
        // the page
        //System.out.println("User ID: " + sessionUser.getUser_id());

        List<Appointment> appointments = mainService.checkAvailableAppointments(appt);
        model.addAttribute("appointments", appointments);

        selectedDoctor = appt.getDoctor_id();

        //System.out.println("Test " + appt.getDoctor_id() + appt.getApp_datetime());

        // repopulates doctor list
        List<Doctor> allDoctors = mainService.getAllDoctors();
        model.addAttribute("allDoctors", allDoctors);

        DisplayAppoint displayAppoint = new DisplayAppoint();
        model.addAttribute("displayAppoint", displayAppoint);

        // refreshes page, now with appointments added
        return "main";
    }

    @PostMapping("/bookAppoint")
    public String bookAppoint(Model model, SessionUser sessionUser, Appt appt) {

        System.out.println("book user: " + sessionUser.getUser_id());
        System.out.println("book doctor: " + selectedDoctor);
        System.out.println("book date: " + appt.getApp_datetime());

        Appt appoint = new Appt(appt.getApp_datetime(),selectedDoctor,sessionUser.getUser_id());

        if(mainService.createAppointment(appoint)){
            model.addAttribute("message", "Success: Appointment Created");
        }
        else{
            model.addAttribute("message", "Error: Appointment not Created");
        }
        // repopulates doctor list
        List<Doctor> allDoctors = mainService.getAllDoctors();
        model.addAttribute("allDoctors", allDoctors);

        // refreshes page
        return "main";
    }

}