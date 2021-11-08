package com.example.aventurasdemarcoyluis.controller;

import com.example.aventurasdemarcoyluis.controller.GameStates.WinState;
import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.Chest;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    public void setUp(String values) {
        inputs= new ByteArrayInputStream((values).getBytes());
        output= new ByteArrayOutputStream();
        System.setIn(inputs);
        controller=new Controller(new BufferedReader(new InputStreamReader(System.in)) , new PrintStream(output));
    }

    @Test
    void getActionPlayer() {
        setUp("1");
        assertEquals(PlayerType.MARCO,controller.getActionPlayer());
    }

    @Test
    void setActionPlayer() {
        setUp("1");
        assertEquals(PlayerType.MARCO,controller.getActionPlayer());
        controller.setActionPlayer(PlayerType.LUIS);
        assertEquals(PlayerType.LUIS,controller.getActionPlayer());
    }

    @Test
    void getMarco() {
        setUp("1");
        assertEquals(controller.getMarco(),new Marco(15, 15, 20, 20,50,50,1));

    }

    @Test
    void setMarco() {
        setUp("1");
        assertEquals(controller.getMarco(),new Marco(15, 15, 20, 20,50,50,1));
        controller.setMarco(new Marco(1, 1, 1, 20,10,10,1));
        assertEquals(controller.getMarco(),new Marco(1, 1, 1, 20,10,10,1));
    }

    @Test
    void getLuis() {
        setUp("1");
        assertEquals(controller.getLuis(),new Luis(15, 15, 20, 20,50,50,1));
    }

    @Test
    void setLuis() {
        setUp("1");
        assertEquals(controller.getLuis(),new Luis(15, 15, 20, 20,50,50,1));
        controller.setLuis(new Luis(1, 1, 1, 20,10,10,1));
        assertEquals(controller.getLuis(),new Luis(1, 1, 1, 20,10,10,1));
    }

    @Test
    void getChest() {
        setUp("1");
        assertTrue(controller.getChest() instanceof Chest);
    }

    @Test
    void setChest() {
        setUp("1");
        Chest chest=new Chest();
        controller.setChest(chest);
        assertEquals(controller.getChest(),chest);
    }

    @Test
    void getEnemies() {
        setUp("1");
        assertTrue(controller.getEnemies() instanceof EnemiesMemory);
    }

    @Test
    void setEnemies() {
        setUp("1");
        EnemiesMemory enemies=new EnemiesMemory();
        controller.setEnemies(enemies);
        assertEquals(controller.getEnemies(),enemies);
    }

    @Test
    void say() {
        setUp("1");
        controller.say("hola");
        assertEquals("hola\r\n",output.toString());
    }

    @Test
    void makeBattle() {
        setUp("1\n0\n2\n0\n1\n");
        //Definimos un marco y un luis con ataque desbalanceado para asi poder probar el metodo
        controller.setMarco(new Marco(100000, 100, 20, 20,10,10,1));
        controller.setLuis(new Luis(100000, 100, 20, 20,10,10,1));
        controller.makeBattle(1);
        assertEquals(controller.getWins(),1);

    }

}