package com.example.aventurasdemarcoyluis.controller.utilities;

import com.example.aventurasdemarcoyluis.model.npc.Boo;
import com.example.aventurasdemarcoyluis.model.npc.Goomba;
import com.example.aventurasdemarcoyluis.model.npc.Spiny;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemiesMemoryTest {

    private EnemiesMemory enemiesMemory;
    private Marco marco;
    private Luis luis;
    @BeforeEach
    void setUp() {
        enemiesMemory = new EnemiesMemory();
        marco=new Marco(3,3,100,100,20,25,5);
        luis=new Luis(3,3,100,100,20,25,5);

    }

    @Test
    void add() {
        Boo boo=new Boo(3,3,100,100);
        Spiny spiny=new Spiny(3,3,100,100);
        Goomba goomba=new Goomba(3,3,100,100);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);
        assertEquals(3,enemiesMemory.getLargeEnemies());

    }

    @Test
    void generateEnemies() {
        enemiesMemory.generateEnemies(3,1);
        assertEquals(3,enemiesMemory.getLargeEnemies());
    }

    @Test
    void makeAttack() {
        Boo boo=new Boo(3,3,100,100);
        Spiny spiny=new Spiny(3,3,100,100);
        Goomba goomba=new Goomba(3,3,100,100);

        enemiesMemory.add(spiny);
        enemiesMemory.makeAttack(marco,luis);
        assertTrue(marco.getHp()==25 || luis.getHp()==25);

        marco=new Marco(3,3,0,100,20,25,5);
        luis=new Luis(3,3,100,100,20,25,5);
        enemiesMemory.makeAttack(marco,luis);
        assertEquals(25,luis.getHp());

        marco=new Marco(3,3,100,100,20,25,5);
        luis=new Luis(3,3,0,100,20,25,5);
        enemiesMemory.makeAttack(marco,luis);
        assertEquals(25,marco.getHp());

        enemiesMemory=new EnemiesMemory();
        enemiesMemory.add(boo);
        marco=new Marco(3,3,0,100,20,25,5);
        luis=new Luis(3,3,100,100,20,25,5);
        enemiesMemory.makeAttack(marco,luis);
        assertEquals(25,luis.getHp());

        enemiesMemory=new EnemiesMemory();
        enemiesMemory.add(goomba);

        marco=new Marco(3,3,100,100,20,25,5);
        luis=new Luis(3,3,100,100,20,25,5);
        enemiesMemory.makeAttack(marco,luis);
        assertTrue(marco.getHp()==25 || luis.getHp()==25);

        marco=new Marco(3,3,0,100,20,25,5);
        luis=new Luis(3,3,100,100,20,25,5);

        enemiesMemory.makeAttack(marco,luis);
        assertEquals(25,luis.getHp());

        marco=new Marco(3,3,100,100,20,25,5);
        luis=new Luis(3,3,0,100,20,25,5);
        enemiesMemory.makeAttack(marco,luis);
        assertEquals(25,marco.getHp());

        marco=new Marco(3,3,0,100,20,25,5);
        luis=new Luis(3,3,0,100,20,25,5);

    }

    @Test
    void updateLifes() {
        Boo boo=new Boo(3,3,0,100);
        Spiny spiny=new Spiny(3,3,0,100);
        Goomba goomba=new Goomba(3,3,0,100);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);
        assertEquals(3,enemiesMemory.getLargeEnemies());
        enemiesMemory.updateLifes();
        assertEquals(0,enemiesMemory.getLargeEnemies());
    }

    @Test
    void attackNormal() {
        Boo boo=new Boo(3,3,100,1);
        Spiny spiny=new Spiny(3,3,100,1);
        Goomba goomba=new Goomba(3,3,100,1);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);

        enemiesMemory.attackNormal(marco,0,0);
        enemiesMemory.attackNormal(marco,1,0);
        enemiesMemory.attackNormal(marco,2,0);

        assertEquals(95,boo.getHp());
        assertEquals(100,spiny.getHp());
        assertEquals(95,goomba.getHp());

        enemiesMemory.attackNormal(luis,0,0);
        enemiesMemory.attackNormal(luis,1,0);
        enemiesMemory.attackNormal(luis,2,0);

        assertEquals(95,boo.getHp());
        assertEquals(100,spiny.getHp());
        assertEquals(90,goomba.getHp());

    }


    @RepeatedTest(50)
    void attackHammer() {
        Boo boo=new Boo(3,3,100,1);
        Spiny spiny=new Spiny(3,3,100,1);
        Goomba goomba=new Goomba(3,3,100,1);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);

        enemiesMemory.attackHammer(marco,0,0);
        enemiesMemory.attackHammer(marco,1,0);
        enemiesMemory.attackHammer(marco,2,0);

        assertEquals(100,boo.getHp());
        assertTrue(spiny.getHp()==100||spiny.getHp()==92.5);
        assertTrue(goomba.getHp()==100||goomba.getHp()==92.5);

        enemiesMemory=new EnemiesMemory();
        boo =new Boo(3,3,100,1);
        spiny=new Spiny(3,3,100,1);
        goomba=new Goomba(3,3,100,1);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);

        enemiesMemory.attackHammer(luis,0,0);
        enemiesMemory.attackHammer(luis,1,0);
        enemiesMemory.attackHammer(luis,2,0);

        assertEquals(100,boo.getHp());
        assertTrue(spiny.getHp()==100||spiny.getHp()==92.5);
        assertTrue(goomba.getHp()==100||goomba.getHp()==92.5);

    }


    @Test
    void selectAttackNormal() {
        Boo boo=new Boo(3,3,100,1);
        Spiny spiny=new Spiny(3,3,100,1);
        Goomba goomba=new Goomba(3,3,100,1);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);
        enemiesMemory.selectAttackNormal(marco,0);
        enemiesMemory.selectAttackNormal(marco,1);
        enemiesMemory.selectAttackNormal(marco,2);

        assertEquals(95,boo.getHp());
        assertEquals(100,spiny.getHp());
        assertEquals(95,goomba.getHp());

        enemiesMemory.selectAttackNormal(luis,0);
        enemiesMemory.selectAttackNormal(luis,1);
        enemiesMemory.selectAttackNormal(luis,2);

        assertEquals(95,boo.getHp());
        assertEquals(100,spiny.getHp());
        assertEquals(90,goomba.getHp());

    }

    @RepeatedTest(50)
    void selectAttackHammer() {
        Boo boo=new Boo(3,3,100,1);
        Spiny spiny=new Spiny(3,3,100,1);
        Goomba goomba=new Goomba(3,3,100,1);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);

        enemiesMemory.selectAttackHammer(marco,0);
        enemiesMemory.selectAttackHammer(marco,1);
        enemiesMemory.selectAttackHammer(marco,2);;

        assertEquals(100,boo.getHp());
        assertTrue(spiny.getHp()==100||spiny.getHp()==92.5);
        assertTrue(goomba.getHp()==100||goomba.getHp()==92.5);

        enemiesMemory=new EnemiesMemory();
        boo =new Boo(3,3,100,1);
        spiny=new Spiny(3,3,100,1);
        goomba=new Goomba(3,3,100,1);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);

        enemiesMemory.selectAttackHammer(luis,0);
        enemiesMemory.selectAttackHammer(luis,1);
        enemiesMemory.selectAttackHammer(luis,2);;

        assertEquals(100,boo.getHp());
        assertTrue(spiny.getHp()==100||spiny.getHp()==92.5);
        assertTrue(goomba.getHp()==100||goomba.getHp()==92.5);
    }



    @Test
    void getStringEnemies() {
        Boo boo=new Boo(3,3,100,1);
        Spiny spiny=new Spiny(3,3,100,1);
        Goomba goomba=new Goomba(3,3,100,1);
        enemiesMemory.add(boo);
        enemiesMemory.add(spiny);
        enemiesMemory.add(goomba);

        assertEquals("0- Boo : HP:100.0, LVL:1\n" +
                "1- Goomba HP:100.0, LVL:1\n" +
                "2- Spiny : HP:100.0, LVL:1\n",enemiesMemory.getStringEnemies());
    }
}