package com.example.aventurasdemarcoyluis.model.items;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private HoneySyrup hs;
    private RedMushroom rm;
    private Star st;
    private Marco marco;
    private Luis luis;
    @BeforeEach
    void setUp() {
        hs=new HoneySyrup();
        rm= new RedMushroom();
        st= new Star();
        marco=new Marco(10,10,9,10,5,10);
        luis=new Luis(10,10,9,10,5,10);
    }

    @Test
    void use() {
        assertEquals(5, marco.getFp());
        assertEquals(5, luis.getFp());
        hs.use(marco);
        hs.use(luis);
        assertEquals(8, marco.getFp());
        assertEquals(8, luis.getFp());

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

        assertFalse(marco.isInmortal());
        assertFalse(luis.isInmortal());

        marco.getAtkBySpiny(10);
        luis.getAtkBySpiny(10);

        assertEquals(9, marco.getHp());
        assertEquals(9, luis.getHp());

        st.use(marco);
        st.use(luis);

        assertTrue(marco.isInmortal());
        assertTrue(luis.isInmortal());

        marco.getAtkBySpiny(10);
        luis.getAtkBySpiny(10);

        assertEquals(9, marco.getHp());
        assertEquals(9, luis.getHp());

    }

    @Test
    void getType() {
        assertEquals(ItemType.HONEYSYRUP,hs.getType());
        assertEquals(ItemType.REDMUSHROOM,rm.getType());
        assertEquals(ItemType.STAR,st.getType());
    }

    @Test
    void testEquals() {
        HoneySyrup hs2=new HoneySyrup();
        RedMushroom rm2= new RedMushroom();
        Star st2= new Star();
        assertEquals(hs,hs2);
        assertEquals(rm,rm2);
        assertEquals(st,st2);
        assertNotEquals(hs,st);
        assertNotEquals(hs,rm);
    }
}