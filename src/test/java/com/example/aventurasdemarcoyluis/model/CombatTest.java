package com.example.aventurasdemarcoyluis.model;

import com.example.aventurasdemarcoyluis.model.npc.*;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {
    private Luis luis;
    private Marco marco;
    private Boo boo;
    private Goomba goomba;
    private Spiny spiny;

    @BeforeEach
    void setUp(){
        luis=new Luis(5,10,10,10,10,10,10);
        marco=new Marco(5,10,10,10,10,10,10);

        boo=new Boo(5,10,10,10);
        goomba=new Goomba(5,10,10,10);
        spiny=new Spiny(5,10,10,10);
    }
    @Test
    void getAttackByEnemies(){
        assertEquals(10, luis.getHp());
        assertEquals(10, marco.getHp());

        marco.getAtkByBoo(37.5);
        luis.getAtkByBoo(37.5);

        assertEquals(6.25, luis.getHp());
        assertEquals(10, marco.getHp());

        marco.getAtkByGoomba(10);
        luis.getAtkByGoomba(10);

        assertEquals(5.25, luis.getHp());
        assertEquals(9, marco.getHp());

        marco.getAtkBySpiny(10);
        luis.getAtkBySpiny(10);

        assertEquals(4.25, luis.getHp());
        assertEquals(8, marco.getHp());
    }

    @Test
    void getAttackByPlayers(){
        assertEquals(10, boo.getHp());
        assertEquals(10, goomba.getHp());
        assertEquals(10, spiny.getHp());

        boo.getAtkByLuisNormal(10);
        goomba.getAtkByLuisNormal(10);
        spiny.getAtkByLuisNormal(10);

        assertEquals(10, boo.getHp());
        assertEquals(9, goomba.getHp());
        assertEquals(10, spiny.getHp());

        boo.getAtkByMarcoNormal(10);
        goomba.getAtkByMarcoNormal(10);
        spiny.getAtkByMarcoNormal(10);

        assertEquals(9, boo.getHp());
        assertEquals(8, goomba.getHp());
        assertEquals(10, spiny.getHp());

        boo.getAtkByMarcoHammer(10);
        goomba.getAtkByMarcoHammer(10);
        spiny.getAtkByMarcoHammer(10);

        assertEquals(9, boo.getHp());
        assertEquals(7, goomba.getHp());
        assertEquals(9, spiny.getHp());

        boo.getAtkByLuisHammer(10);
        goomba.getAtkByLuisHammer(10);
        spiny.getAtkByLuisHammer(10);

        assertEquals(9, boo.getHp());
        assertEquals(6, goomba.getHp());
        assertEquals(8, spiny.getHp());
    }

    @Test
    void attackNormal() {
        assertEquals(10, luis.getHp());
        assertEquals(10, marco.getHp());
        assertEquals(10, boo.getHp());
        assertEquals(10, goomba.getHp());
        assertEquals(10, spiny.getHp());

        marco.attackNormal(goomba);
        marco.attackNormal(spiny);
        marco.attackNormal(boo);

        assertEquals(5, boo.getHp());
        assertEquals(5, goomba.getHp());
        assertEquals(10, spiny.getHp());
        assertEquals(9.5, marco.getHp());

        luis.attackNormal(goomba);
        luis.attackNormal(spiny);
        luis.attackNormal(boo);

        assertEquals(5, boo.getHp());
        assertEquals(0, goomba.getHp());
        assertEquals(10, spiny.getHp());
        assertEquals(9.5, luis.getHp());
    }

    @RepeatedTest(500)
    void attackHammer() {
        assertEquals(10, luis.getHp());
        assertEquals(10, marco.getHp());
        assertEquals(10, boo.getHp());
        assertEquals(10, goomba.getHp());
        assertEquals(10, spiny.getHp());

        marco.attackHammer(goomba);
        marco.attackHammer(spiny);
        marco.attackHammer(boo);

        assertEquals(10, boo.getHp());
        assertTrue(2.5==goomba.getHp() || 10==boo.getHp());
        assertTrue(2.5==spiny.getHp() || 10==spiny.getHp());
        assertEquals(10, marco.getHp());

        //Reset
        boo=new Boo(5,10,10,10);
        goomba=new Goomba(5,10,10,10);
        spiny=new Spiny(5,10,10,10);

        luis.attackHammer(goomba);
        luis.attackHammer(spiny);
        luis.attackHammer(boo);

        assertEquals(10, boo.getHp());
        assertTrue(2.5==goomba.getHp() || 10==boo.getHp());
        assertTrue(2.5==spiny.getHp() || 10==spiny.getHp());
        assertEquals(10, luis.getHp());
    }

    @Test
    void enemyAttacks(){
        assertEquals(10, luis.getHp());
        assertEquals(10, marco.getHp());
        assertEquals(10, boo.getHp());
        assertEquals(10, goomba.getHp());
        assertEquals(10, spiny.getHp());

        goomba.attack(marco);
        goomba.attack(luis);
        assertEquals(6.25, marco.getHp());
        assertEquals(6.25, luis.getHp());

        spiny.attack(marco);
        spiny.attack(luis);
        assertEquals(2.5, marco.getHp());
        assertEquals(2.5, luis.getHp());

        boo.attack(marco);
        boo.attack(luis);
        assertEquals(2.5, marco.getHp());
        assertEquals(0, luis.getHp());

    }
}