package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedMushroomTest {

    private RedMushroom rm;
    private Marco marco;
    private Luis luis;
    @BeforeEach
    void setUp() {
        rm= new RedMushroom();
        marco=new Marco(10,10,9,10,5,5,10);
        luis=new Luis(10,10,9,10,5,5,10);
    }

    @Test
    void use() {
        assertEquals(9, marco.getHp());
        assertEquals(9, luis.getHp());
        rm.use(marco);
        rm.use(luis);
        assertEquals(10, marco.getHp());
        assertEquals(10, luis.getHp());
        rm.use(marco);
        rm.use(luis);
        assertEquals(10, marco.getHp());
        assertEquals(10, luis.getHp());
    }

    @Test
    void getType() {
        assertEquals(ItemType.REDMUSHROOM,rm.getType());
    }

    @Test
    void testEquals() {
        HoneySyrup hs2=new HoneySyrup();
        RedMushroom rm2= new RedMushroom();
        Star st2= new Star();
        assertEquals(rm,rm2);
        assertNotEquals(rm,st2);
        assertNotEquals(hs2,rm);
    }
    @Test
    void useInPlayer(){
        assertFalse(marco.haveAItem(ItemType.REDMUSHROOM));
        assertFalse(luis.haveAItem(ItemType.REDMUSHROOM));

        marco.giveItem(rm);
        luis.giveItem(rm);

        assertTrue(marco.haveAItem(ItemType.REDMUSHROOM));
        assertTrue(luis.haveAItem(ItemType.REDMUSHROOM));

        assertEquals(9, marco.getHp());
        assertEquals(9, luis.getHp());

        marco.useRedMushroom();
        luis.useRedMushroom();

        assertEquals(10, marco.getHp());
        assertEquals(10, luis.getHp());

        assertFalse(marco.haveAItem(ItemType.REDMUSHROOM));
        assertFalse(luis.haveAItem(ItemType.REDMUSHROOM));
    }
}