package com.example.aventurasdemarcoyluis.model;

import com.example.aventurasdemarcoyluis.model.items.Item;
import com.example.aventurasdemarcoyluis.model.items.ItemType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This method represents a player chest. this element is used to conserve the items that the player need in the game.
 * @author Christian Jesus Parra Cofre.
 */
public class Chest {
    private HashMap<ItemType, ArrayList<Item>> chest;

    /**
     * Create the chest
     */
    public Chest() {
        this.chest = new HashMap<>();
    }

    /**
     * Add a item to the chest
     * @param item item to add
     */
    public void addItem(Item item) {
        if (!chest.containsKey(item.getType())) {
            chest.put(item.getType(), new ArrayList<>());
        }
        chest.get(item.getType()).add(item);
    }

    /**
     * Return the hashmap of the chest
     * @return chest
     */
    public HashMap<ItemType, ArrayList<Item>> getChest() {
        return chest;
    }

    /**
     * Use to give a player one item.
     * @param item item type
     * @param player player to use the item
     */
    public void useItem(ItemType item, ItemUse player){
        if (chest.containsKey(item) && chest.get(item).size() > 0) {
            chest.get(item).get(0).use(player);
            chest.get(item).remove(0);
        }
    }

    /**
     * Return a string with the index and the number of items in the chest
     * @return string
     */
    public String getStringItems(){
        String items = "";
        for (ItemType item : chest.keySet()) {
            items += item.toString() + ": " + chest.get(item).size() + "\n";
        }
        return items;
    }

}
