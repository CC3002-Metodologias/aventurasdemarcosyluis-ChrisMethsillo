package com.example.aventurasdemarcoyluis.model.items;
import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.ItemUse;

/**
 * In this game there are different items which can be used by the playable characters.
 * This interface implements the use of these items.
 * @author Christian Jesus Parra Cofre
 */
public interface Item {
    /**
     * Use the item in a player.
     * @param player player who will use the object
     */
    void use(ItemUse player);

    /**
     * Return the item typeplayer who will use the object
     * @see ItemType
     * @return item type
     */
    ItemType getType();

    /**
     * Check if an object is equal to the item
     * @param o object
     * @return <code>true</code> If are the same object <code>false</code> otherwise
     */
    boolean equals(Object o);
}
