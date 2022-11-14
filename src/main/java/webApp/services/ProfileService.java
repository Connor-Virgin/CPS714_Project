package webApp.services;
import webApp.models.App;
import backend.DB_Appointment;
import objects.Appointment;
import java.util.*;

public class ProfileService {

    public boolean displayAppointments(App app) {
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
