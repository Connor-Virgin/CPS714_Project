package backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import objects.Appointment;

public class AppointmentTest {
    
    public static void main(String[] args) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2022-11-20");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

        Appointment appointment = new Appointment(cal,4,2);

        /* List<Appointment> ls = DB_Appointment.getAppointmentsByDoctorId(1);
        Appointment app = ls.get(0);
        Calendar cal = app.getAppointmentStart();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(sdf.format(cal.getTime())); */

    }

}
