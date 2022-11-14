package webApp.models;

/*
 * Model (object) used for displaying / receiving registration information in the front end
 * Still plan to use objects for backend/business stuff
 */

public class SessionUser {

    private int user_id;
    private int role;
    private String firstname;
    private String lastname;
    private String email;

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
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

    public SessionUser(String firstname, String lastname, String email, int role, int user_id){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.user_id = user_id;
    }

    public SessionUser(){
        this.firstname = "firstname";
        this.lastname = "lastname";
        this.email = "email";
        this.role = 0;
        this.user_id = 0;
    }

    @Override
    public String toString(){
        return "SessionUser [user_id=" + user_id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", role=" + role + "]";
    }
}