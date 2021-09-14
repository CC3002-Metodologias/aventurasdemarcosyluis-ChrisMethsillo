package com.example.aventurasdemarcoyluis.model.npc;
import com.example.aventurasdemarcoyluis.model.PlayersCombat;
/**
 * This interface implements different methods in charge of giving you a combat system in the game.
 * Different types of attacks are implemented for the enemies use, and attacks that can be received for the players.
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.AbstractPlayers
 */
public interface EnemiesCombat {
    /**
     * Return the type of this enemy character
     * @return Enemy type
     */
    public EnemyType getType();

    /**
     * This method make an attack to a player
     * @param player player to attack
     */
    public void attack(PlayersCombat player);
    /**
     * This method is to take damage done by the normal attack of Marco.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.playablechar.Marco
     */
    public void getAtkByMarcoNormal(double dmg);

    /**
     * This method is to take damage done by the normal attack of Luis.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.playablechar.Luis
     */
    public void getAtkByLuisNormal(double dmg);

    /**
     * This method is to take damage done by the hammer attack of Marco.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.playablechar.Marco
     */
    public void getAtkByMarcoHammer(double dmg);

    /**
     * This method is to take damage done by the hammer attack of Luis.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.playablechar.Luis
     */
    public void getAtkByLuisHammer(double dmg);



}
