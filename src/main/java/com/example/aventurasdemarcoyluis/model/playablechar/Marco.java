package com.example.aventurasdemarcoyluis.model.playablechar;

import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.PlayersCombat;
import com.example.aventurasdemarcoyluis.model.npc.*;

/**
 * One of the playable characters is Marco. He has different methods for the combat system of the game
 * @author Christian Jesus Parra Cofre
 * @see PlayersCombat
 */
public class Marco extends AbstractPlayers implements PlayersCombat {
    /**
     * Creates a new marco
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param MaxHP  Max heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     */
    public Marco(int ATK, int DEF, double HP,double MaxHP, int FP, int LVL) {
        super(ATK, DEF, HP, MaxHP, FP, LVL, PlayerType.MARCO);
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
        this.dealDamage(0);
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
            enemy.getAtkByMarcoNormal(dmg);
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
            enemy.getAtkByMarcoHammer(dmg);
            reduceFp(2);
        }
    }
}
