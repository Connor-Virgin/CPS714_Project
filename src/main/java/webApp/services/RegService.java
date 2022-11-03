package webApp.services;

import org.springframework.stereotype.Service;
import webApp.models.Reg;
import backend.DB_User;
import objects.User;

/*
 * Business layer to be used by RegistrationController
 * Make calls to backend and perform other functions
 */

@Service
public class RegService {
    public boolean register(Reg reg){
        return true;
    }
}
