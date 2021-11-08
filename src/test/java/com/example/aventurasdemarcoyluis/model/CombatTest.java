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
    void setUp() {
        luis = new Luis(5, 10, 10, 10, 20, 20, 10);
        marco = new Marco(5, 10, 10, 10, 20, 20, 10);

        boo = new Boo(5, 10, 10, 10);
        goomba = new Goomba(5, 10, 10, 10);
        spiny = new Spiny(5, 10, 10, 10);
    }

    @Test
    void normalAtkLuis() {
        assertEquals(luis.getHp(), 10);
        assertEquals(goomba.getHp(), 10);
        assertEquals(spiny.getHp(), 10);

        luis.attackNormal(goomba);
        assertEquals(goomba.getHp(), 5);
        luis.attackNormal(goomba);
        assertEquals(goomba.getHp(), 0);
        luis.attackNormal(goomba);
        assertEquals(goomba.getHp(), 0);

        luis.attackNormal(spiny);
        assertEquals(spiny.getHp(), 10);
        assertEquals(luis.getHp(), 9);
    }

    @Test
    void normalAtkMarco() {
        assertEquals(marco.getHp(), 10);
        assertEquals(goomba.getHp(), 10);
        assertEquals(spiny.getHp(), 10);
        assertEquals(boo.getHp(), 10);

        marco.attackNormal(goomba);
        assertEquals(goomba.getHp(), 5);
        marco.attackNormal(goomba);
        assertEquals(goomba.getHp(), 0);
        marco.attackNormal(goomba);
        assertEquals(goomba.getHp(), 0);

        marco.attackNormal(boo);
        assertEquals(boo.getHp(), 5);
        marco.attackNormal(boo);
        assertEquals(boo.getHp(), 0);
        marco.attackNormal(boo);
        assertEquals(boo.getHp(), 0);

        marco.attackNormal(spiny);
        assertEquals(spiny.getHp(), 10);
        assertEquals(marco.getHp(), 9);
    }

    @RepeatedTest(50)
    void hammerAtkLuis() {
        assertEquals(luis.getHp(), 10);
        assertEquals(goomba.getHp(), 10);
        assertEquals(spiny.getHp(), 10);

        luis.attackHammer(goomba);
        assertTrue(goomba.getHp() == 10 || goomba.getHp() == 2.5);

        luis.attackHammer(spiny);
        assertTrue(spiny.getHp() == 10 || spiny.getHp() == 2.5);
    }

    @RepeatedTest(50)
    void hammerAtkMarco() {
        assertEquals(marco.getHp(), 10);
        assertEquals(goomba.getHp(), 10);
        assertEquals(spiny.getHp(), 10);

        marco.attackHammer(goomba);
        assertTrue(goomba.getHp() == 10 || goomba.getHp() == 2.5);

        marco.attackHammer(spiny);
        assertTrue(spiny.getHp() == 10 || spiny.getHp() == 2.5);

        marco.attackHammer(boo);
        assertTrue(boo.getHp() == 10 || boo.getHp() == 2.5);
    }

    @Test
    void atkBoo(){
        assertEquals(luis.getHp(), 10);
        assertEquals(boo.getHp(), 10);

        boo.attack(luis);
        assertEquals(luis.getHp(), 6.25);

        boo.attack(luis);
        assertEquals(luis.getHp(), 2.5);

        boo.attack(luis);
        assertEquals(luis.getHp(), 0);

        boo.attack(luis);
        assertEquals(luis.getHp(), 0);

    }
    @Test
    void atkSpiny(){
        assertEquals(luis.getHp(), 10);
        assertEquals(marco.getHp(), 10);
        assertEquals(spiny.getHp(), 10);

        spiny.attack(luis);
        assertEquals(luis.getHp(), 6.25);

        spiny.attack(luis);
        assertEquals(luis.getHp(), 2.5);

        spiny.attack(luis);
        assertEquals(luis.getHp(), 0);

        spiny.attack(luis);
        assertEquals(luis.getHp(), 0);

        spiny.attack(marco);
        assertEquals(marco.getHp(), 6.25);

        spiny.attack(marco);
        assertEquals(marco.getHp(), 2.5);

        spiny.attack(marco);
        assertEquals(marco.getHp(), 0);

        spiny.attack(marco);
        assertEquals(marco.getHp(), 0);


    }
    @Test
    void atkGoomba(){
        assertEquals(luis.getHp(), 10);
        assertEquals(marco.getHp(), 10);
        assertEquals(goomba.getHp(), 10);

        goomba.attack(luis);
        assertEquals(luis.getHp(), 6.25);

        goomba.attack(luis);
        assertEquals(luis.getHp(), 2.5);

        goomba.attack(luis);
        assertEquals(luis.getHp(), 0);

        goomba.attack(luis);
        assertEquals(luis.getHp(), 0);

        goomba.attack(marco);
        assertEquals(marco.getHp(), 6.25);

        goomba.attack(marco);
        assertEquals(marco.getHp(), 2.5);

        goomba.attack(marco);
        assertEquals(marco.getHp(), 0);

        goomba.attack(marco);
        assertEquals(marco.getHp(), 0);
    }
}