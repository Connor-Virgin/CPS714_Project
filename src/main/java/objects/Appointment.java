package objects;

import java.util.*;

public class Appointment {
    // Instance Variables
    private int appointment_id;
    private Calendar appointment_datetime;
    private int appointment_duration_min;
    private int doctor_id;
    private int patient_id;
    private String doctor_notes;

    // Setter Classes
    public void setAppointmentId(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public void setAppointmentDateTime(Calendar appointment_datetime) {
        this.appointment_datetime = appointment_datetime;
    }

    public void setAppointmentDuration(int appointment_duration_min) {
        this.appointment_duration_min = appointment_duration_min;
    }

    public void setDoctorId(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setPatientId(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctorNotes(String notes) {
        this.doctor_notes = notes;
    }

    // Getter Classes
    public int getAppointmentId() {
        return appointment_id;
    }

    public Calendar getAppointmentStart() {
        return appointment_datetime;
    }

    public int getAppointmentDuration() {
        return appointment_duration_min;
    }

    public Calendar getAppointmentEnd() {
        Calendar appointment_end = (Calendar) appointment_datetime.clone();
        appointment_end.add(Calendar.MINUTE, appointment_duration_min);
        return appointment_end;
    }

    public int getDoctorId() {
        return doctor_id;
    }

    public int getPatientId() {
        return patient_id;
    }

    public String getDoctorNotes() {
        return doctor_notes;
    }

    // Constructor
    // For READ, UPDATE, DELETE existing appointment
    public Appointment(int appointment_id, Calendar appointment_datetime,
            int doctor_id, int patient_id, String doctor_notes) {
        this.appointment_id = appointment_id;
        this.appointment_datetime = appointment_datetime;
        this.appointment_duration_min = 30;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.doctor_notes = doctor_notes;
    }

    // For INSERT new appointment
    public Appointment(Calendar appointment_datetime,
            int doctor_id, int patient_id) {
        this(0, appointment_datetime, doctor_id, patient_id, "Notes: ");
    }

    // Default Constructor
    public Appointment() {
        /*
         * this.appointID = "0";
         * this.patientID = "0000-00-00-AA";
         * this.doctorID = "0000-00-00-AA";
         * this.dateTime = "2022-10-06T11:30";
         * this.duration = "1";
         */
    }

}
