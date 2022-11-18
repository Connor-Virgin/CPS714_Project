package webApp.services;
import webApp.models.Appt;
import webApp.models.DisplayAppoint;
import backend.DB_Appointment;
import backend.DB_Doctor;
import objects.Appointment;
import objects.Doctor;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
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

        public boolean deleteAppt(int ID){
            try {
                if(DB_Appointment.deleteAppointmentByID(ID)){
                    System.out.println("Deleted Appointment with ID: " + ID);
                    return true;
                }
                return false;
            } catch (Exception e) {
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
