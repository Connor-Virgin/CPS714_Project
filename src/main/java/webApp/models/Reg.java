package webApp.models;

/*
 * Model (object) used for displaying / receiving registration information in the front end
 * Still plan to use objects for backend/business stuff
 */

public class Reg {
    
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String address;
    private String telephone;
    private String role;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Reg(String firstname, String lastname, String email, String address, String telephone,
    String role, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.role = role;
        this.password = password;
    }

    public Reg(){
        
    }

    @Override
    public String toString(){
        return "Login [firstname=" + firstname + ", lastname=" + lastname + ", role=" + role + "]";
    }
    

}
