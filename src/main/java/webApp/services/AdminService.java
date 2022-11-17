package webApp.services;
import webApp.models.Appt;
import backend.DB_Appointment;
import objects.Appointment;
import java.util.*;

public class AdminService {
        // The admin should be able to view all appointments based on the doctor

        public List<Appointment> displayAppointmentsByDoctor(Appt app) {
            try {
                // We want to get the list of appointments based on a "doctor" dropdown menu the admin chooses... not based on appointment
                // So admin should be able to: Choose a doctor (Dr1, Dr2, Dr3) and whichever one is chosen should display all their appointments
                List<Appointment> list = DB_Appointment.getAppointmentsByDoctorId(app.getDoctor_id());
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
