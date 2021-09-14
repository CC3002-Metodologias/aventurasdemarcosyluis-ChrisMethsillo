package com.example.aventurasdemarcoyluis.model.npc;

import com.example.aventurasdemarcoyluis.model.PlayersCombat;

/**
 *This class represent the Enemy Spiny, implements different methods to the combat system
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.npc.Enemies
 */
public class Spiny extends Enemies implements EnemiesCombat{
    /**
     * Creates a new Spiny
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Spiny(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL, EnemyType.SPINY);
    }

    /**
     * {@inheritDoc}
     * @param player player to attack
     */
    @Override
    public void attack(PlayersCombat player) {
        if(!isDeath()){
            double dmg=0.75*this.getAtk()*this.getLvl();
            player.getAtkByGoomba(dmg);
        }
    }

    /**
     * {@inheritDoc}
     * Spiny doesn't receive damage from normals attacks
     * @param dmg damage taken
     */
    @Override
    public void getAtkByMarcoNormal(double dmg) {
        this.dealDamage(0);
    }

    /**
     * {@inheritDoc}
     * Spiny doesn't receive damage from normals attacks
     * @param dmg damage taken
     */
    @Override
    public void getAtkByLuisNormal(double dmg) {
        this.dealDamage(0);
    }

    /**
     * {@inheritDoc}
     * @param dmg damage taken
     */
    @Override
    public void getAtkByMarcoHammer(double dmg) {
        this.dealDamage(dmg/this.getDef());
    }

    /**
     * {@inheritDoc}
     * @param dmg damage taken
     */
    @Override
    public void getAtkByLuisHammer(double dmg) {
        this.dealDamage(dmg/this.getDef());
    }
}
