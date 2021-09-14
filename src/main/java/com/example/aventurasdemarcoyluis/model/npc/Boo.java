package com.example.aventurasdemarcoyluis.model.npc;
import com.example.aventurasdemarcoyluis.model.PlayersCombat;

/**
 *This class represent the Enemy Boo, implements different methods to the combat system
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.npc.Enemies
 */
public class Boo extends Enemies implements EnemiesCombat{
    /**
     * Creates a new Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Boo(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL, EnemyType.BOO);
    }

    /**
     * {@inheritDoc}
     * @param player player to attack
     */
    @Override
    public void attack(PlayersCombat player) {
        if(!isDeath()){
            double dmg=0.75*this.getAtk()*this.getLvl();
            player.getAtkByBoo(dmg);
        }
    }

    /**
     * {@inheritDoc}
     * @param dmg damage taken
     */
    @Override
    public void getAtkByMarcoNormal(double dmg) {
        this.dealDamage(dmg/this.getDef());
    }

    /**
     * {@inheritDoc}
     * Boo doesn't receive damage from luis.
     * @param dmg damage taken
     */
    @Override
    public void getAtkByLuisNormal(double dmg) {
        this.dealDamage(0);
    }

    /**
     * {@inheritDoc}
     * Boo doesn't receive damage from a hammer attack.
     * @param dmg damage taken
     */
    @Override
    public void getAtkByMarcoHammer(double dmg) {
        this.dealDamage(0);
    }

    /**
     * {@inheritDoc}
     * * Boo doesn't receive damage from luis
     * Boo doesn't receive damage from a hammer attack.
     * @param dmg damage taken
     */
    @Override
    public void getAtkByLuisHammer(double dmg) {
        this.dealDamage(0);
    }
}
