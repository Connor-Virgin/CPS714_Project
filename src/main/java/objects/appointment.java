package objects;

import java.util.Calendar;

/**
 *
 * @author Connor
 */
public class appointment {
    // Instance Variables
    int appointment_id;
    Calendar appointment_datetime;
    int appointment_duration_min;
    String doctor_id;
    String patient_id;

    // Setter Classes
    public void setAppointmentDateTime(Calendar appointment_datetime) {
        this.appointment_datetime = appointment_datetime;
    }

    public void setAppointmentDuration(int appointment_duration_min) {
        this.appointment_duration_min = appointment_duration_min;
    }

    public void setDoctorID(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setPatientID(String patient_id) {
        this.patient_id = patient_id;
    }

    // Getter Classes
    public int getAppointmentID() {
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

    public String getDoctorID() {
        return doctor_id;
    }

    public String getPatientID() {
        return patient_id;
    }

    // Constructor
    // For READ, UPDATE, DELETE appointment
    public appointment(int appointment_id, Calendar appointment_datetime, int appointment_duration_min,
            String doctor_id, String patient_id) {
        this.appointment_id = appointment_id;
        this.appointment_datetime = appointment_datetime;
        this.appointment_duration_min = appointment_duration_min;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
    }

    // For INSERT new appointment
    public appointment(Calendar appointment_datetime, int appointment_duration_min,
            String doctor_id, String patient_id) {
        this(0, appointment_datetime, appointment_duration_min, doctor_id, patient_id);
    }

    // Default Constructor
    public appointment() {
        /*
         * this.appointID = "0";
         * this.patientID = "0000-00-00-AA";
         * this.doctorID = "0000-00-00-AA";
         * this.dateTime = "2022-10-06T11:30";
         * this.duration = "1";
         */
    }

}
