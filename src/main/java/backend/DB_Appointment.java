package backend;

import java.util.Calendar;
import java.util.stream.Collectors;
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
            sql += "appointment_duration_min, ";
            sql += "patient_id, ";
            sql += "doctor_id,";
            sql += "doctor_notes";
            sql += ")";
            sql += "VALUES (";
            sql += "'" + SQLManager.CalToSQLDateTime(app.getAppointmentStart()) + "',";
            sql += app.getAppointmentDuration() + ", ";
            sql += "'" + app.getPatientId() + "', ";
            sql += "'" + app.getDoctorId()+ "', ";
            sql += "'" + app.getDoctorNotes() + "'";
            sql += ")";

        }
        // UPDATE Appointment
        else {
            sql = "UPDATE" + APPOINTMENT_TABLE + " SET ";
            sql += "appointment_datetime = '" + SQLManager.CalToSQLDateTime(app.getAppointmentStart()) + "', ";
            sql += "appointment_duration_min = " + app.getAppointmentDuration() + ", ";
            sql += "patient_id = " + app.getPatientId() + ", ";
            sql += "doctor_id = " + app.getDoctorId() + ", ";
            sql += "doctor_notes = " + app.getDoctorNotes() + " ";
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

    public static boolean deleteAppointmentByID(int ID) {

        String sql;

        sql = "DELETE FROM " + APPOINTMENT_TABLE + " ";
        sql += "WHERE appointment_id = " + ID;

        boolean app_success = SQLManager.execute(sql);

        return app_success;

    }

    // GET Appointment Methods
    public static List<Appointment> getAvailableAppointments(int doctor_id, int patient_id, Calendar appointment_date) {
        List<Appointment> available = new ArrayList<Appointment>();
        List<Appointment> existing_doctor = getAppointmentsByDoctorId(doctor_id);
        List<Appointment> existing_patient = getAppointmentsByPatientId(patient_id);

        for (Appointment app : buildDailyAppointmentsList(doctor_id, patient_id, appointment_date)) {
            boolean patient_is_free = !validateAppointment(app, existing_patient);
            boolean doctor_is_free = !validateAppointment(app, existing_doctor);

            if (patient_is_free && doctor_is_free) {available.add(app);};
        }

        return available;
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

    public static Appointment getAppointmentByID(int appointment_id) {
        String sql;

        sql = "SELECT * FROM " + APPOINTMENT_TABLE + " ";
        sql += "WHERE appointment_id = " + appointment_id + "";

        return getAppointment(sql);
    }

    public static List<String> getNotesByPatientId(int patient_id) {
        List<Appointment> apps = getAppointmentsByPatientId(patient_id);
        List<String> notes = apps.stream().map(app -> app.getDoctorNotes()).collect(Collectors.toList());
        return notes;
    }

    // Helpers
    private static Appointment[] buildDailyAppointmentsList(int doctor_id, int patient_id, Calendar appointment_date) {
        Appointment[] apps_list = new Appointment[16];

        for (int i = 0; i < apps_list.length; i++) {
            Calendar app_datetime = (Calendar) appointment_date.clone();
            app_datetime.set(Calendar.HOUR_OF_DAY, 9);
            app_datetime.set(Calendar.MINUTE, 0);
            app_datetime.add(Calendar.MINUTE, i * 30);
            apps_list[i] = new Appointment(app_datetime,doctor_id,patient_id);
        }
        return apps_list;
    }

    private static boolean validateAppointment(Appointment app, List<Appointment> apps_list) {
        boolean conflict = false;

        for (Appointment a : apps_list) {
            if(app.getAppointmentStart().compareTo(a.getAppointmentStart()) == 0) {
                conflict = true;
            }
        }

        return conflict;
    }

    private static Appointment getAppointmentByDateTimeDoctor(int doctor_id, Calendar appointment_datetime) {
        String sql;

        sql = "SELECT * FROM " + APPOINTMENT_TABLE + " ";
        sql += "WHERE doctor_id = " + doctor_id + " AND appointment_datetime = '" + SQLManager.CalToSQLDateTime(appointment_datetime) + "'";

        return getAppointment(sql);
    }

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
        String doctor_notes = app_map.get("doctor_notes").toString();

        return new Appointment(appointment_id, appointment_datetime, doctor_id, patient_id, doctor_notes);
    }
}
