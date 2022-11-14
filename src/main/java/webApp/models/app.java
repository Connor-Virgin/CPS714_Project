package webApp.models;

import java.util.Calendar;

public class App {
    private Calendar app_datetime;
    private int app_ID;
    private int doctor_id;
    private int patient_id;

    public Calendar getDateTime() {
        return app_datetime;
    }
    public void setAppDateTime(Calendar app_datetime) {
        this.app_datetime = app_datetime;
    }

    public int getAppointmentID() {
        return app_ID;
    }
    
    public void setAppID(int app_ID) {
        this.app_ID = app_ID;
    }

    public int getDoctorId() {
        return doctor_id;
    }

    public int getPatientId() {
        return patient_id;
    }

    public void setDoctorId(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setPatientId(int patient_id) {
        this.patient_id = patient_id;
    }

    public App (Calendar app_datetime, int doctor_id, int patient_id) {
        this.app_datetime = app_datetime;
        this.app_ID = app_ID;
        this.patient_id = patient_id;
    }

    public App (Calendar app_datetime, int app_ID) {
        this.app_datetime = app_datetime;
        this.app_ID = app_ID;
    }
}
