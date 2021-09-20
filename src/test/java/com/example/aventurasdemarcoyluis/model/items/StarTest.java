package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarTest {
    private Star st;
    private Marco marco;
    private Luis luis;
    @BeforeEach
    void setUp() {
        st= new Star();
        marco=new Marco(10,10,10,10,5,5,10);
        luis=new Luis(10,10,10,10,5,5,10);
    }
    @Test
    void use() {
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
        assertEquals(ItemType.STAR,st.getType());
    }

    @Test
    void testEquals() {
        HoneySyrup hs2=new HoneySyrup();
        RedMushroom rm2= new RedMushroom();
        Star st2= new Star();
        assertEquals(st,st2);
        assertNotEquals(hs2,st);
        assertNotEquals(st,rm2);
    }
    @Test
    void useInPlayer(){
        assertFalse(marco.haveAItem(ItemType.STAR));
        assertFalse(luis.haveAItem(ItemType.STAR));

        marco.giveItem(st);
        luis.giveItem(st);

        assertTrue(marco.haveAItem(ItemType.STAR));
        assertTrue(luis.haveAItem(ItemType.STAR));

        assertFalse(marco.isInmortal());
        assertFalse(luis.isInmortal());

        assertEquals(10, marco.getHp());
        assertEquals(10, luis.getHp());

        marco.getAtkBySpiny(10);
        luis.getAtkBySpiny(10);

        assertEquals(9, marco.getHp());
        assertEquals(9, luis.getHp());

        marco.useStar();
        luis.useStar();

        assertTrue(marco.isInmortal());
        assertTrue(luis.isInmortal());

        marco.getAtkBySpiny(10);
        luis.getAtkBySpiny(10);

        assertEquals(9, marco.getHp());
        assertEquals(9, luis.getHp());

        assertFalse(marco.haveAItem(ItemType.STAR));
        assertFalse(luis.haveAItem(ItemType.STAR));
    }
}