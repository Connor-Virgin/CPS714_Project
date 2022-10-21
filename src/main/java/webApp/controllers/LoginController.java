package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webApp.models.Login;
import webApp.services.LoginService;

/*
 * Handles the GET and POST requests on the login.html page
 */

@Controller
public class LoginController {

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

        //if login info deemed valid in the LoginService
        if(loginservice.doesExsist(login)){
            //Pass this.login to home.html
            model.addAttribute("login", login);
            return "home";
        }
        else{
            //Pass a string called errorMessage to be dispayed on login.html
            model.addAttribute("errorMessage", "Login Failed: Your user ID or password is incorrect");
            //Refreshes login.html
            return "login";
        }
    }
}
