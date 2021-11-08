package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.npc.Boo;
import com.example.aventurasdemarcoyluis.model.npc.Goomba;
import com.example.aventurasdemarcoyluis.model.npc.Spiny;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class EnemiesTurnTest {
    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    private IGameStates enemiesTurn= new EnemiesTurn();
    public void setUp(String values) {
        inputs= new ByteArrayInputStream((values).getBytes());
        output= new ByteArrayOutputStream();
        System.setIn(inputs);
        controller=new Controller(new BufferedReader(new InputStreamReader(System.in)) , new PrintStream(output));
    }
    @Test
    void getAction() {
        assertEquals(enemiesTurn.getAction(), "Turno enemigo, apreta cualquier numero para continuar.");
    }

    @Test
    void doAction() {
       setUp("1");
        EnemiesMemory enemies= new EnemiesMemory();
        Boo boo =new Boo(3,3,100,1);
        Spiny spiny=new Spiny(3,3,100,1);
        Goomba goomba=new Goomba(3,3,100,1);
        enemies.add(boo);
        enemies.add(spiny);
        enemies.add(goomba);
        controller.setEnemies(enemies);
        enemiesTurn.setController(controller);
        enemiesTurn.doAction("1");
        assertTrue(controller.getMarco().getHp()==19.85 ||controller.getLuis().getHp()==19.85);

    }

    @Test
    void isFinal() {
        assertFalse(enemiesTurn.isFinal());
    }
}
