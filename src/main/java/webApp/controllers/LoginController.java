package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webApp.models.Login;

@Controller
public class LoginController {
    
    @GetMapping("/login")
	public String login(Model model, Login login) {
        return "login";
    }
        
    @PostMapping("/submit")
    public String loginSubmit(Model model, Login login){
        System.out.println(login.toString());
        return "login";
    }
}
