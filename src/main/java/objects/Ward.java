package objects;
import java.util.*;

public class Ward {
    private int room_number;
    private String department;
    private List<Patient> listOfPatients; // Each ward/room will be assigned to a certian list/number of patients

    public int getRoomNumber () {
        return room_number;
    }

    public String getDepartment () {
        return department;
    }

    public List<Patient> getPatientsInRoom() {
        return listOfPatients;
    }

    public void setRoomNumber (int room_number) {
        this.room_number = room_number;
    }

    public void setDepartment (String department) {
        this.department = department;
    }

    public void  setPatientsInRoom(List<Patient> listOfPatients) {
        this.listOfPatients = listOfPatients;
    }

    public boolean isPatientInRoom (Patient patient, List<Patient> listOfPatients) {
        if (listOfPatients.contains(patient)) {
            return true;
        }
        return false;
    }

    //Constructors
    //For read, update, delete wards
    public Ward(int room_number, String department, List<Patient> listOfPatients) {
        this.room_number = room_number;
        this.department = department;
        this.listOfPatients = listOfPatients;
    }

    // For insert new wards
    public Ward(String department, List<Patient> listOfPatients) {
        this(0, department, listOfPatients);
    }

    // Default 
    public Ward() {
        this("Surgery", null);
    }

}
