package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webApp.models.Reg;
import webApp.models.DoctorReg;
import webApp.models.Login;
import webApp.models.PatientReg;
import webApp.services.RegService;

/*
 * Handles the GET and POST requests on the Registration.html page
 */

@Controller
public class RegistrationController {

    //Instance Variables
    private RegService regService;

    //Constructor (needed for Spring to use the RegService)
    public RegistrationController(RegService regService){
        this.regService = regService;
    }

    //Deals with the HTML get request '/registration'
    @GetMapping("/registration")
	public String reg(Model model, PatientReg patientReg) {
        //Sets regRole to 3 to display patient registration form
        model.addAttribute("regRole", 3);
        //Thymeleaf looks for registration.html in resources/templates/
        return "registration";
    }

    //Deals with get request '/doctorRegistration'
    @GetMapping("/doctorRegistration")
    public String regSubmit(Model model, DoctorReg doctorReg){
        //Sets regRole to 2 to display patient registration form
        model.addAttribute("regRole", 2);
        //Thymeleaf looks for registration.html in resources/templates/
        return "registration";
    }
    
     //Deals with the HTML post request mapped to '/patientReg'
     @PostMapping("/patientReg")
     public String patientReg(Model model, PatientReg patientReg, Login login){
        
        //System.out.println(patientReg.toString());

        if(regService.PatientRegister(patientReg)){
            //Pass a string called errorMessage to be dispayed on login.html
            model.addAttribute("errorMessage", "Registration Successful: Login to access system");
            //Back to login.html
            return "login";
        }
        else{
            //Pass a string called errorMessage to be dispayed on login.html
            model.addAttribute("errorMessage", "Registration Failed: An error has occured");
            //Back to login.html
            return "login";
        }
    }

         //Deals with the HTML post request mapped to '/doctorReg'
         @PostMapping("/doctorReg")
         public String doctorReg(Model model, DoctorReg doctorReg, Reg reg, Login login){
            
            //System.out.println(doctorReg.toString());
    
            if(regService.DoctorRegister(doctorReg)){
                //Pass a string called errorMessage to be dispayed on login.html
                model.addAttribute("errorMessage", "Registration Successful: Login to access system");
                //Back to login.html
                return "login";
            }
            else{
                //Pass a string called errorMessage to be dispayed on login.html
                model.addAttribute("errorMessage", "Registration Failed: An error has occured");
                //Back to login.html
                return "login";
            }
        }
}
