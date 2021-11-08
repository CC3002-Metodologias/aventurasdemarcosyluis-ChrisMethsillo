package com.example.aventurasdemarcoyluis.controller;

import com.example.aventurasdemarcoyluis.controller.GameStates.IGameStates;
import com.example.aventurasdemarcoyluis.controller.GameStates.SelectAction;
import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.Chest;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.items.factories.ItemFactory;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * This class is the controller of the game. This class make the structure of the game, make combats, upgrade the player, etc
 * @author Christian Jesus Parra Cofre
 */
public class Controller {
    private Marco marco;
    private Luis luis;
    private Chest chest;
    private ItemFactory itemFactory;
    private EnemiesMemory enemies=new EnemiesMemory();
    private IGameStates gameState;
    private PlayerType actionPlayer = PlayerType.MARCO;
    private BufferedReader reader;
    private PrintStream printStream;
    private int wins=0;

    /**
     * This method is the constructor of the controller.
     * @param reader To receive the input from the user
     * @param printStream To send the output to the user
     */
    public Controller(BufferedReader reader, PrintStream printStream) {
        marco = new Marco(15, 15, 20, 20,50,50,1);
        luis = new Luis(15, 15, 20, 20,50,50,1);
        chest = new Chest();
        itemFactory = new ItemFactory();
        this.reader = reader;
        this.printStream = printStream;
    }

    /**
     * Update the State of the combat
     * @param gameState The new state of the combat
     */
    public void setGameState(IGameStates gameState){
        this.gameState = gameState;
    }

    /**
     * Return the game state of this controller.
     * @return game state
     */
    public IGameStates getGameState(){
        return gameState;
    }

    /**
     * This method return the player that is going to make the action
     * @return The player that is going to make the action
     */
    public PlayerType getActionPlayer(){
        return actionPlayer;
    }

    /**
     * This method set the player that is going to make the action
     * @param actionPlayer The player that is going to make the action
     */
    public void setActionPlayer(PlayerType actionPlayer){
        this.actionPlayer = actionPlayer;
    }


    /**
     * Get the marco of this controller
     * @return marco
     */
    public Marco getMarco() {
        return marco;
    }

    /**
     * Set the marco of this controller
     * @param marco marco to set
     */
    public void setMarco(Marco marco) {
        this.marco= marco;
    }

    /**
     * Get the luis of this controller
     * @return luis
     */
    public Luis getLuis() {
        return luis;
    }

    /**
     * Set the luis of this controller
     * @param luis luis to set
     */
    public void setLuis(Luis luis) {
        this.luis = luis;
    }

    /**
     * Get the chest of this controller
     * @return chest
     */
    public Chest getChest() {
        return chest;
    }

    /**
     * Set the chest of this controller
     * @param chest chest to set
     */
    public void setChest(Chest chest) {
        this.chest = chest;
    }

    /**
     * Get the enemies of this controller
     * @return enemies
     */
    public EnemiesMemory getEnemies() {
        return enemies;
    }

    /**
     * Set the enemies of this controller
     * @param enemies enemies to set
     */
    public void setEnemies(EnemiesMemory enemies) {
        this.enemies = enemies;
    }

    /**
     * Print something in the PrintStream
     * @param text The text to print
     */
    public void say(String text){
        printStream.println(text);
    }

    /**
     * This method is to make a battle. with n enemies with level between 1 and the level of the player.
     * @param large The number of enemies
     */
    public void makeBattle(int large){
        enemies.generateEnemies(large , marco.getLvl());
        setGameState(new SelectAction());
        gameState.setController(this);
        while(!gameState.isFinal()){
            say(gameState.getAction());
            try {
                String line = reader.readLine();
                gameState.doAction(line);
                gameState.setController(this);
            }
            catch (IOException e) {
                say("Something wrong. try again.");
            }
        }
        say(gameState.getAction());
        if(enemies.isDefeat()){
            wins++;
        }
    }

    /**
     * Returns the number of wins
     * @return wins
     */
    public int getWins(){
        return wins;
    }




}
