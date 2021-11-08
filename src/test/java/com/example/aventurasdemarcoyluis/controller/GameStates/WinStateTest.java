package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class WinStateTest {

    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    private IGameStates WinState= new WinState();;
    public void setUp(String values) {
        inputs= new ByteArrayInputStream((values).getBytes());
        output= new ByteArrayOutputStream();
        System.setIn(inputs);
        controller=new Controller(new BufferedReader(new InputStreamReader(System.in)) , new PrintStream(output));
    }
    @Test
    void getAction() {
        assertEquals("Ganaste este combate", WinState.getAction());
    }

    @Test
    void doAction() {
        setUp("1");
        WinState.setController(controller);
        WinState.doAction("1");
        assertEquals("Ganaste este combate",controller.getGameState().getAction());
    }

    @Test
    void isFinal() {
        assertTrue(WinState.isFinal());
    }
}