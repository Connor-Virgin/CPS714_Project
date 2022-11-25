package webApp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import objects.Appointment;
import objects.Doctor;
import objects.Patient;
import webApp.models.Appt;
import webApp.models.SessionUser;
import webApp.models.DisplayAppoint;
import webApp.services.DoctorService;

@Controller
@SessionAttributes({"sessionUser"})
public class DoctorController {
    
    //Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

    //Instance Variables
    private DoctorService doctorService;

    //Constructor (needed for Spring to use the doctorService)
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

     //Deals with the HTML get request '/doctor'
     @GetMapping("/doctor")
     public String main(Model model, SessionUser sessionUser) {

        List<Appointment> appointments = doctorService.getDoctorAppoints(sessionUser.getUser_id());
        model.addAttribute("appointments", appointments);
        //Thymeleaf looks for doctor.html in resources/templates/
        return "doctor";
     }

    @GetMapping("/patientInfo/{id}")
	public String patientInfo(@PathVariable int id, Model model, SessionUser sessionUser) {
		Patient patient = doctorService.patientInfo(id);
        model.addAttribute("patient", patient);
		return "doctor";
	}
     
}
