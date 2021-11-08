package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.npc.Goomba;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class NormalAttackTurnTest {

    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    private IGameStates normalAttack= new NormalAttackTurn();
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
        normalAttack.setController(controller);
        assertEquals("Ataque normal\n" +
                "¿A quién atacar?\n" +
                "0- Goomba HP:10.0, LVL:10\n",normalAttack.getAction());
    }

    @Test
    void doAction() {
        setUp("1");
        EnemiesMemory enemies=new EnemiesMemory();
        Goomba goomba=new Goomba(5,10,10,10);
        enemies.add(goomba);
        controller.setEnemies(enemies);
        normalAttack.setController(controller);
        normalAttack.doAction("2");
        assertEquals("No esta ese enemigo.\r\n",output.toString());
        normalAttack.doAction("0");
        assertEquals(8.5,goomba.getHp());

        controller.setActionPlayer(PlayerType.LUIS);
        normalAttack.doAction("0");
        assertEquals(7,goomba.getHp());

    }

    @Test
    void isFinal() {
        assertFalse(normalAttack.isFinal());
    }
}