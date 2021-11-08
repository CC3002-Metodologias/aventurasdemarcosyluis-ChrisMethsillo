package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class LoseStateTest {

    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    private IGameStates loseState= new LoseState();;
    public void setUp(String values) {
        inputs= new ByteArrayInputStream((values).getBytes());
        output= new ByteArrayOutputStream();
        System.setIn(inputs);
        controller=new Controller(new BufferedReader(new InputStreamReader(System.in)) , new PrintStream(output));
    }
    @Test
    void getAction() {
        assertEquals("Perdiste", loseState.getAction());
    }

    @Test
    void doAction() {
        setUp("1");
        loseState.setController(controller);
        loseState.doAction("1");
        assertEquals("Perdiste",controller.getGameState().getAction());
    }

    @Test
    void isFinal() {
        assertTrue(loseState.isFinal());
    }
}