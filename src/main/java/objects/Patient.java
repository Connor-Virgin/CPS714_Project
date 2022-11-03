package objects;

import java.util.Calendar;

public class Patient extends User {
    // determine what attributes should be unique to patients
    int patient_id;
    String health_card;
    Calendar birthdate;
    String gender;
    int height_cm;
    int weight_lbs;

    // Setter Classes
    public void setHealthCard(String healthCard) {
        this.health_card = healthCard;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(int height_cm) {
        this.height_cm = height_cm;
    }

    public void setWeight(int weight_lbs) {
        this.weight_lbs = weight_lbs;
    }

    // Getter Classes

    public int getPatientId() {
        return patient_id;
    }

    public String getHealthCard() {
        return health_card;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public int getAge() {

        Calendar currentDate = Calendar.getInstance();
        int age = currentDate.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);
        if ((birthdate.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))
                || (birthdate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                        && birthdate.get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH))) {
            // decrements age by 1 if birthday has not passed this year
            age--;
        }

        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getHeight() {
        return height_cm;
    }

    public int getWeight() {
        return weight_lbs;
    }

    // Constructor
    // For read, update, delete patient+user
    public Patient(int patient_id, int user_id, String user_name, String first_name, String last_name,
            String health_card, String email, String address, String telephone, Calendar birthdate, String gender,
            int height_cm, int weight_lbs, int role, int status, String password) {
        super(user_id, user_name, first_name, last_name, email, address, telephone, role, status, password);

        this.patient_id = patient_id;
        this.health_card = health_card;
        this.birthdate = birthdate;
        this.gender = gender;
        this.height_cm = height_cm;
        this.weight_lbs = weight_lbs;

    }

    // For INSERT new patient+user
    public Patient(String user_name, String first_name, String last_name, String health_card, String email,
            String address, String telephone, Calendar birthdate, String gender, int height_cm,
            int weight_lbs, int role, int status, String password) {
        this(0, 0, user_name, first_name, last_name, health_card, email, address,
                telephone, birthdate, gender, height_cm,
                weight_lbs, role, status, password);

    }

    // Default Constructor
    public Patient() {

    }
}
