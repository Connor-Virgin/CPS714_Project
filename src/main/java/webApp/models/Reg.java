package webApp.models;

public class Reg {
    
    private String firstname;
    private String lastname;
    private String healthcardnumber;
    private String email;
    private String password;

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

    public String getHealthcardnumber() {
        return this.healthcardnumber;
    }

    public void setHealthcardnumber(String healthcardnumber) {
        this.healthcardnumber = healthcardnumber;
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

    public Reg(String firstname, String lastname, String healthcardnumber, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.healthcardnumber = healthcardnumber;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString(){
        return "Login [firstname=" + firstname + ", lastname=" + lastname + "]";
    }
    

}
