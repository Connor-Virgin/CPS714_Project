package webApp.models;
/*
 * Login model used recieve post request from view layer (html)
 * To be used to populate Account object for business services
 */
public class Login {

    private String email;
    private String password;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login [email=" + email + ", password=" + password + "]";
    }

}
