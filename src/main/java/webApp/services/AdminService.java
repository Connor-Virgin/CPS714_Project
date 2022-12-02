package webApp.services;

import webApp.models.Appt;
import webApp.models.DisplayAppoint;
import backend.DB_Appointment;
import backend.DB_Doctor;
import backend.DB_Patient;
import objects.Appointment;
import objects.Doctor;
import objects.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
    // The admin should be able to view all appointments based on the doctor

    public List<Appointment> displayAppointmentsByDoctor(Appt app) {
        try {
            // We want to get the list of appointments based on a "doctor" dropdown menu the
            // admin chooses... not based on appointment
            // So admin should be able to: Choose a doctor (Dr1, Dr2, Dr3) and whichever one
            // is chosen should display all their appointments
            List<Appointment> list = DB_Appointment.getAppointmentsByDoctorId(app.getDoctor_id());
            if (list == null) {
                return null;
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //Deletes appointment by ID
    public boolean deleteAppt(int ID) {
        try {
            if (DB_Appointment.deleteAppointmentByID(ID)) {
                System.out.println("Deleted Appointment with ID: " + ID);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Patient> getWardPatients(int ward) {
        try {
            List<Patient> list = DB_Patient.getPatientsByWard(ward);
            if (list == null) {
                return null;
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //Gets Available Rooms given ward
    public List<Integer> getAvailableRooms(int ward){
        List<Integer> rooms = new ArrayList<>();
        for (int index = 1; index < 50; index++) {
            rooms.add(index);
        }
        //List<Integer> rooms = DB_Patient.getAvailableRoomsByWard(ward);
        return rooms;
    }

    // Updates exsisting Ward and Status given patientID and new Ward 
    public boolean updateWard(int patientID, int ward, int room) {
        try {
            Patient patient = DB_Patient.getPatientById(patientID);
            patient.setWard(ward);

            //Setting status to 'Outpatient' if ward is 0, 'Inpatient' if else
            if(ward == 0){
                patient.setStatus(3);
                patient.setRoom(0);
            }
            else{
                patient.setStatus(2);
                patient.setRoom(room);
            }

            DB_Patient.createUpdatePatient(patient);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // Populates List of doctors to display
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = DB_Doctor.getAllDoctors();
        return list;
    }

}
