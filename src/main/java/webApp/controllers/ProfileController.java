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
import objects.Patient;
import webApp.models.Appt;
import webApp.models.SessionUser;
import webApp.services.ProfileService;

@Controller
@SessionAttributes({"sessionUser"})
public class ProfileController {

    //Used to keep sessionUser info on page even when reloaded
    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

    //Instance Variables
    private ProfileService profileService;

    //Constructor (needed for Spring to use the profileService)
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

     //Deals with the HTML get request '/profile'
     @GetMapping("/profile")
     public String main(Model model, SessionUser sessionUser) {

        Patient patient = profileService.patientInfo(sessionUser.getUser_id());
        model.addAttribute("patient", patient);

        List<Appointment> appointments = profileService.getPatientAppoints(sessionUser.getUser_id());
        model.addAttribute("appointments", appointments);
        
        //Thymeleaf looks for profile.html in resources/templates/
        return "profile";
     }

/*     @GetMapping("/profileInfo/{id}")
	public String patientInfo(@PathVariable int id, Model model, SessionUser sessionUser) {
		Patient patient = profileService.patientInfo(id);
        model.addAttribute("patient", patient);
		return "profile";
	} */

    @GetMapping("/deleteAppointsPatient/{id}")
	public String deleteAppt(@PathVariable int id) {
		profileService.deleteAppt(id);
		return "redirect:/profile";
	}

}