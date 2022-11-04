package webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

     //Deals with the HTML get request '/demo'
     @GetMapping("/demo")
     public String demo(Model model) {
         //Thymeleaf looks for demo.html in resources/templates/
         return "demo";
     }
}
