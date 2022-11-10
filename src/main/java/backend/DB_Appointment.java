package backend;

import java.util.Calendar;
import java.util.*;

import objects.Appointment;

public class DB_Appointment {

    private static final String APPOINTMENT_TABLE = "[dbo].[Appointment]";

    // make database connection
    // create, read, update, delete appointment data in the database
    public static Appointment createUpdateUser(Appointment app) {

        String sql;

        // NEW Appointment
        if (app.getAppointmentId() == 0) {
            sql = "INSERT INTO " + APPOINTMENT_TABLE + " (";
            sql += "appointment_datetime, ";
            sql += "appointment_duration, ";
            sql += "patient_id, ";
            sql += "doctor_id";
            sql += ")";
            sql += "VALUES (";
            sql += "'" + SQLManager.CalToSQLDateTime(app.getAppointmentStart()) + "', ";
            sql += app.getAppointmentDuration() + ", ";
            sql += "'" + app.getPatientId() + "', ";
            sql += "'" + app.getDoctorId()+ "'";
            sql += ")";

        }
        // UPDATE Appointment
        else {
            sql = "UPDATE" + APPOINTMENT_TABLE + " SET ";
            sql += "appointment_datetime = '" + SQLManager.CalToSQLDateTime(app.getAppointmentStart()) + "', ";
            sql += "appointment_duration = " + app.getAppointmentDuration() + ", ";
            sql += "patient_id = " + app.getPatientId() + ", ";
            sql += "doctor_id = " + app.getDoctorId() + " ";
            sql += "WHERE appointment_id = " + app.getAppointmentId();

        }

        boolean app_success = SQLManager.execute(sql);

        return app_success ? getAppointmentByDateTimeDoctor(app.getDoctorId(),app.getAppointmentStart()) : null;
    }

    //DELETE Appointment
    public static boolean deleteAppointment(Appointment app) {

        String sql;

        sql = "DELETE FROM " + APPOINTMENT_TABLE + " ";
        sql += "WHERE appointment_id = " + app.getAppointmentId();

        boolean app_success = SQLManager.execute(sql);

        return app_success;

    }

    // GET Appointment Methods
    public static Appointment getAppointmentByDateTimeDoctor(int doctor_id, Calendar appointment_datetime) {
        String sql;

        sql = "SELECT * FROM " + APPOINTMENT_TABLE + " ";
        sql += "WHERE doctor_id = " + doctor_id + " AND appointment_datetime = '" + SQLManager.CalToSQLDateTime(appointment_datetime) + "'";

        return getAppointment(sql);
    }

    public static List<Appointment> getAppointmentsByDoctorId(int doctor_id) {
        String sql;

        sql = "SELECT * FROM " + APPOINTMENT_TABLE + " ";
        sql += "WHERE doctor_id = " + doctor_id + " AND appointment_datetime >= '" + SQLManager.CalToSQLDateTime(Calendar.getInstance()) + "'";

        return getAppointmentsList(sql);
    }

    public static List<Appointment> getAppointmentsByPatientId(int patient_id) {
        String sql;

        sql = "SELECT * FROM " + APPOINTMENT_TABLE + " ";
        sql += "WHERE patient_id = " + patient_id + " AND appointment_datetime >= '" + SQLManager.CalToSQLDateTime(Calendar.getInstance()) + "'";

        return getAppointmentsList(sql);
    }

    // Helpers
    private static List<Appointment> getAppointmentsList(String sql) {
        List<Appointment> appointments = new ArrayList<Appointment>();
        
        List<HashMap<String, Object>> lsAppointments = SQLManager.query(sql);

        for (HashMap<String, Object> appointment_map : lsAppointments) {
            appointments.add(deserializeAppointmentHashMap(appointment_map));
        }

        return appointments;
    }

    private static Appointment getAppointment(String sql) {
        Appointment app = null;
        
        List<HashMap<String, Object>> lsAppointments = SQLManager.query(sql);

        if (lsAppointments.size() >= 1) {
            HashMap<String, Object> appointment_map = lsAppointments.get(0);
            app = deserializeAppointmentHashMap(appointment_map);
        }

        return app;
    }

    private static Appointment deserializeAppointmentHashMap(HashMap<String, Object> app_map) {

        int appointment_id = (int) app_map.get("appointment_id");
        Calendar appointment_datetime = SQLManager.SQLDateTimeToCal(app_map.get("appointment_datetime").toString());
        //int appointment_duration = (int) app_map.get("appointment_duration");
        int doctor_id = (int) app_map.get("doctor_id");
        int patient_id = (int) app_map.get("patient_id");

        return new Appointment(appointment_id, appointment_datetime, doctor_id, patient_id);
    }
}
