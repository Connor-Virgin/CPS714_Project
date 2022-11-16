package webApp.services;

import org.springframework.stereotype.Service;
import java.util.*;
import backend.DB_Appointment;
import objects.Appointment;
import webApp.models.Appt;

/*
 * Business layer to be used by MainController
 * Make calls to backend and perform other functions
 */

@Service
public class MainService {

    // Display available appointments by date and doctor

    public List<Appointment> checkAvailableAppointments (Appt app) {
        try {
            List<Appointment> appointments = DB_Appointment.getAvailableAppointments(app.getDoctorId(), app.getPatientId(), app.getDateTime());
            return appointments;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean createAppointment(Appointment app) {
        try {
            Appointment a = DB_Appointment.createUpdateUser(app);
            if (a == null) {
                return false;
            }
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
}
