package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;

/**
 * A game state represent the different states of the game which you can select player, select the attack, or use one item an receive
 * attacks from the enemies
 * @author Christian Jesus Parra Cofré
 */
public abstract class AbstractGameState implements IGameStates {
    protected Controller controller;

    /**
     * Return the action of this game state;
     * @return String with the action
     */
    @Override
    public String getAction() {
        return "Nada";
    }

    /**
     * Do the action of this game state.
     * @param action action to do
     */
    @Override
    public void doAction(String action) {

    }

    /**
     * Verify if this state is a final state
     * @return True if is final state, false if not.
     */
    @Override
    public boolean isFinal() {
        return false;
    }

    /**
     * Set the controller
     */
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
