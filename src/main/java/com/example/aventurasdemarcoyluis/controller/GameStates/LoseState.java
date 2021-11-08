package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;

/**
 * This class is the state of the game when the player loses.
 * @author Christian Jesus Parra Cofre.
 */
public class LoseState extends AbstractGameState{
    /**
     * {@inheritDoc}
     * Show a lose message.
     * @return A lose message.
     */
    @Override
    public String getAction() {
        return "Perdiste";
    }

    /**
     * {@inheritDoc}
     * Set the game state in the lose state.
     * @param action this state receive every action.
     */
    @Override
    public void doAction(String action) {
        controller.setGameState(new LoseState());
    }

    /**
     * {@inheritDoc}
     * This is a final state.
     * @return True.
     */
    @Override
    public boolean isFinal() {
        return true;
    }


}
