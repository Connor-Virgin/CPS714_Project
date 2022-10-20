package webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(projectApplication.class, args);
	}

	@GetMapping("/login")
	public String login() {
            return "login";
        }
        
        @PostMapping("/submit")
        public String loginSubmit(){
            System.out.println("\nSubmitted\n");
            return "login";
        }
}
