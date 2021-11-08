package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;

/**
 * Interface that defines the methods for the game states
 * @author Christian Jesus Parra Cofre
 */
public interface IGameStates {
    /**
     * Return the action of this game state;
     * @return String with the action
     */
    String getAction();
    /**
     * Do the action of this game state.
     * @param action action to do
     */
    void doAction(String action);
    /**
     * Verify if this state is a final state
     * @return True if is final state, false if not.
     */
    boolean isFinal();
    /**
     * Set the controller of this game state
     * @param controller Controller of the game
     */
    void setController(Controller controller);
}
