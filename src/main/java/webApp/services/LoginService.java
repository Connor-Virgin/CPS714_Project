package webApp.services;

import org.springframework.stereotype.Service;
import webApp.models.Login;

/*
 * Business layer to be used by LoginController
 * Make calls to backend and perform other functions
 */

@Service
public class LoginService {
    
    //Calls to CRUD_User to confirm validity of login information
    public boolean doesExsist(Login login){
        //TODO Create call to CRUD_User
        return true;
    }
 
}
