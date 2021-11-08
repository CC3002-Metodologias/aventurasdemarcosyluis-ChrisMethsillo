package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.npc.*;

/**
 * This game state is used when the player is attacking an enemy with a normal attack.
 * @author Christian Jesus Parra Cofre
 */
public class NormalAttackTurn extends AbstractGameState{

    /**
     * {@inheritDoc}
     * Notify that the players are in the Normal attack turn state.
     * And show the enemy options to the players.
     * @return String with the options to the players.
     */
    @Override
    public String getAction(){
        String enemigos = controller.getEnemies().getStringEnemies();
        return ("Ataque normal\n¿A quién atacar?\n" + enemigos);
    }

    /**
     * {@inheritDoc}
     * This state realize a attack with a normal attack.
     * @param action Select the index of the enemy to attack
     */
    @Override
    public void doAction(String action) {

        if(controller.getEnemies().getLargeEnemies()<Integer.parseInt(action)){
            controller.say("No esta ese enemigo.");
            controller.setGameState(new NormalAttackTurn());
            return;
        }
        else{
            EnemiesMemory enemiesMemory = controller.getEnemies();
            if(controller.getActionPlayer()==PlayerType.MARCO){
                enemiesMemory.selectAttackNormal(controller.getMarco(),Integer.parseInt(action));
                enemiesMemory.updateLifes();
            }
            else if(controller.getActionPlayer()==PlayerType.LUIS){
                enemiesMemory.selectAttackNormal(controller.getLuis(),Integer.parseInt(action));
                enemiesMemory.updateLifes();
            }
            controller.setEnemies(enemiesMemory);
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

    /**
     * {@inheritDoc}
     * This state is not final
     * @return False
     */
    @Override
    public boolean isFinal() {
        return false;
    }


}
