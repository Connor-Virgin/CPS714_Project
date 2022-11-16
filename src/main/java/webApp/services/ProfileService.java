package webApp.services;
import webApp.models.Appt;
import backend.DB_Appointment;
import objects.Appointment;
import java.util.*;

public class ProfileService {

    public List<Appointment> displayAppointments(Appt app) {
        try {
            List<Appointment> list = DB_Appointment.getAppointmentsByPatientId(app.getPatientId());
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
}
