package objects;

/**
 *
 * @author Connor
 */
public class appoint {
    //Instance Variables
    String appointID;
    String patientID;
    String doctorID;
    String dateTime;
    String duration;
    
    //Setter Classes
    public void setAppointID(String appointID){
        this.appointID = appointID;
    }
    
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }
    
    public void setDoctorID(String doctorID){
        this.doctorID = doctorID;
    }
    
    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }
    
    public void setDuration(String duration){
        this.duration = duration;
    }
    
    //Getter Classes
    public String getAppointID(){
        return appointID;
    }
    
    public String getPatientID(){
        return patientID;
    }
    
    public String getDoctorID(){
        return doctorID;
    }
    
    public String getDateTime(){
        return dateTime;
    }
    
    public String getDuration(){
        return duration;
    }
    
    //Constructor
    public appoint(String appointID, String patientID, String doctorID, String dateTime, String duration){
        this.appointID = appointID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.dateTime = dateTime;
        this.duration = duration;
    }
    
    //Default Constructor
    public appoint(){
        this.appointID = "0";
        this.patientID = "0000-00-00-AA";
        this.doctorID = "0000-00-00-AA";
        this.dateTime = "2022-10-06T11:30";
        this.duration = "1";
    }
    
    
}
