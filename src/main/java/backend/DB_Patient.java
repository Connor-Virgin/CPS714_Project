package backend;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import objects.Patient;
import objects.User;

/**
 *
 * @author Connor
 */
public class DB_Patient {

    private static final String PATIENT_TABLE = "[dbo].[Patient]";
    private static final String PATIENT_VIEW = "[dbo].[vw_Patient]";

    // make database connection
    // Create,read,update,delete user data in the database
    public static Patient createUpdatePatient(Patient patient) {

        User user = DB_User.createUpdateUser(patient);

        if (user != null) {
            String sql;

            // NEW Patient
            if (patient.getPatientId() == 0) {
                sql = "INSERT INTO " + PATIENT_TABLE + " (";
                sql += "user_id, ";
                sql += "health_card, ";
                sql += "birthdate, ";
                sql += "gender, ";
                sql += "height_cm, ";
                sql += "weight_lbs";
                sql += ")";
                sql += "VALUES (";
                sql += user.getUserId() + ", ";
                sql += "'" + patient.getHealthCard() + "', ";
                sql += "'" + new java.sql.Date(patient.getBirthdate().getTimeInMillis()) + "', ";
                sql += "'" + patient.getGender() + "', ";
                sql += patient.getHeight() + ", ";
                sql += patient.getWeight();
                sql += ")";

            }
            // UPDATE Patient
            else {
                sql = "UPDATE" + PATIENT_TABLE + " SET ";
                sql += "health_card = '" + patient.getHealthCard() + "', ";
                sql += "birthdate = '" + new java.sql.Date(patient.getBirthdate().getTimeInMillis()) + "', ";
                sql += "gender = '" + patient.getGender() + "', ";
                sql += "height_cm = " + patient.getHeight() + ", ";
                sql += "weight_lbs = " + patient.getWeight();
                sql += "WHERE patient_id = " + patient.getPatientId();

            }

            boolean patient_success = SQLManager.execute(sql);

            return patient_success ? getPatientByUserId(user.getUserId()) : null;

        }

        return null;

    }

    public static Patient getPatientById(int patient_id) {
        Patient patient = null;
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW + " ";
        sql += "WHERE patient_id = " + patient_id;

        List<HashMap<String, Object>> lsPatients = SQLManager.query(sql);

        if (lsPatients.size() >= 1) {
            HashMap<String, Object> patient_map = lsPatients.get(0);
            patient = deserializePatientHashMap(patient_map);
        }

        return patient;
    }

    public static Patient getPatientByUserId(int user_id) {
        Patient patient = null;
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW + " ";
        sql += "WHERE user_id = " + user_id;

        List<HashMap<String, Object>> lsPatients = SQLManager.query(sql);

        if (lsPatients.size() >= 1) {
            HashMap<String, Object> patient_map = lsPatients.get(0);
            patient = deserializePatientHashMap(patient_map);
        }

        return patient;
    }

    public static List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<Patient>();
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW;

        List<HashMap<String, Object>> lsPatients = SQLManager.query(sql);

        for (HashMap<String, Object> patient_map : lsPatients) {
            patients.add(deserializePatientHashMap(patient_map));
        }

        return patients;
    }

    public static boolean deletePatient(Patient patient) {

        String sql;

        sql = "DELETE FROM " + PATIENT_TABLE + " ";
        sql += "WHERE patient_id = " + patient.getPatientId();

        boolean patient_success = SQLManager.execute(sql);
        boolean user_success = DB_User.deleteUser(patient);

        return (patient_success && user_success);

    }

    private static Patient deserializePatientHashMap(HashMap<String, Object> patient_map) {

        int patient_id = (int) patient_map.get("patient_id");
        int user_id = (int) patient_map.get("user_id");
        String health_card = patient_map.get("health_card").toString();
        Calendar birthdate = SQLManager.convertSQLDatetimeToCalendar(patient_map.get("birthdate").toString());
        String gender = patient_map.get("gender").toString();
        int height_cm = (int) patient_map.get("height_cm");
        int weight_lbs = (int) patient_map.get("weight_lbs");

        String user_name = patient_map.get("login").toString();
        String first_name = patient_map.get("first_name").toString();
        String last_name = patient_map.get("last_name").toString();
        String email = patient_map.get("email").toString();
        String address = patient_map.get("address").toString();
        String telephone = patient_map.get("telephone").toString();
        int role = (int) patient_map.get("role");
        int status = (int) patient_map.get("status");
        String password = patient_map.get("password").toString();

        return new Patient(patient_id, user_id, user_name, first_name, last_name, health_card, email, address,
                telephone, birthdate, gender, height_cm, weight_lbs, role, status, password);
    }
}
