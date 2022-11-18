package webApp.services;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import backend.DB_Appointment;
import backend.DB_Doctor;
import backend.DB_Patient;
import objects.Appointment;
import objects.Doctor;
import objects.Patient;
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

            //Parse string into calendar object
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(app.getApp_datetime());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            List<Appointment> appointments = DB_Appointment.getAvailableAppointments(app.getDoctor_id(), app.getPatient_id(), cal);
            if (appointments == null) {
                System.out.println("No available appointments");
                return null;
            }
            return appointments;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean createAppointment(Appt appt) {
        try {

            //Parse string into calendar object
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
            Date date = sdf.parse(appt.getApp_datetime());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            Patient patient = DB_Patient.getPatientByUserId(appt.getPatient_id());

            Appointment appointment = new Appointment(cal,appt.getDoctor_id(),patient.getPatientId());

            Appointment a = DB_Appointment.createUpdateUser(appointment);
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

    //Populates List of doctors to display
    public List<Doctor> getAllDoctors(){
        List<Doctor> list = DB_Doctor.getAllDoctors();
        return list;
     }
    
}
