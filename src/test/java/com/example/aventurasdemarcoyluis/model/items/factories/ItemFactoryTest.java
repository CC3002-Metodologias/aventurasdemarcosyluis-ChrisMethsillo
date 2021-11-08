package com.example.aventurasdemarcoyluis.model.items.factories;

import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {
    private ItemFactory itemFactory = new ItemFactory();
    @Test
    void createHoneySyrup() {
        assertEquals(itemFactory.createHoneySyrup(), new HoneySyrup());
    }

    @Test
    void createRedMushroom() {
        assertEquals(itemFactory.createRedMushroom(), new RedMushroom());
    }
}