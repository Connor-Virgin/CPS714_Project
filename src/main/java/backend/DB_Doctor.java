package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.Doctor;
import objects.User;

public class DB_Doctor {
    
    private static final String DOCTOR_TABLE = "[dbo].[Doctor]";
    private static final String DOCTOR_VIEW = "[dbo].[vw_Doctor]";

    // make database connection
    // Create,read,update,delete user data in the database
    public static Doctor createUpdatePatient(Doctor doctor) {

        User user = DB_User.createUpdateUser(doctor);

        if (user != null) {
            String sql;

            // NEW Doctor
            if (doctor.getDoctorId() == 0) {
                sql = "INSERT INTO " + DOCTOR_TABLE + " (";
                sql += "user_id, ";
                sql += "department, ";
                sql += "position";
                sql += ") ";
                sql += "VALUES (";
                sql += user.getUserId() + ", ";
                sql += "'" + doctor.getDepartment() + "', ";
                sql += "'" + doctor.getPosition() + "'";
                sql += ")";

            }
            // UPDATE Doctor
            else {
                sql = "UPDATE" + DOCTOR_TABLE + " SET ";
                sql += "department = '" + doctor.getDepartment() + "', ";
                sql += "position = '" + doctor.getPosition() + "' ";
                sql += "WHERE doctor_id = " + doctor.getDoctorId();

            }

            boolean doctor_success = SQLManager.execute(sql);

            return doctor_success ? getDoctorByUserId(user.getUserId()) : null;

        }

        return null;

    }

    public static Doctor getDoctorById(int doctor_id) {
        Doctor doctor = null;
        String sql;

        sql = "SELECT * FROM " + DOCTOR_VIEW + " ";
        sql += "WHERE doctor_id = " + doctor_id;

        List<HashMap<String, Object>> lsDoctors = SQLManager.query(sql);

        if (lsDoctors.size() >= 1) {
            HashMap<String, Object> doctor_map = lsDoctors.get(0);
            doctor = deserializeDoctorHashMap(doctor_map);
        }

        return doctor;
    }

    public static Doctor getDoctorByUserId(int user_id) {
        Doctor doctor = null;
        String sql;

        sql = "SELECT * FROM " + DOCTOR_VIEW + " ";
        sql += "WHERE user_id = " + user_id;

        List<HashMap<String, Object>> lsDoctors = SQLManager.query(sql);

        if (lsDoctors.size() >= 1) {
            HashMap<String, Object> doctor_map = lsDoctors.get(0);
            doctor = deserializeDoctorHashMap(doctor_map);
        }

        return doctor;
    }

    public static List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        String sql;

        sql = "SELECT * FROM " + DOCTOR_VIEW;

        List<HashMap<String, Object>> lsDoctors = SQLManager.query(sql);

        for (HashMap<String, Object> doctor_map : lsDoctors) {
            doctors.add(deserializeDoctorHashMap(doctor_map));
        }

        return doctors;
    }

    public static boolean deleteDoctor(Doctor doctor) {

        String sql;

        sql = "DELETE FROM " + DOCTOR_TABLE + " ";
        sql += "WHERE doctor_id = " + doctor.getDoctorId();

        boolean doctor_success = SQLManager.execute(sql);
        boolean user_success = DB_User.deleteUser(doctor);

        return (doctor_success && user_success);

    }

    private static Doctor deserializeDoctorHashMap(HashMap<String, Object> doctor_map) {

        int doctor_id = (int) doctor_map.get("doctor_id");
        int user_id = (int) doctor_map.get("user_id");
        String department = doctor_map.get("department").toString();
        String position = doctor_map.get("position").toString();

        String user_name = doctor_map.get("login").toString();
        String first_name = doctor_map.get("first_name").toString();
        String last_name = doctor_map.get("last_name").toString();
        String email = doctor_map.get("email").toString();
        String address = doctor_map.get("address").toString();
        String telephone = doctor_map.get("telephone").toString();
        int role = (int) doctor_map.get("role");
        int status = (int) doctor_map.get("status");
        String password = doctor_map.get("password").toString();

        return new Doctor(doctor_id, user_id, user_name, first_name, last_name, email,
        address, telephone, department, position, role, status, password);
    }
}
