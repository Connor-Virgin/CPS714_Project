
package webApp.services;

import org.springframework.stereotype.Service;

import backend.DB_Inventory;
import objects.Item;

@Service
public class InventoryService {

    //Update item quantity in DB given item
    public boolean updateItemQuantity(Item item) {
        try {
            Item dbItem = DB_Inventory.getItemByName(item.getItemName());

            dbItem.setQuantity(item.getQuantity());
            DB_Inventory.createUpdateItem(dbItem);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //Add item to the DB
    public boolean addItem(Item item) {
        try {
            DB_Inventory.createUpdateItem(item);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //Add item to the DB
    public boolean deleteItem(Item item) {
        try {
            Item dbItem = DB_Inventory.getItemByName(item.getItemName());
            DB_Inventory.deleteItem(dbItem);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
