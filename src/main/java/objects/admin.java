/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author Connor
 */
public class admin extends user {
    //Instance Variables
    String adminID;
    
    //Setters
    public void setDoctorID(String adminID){
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
