package backend;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

import objects.Patient;

public class SQLManagerTest {

    public static void main(String[] args) throws SQLException {

        // NEW
        System.out.println("-----------\nNEW RECORD\n----------");
        Patient tester = new Patient("TESTER", "TEST", "PATIENT", "123456789AA", "test@hospitalerp.com",
                "245 Church Street","+1(416)123-4567", SQLManager.SQLDateTimeToCal("1990-01-01 00:00:00"), "MALE", 190,
                175, 3, 2, "pass");

        tester = DB_Patient.createUpdatePatient(tester);
        test();

        // READ & UPDATE
        System.out.println("-----------\nUPDATE RECORD\n----------");
        tester.setLastName("von Gogh");

        tester = DB_Patient.createUpdatePatient(tester);
        test();

        // DELETE
        System.out.println("-----------\nDELETE RECORD\n----------");
        DB_Patient.deletePatient(tester);
        test();

    }

    private static void test() {
        System.out.println("Query Response: ");
        List<HashMap<String, Object>> lsResults = SQLManager.query("SELECT * FROM [dbo].[vw_Patient]");

        for (HashMap<String, Object> hm : lsResults) {
            System.out.println(hm);
        }

        System.out.println("-----------------------\nDeserialization Result: ");
        List<Patient> patients = DB_Patient.getAllPatients();

        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }

        try {
            System.out.println("-----------------------\nPress Enter to continue");
            System.in.read();
        } catch (Exception e) {
        }
    }

}
