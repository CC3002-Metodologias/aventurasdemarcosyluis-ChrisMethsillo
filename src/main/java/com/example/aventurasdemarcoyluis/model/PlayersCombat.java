package com.example.aventurasdemarcoyluis.model;
import com.example.aventurasdemarcoyluis.model.npc.EnemiesCombat;

/**
 * This interface implements different methods for the combat system in the game.
 * Different types of attacks are implemented for the character use, and attacks that can be received.
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.npc.Enemies
 */
public interface PlayersCombat {

    /**
     * This method is to take damage done by the enemy Goomba.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Goomba
     */
    public void getAtkByGoomba(double dmg);

    /**
     * This method is to take damage done by the enemy Spiny.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Spiny
     */
    public void getAtkBySpiny(double dmg);

    /**
     * This method is to take damage done by the enemy Boo.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Boo
     */
    public void getAtkByBoo(double dmg);

    /**
     * This method make a Normal attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackNormal(EnemiesCombat enemy);

    /**
     * This method make a Hammer attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackHammer(EnemiesCombat enemy);
}
