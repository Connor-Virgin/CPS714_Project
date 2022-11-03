package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webApp.models.Reg;
import webApp.models.Login;
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
	public String reg(Model model, Reg reg) {
        //Thymeleaf looks for registration.html in resources/templates/
        return "registration";
    }
    
     //Deals with the HTML post request mapped to '/regsubmit'
     @PostMapping("/regsubmit")
     public String regSubmit(Model model, Reg reg, Login login){
        
        System.out.println(reg.toString());

        if(regService.register(reg)){
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
