package objects;
import java.util.*;

public class Item {
    private int itemId;
    private String itemName;
    private int quantity;

    // Setter Classes
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter Classes
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    //Constructors
    //For read, update, delete item
    public Item(int itemId, String itemName, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // For insert new item
    public Item(String itemName, int quantity) {
        this(0, itemName, quantity);
    }

    // Default 
    public Item() {
        this("Gowns", 1000);
    }

}
