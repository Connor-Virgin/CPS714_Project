package webApp.services;

import org.springframework.stereotype.Service;
import webApp.models.Login;

@Service("ls")
public class LoginService {
    
    public boolean doesExsist(Login login){
        return true;
    }
 
}
