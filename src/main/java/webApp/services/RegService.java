package webApp.services;

import org.springframework.stereotype.Service;
import webApp.models.Reg;
import backend.DB_User;
import objects.User;
import references.Role;
import references.Status;

/*
 * Business layer to be used by RegistrationController
 * Make calls to backend and perform other functions
 */

@Service
public class RegService {
    public boolean register(Reg reg){
        try {
            User user = new User(reg.getEmail(), reg.getFirstname(), reg.getLastname(), reg.getEmail(), reg.getAddress(),
                reg.getTelephone(),Integer.parseInt(reg.getRole()),Status.Outpatient.Id,reg.getPassword());

            DB_User.createUpdateUser(user);
            return true; 
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
