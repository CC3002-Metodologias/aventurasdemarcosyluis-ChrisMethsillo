package com.example.aventurasdemarcoyluis.model.npc;

import com.example.aventurasdemarcoyluis.model.playablechar.LuisCombat;

/**
 * This interface implements different methods in charge of giving you a boo combat system in the game.
 * Different types of attacks are implemented for the enemies use, and attacks that can be received for the players.
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.AbstractPlayers
 */

public interface BooCombat {
    /**
     * Return the type of this enemy character
     * @return Enemy type
     */
    public EnemyType getType();

    /**
     * This method make an attack to a Luis
     * @param player player to attack
     */
    public void attack(LuisCombat player);

    /**
     * This method is to take damage done by the normal attack of Marco.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.playablechar.Marco
     */
    public void getAtkByMarcoNormal(double dmg);

    /**
     * This method is to take damage done by the normal attack of Marco.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.playablechar.Marco
     */
    public void getAtkByMarcoHammer(double dmg);

    /**
     * Returns the defense points
     * @return def points
     */
    public double getDef();

}
