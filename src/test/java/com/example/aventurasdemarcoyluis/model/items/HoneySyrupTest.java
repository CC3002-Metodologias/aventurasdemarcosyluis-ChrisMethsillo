package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoneySyrupTest {
    private HoneySyrup honeySyrup = new HoneySyrup();
    @Test
    void use() {
        Marco marco = new Marco(3,3,90,100,20,25,5);
        assertEquals(20, marco.getFp());
        honeySyrup.use(marco);
        assertEquals(23, marco.getFp());
    }

    @Test
    void getType() {
        assertEquals(ItemType.HONEYSYRUP, honeySyrup.getType());
    }

    @Test
    void testEquals() {
        assertEquals(honeySyrup, new HoneySyrup());
    }
}