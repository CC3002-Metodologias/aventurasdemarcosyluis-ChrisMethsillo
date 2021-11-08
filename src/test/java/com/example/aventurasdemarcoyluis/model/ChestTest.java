package com.example.aventurasdemarcoyluis.model;

import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.ItemType;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChestTest {
    private Chest chest = new Chest();
    @Test
    void addItem() {
        chest.addItem(new HoneySyrup());
        assertEquals(1, chest.getChest().size());
        chest.addItem(new RedMushroom());
        assertEquals(2, chest.getChest().size());
    }

    @Test
    void useItem() {
        Marco marco= new Marco(3,3,100,100,20,25,5);
        chest.addItem(new HoneySyrup());
        assertEquals(1,  chest.getChest().get(ItemType.HONEYSYRUP).size());
        chest.useItem(ItemType.HONEYSYRUP, marco);
        assertEquals(0, chest.getChest().get(ItemType.HONEYSYRUP).size());
    }

    @Test
    void getStringItems() {
        chest.addItem(new HoneySyrup());
        String expected=chest.getStringItems();
        assertEquals("HONEYSYRUP: 1\n",expected);
    }
}