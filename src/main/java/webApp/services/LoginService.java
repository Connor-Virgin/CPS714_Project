package webApp.services;

import org.springframework.stereotype.Service;
import webApp.models.Login;
import backend.DB_User;
import objects.User;

/*
 * Business layer to be used by LoginController
 * Make calls to backend and perform other functions
 */

@Service
public class LoginService {
    
    //Calls to DB_User to confirm validity of login information
    public boolean doesExsist(Login login){
        try{
            User userInfo = DB_User.getUser(login.getEmail(), login.getPassword());
            if(userInfo == null){
                return false;
            }
            return true;
        } catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
