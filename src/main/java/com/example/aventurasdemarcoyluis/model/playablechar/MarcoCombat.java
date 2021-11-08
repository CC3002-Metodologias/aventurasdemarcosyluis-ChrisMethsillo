package com.example.aventurasdemarcoyluis.model.playablechar;
import com.example.aventurasdemarcoyluis.model.npc.BooCombat;
import com.example.aventurasdemarcoyluis.model.npc.GoombaCombat;
import com.example.aventurasdemarcoyluis.model.npc.SpinyCombat;

/**
 * This interface implements different methods for the Marco combat system in the game.
 * Different types of attacks are implemented for the character use, and attacks that can be received.
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.npc.Enemies
 */
public interface MarcoCombat {
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
     * This method make a Normal attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackNormal(GoombaCombat enemy);

    /**
     * This method make a Normal attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackNormal(SpinyCombat enemy);

    /**
     * This method make a Normal attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackNormal(BooCombat enemy);

    /**
     * This method make a Hammer attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackHammer(GoombaCombat enemy);

    /**
     * This method make a Hammer attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackHammer(BooCombat enemy);

    /**
     * This method make a Hammer attack to an enemy
     * @param enemy enemy to attack
     */
    public void attackHammer(SpinyCombat enemy);

    /**
     * This method returns the Def points
     * @return defense points
     */
    public double getDef();
}
