package objects;

/**
 *
 * @author Connor
 */
public class admin extends user {
    //Instance Variables
    String adminID;
    
    //Setters
    public void setAdminID(String adminID){
        this.adminID = adminID;
    }
    
    //Getters
    public String getAdminID(){
        return adminID;
    }
    
    //Constructor
    public admin(String email, String password, String adminID){
        this.adminID = adminID;
        this.email = email;
        this.password = password;    
    }
    
    //Default Constructor
    public admin(){
        this.adminID = "0000-00-00-AA"; 
        this.email = "johnDoe@gmail.com"; 
        this.password = "password"; 
    }
}
