package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.Item;

public class DB_Inventory {
    
    private static final String INVENTORY_TABLE = "[dbo].[INVENTORY]";

    // make database connection
    // Create,read,update,delete user data in the database
    public static Item createUpdateItem(Item item) {

        String sql;

        // NEW Item
        if (item.getItemId() == 0) {
            sql = "INSERT INTO " + INVENTORY_TABLE + " (";
            sql += "item_name, ";
            sql += "quantity";
            sql += ") ";
            sql += "VALUES (";
            sql += "'" + item.getItemName() + "', ";
            sql += item.getQuantity();
            sql += ")";

        }
        // UPDATE Item
        else {
            sql = "UPDATE" + INVENTORY_TABLE + " SET ";
            sql += "item_name = '" + item.getItemName() + "', ";
            sql += "quantity = " + item.getQuantity() + " ";
            sql += "WHERE item_id = " + item.getItemId();

        }

        boolean item_success = SQLManager.execute(sql);

        return item_success ? getItemByName(item.getItemName()) : null;

    }

    // DELETE Item
    public static boolean deleteItem(Item item) {

        String sql;

        sql = "DELETE FROM " + INVENTORY_TABLE + " ";
        sql += "WHERE item_id = " + item.getItemId();

        boolean item_success = SQLManager.execute(sql);

        return item_success;

    }

    // GET Item Methods
    public static Item getItemById(int item_id) {
        String sql;

        sql = "SELECT * FROM " + INVENTORY_TABLE + " ";
        sql += "WHERE item_id = " + item_id;

        return getItem(sql);
    }

    public static Item getItemByName(String item_name) {
        String sql;

        sql = "SELECT * FROM " + INVENTORY_TABLE + " ";
        sql += "WHERE item_name = " + item_name;

        return getItem(sql);
    }

    public static List<Item> getAllItems() {
        String sql;

        sql = "SELECT * FROM " + INVENTORY_TABLE;

        return getItemsList(sql);
    }

    // Helper functions
    private static List<Item> getItemsList(String sql) {
        List<Item> items = new ArrayList<Item>();

        List<HashMap<String, Object>> lsItems = SQLManager.query(sql);

        for (HashMap<String, Object> item_map : lsItems) {
            items.add(deserializeItemHashMap(item_map));
        }

        return items;
    }

    private static Item getItem(String sql) {
        Item item = null;

        List<HashMap<String, Object>> lsItems = SQLManager.query(sql);

        if (lsItems.size() >= 1) {
            HashMap<String, Object> item_map = lsItems.get(0);
            item = deserializeItemHashMap(item_map);
        }

        return item;
    }

    private static Item deserializeItemHashMap(HashMap<String, Object> item_map) {

        int item_id = (int) item_map.get("item_id");
        String item_name = item_map.get("item_name").toString();
        int quantity = (int) item_map.get("quantity");

        return new Item(item_id, item_name, quantity);
    }
}
