package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedMushroomTest {
    private RedMushroom rm = new RedMushroom();
    @Test
    void use() {
        Marco marco = new Marco(3,3,90,100,20,25,5);
        assertEquals(90, marco.getHp());
        rm.use(marco);
        assertEquals(100, marco.getHp());
    }

    @Test
    void getType() {
        assertEquals(ItemType.REDMUSHROOM, rm.getType());
    }

    @Test
    void testEquals() {
        assertEquals(rm, new RedMushroom());
    }
}