package objects;

/**
 *
 * @author Connor
 */
public class doctor extends user {
   //determine what attributes should be unique to doctors
    //Instance Variables
    String doctorID;
    String firstName;
    String lastName;
    
    //Setter Classes
    public void setDoctorID(String doctorID){
        this.doctorID = doctorID;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    //Getter Classes
    public String getDoctorID(){
        return doctorID;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
     public String getLastName(){
        return lastName;
    }
     
    //Constructor
    public doctor(String doctorID, String email, String password, String firstName, String lastName){
        this.doctorID = doctorID;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;       
    }
    
    //Default Constructor
    public doctor(){
        this.doctorID = "0000-00-00-AA"; 
        this.email = "DoctorPepper@gmail.com"; 
        this.password = "password"; 
        this.firstName = "Doctor";
        this.lastName = "Pepper"; 
    } 
}
