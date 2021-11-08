package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;

/**
 * This class represents the win state of the game.
 */
public class WinState extends AbstractGameState {
    /**
     * {@inheritDoc}
     * Show s the win message.
     * @return Win message.
     */
    @Override
    public String getAction() {
        return "Ganaste este combate";
    }

    /**
     * {@inheritDoc}
     * Set the win state.
     * @param action action to do
     */
    @Override
    public void doAction(String action) {
        controller.setGameState(new WinState());
    }

    /**
     * {@inheritDoc}
     * @return True
     */
    @Override
    public boolean isFinal() {
        return true;
    }


}
