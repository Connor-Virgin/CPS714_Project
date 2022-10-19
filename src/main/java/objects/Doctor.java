package objects;

/**
 *
 * @author Connor
 */
public class Doctor extends User {
    // determine what attributes should be unique to doctors
    // Instance Variables
    int doctorID;

    // Setter Classes

    // Getter Classes
    public int getDoctorId() {
        return doctorID;
    }

    // Constructor
    // For READ, UPDATE, DELETE existing doctor
    public Doctor(int doctorID, int user_id, String first_name, String last_name, String address, String telephone,
            int role,
            int status) {
        super(user_id, first_name, last_name, address, telephone, role, status);
        this.doctorID = doctorID;
    }

    // For INSERT new doctor
    public Doctor(String first_name, String last_name, String address, String telephone,
            int role,
            int status) {
        this(0, 0, first_name, last_name, address, telephone, role, status);
    }

    // Default Constructor
    public Doctor() {
        /*
         * this.doctorID = "0000-00-00-AA";
         * this.email = "DoctorPepper@gmail.com";
         * this.password = "password";
         * this.firstName = "Doctor";
         * this.lastName = "Pepper";
         */
    }
}
