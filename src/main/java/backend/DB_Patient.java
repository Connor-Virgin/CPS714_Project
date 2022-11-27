package backend;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import objects.Appointment;
import objects.Patient;
import objects.User;

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
                sql += "weight_lbs, ";
                sql += "ward, ";
                sql += "room";
                sql += ")";
                sql += "VALUES (";
                sql += user.getUserId() + ", ";
                sql += "'" + patient.getHealthCard() + "', ";
                sql += "'" + new java.sql.Date(patient.getBirthdate().getTimeInMillis()) + "', ";
                sql += "'" + patient.getGender() + "', ";
                sql += patient.getHeight() + ", ";
                sql += patient.getWeight() + ", ";
                sql += patient.getWard() + ", ";
                sql += patient.getRoom();
                sql += ")";

            }
            // UPDATE Patient
            else {
                sql = "UPDATE" + PATIENT_TABLE + " SET ";
                sql += "health_card = '" + patient.getHealthCard() + "', ";
                sql += "birthdate = '" + new java.sql.Date(patient.getBirthdate().getTimeInMillis()) + "', ";
                sql += "gender = '" + patient.getGender() + "', ";
                sql += "height_cm = " + patient.getHeight() + ", ";
                sql += "weight_lbs = " + patient.getWeight() + ", ";
                sql += "ward = " + patient.getWard() + ", ";
                sql += "room = " + patient.getRoom() + " ";
                sql += "WHERE patient_id = " + patient.getPatientId();

            }

            boolean patient_success = SQLManager.execute(sql);

            return patient_success ? getPatientByUserId(user.getUserId()) : null;

        }

        return null;

    }

    //DELETE Patient
    public static boolean deletePatient(Patient patient) {

        String sql;

        sql = "DELETE FROM " + PATIENT_TABLE + " ";
        sql += "WHERE patient_id = " + patient.getPatientId();

        boolean patient_success = SQLManager.execute(sql);
        boolean user_success = DB_User.deleteUser(patient);

        return (patient_success && user_success);

    }

    // GET Patient Methods
    public static Patient getPatientById(int patient_id) {
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW + " ";
        sql += "WHERE patient_id = " + patient_id;

        return getPatient(sql);
    }

    public static Patient getPatientByUserId(int user_id) {
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW + " ";
        sql += "WHERE user_id = " + user_id;

        return getPatient(sql);
    }

    public static Patient getPatientByHealthCard(String health_card) {
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW + " ";
        sql += "WHERE health_card = '" + health_card + "'";

        return getPatient(sql);
    }

    public static Patient getPatientByWardRoom(int ward, int room) {
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW + " ";
        sql += "WHERE ward = " + ward + " AND room = " + room;

        return getPatient(sql);
    }

    public static List<Patient> getAllPatients() {
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW;

        return getPatientsList(sql);
    }

    public static List<Patient> getPatientsByWard(int ward) {
        String sql;

        sql = "SELECT * FROM " + PATIENT_VIEW + " ";
        sql += "WHERE ward = " + ward;

        return getPatientsList(sql);
    }

    public static List<String> getNotesByPatientId(int patient_id) {
        List<Appointment> apps = DB_Appointment.getAppointmentsByPatientId(patient_id);
        List<String> notes = apps.stream().map(app -> app.getDoctorNotes()).collect(Collectors.toList());
        return notes;
    }

    //Helper functions
    private static List<Patient> getPatientsList(String sql) {
        List<Patient> patients = new ArrayList<Patient>();

        List<HashMap<String, Object>> lsPatients = SQLManager.query(sql);

        for (HashMap<String, Object> patient_map : lsPatients) {
            patients.add(deserializePatientHashMap(patient_map));
        }

        return patients;
    }

    private static Patient getPatient(String sql) {
        Patient patient = null;

        List<HashMap<String, Object>> lsPatients = SQLManager.query(sql);

        if (lsPatients.size() >= 1) {
            HashMap<String, Object> patient_map = lsPatients.get(0);
            patient = deserializePatientHashMap(patient_map);
        }

        return patient;
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
        int ward = (int) patient_map.get("ward");
        int room = (int) patient_map.get("room");
        String password = patient_map.get("password").toString();

        return new Patient(patient_id, user_id, user_name, first_name, last_name, health_card, email, address,
                telephone, birthdate, gender, height_cm, weight_lbs, role, status, ward, room, password);
    }
}
