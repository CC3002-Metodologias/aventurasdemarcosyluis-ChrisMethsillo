package com.example.aventurasdemarcoyluis.model.npc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemiesTest {
    private Boo boo;
    private Goomba goomba;
    private Spiny spiny;

    @BeforeEach
    void setUp(){
        boo=new Boo(5,10,10,10);
        goomba=new Goomba(5,10,10,10);
        spiny=new Spiny(5,10,10,10);
    }

    @Test
    void testConstructor(){
        assertTrue(boo instanceof Boo);
        assertTrue(goomba instanceof Goomba);
        assertTrue(spiny instanceof Spiny);
        assertTrue(boo instanceof Enemies);
        assertTrue(goomba instanceof Enemies);
        assertTrue(spiny instanceof Enemies);
    }
    @Test
    void getAtk() {
        assertEquals(5,boo.getAtk());
        assertEquals(5,goomba.getAtk());
        assertEquals(5,spiny.getAtk());

    }

    @Test
    void getDef() {
        assertEquals(10,boo.getDef());
        assertEquals(10,goomba.getDef());
        assertEquals(10,spiny.getDef());
    }

    @Test
    void getHp() {
        assertEquals(10,boo.getHp());
        assertEquals(10,goomba.getHp());
        assertEquals(10,spiny.getHp());
    }

    @Test
    void getLvl() {
        assertEquals(10,boo.getLvl());
        assertEquals(10,goomba.getLvl());
        assertEquals(10,spiny.getLvl());
    }

    @Test
    void getType() {
        assertEquals(EnemyType.BOO,boo.getType());
        assertEquals(EnemyType.GOOMBA,goomba.getType());
        assertEquals(EnemyType.SPINY,spiny.getType());
    }

    @Test
    void isDeath() {
        assertFalse(boo.isDeath());
        assertFalse(goomba.isDeath());
        assertFalse(spiny.isDeath());
        boo=new Boo(5,10,0,10);
        goomba=new Goomba(5,5,0,10);
        spiny=new Spiny(5,5,0,10);
        assertTrue(boo.isDeath());
        assertTrue(goomba.isDeath());
        assertTrue(spiny.isDeath());
    }

    @Test
    void dealDamage() {
        assertEquals(10,boo.getHp());
        assertEquals(10,goomba.getHp());
        assertEquals(10,spiny.getHp());
        boo.dealDamage(3);
        spiny.dealDamage(3);
        goomba.dealDamage(3);
        assertEquals(7,boo.getHp());
        assertEquals(7,goomba.getHp());
        assertEquals(7,spiny.getHp());
    }

    @Test
    void testEquals() {
        Boo boo2=new Boo(5,10,10,10);
        Goomba goomba2=new Goomba(5,10,10,10);
        Spiny spiny2=new Spiny(5,10,10,10);
        assertEquals(boo2,boo);
        assertEquals(goomba2,goomba);
        assertEquals(spiny2,spiny);
        assertNotEquals(boo,goomba);
        assertNotEquals(boo,spiny);
    }
}