package webApp.services;
import webApp.models.Appt;
import backend.DB_Appointment;
import objects.Appointment;
import webApp.models.SessionUser;
import java.util.*;

public class ProfileService {

    // This will retrieve the user's info to  display on the profile page

    public String[] displayUserInfo (SessionUser sessionUser) {
        try {
            String role = getUserRole(sessionUser);           
            String[] userInfo = {role, sessionUser.getFirstname(), sessionUser.getLastname(), sessionUser.getEmail()};
            return userInfo;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // This will get all the users current appointments

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

    // Helper function

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
