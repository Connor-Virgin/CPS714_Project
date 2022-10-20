package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.User;

/**
 *
 * @author Connor
 */
public class DB_User {

    private static final String USER_TABLE = "dbo.User";

    // make database connection
    // Create,read,update,delete user data in the database
    public static boolean createUpdateUser(User user) {

        String sql;

        // NEW User
        if (user.getUserId() == 0) {
            sql = "INSERT INTO " + USER_TABLE + " VALUES (";
            sql += user.getUserName() + ", ";
            sql += user.getFirstName() + ", ";
            sql += user.getLastName() + ", ";
            sql += user.getEmail() + ", ";
            sql += user.getAddress() + ", ";
            sql += user.getTelephone() + ", ";
            sql += user.getRole() + ", ";
            sql += user.getStatus() + ", ";
            sql += user.getPassword();
            sql += ")";

        }
        // UPDATE User
        else {
            sql = "UPDATE" + USER_TABLE + " SET ";
            sql += "user_name = " + user.getUserName() + ", ";
            sql += "first_name = " + user.getFirstName() + ", ";
            sql += "last_name = " + user.getLastName() + ", ";
            sql += "email = " + user.getEmail() + ", ";
            sql += "address = " + user.getAddress() + ", ";
            sql += "telephone = " + user.getTelephone() + ", ";
            sql += "role = " + user.getRole() + ", ";
            sql += "status = " + user.getStatus() + " ";
            sql += "password = " + user.getPassword() + " ";
            sql += "WHERE user_id = " + user.getUserId();
            sql += ")";

        }

        return SQLManager.execute(sql);
    }

    public static User getUser(int user_id) {
        User user = null;
        String sql;

        sql = "SELECT * FROM " + USER_TABLE + " ";
        sql += "WHERE user_id = " + user_id;

        List<HashMap<String, Object>> lsUser = SQLManager.query(sql);

        if (lsUser.size() >= 1) {
            HashMap<String, Object> user_map = lsUser.get(0);
            user = deserializeUserHashMap(user_map);
        }

        return user;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sql;

        sql = "SELECT * FROM " + USER_TABLE;

        List<HashMap<String, Object>> lsUsers = SQLManager.query(sql);

        for (HashMap<String, Object> user_map : lsUsers) {
            users.add(deserializeUserHashMap(user_map));
        }

        return users;
    }

    public static boolean deleteUser(User user) {

        // Cannot delete root admin account
        if (user.getUserId() != 1) {
            String sql;

            sql = "DELETE FROM " + USER_TABLE + " WHERE ";
            sql += "user_id = " + user.getUserId();

            return SQLManager.execute(sql);
        }

        return false;
    }

    private static User deserializeUserHashMap(HashMap<String, Object> user_map) {

        int user_id = (int) user_map.get("user_id");
        String user_name = user_map.get("user_name").toString();
        String first_name = user_map.get("first_name").toString();
        String last_name = user_map.get("last_name").toString();
        String email = user_map.get("email").toString();
        String address = user_map.get("address").toString();
        String telephone = user_map.get("telephone").toString();
        int role = (int) user_map.get("role");
        int status = (int) user_map.get("status");
        String password = user_map.get("password").toString();

        return new User(user_id, user_name, first_name, last_name, email, address, telephone, role, status, password);
    }

}
