package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.ItemUse;
import com.example.aventurasdemarcoyluis.model.npc.Enemies;

/**
 * The Star is one of the available items in this game. This item makes the player inmortal.
 * @see Item
 * @author Christian Jesus Parra Cofré
 */
public class Star implements Item{
    private static ItemType type=ItemType.STAR;

    /**
     * Creates a new Star
     */
    public Star(){}

    /**
     * {@inheritDoc}
     * The star makes the player inmortal.
     * @param player player who will use the object
     */
    @Override
    public void use(AbstractPlayers player) {
        player.makeInmortal();
    }

    /**
     * {@inheritDoc}
     * @return Star item type
     */
    public ItemType getType(){
        return type;
    }

    /**
     * Check if an object is equal to the Star
     * @param o object
     * @return <code>true</code> If are the same object <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item objecto = (Item) o;
        return objecto.getType()==type;
    }
}
