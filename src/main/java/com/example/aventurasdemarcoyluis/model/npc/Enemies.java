package com.example.aventurasdemarcoyluis.model.npc;

import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.LuisCombat;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import com.example.aventurasdemarcoyluis.model.playablechar.MarcoCombat;

import java.util.Objects;

/**
 * This class represent an enemy in the game. This non-playable character has different features as life points and levels.
 * It also possesses combat characteristics such as attack, defense and fighting points.
 *
 * @author Christian Jesus Parra Cofre
 */
public abstract class Enemies {
    private double atk;
    private double def;
    private double hp;
    private int lvl=1;
    private EnemyType type;

    /**
     * Creates a new Enemy
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     * @param t Enemy type
     *
     */
    public Enemies(double ATK, double DEF,double HP, int LVL, EnemyType t ){
        atk=ATK;
        def=DEF;
        hp=HP;
        lvl=LVL;
        type=t;
    }

    /**
     * Returns the enemy attack point
     * @return atk
     */
    public double getAtk() {
        return atk;
    }

    /**
     * Returns the enemy defense point
     * @return def
     */
    public double getDef() {
        return def;
    }

    /**
     * Returns the enemy life points
     * @return hp
     */
    public double getHp() {
        return hp;
    }

    /**
     * Set the enemy life points
     * @param hp hp
     */
    private void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * Return the enemy level
     * @return lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * return the enemy type
     * @return Enemy type
     */
    public EnemyType getType() {
        return type;
    }

    /**
     *Check if the enemy is death
     * @return <code>true</code> If the enemy is death <code>false</code> otherwise
     */
    public boolean isDeath(){
        return hp==0;
    }

    /**
     *Deal damage to the enemy
     * @param dmg damage received
     */
    protected void dealDamage(double dmg){
        if(isDeath() || getHp()<=dmg){
            setHp(0);
        }
        else{
            setHp(getHp()-dmg);
        }
    }

    /**
     * {@inheritDoc}
     * @param o Object to compare
     * @return <code>true</code> If are the same object <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enemies)) return false;
        Enemies enemies = (Enemies) o;
        return atk == enemies.atk && def == enemies.def && Double.compare(enemies.hp, hp) == 0 && lvl == enemies.lvl && type == enemies.type;
    }

    /**
     * {@inheritDoc}
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(atk, def, hp, lvl, type);
    }


}
