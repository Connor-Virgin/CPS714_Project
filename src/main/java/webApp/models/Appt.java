package webApp.models;
import java.util.Calendar;

public class Appt {
    private String app_datetime;
    private int doctor_id;
    private int patient_id;
    private Calendar cal;

    public Calendar getCal() {
        return this.cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }

    public String getApp_datetime() {
        return this.app_datetime;
    }

    public void setApp_datetime(String app_datetime) {
        this.app_datetime = app_datetime;
    }

    public int getDoctor_id() {
        return this.doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Appt(String app_datetime, int doctor_id, int patient_id) {
        this.app_datetime = app_datetime;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.cal = null;
    }

    public Appt(Calendar cal, int doctor_id, int patient_id) {
        this.app_datetime = null;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.cal = cal;
    }

    public Appt(){
        this.app_datetime = null;
        this.cal = null;
        this.doctor_id = 0;
        this.patient_id = 0;
    }

    @Override
    public String toString() {
        return "Appointment [date=" + app_datetime + ", patient_id=" + patient_id + "doctor_id = " + doctor_id + "]";
    }
    
}
