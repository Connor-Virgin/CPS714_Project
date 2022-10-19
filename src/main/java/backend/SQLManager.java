package backend;

import java.util.*;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.*;

public class SQLManager {

    private static final Logger log = Logger.getLogger(SQLManager.class.getName());

    private static Connection createConnection() throws IOException, SQLException {
        // Retrieves the connection string and returns a connection object
        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(SQLManager.class.getClassLoader().getResourceAsStream("sql.properties"));

        log.info("Connecting to the database");
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        log.info("Database connection test: " + connection.getCatalog());

        return connection;
    }

    public static final boolean execute(String sqlStatement) {
        // Executes a SQL statement without a returned result set
        // INSERT, UPDATE, DELETE

        boolean success = false;

        try {
            Connection connection = createConnection();

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);

            log.info("Closing database connection");
            connection.close();

            success = true;
            log.info("Statement Execution Successful");

        } catch (IOException ioe) {
            log.warning("Unable to read sql connection resource");
            log.warning(ioe.toString());
        } catch (SQLTimeoutException ste) {
            log.warning("Query has timed out");
            log.warning(ste.toString());
        } catch (SQLException se) {
            log.warning("Unable to execute SQL statement");
            log.warning(se.toString());
        }

        return success;

    }

    public static final List<HashMap<String, Object>> query(String sqlQuery) {
        // Executes a SQL query with a returned result set, and store in a List of
        // HashMaps for deserialization later

        ResultSet rs = null;
        List<HashMap<String, Object>> lsReturnResults = null;

        try {
            Connection connection = createConnection();

            Statement statement = connection.createStatement();
            rs = statement.executeQuery(sqlQuery);

            lsReturnResults = convertResultSetToList(rs); // Convert the temporary ResultSet to a List of HashMap

            log.info("Closing database connection");
            connection.close();

            log.info("Query Execution Successful. " + lsReturnResults.size() + " results returned.");

        } catch (IOException ioe) {
            log.warning("Unable to read sql connection resource");
            log.warning(ioe.toString());
        } catch (SQLTimeoutException ste) {
            log.warning("Query has timed out");
            log.warning(ste.toString());
        } catch (SQLException se) {
            log.warning("Unable to execute SQL statement");
            log.warning(se.toString());
        }

        return lsReturnResults;

    }

    public static List<HashMap<String, Object>> convertResultSetToList(ResultSet rs) throws SQLException {
        // Stage 1 of deserialization
        // Write ResultSet to a list of hashmap objects that map column name to value

        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        while (rs.next()) {
            HashMap<String, Object> row = new HashMap<String, Object>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }

}
