package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.npc.*;

import java.util.ArrayList;

/**
 * This game state is used when the player is attacking an enemy with the Hammer.
 * @author Christian Jesus Parra Cofre
 */
public class HammerAttackTurn extends AbstractGameState{

    /**
     * {@inheritDoc}
     * Notify that the players are in the HammerAttackTurn state.
     * And show the enemy options to the players.
     * @return String with the options to the players.
     */
    @Override
    public String getAction(){
        String enemigos = controller.getEnemies().getStringEnemies();
        return "Ataque de martillo \n"+ "¿A quién atacar?\n" + enemigos ;
    }

    /**
     * {@inheritDoc}
     * This state realize a attack with the hammer.
     * @param action Select the index of the enemy to attack
     */
    @Override
    public void doAction(String action) {
        if(controller.getEnemies().getLargeEnemies()<Integer.parseInt(action)){
            controller.say("No esta ese enemigo.");
            controller.setGameState(new HammerAttackTurn());
            return;
        }
        else{
            EnemiesMemory enemiesMemory = controller.getEnemies();
            if(controller.getActionPlayer()==PlayerType.MARCO){
                enemiesMemory.selectAttackHammer(controller.getMarco(),Integer.parseInt(action));
            }
            else if(controller.getActionPlayer()==PlayerType.LUIS){
                enemiesMemory.selectAttackHammer(controller.getLuis(),Integer.parseInt(action));
            }
            if(controller.getActionPlayer()==PlayerType.MARCO){
                if(controller.getLuis().isDeath()){
                    controller.setGameState(new EnemiesTurn());
                }
                else{
                    controller.setActionPlayer(PlayerType.LUIS);
                    controller.setGameState(new SelectAction());
                }
            }
            else if(controller.getActionPlayer()==PlayerType.LUIS){
                if(controller.getMarco().isDeath()) {
                    controller.setGameState(new EnemiesTurn());
                }
                else{
                    controller.setActionPlayer(PlayerType.MARCO);
                    controller.setGameState(new EnemiesTurn());
                }
            }
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }


}
