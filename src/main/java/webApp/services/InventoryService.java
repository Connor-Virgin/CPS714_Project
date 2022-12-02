package webApp.services;
import org.springframework.stereotype.Service;

import backend.DB_Appointment;
import backend.DB_Inventory;
import objects.Item;

@Service
public class InventoryService {
        
    public void updateItemQuantity(Item item, int quantity){
        item.setQuantity(quantity);
        DB_Inventory.createUpdateItem(item);
    }

}
