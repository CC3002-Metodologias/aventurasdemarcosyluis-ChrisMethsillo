package com.example.aventurasdemarcoyluis.model.npc.factories;

import com.example.aventurasdemarcoyluis.model.npc.Boo;
import com.example.aventurasdemarcoyluis.model.npc.Goomba;
import com.example.aventurasdemarcoyluis.model.npc.Spiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyFactoryTest {
    private EnemyFactory enemyFactory;
    @BeforeEach
    void setUp() {
        enemyFactory = new EnemyFactory();
    }
    @Test
    void getGoomba() {
        Goomba goomba = enemyFactory.getGoomba(1);
        assertEquals(new Goomba(20*(1+0.15), 10*(1+0.15), 20*(1+0.15), 1), goomba);
    }

    @Test
    void getBoo() {
        Boo boo = enemyFactory.getBoo(1);
        assertEquals(new Boo(25*(1+0.15), 10*(1+0.15), 20*(1+0.15), 1), boo);
    }

    @Test
    void getSpiny() {
        Spiny spiny = enemyFactory.getSpiny(1);
        assertEquals(new Spiny(20*(1+0.15), 15*(1+0.15), 20*(1+0.15), 1), spiny);
    }
}