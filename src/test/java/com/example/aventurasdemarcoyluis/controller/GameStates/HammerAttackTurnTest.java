package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.npc.Goomba;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class HammerAttackTurnTest {

    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    private IGameStates hammerAttackTurn= new HammerAttackTurn();
    public void setUp(String values) {
        inputs= new ByteArrayInputStream((values).getBytes());
        output= new ByteArrayOutputStream();
        System.setIn(inputs);
        controller=new Controller(new BufferedReader(new InputStreamReader(System.in)) , new PrintStream(output));
    }

    @Test
    void getAction() {
        setUp("1");
        EnemiesMemory enemies=new EnemiesMemory();
        enemies.add(new Goomba(5,10,10,10));
        controller.setEnemies(enemies);
        hammerAttackTurn.setController(controller);
        assertEquals("Ataque de martillo \n" +
                "¿A quién atacar?\n" +
                "0- Goomba HP:10.0, LVL:10\n",hammerAttackTurn.getAction());
    }

    @Test
    void doAction() {
        setUp("1");
        EnemiesMemory enemies=new EnemiesMemory();
        Goomba goomba=new Goomba(5,10,10,10);
        enemies.add(goomba);
        controller.setEnemies(enemies);
        hammerAttackTurn.setController(controller);
        hammerAttackTurn.doAction("2");
        assertEquals("No esta ese enemigo.\r\n",output.toString());
        hammerAttackTurn.doAction("0");
        assertTrue(goomba.getHp()==10 || goomba.getHp()==7.75);

    }

    @Test
    void isFinal() {
        assertFalse(hammerAttackTurn.isFinal());
    }
}