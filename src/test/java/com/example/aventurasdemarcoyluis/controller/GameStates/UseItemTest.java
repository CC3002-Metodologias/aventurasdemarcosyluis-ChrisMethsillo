package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.model.Chest;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UseItemTest {

    private Controller controller;
    private ByteArrayInputStream inputs;
    private ByteArrayOutputStream output;
    private IGameStates useItem= new UseItem();
    public void setUp(String values) {
        inputs= new ByteArrayInputStream((values).getBytes());
        output= new ByteArrayOutputStream();
        System.setIn(inputs);
        controller=new Controller(new BufferedReader(new InputStreamReader(System.in)) , new PrintStream(output));
    }


    @Test
    void getAction() {
        setUp("1");
        useItem.setController(controller);
        Chest chest= new Chest();
        chest.addItem(new RedMushroom());
        controller.setChest(chest);
        useItem.getAction();
        assertEquals("Selecciona item:\n" +
                " 1-Red mushroom, 2-Honey Syrup (En caso de usar uno que no hay, se pierde turno) \n" +
                "Items disponibles: \n" +
                "REDMUSHROOM: 1\n", useItem.getAction());
    }

    @Test
    void doAction() {
        setUp("1");
        useItem.setController(controller);
        Chest chest= new Chest();
        chest.addItem(new RedMushroom());
        chest.addItem(new RedMushroom());
        chest.addItem(new HoneySyrup());
        chest.addItem(new HoneySyrup());
        controller.setChest(chest);

        controller.setMarco(new Marco(1,1,10,100,1,5,1));
        controller.setLuis(new Luis(1,1,10,100,1,5,1));

        controller.setActionPlayer(PlayerType.MARCO);
        useItem.doAction("1");
        controller.setActionPlayer(PlayerType.MARCO);
        useItem.doAction("2");

        assertEquals(controller.getMarco().getHp(),20);
        assertEquals(controller.getMarco().getFp(),4);

        controller.setActionPlayer(PlayerType.LUIS);
        useItem.doAction("1");
        controller.setActionPlayer(PlayerType.LUIS);
        useItem.doAction("2");

        assertEquals(controller.getLuis().getHp(),20);
        assertEquals(controller.getLuis().getFp(),4);

    }

    @Test
    void isFinal() {
        assertFalse(useItem.isFinal());
    }
}