package com.example.aventurasdemarcoyluis.model.items;
import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.ItemUse;
import com.example.aventurasdemarcoyluis.model.npc.Enemies;

/**
 * The Red Mushroom is one of the available items in this game. This item heals a 10% HP of the player.
 * @see Item
 * @author Christian Jesus Parra Cofré
 */
public class RedMushroom implements Item{
    private static ItemType type=ItemType.REDMUSHROOM;

    /**
     * Creates a new Red Mushroom
     */
    public RedMushroom(){}

    /**
     * {@inheritDoc}
     * The Red Mushroom restore 10% Hp of the player.
     * @param player player who will use the object
     */
    @Override
    public void use(AbstractPlayers player) {
        player.increaseHp(0.1* player.MAXHP());
    }

    /**
     * {@inheritDoc}
     * @return Red Mushroom item type
     */
    public ItemType getType(){
        return type;
    }

    /**
     * Check if an object is equal to the Red mushroom
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