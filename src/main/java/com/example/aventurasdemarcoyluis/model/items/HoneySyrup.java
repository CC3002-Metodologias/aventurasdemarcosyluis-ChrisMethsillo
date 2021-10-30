package com.example.aventurasdemarcoyluis.model.items;
import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.ItemUse;

/**
 * The Honey Syrup is one of the available items in this game. This item restore 3 Fighting Points of the player.
 * @see Item
 * @author Christian Jesus Parra Cofré
 */
public class HoneySyrup implements Item{
    private static ItemType type=ItemType.HONEYSYRUP;

    /**
     * Creates a new Honey Syrup
     */
    public HoneySyrup(){}

    /**
     * {@inheritDoc}
     * The honey syrup restore 3 Fp of the player.
     * @param player player who will use the object
     */
    @Override
    public void use(AbstractPlayers player) {
        player.increaseFp(3);
    }

    /**
     * {@inheritDoc}
     * @return Honey syrup item type
     */
    public ItemType getType(){
        return type;
    }

    /**
     * Check if an object is equal to the Honey Syrup
     * @param o object to compare
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