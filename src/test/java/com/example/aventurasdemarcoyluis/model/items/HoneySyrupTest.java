package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoneySyrupTest {
    private HoneySyrup hs;
    private Marco marco;
    private Luis luis;

    @BeforeEach
    void setUp() {
        hs=new HoneySyrup();
        marco=new Marco(10,10,9,10,5,8,10);
        luis=new Luis(10,10,9,10,5,8,10);
    }

    @Test
    void use() {
        assertEquals(5, marco.getFp());
        assertEquals(5, luis.getFp());
        hs.use(marco);
        hs.use(luis);
        assertEquals(8, marco.getFp());
        assertEquals(8, luis.getFp());
        hs.use(marco);
        hs.use(luis);
        assertEquals(8, marco.getFp());
        assertEquals(8, luis.getFp());
    }

    @Test
    void getType() {
        assertEquals(ItemType.HONEYSYRUP,hs.getType());
    }

    @Test
    void testEquals() {
        HoneySyrup hs2=new HoneySyrup();
        RedMushroom rm2= new RedMushroom();
        Star st2= new Star();
        assertEquals(hs,hs2);
        assertNotEquals(hs,st2);
        assertNotEquals(hs,rm2);
    }

    @Test
    void useInPlayer(){
        assertFalse(marco.haveAItem(ItemType.HONEYSYRUP));
        assertFalse(luis.haveAItem(ItemType.HONEYSYRUP));

        marco.giveItem(hs);
        luis.giveItem(hs);
        marco.giveItem(hs);
        luis.giveItem(hs);

        assertTrue(marco.haveAItem(ItemType.HONEYSYRUP));
        assertTrue(luis.haveAItem(ItemType.HONEYSYRUP));

        assertEquals(5, marco.getFp());
        assertEquals(5, luis.getFp());

        marco.useHoneySyrup();
        luis.useHoneySyrup();

        assertEquals(8, marco.getFp());
        assertEquals(8, luis.getFp());

        marco.useHoneySyrup();
        luis.useHoneySyrup();

        assertEquals(8, marco.getFp());
        assertEquals(8, luis.getFp());

        assertFalse(marco.haveAItem(ItemType.HONEYSYRUP));
        assertFalse(luis.haveAItem(ItemType.HONEYSYRUP));
    }
}