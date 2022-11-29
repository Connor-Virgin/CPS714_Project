package webApp.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import webApp.models.PatientReg;
import webApp.models.DoctorReg;
import webApp.models.Reg;

import backend.DB_User;
import backend.DB_Patient;
import backend.DB_Doctor;

import objects.Patient;
import objects.Doctor;
import objects.User;

import references.Role;
import references.Status;

/*
 * Business layer to be used by RegistrationController
 * Make calls to backend and perform other functions
 */

@Service
public class RegService {

    //For patient registration
    public boolean PatientRegister(PatientReg reg){
        
        try {

            //Parse string into calendar object
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(reg.getBirthdate());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            //Create new patient object
            Patient patient = new Patient(reg.getEmail(), reg.getFirstname(), reg.getLastname(), reg.getHealth_card(), reg.getEmail(), reg.getAddress(),
            reg.getTelephone(), cal, reg.getGender(), Integer.parseInt(reg.getHeight_cm()), Integer.parseInt(reg.getweight_kg()),
            Role.Patient.Id, Status.Outpatient.Id, 0, 0, reg.getPassword());

            //add to database
            DB_Patient.createUpdatePatient(patient);
            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    //For Doctor Registration
    public boolean DoctorRegister(DoctorReg reg){
        try {
            //Create new doctor object
            Doctor doctor = new Doctor(reg.getEmail(), reg.getFirstname(), reg.getLastname(), reg.getEmail(), reg.getAddress(),
            reg.getTelephone(), reg.getDepartment(), reg.getPosition(), Role.Doctor.Id, Status.Staff.Id, reg.getPassword());

            //add to database
            DB_Doctor.createUpdateDoctor(doctor);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //For user registraion (not used)
    public boolean register(Reg reg){
        try {
            User user = new User(reg.getEmail(), reg.getFirstname(), reg.getLastname(), reg.getEmail(), reg.getAddress(),
                reg.getTelephone(),Integer.parseInt(reg.getRole()),Status.Outpatient.Id,reg.getPassword());

            DB_User.createUpdateUser(user);
            return true; 
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
