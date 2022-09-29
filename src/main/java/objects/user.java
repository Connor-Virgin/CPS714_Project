package objects;

/**
 *
 * @author Connor
 */
public class user {
   
    //Instance Variables
    String healthCard;//Unique identifier in database
    String email;
    String password;
    String firstName;
    String lastName;
    int age;
    
    //Setter Classes
    public void setHealthCard(String healthCard){
        this.healthCard = healthCard;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setAge(int age){
        this.age = age;
    }
     
    //Getter Classes
    public String getHealthCard(){
        return healthCard;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
     public String getLastName(){
        return lastName;
    }
     
    public int getAge(){
        return age;
    }
    
    //Constructor
    public user(String healthCard, String email, String password, String firstName, String lastName, int age){
        this.healthCard = healthCard;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;       
    }
    
    //Default Constructor
    public user(){
        this.healthCard = "0000-00-00-AA"; 
        this.email = "johnDoe@gmail.com"; 
        this.password = "password"; 
        this.firstName = "John";
        this.lastName = "Doe";
        this.age = 50; 
    }
}
