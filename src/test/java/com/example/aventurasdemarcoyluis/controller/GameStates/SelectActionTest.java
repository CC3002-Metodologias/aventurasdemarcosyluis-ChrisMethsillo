package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class SelectActionTest {

    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    private IGameStates selectAction= new SelectAction();
    public void setUp(String values) {
        inputs= new ByteArrayInputStream((values).getBytes());
        output= new ByteArrayOutputStream();
        System.setIn(inputs);
        controller=new Controller(new BufferedReader(new InputStreamReader(System.in)) , new PrintStream(output));
    }

    @Test
    void getAction() {
        setUp("1");
        selectAction.setController(controller);
        assertEquals("Turno de Marco: HP = 20.0, FP = 50.0 Selecciona una acción: \n" +
                "1. Ataque normal \n" +
                "2. Ataque con martillo \n" +
                "3. Usar objeto \n" +
                "4. Pasar turno",selectAction.getAction());
        controller.setActionPlayer(PlayerType.LUIS);
        assertEquals("Turno de Luis: HP = 20.0, FP = 50.0 Selecciona una acción: \n" +
                "1. Ataque normal \n" +
                "2. Ataque con martillo \n" +
                "3. Usar objeto \n" +
                "4. Pasar turno",selectAction.getAction());
        controller.setMarco(new Marco(1,1,0,1,0,1,1));
        controller.setActionPlayer(PlayerType.MARCO);
        assertEquals("Turno de Luis: HP = 20.0, FP = 50.0 Selecciona una acción: \n" +
                "1. Ataque normal \n" +
                "2. Ataque con martillo \n" +
                "3. Usar objeto \n" +
                "4. Pasar turno",selectAction.getAction());
        controller.setLuis(new Luis(1,1,0,1,0,1,1));
        controller.setActionPlayer(PlayerType.LUIS);
        assertEquals("Tus personajes han sido derrotados.",selectAction.getAction());
        controller.setMarco(new Marco(1,1,1,1,1,1,1));
        assertEquals("Turno de Marco: HP = 1.0, FP = 1.0 Selecciona una acción: \n" +
                "1. Ataque normal \n" +
                "2. Ataque con martillo \n" +
                "3. Usar objeto \n" +
                "4. Pasar turno",selectAction.getAction());

    }

    @Test
    void doAction() {
    }

    @Test
    void isFinal() {
    }
}