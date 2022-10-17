package objects;

/**
 *
 * @author Connor
 */
public class doctor extends user {
    // determine what attributes should be unique to doctors
    // Instance Variables
    int doctorID;

    // Setter Classes
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    // Getter Classes
    public int getDoctorID() {
        return doctorID;
    }

    // Constructor
    public doctor(int doctorID, int user_id, String first_name, String last_name, String address, String telephone,
            int role,
            int status) {
        super(user_id, first_name, last_name, address, telephone, role, status);
        this.doctorID = doctorID;
    }

    // Default Constructor
    public doctor() {
        /*
         * this.doctorID = "0000-00-00-AA";
         * this.email = "DoctorPepper@gmail.com";
         * this.password = "password";
         * this.firstName = "Doctor";
         * this.lastName = "Pepper";
         */
    }
}
