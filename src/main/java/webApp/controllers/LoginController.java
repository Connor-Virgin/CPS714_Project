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

    @GetMapping("/login")
	public String login(Model model, Login login) {
        return "login";
    }
        
    @PostMapping("/submit")
    public String loginSubmit(Model model, Login login){
        System.out.println(login.toString());
        //model.addAttribute("email", login.getEmail());
        model.addAttribute("message", login.getEmail());
        return "home";
    }
}
