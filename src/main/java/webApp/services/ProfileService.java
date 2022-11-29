package webApp.services;
import webApp.models.Appt;
import backend.DB_Appointment;
import backend.DB_Doctor;
import backend.DB_Patient;
import objects.Appointment;
import objects.Doctor;
import objects.Patient;
import webApp.models.SessionUser;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    //Returns list of appointments given a patients's userID
    public List<Appointment> getPatientAppoints(int userID) {

        try {
            Patient patient = DB_Patient.getPatientByUserId(userID);
            System.out.println(patient.getPatientId());
            List<Appointment> list = DB_Appointment.getAppointmentsByPatientId(patient.getPatientId());
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

    //Returns a Patient given a userID
    public Patient patientInfo(int userID){
        try {
            Patient patient = DB_Patient.getPatientByUserId(userID);
            return patient;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //Returns a Patient given a doctorID
    public Doctor doctorInfo(int doctorID){
        try {
            Doctor doctor = DB_Doctor.getDoctorById(doctorID);
            return doctor;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //Returns a Patient given a doctorID
    public Appointment appointInfo(int appointID){
        try {
            Appointment appointment = DB_Appointment.getAppointmentByID(appointID);
            return appointment;
        } catch (Exception e) {
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
