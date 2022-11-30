package webApp.services;

import backend.DB_Appointment;
import backend.DB_Doctor;
import backend.DB_Patient;
import objects.Appointment;
import objects.Doctor;
import objects.Patient;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    // Returns list of appointments given a doctor's userID
    public List<Appointment> getDoctorAppoints(int userID) {

        try {
            Doctor doctor = DB_Doctor.getDoctorByUserId(userID);
            System.out.println(doctor.getDoctorId());
            List<Appointment> list = DB_Appointment.getAppointmentsByDoctorId(doctor.getDoctorId());
            if (list == null) {
                return null;
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Returns a Patient given a patientID
    public Patient patientInfo(int patientID) {
        try {
            Patient patient = DB_Patient.getPatientById(patientID);
            return patient;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Returns a Patient given a doctorID
    public Appointment appointInfo(int appointID) {
        try {
            Appointment appointment = DB_Appointment.getAppointmentByID(appointID);
            return appointment;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //Updates exsisting Appointment given an Appointment

    // Populates List of doctors to display
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = DB_Doctor.getAllDoctors();
        return list;
    }

}