package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import objects.Doctor;

import webApp.models.Login;
import webApp.models.SessionUser;
import webApp.models.Appt;

import webApp.services.LoginService;

/*
 * Handles the GET and POST requests on the login.html page
 */

@Controller
@SessionAttributes({"sessionUser"})
public class LoginController {

    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

    //Instance Variables
    private LoginService loginservice;

    //Constructor (needed for Spring to use the LoginService)
    public LoginController(LoginService loginservice){
        this.loginservice = loginservice;
    }

    //Deals with the HTML get request '/login'
    @GetMapping("/login")
	public String login(Model model, Login login) {
        //Thymeleaf looks for login.html in resources/templates/
        return "login";
    }
    
    //Deals with the HTML post request mapped to '/submit'
    @PostMapping("/submit")
    public String loginSubmit(Model model, Login login){
        System.out.println(login.toString());
        
        try{
            SessionUser sessionUser = loginservice.loginUser(login);
            if (sessionUser == null){
                //Pass a string called errorMessage to be dispayed on login.html
                model.addAttribute("errorMessage", "Login Failed: Your user ID or password is incorrect");
                //Refreshes login.html
                return "login";
            }
            else{
                List<Doctor> allDoctors = loginservice.getAllDoctors();
                model.addAttribute("allDoctors", allDoctors);
                Appt appt = new Appt();
                model.addAttribute("sessionUser", sessionUser);
                model.addAttribute("appt", appt );
                
                switch (sessionUser.getRole()) {
                    //Admin
                    case 1:
                        return "admin";
                    //Doctor
                    case 2:
                        return "main";
                    //Patient
                    case 3:
                        return "main";
                    default:
                        //Pass a string called errorMessage to be dispayed on login.html
                        model.addAttribute("errorMessage", "Error Identifying Account Type");
                        //Refreshes login.html
                        return "login";
                }
            }

        }
        catch(Exception e){
            //Pass a string called errorMessage to be dispayed on login.html
            model.addAttribute("errorMessage", "Error on Login");
            //Refreshes login.html
            return "login";
        }
    }
}
