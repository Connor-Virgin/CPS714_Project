package webApp.services;

import org.springframework.stereotype.Service;
import java.util.*;
import backend.DB_User;
import backend.DB_Appointment;
import backend.DB_Doctor;
import backend.DB_Patient;
import objects.User;
import objects.Appointment;
import references.Role;
import references.Status;

/*
 * Business layer to be used by MainController
 * Make calls to backend and perform other functions
 */

@Service
public class MainService {
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

    // Display available appointments by date and doctor

    // profile page:

    public boolean displayAppointmentByDateTimeDoctor(Appointment app) {
        try {
            Appointment a = DB_Appointment.getAppointmentByDateTimeDoctor(app.getDoctorId(), app.getAppointmentStart());
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

    public boolean displayAppointments(Appointment app) {
        try {
            List<Appointment> list = DB_Appointment.getAppointmentsByPatientId(app.getPatientId());
            if (list == null) {
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
