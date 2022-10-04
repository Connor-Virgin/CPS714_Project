package objects;

/**
 *
 * @author Connor
 */
public class user {
   
    //Instance Variables
    String email;
    String password;
    
    //Setter Classes
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    //Getter Classes
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    //Constructor
    public user(String email, String password){
        this.email = email;
        this.password = password;    
    }
    
    //Default Constructor
    public user(){
        this.email = "johnDoe@gmail.com"; 
        this.password = "password"; 
    }
}
