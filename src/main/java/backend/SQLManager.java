package backend;

import java.util.*;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.*;

public class SQLManager {

    private static final Logger log = Logger.getLogger(SQLManager.class.getName());

    public static final ResultSet execute(String sqlStatement) {

        ResultSet result = null;

        try {
            log.info("Loading application properties TEST");
            Properties properties = new Properties();
            properties.load(SQLManager.class.getClassLoader().getResourceAsStream("sql.properties"));

            log.info("Connecting to the database");
            Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);

            log.info("Database connection test: " + connection.getCatalog());

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sqlStatement);

            log.info("Closing database connection");
            connection.close();

        } catch (IOException ioe) {
            log.warning("Unable to read sql connection resource");
            log.warning(ioe.getMessage());
        } catch (SQLTimeoutException ste) {
            log.warning("Query has timed out");
            log.warning(ste.getMessage());
        } catch (SQLException se) {
            log.warning("Unable to execute SQL statement");
            log.warning(se.getMessage());
        }

        return result;

    }
}
