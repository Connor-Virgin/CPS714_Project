package frontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Connor
 */

@Controller
public class indexController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
}
