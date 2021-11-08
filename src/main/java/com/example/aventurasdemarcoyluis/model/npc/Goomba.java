package com.example.aventurasdemarcoyluis.model.npc;

import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.LuisCombat;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import com.example.aventurasdemarcoyluis.model.playablechar.MarcoCombat;

/**
 *This class represent the Enemy Goomba, implements different methods to the combat system
 * @author Christian Jesus Parra Cofre
 * @see com.example.aventurasdemarcoyluis.model.npc.Enemies
 */
public class Goomba extends Enemies implements GoombaCombat {

    /**
     * Creates a new Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Goomba(double ATK, double DEF, double HP, int LVL) {
        super(ATK, DEF, HP, LVL, EnemyType.GOOMBA);
    }

    /**
     * {@inheritDoc}
     * @param player player to attack
     */
    @Override
    public void attack(LuisCombat player) {
        if(!isDeath()){
            double dmg=0.75*(this.getAtk()*this.getLvl())/player.getDef();
            player.getAtkByGoomba(dmg);
        }
    }
    /**
     * {@inheritDoc}
     * @param player player to attack
     */
    @Override
    public void attack(MarcoCombat player) {
        if(!isDeath()){
            double dmg=0.75*this.getAtk()*this.getLvl()/player.getDef();
            player.getAtkByGoomba(dmg);
        }
    }

    /**
     * {@inheritDoc}
     * @param dmg damage taken
     */
    @Override
    public void getAtkByMarcoNormal(double dmg) {
        this.dealDamage(dmg);
    }

    /**
     * {@inheritDoc}
     * @param dmg damage taken
     */
    @Override
    public void getAtkByLuisNormal(double dmg) {
        this.dealDamage(dmg);
    }

    /**
     * {@inheritDoc}
     * @param dmg damage taken
     */
    @Override
    public void getAtkByMarcoHammer(double dmg) {
        this.dealDamage(dmg);
    }

    /**
     * {@inheritDoc}
     * @param dmg damage taken
     */
    @Override
    public void getAtkByLuisHammer(double dmg) {
        this.dealDamage(dmg);
    }


}
