package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.utilities.EnemiesMemory;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;

/**
 * This class represent s the state of the game when the enemies are attacking the player.
 * @author Christian Jesus Parra Cofré
 */
public class EnemiesTurn extends AbstractGameState{

    /**
     * {@inheritDoc}
     * In this case, notify that the enemies are attacking the player.
     * @return "Turno enemigo, apreta cualquier numero para continuar."
     */
    @Override
    public String getAction() {
        return "Turno enemigo, apreta cualquier numero para continuar.";
    }

    /**
     * {@inheritDoc}
     * In this case, the enemies attack the player.
     * @param action the enemy attacks regardless of the action
     */
    @Override
    public void doAction(String action) {
        EnemiesMemory enemies =controller.getEnemies();
        enemies.updateLifes();
        controller.setEnemies(enemies);
        if(controller.getEnemies().isDefeat()){
            controller.setGameState(new WinState());
            return;
        }
        Marco marco = controller.getMarco();
        Luis luis = controller.getLuis();

        String ataque = controller.getEnemies().makeAttack(marco, luis);
        controller.say(ataque);

        controller.setMarco(marco);
        controller.setLuis(luis);
        controller.setActionPlayer(PlayerType.MARCO);
        controller.setGameState(new SelectAction());

    }

    /**
     * {@inheritDoc}
     * This state is not final.
     * @return False.
     */
    @Override
    public boolean isFinal() {
        return false;
    }


}
