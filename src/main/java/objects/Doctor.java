package objects;

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
    public Doctor(int doctorID, int user_id, String user_name, String first_name, String last_name, String email,
            String address, String telephone, int role, int status, String password) {
        super(user_id, user_name, first_name, last_name, email, address, telephone, role, status, password);
        this.doctorID = doctorID;
    }

    // For INSERT new doctor
    public Doctor(String user_name, String first_name, String last_name, String email, String address, String telephone,
            int role, int status, String password) {
        this(0, 0, user_name, first_name, last_name, email, address, telephone, role, status, password);
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
