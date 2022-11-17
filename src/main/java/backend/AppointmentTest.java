package backend;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import objects.Appointment;

public class AppointmentTest {
    
    public static void main(String[] args) {
        
        List<Appointment> ls = DB_Appointment.getAppointmentsByDoctorId(1);
        Appointment app = ls.get(0);
        Calendar cal = app.getAppointmentStart();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));

    }

}
