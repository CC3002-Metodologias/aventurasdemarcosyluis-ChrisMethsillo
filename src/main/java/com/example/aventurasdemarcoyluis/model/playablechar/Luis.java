package com.example.aventurasdemarcoyluis.model.playablechar;

import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.PlayersCombat;
import com.example.aventurasdemarcoyluis.model.npc.*;

/**
 * One of the playable characters is Luis. He has different methods for the combat system of the game
 * @author Christian Jesus Parra Cofre
 * @see PlayersCombat
 */
public class Luis extends AbstractPlayers implements PlayersCombat {
    /**
     * Creates a new Luis
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param maxHP Max heal points
     * @param FP  fight points
     * @param maxFP Max fight points
     * @param LVL level of the Unit
     */
    public Luis(int ATK, int DEF, double HP, double maxHP, int FP, int maxFP, int LVL) {
        super(ATK, DEF, HP, maxHP, FP, maxFP, LVL, PlayerType.LUIS);
    }

    /**
     * This method is to take damage done by the enemy Goomba.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Goomba
     */
    @Override
    public void getAtkByGoomba(double dmg) {
        this.dealDamage(dmg/this.getDef());
    }

    /**
     * This method is to take damage done by the enemy Spiny.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Spiny
     */
    @Override
    public void getAtkBySpiny(double dmg) {
        this.dealDamage(dmg/this.getDef());
    }

    /**
     * This method is to take damage done by the enemy Boo.
     * @param dmg damage taken
     * @see com.example.aventurasdemarcoyluis.model.npc.Boo
     */
    @Override
    public void getAtkByBoo(double dmg) {
        this.dealDamage(dmg/this.getDef());
    }

    /**
     * This method make a Normal attack to an enemy.
     * Different enemies make different consequences, like receive damage or secondary effects.
     * @param enemy enemy to attack
     */
    @Override
    public void attackNormal(EnemiesCombat enemy) {
        if(!isDeath() & hasEnoughFp(1)){
            double dmg=this.getAtk()*this.getLvl();
            enemy.getAtkByLuisNormal(dmg);
            reduceFp(1);
        }
        if(enemy.getType()==EnemyType.SPINY){
            this.dealDamage(0.05*getHp());
        }
    }
    /**
     * This method make a Hammer attack to an enemy
     * Different enemies make different consequences, like receive damage or secondary effects.
     * @param enemy enemy to attack
     */
    @Override
    public void attackHammer(EnemiesCombat enemy) {
        boolean probability=Math.random()>=0.25;
        if(!isDeath() & probability & hasEnoughFp(2)){
            double dmg=1.5*this.getAtk()*this.getLvl();
            enemy.getAtkByLuisHammer(dmg);
            reduceFp(2);
        }
    }
}
