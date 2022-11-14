package webApp.models;

public class PatientReg extends Reg{
    private String health_card;
    private String birthdate;
    private String gender;
    private String height_cm;
    private String weight_kg;

    public String getHeight_cm() {
        return this.height_cm;
    }

    public void setHeight_cm(String height_cm) {
        this.height_cm = height_cm;
    }

    public String getweight_kg() {
        return this.weight_kg;
    }

    public void setweight_kg(String weight_kg) {
        this.weight_kg = weight_kg;
    }

    public String getHealth_card() {
        return this.health_card;
    }

    public void setHealth_card(String health_card) {
        this.health_card = health_card;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PatientReg(String firstname, String lastname, String email, String address, String telephone,
    String role, String password, String health_card, String birthdate, String gender, String height_cm, String weight_kg){
        super(firstname, lastname, email, address, telephone, role, password);

        this.health_card = health_card;
        this.birthdate = birthdate;
        this.gender = gender;
        this.height_cm = height_cm;
        this.weight_kg = weight_kg;
    }

}
