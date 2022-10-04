package objects;

/**
 *
 * @author Connor
 */
public class patient extends user {
    //determine what attributes should be unique to patients
    String healthCard;//Unique identifier in database
    String firstName;
    String lastName;
    int age;
    
    //Setter Classes
    public void setHealthCard(String healthCard){
        this.healthCard = healthCard;
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
    public patient(String healthCard, String email, String password, String firstName, String lastName, int age){
        this.healthCard = healthCard;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;       
    }
    
    //Default Constructor
    public patient(){
        this.healthCard = "0000-00-00-AA"; 
        this.email = "johnDoe@gmail.com"; 
        this.password = "password"; 
        this.firstName = "John";
        this.lastName = "Doe";
        this.age = 50; 
    } 
}
