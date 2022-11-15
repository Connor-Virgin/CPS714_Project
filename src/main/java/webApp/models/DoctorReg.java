package webApp.models;
/*
 * Model (object) used for displaying / receiving registration information in the front end
 * Still plan to use objects for backend/business stuff
 */

public class DoctorReg extends Reg{

    private String department;
    private String position;

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public DoctorReg(String firstname, String lastname, String email, String address, String telephone,
    String role, String password, String department, String position){
        super(firstname, lastname, email, address, telephone, role, password);
        this.department = department;
        this.position = position;
    }   
}
