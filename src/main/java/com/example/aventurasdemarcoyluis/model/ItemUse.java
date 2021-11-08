package com.example.aventurasdemarcoyluis.model;

/**
 * This interface implements different methods for the use of existing items in the game
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.items.Item
 */
public interface ItemUse {
    /**
     *Use the RedMushroom item
     * @see com.example.aventurasdemarcoyluis.model.items.Item
     * @see com.example.aventurasdemarcoyluis.model.items.RedMushroom
     */
    void useRedMushroom();

    /**
     *Use the HoneySyrup item
     * @see com.example.aventurasdemarcoyluis.model.items.Item
     * @see com.example.aventurasdemarcoyluis.model.items.HoneySyrup
     */
    void useHoneySyrup();

    /**
     *Check if the character is death
     * @return <code>true</code> If the player is death <code>false</code> otherwise
     */
    boolean isDeath();

    /**
     * Return the type of the player
     * @return player type
     */
    PlayerType getType();
}
