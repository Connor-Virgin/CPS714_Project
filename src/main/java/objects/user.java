package objects;

import references.Role;
import references.Status;

public class User {

    // Instance Variables
    int user_id;
    String user_name;
    String first_name;
    String last_name;
    String email;
    String address;
    String telephone;
    int role;
    int status;
    String password;

    // Setter Classes
    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter Classes
    public int getUserId() {
        return user_id;
    }

    public String getUserName() {
        return user_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getRole() {
        return role;
    }

    public int getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    // Constructor
    // For READ, UPDATE, DELETE existing users
    public User(int user_id, String user_name, String first_name, String last_name, String email, String address,
            String telephone, int role, int status, String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.telephone = cleanTelephone(telephone);
        this.role = role;
        this.status = status;
        this.password = password;
    }

    // For INSERT new users
    public User(String user_name, String first_name, String last_name, String email, String address, String telephone,
            int role, int status, String password) {
        this(0, user_name, first_name, last_name, email, address, telephone, role, status, password);

    }

    // Default Constructor
    public User() {
        this("jdoe", "John", "Doe", "jdoe@hospitalerp.com", "123 Lakeview Road", "4161234567", Role.Patient.Id,
                Status.Outpatient.Id, "12345");
    }

    // Telephone number cleanup
    private String cleanTelephone(String telephone) {

        // Remove non-numeric
        String telephone_number = telephone.replaceAll("[^\\d]", "");

        // Right most 10 digits
        telephone_number = telephone_number == null || telephone_number.length() < 10 ? telephone_number
                : telephone_number.substring(telephone_number.length() - 10);

        return telephone_number;
    }

    public String toString() {
        return user_id + " - " + last_name + ", " + first_name + " : " + Role.getById(role) + " - "
                + Status.getById(status);
    }
}
