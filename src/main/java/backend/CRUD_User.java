package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.User;

public class CRUD_User {

    private static final String USER_TABLE = "dbo.User";

    // make database connection
    // Create,read,update,delete user data in the database
    public static boolean createUpdateUser(User user) {

        String sql;

        // NEW User
        if (user.getUserId() == 0) {
            sql = "INSERT INTO " + USER_TABLE + " VALUES (";
            sql += user.getFirstName() + ", ";
            sql += user.getLastName() + ", ";
            sql += user.getAddress() + ", ";
            sql += user.getTelephone() + ", ";
            sql += user.getRole() + ", ";
            sql += user.getStatus();
            sql += ")";

        }
        // UPDATE User
        else {
            sql = "UPDATE" + USER_TABLE + " SET ";
            sql += "first_name = " + user.getFirstName() + ", ";
            sql += "last_name = " + user.getLastName() + ", ";
            sql += "address = " + user.getAddress() + ", ";
            sql += "telephone = " + user.getTelephone() + ", ";
            sql += "role = " + user.getRole() + ", ";
            sql += "status = " + user.getStatus() + " ";
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

    public static User deserializeUserHashMap(HashMap<String, Object> user_map) {
        User user = null;
        // TODO STEP 2 of deserialization
        return user;
    }

}
