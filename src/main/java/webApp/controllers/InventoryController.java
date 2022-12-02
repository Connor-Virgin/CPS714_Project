package webApp.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import backend.DB_Inventory;
import objects.Item;
import webApp.models.SessionUser;
import webApp.services.InventoryService;

@Controller
@SessionAttributes({"sessionUser"})
public class InventoryController {
   
    private InventoryService inventoryService;

    public Item item;

    @ModelAttribute("sessionUser")
    public SessionUser sessionUser(){
        return new SessionUser();
    }

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory")
	public String inventory(Model model) {
        List<Item> allItems = DB_Inventory.getAllItems();
        model.addAttribute("allItems", allItems);
        model.addAttribute("item", item);
        return "inventory";
    }

    @PostMapping("/editquantity")
        public String EditQuantity(Model model, Item item){
        
        model.addAttribute("item", item);
        
        //updateItemQuantity(item);
        
        List<Item> allItems = DB_Inventory.getAllItems();
        model.addAttribute("allItems", allItems);    
 
        return "inventory";   
    }

    @PostMapping("/additem")
        public String AddItem(Model model){
        
        List<Item> allItems = DB_Inventory.getAllItems();
        model.addAttribute("allItems", allItems);    

        return "inventory";   
    }

    @PostMapping("/deleteitem")
        public String DeleteItem(Model model){
        
        List<Item> allItems = DB_Inventory.getAllItems();
        model.addAttribute("allItems", allItems);    

        return "inventory";   
    }
}