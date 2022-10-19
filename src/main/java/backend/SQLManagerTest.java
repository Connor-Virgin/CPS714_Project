package backend;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class SQLManagerTest {

    public static void main(String[] args) throws SQLException {
        List<HashMap<String, Object>> lsResults = SQLManager.query("SELECT * FROM dbo.Account");

        for (HashMap<String, Object> hm : lsResults) {
            System.out.println(hm);
        }

        boolean success = SQLManager
                .execute("UPDATE dbo.Account SET password = 12345 WHERE account_id = 1");

        System.out.println(success);

    }

}
