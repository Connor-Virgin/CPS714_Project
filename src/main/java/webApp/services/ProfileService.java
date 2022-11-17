package webApp.services;
import webApp.models.Appt;
import backend.DB_Appointment;
import objects.Appointment;
import webApp.models.Login;
import webApp.models.SessionUser;
import webApp.services.LoginService;
import java.util.*;

public class ProfileService {

    public String[] displayUserInfo (LoginService user , Login login) {
        try {
            SessionUser sessionUser = user.loginUser(login);
            if (sessionUser == null) {
                return null;
            }
            String role = getUserRole(sessionUser);           
            String[] userInfo = {role, sessionUser.getFirstname(), sessionUser.getLastname(), sessionUser.getEmail()};
            return userInfo;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Appointment> displayAppointments(Appt app) {
        try {
            List<Appointment> list = DB_Appointment.getAppointmentsByPatientId(app.getPatient_id());
            if (list == null) {
                return null;
            }
            return list;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getUserRole (SessionUser sessionUser) {
        switch (sessionUser.getRole()) {
            case 1: 
                return "admin";            
            case 2:
                return "doctor";               
            case 3:
                return "patient";              
            default:
                return null;
            }
    }
}
