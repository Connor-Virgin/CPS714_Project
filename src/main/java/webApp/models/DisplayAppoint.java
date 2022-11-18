package webApp.models;

public class DisplayAppoint{
    private int appointment_id;
    private String appointment_datetime;
    private int doctor_id;
    private int patient_id;

    public int getAppointment_id() {
        return this.appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public DisplayAppoint(int appointment_id){
        this.appointment_id = appointment_id;
    }

    public DisplayAppoint(){
        this.appointment_id = 0;
    }

}
