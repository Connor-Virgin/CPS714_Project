package objects;

import references.RoleTable;
import references.StatusTable;

public class User {

    // Instance Variables
    int user_id;
    String first_name;
    String last_name;
    String address;
    String telephone;
    int role;
    int status;

    // Setter Classes
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
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

    // Getter Classes
    public String setFirstName() {
        return first_name;
    }

    public String setLastName() {
        return last_name;
    }

    public String setAddress() {
        return address;
    }

    public String setTelephone() {
        return telephone;
    }

    public int setRole() {
        return role;
    }

    public int setStatus() {
        return status;
    }

    // Constructor
    // For read and update
    public User(int user_id, String first_name, String last_name, String address, String telephone, int role,
            int status) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.telephone = telephone;
        this.role = role;
        this.status = status;
    }

    // For new user
    public User(String first_name, String last_name, String address, String telephone, int role, int status) {
        this(0, first_name, last_name, address, telephone, role, status);
    }

    // Default Constructor
    public User() {
        this("John", "Doe", "123 Lakeview Road", "4161234567", RoleTable.Patient.Id,
                StatusTable.Outpatient.Id);
    }
}
