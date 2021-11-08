package com.example.aventurasdemarcoyluis.model;


import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.Item;
import com.example.aventurasdemarcoyluis.model.items.ItemType;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

/**
 * This class represent a playable character in the game.
 * A playable character has many features, as life points and levels.
 * It also possesses combat characteristics such as attack, defense, fighting points, and a state of immortality.
 *
 *  @author Christian Jesus Parra Cofre.
 */
public abstract class AbstractPlayers implements ItemUse{
    private double atk;
    private double def;
    private double hp;
    private static double MAXHP;
    private double fp;
    private static double MAXFP;
    private int lvl;
    private boolean inmortal=false;
    private PlayerType character;


    /**
     * Creates a new player
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param maxHP Max heal points
     * @param FP  fight points
     * @param maxFP Max fight points
     * @param LVL level of the Unit
     * @param CHARACTER Character Type
     */
    public AbstractPlayers(double ATK, double DEF, double HP, double maxHP, double FP, double maxFP, int LVL, PlayerType CHARACTER){
        atk=ATK;
        def=DEF;
        MAXHP=maxHP;
        MAXFP=maxFP;
        hp=HP;
        fp=FP;
        lvl=LVL;
        character=CHARACTER;
    }

    /**
     *Set the hp of the character
     * @param hp new hp
     */
    private void setHp(double hp){
        if(hp>MAXHP){
            this.hp=MAXHP;
        }
        else{
            this.hp=hp;
        }
    }

    /**
     *Set the fp of the character
     * @param fp new fp
     */
    private void setFp(double fp){
        if(fp>MAXFP){
            this.fp=MAXFP;
        }
        else{
            this.fp=fp;
        }
    }

    /**
     *Return the hp of the character
     * @return character hp
     */
    public double getHp(){
        return hp;
    }

    /**
     *Return the Atack points of the character
     * @return atk
     */
    public double getAtk(){
        return atk;
    }

    /**
     * Return the Defense points of the character
     * @return def
     */
    public double getDef(){
        return def;
    }

    /**
     *Return the level of the character
     * @return lvl
     */
    public int getLvl(){
        return lvl;
    }

    /**
     *Return the fight points of the character
     * @return fp
     */
    public double getFp(){return fp;}

    /**
     *Return the character type
     * @return character
     */
    public PlayerType getType(){return character;}

    /**
     *Check if the character is death
     * @return <code>true</code> If the player is death <code>false</code> otherwise
     */
    public boolean isDeath(){
        return this.hp==0;
    }
    /**
     *Check if the character is inmortal
     * @return <code>true</code> If the player is inmortal <code>false</code> otherwise
     */
    public boolean isInmortal(){
        return this.inmortal;
    }

    /**
     *Check if the character has more fp than a determinate fp value
     * @param fp fp value to compare
     * @return <code>true</code> If the player has enough fighting points <code>false</code> otherwise
     */
    public boolean hasEnoughFp(int fp){
        return getFp()>=fp;
    }

    /**
     *Make the character inmortal.
     */
    public void makeInmortal(){
        this.inmortal=true;
    }

    /**
     *Increase the character fp
     * @param fp fp to increase
     */
    public void increaseFp(int fp){
        if(getFp()+fp>MAXFP){
            setFp(MAXFP);
        }
        else{
            setFp(getFp()+fp);
        }
    }

    /**
     * Returns the max hp of the player
     * @return MAXHP
     */
    public double getMAXHP(){
        return MAXHP;
    }

    /**
     *Reduce the character fp
     * @param fp fp to reduce
     */
    protected void reduceFp(int fp){
        if(hasEnoughFp(fp)){
            setFp(getFp()-fp);
        }
    }

    /**
     *Increase the character hp
     * @param hp hp to increase
     */
    public void increaseHp(double hp){
        if(getHp()+hp>MAXHP){
            setHp(MAXHP);
        }
        else{
            setHp(getHp()+hp);
        }
    }

    /**
     * Increase the level of the character and increase the stats.
     */
    public void increaseLvl(){
        MAXHP=MAXHP*(1.15);
        MAXFP= MAXFP*(1.15);
        atk=atk*(1.15);
        def=def*(1.15);
        lvl++;
    }

    /**
     *Deal damage to the character
     * @param dmg damage received
     */
    protected void dealDamage(double dmg){
        if(!inmortal){
            if(isDeath() || getHp()<=dmg){
                setHp(0);
            }
            else{
                setHp(getHp()-dmg);
            }
        }
    }

    /**
     *Use the HoneySyrup item
     * @see com.example.aventurasdemarcoyluis.model.items.Item
     * @see com.example.aventurasdemarcoyluis.model.items.HoneySyrup
     */
    @Override
    public void useHoneySyrup() {
        this.increaseFp(3);
    }



    /**
     *Use the RedMushroom item
     * @see com.example.aventurasdemarcoyluis.model.items.Item
     * @see com.example.aventurasdemarcoyluis.model.items.RedMushroom
     */
    @Override
    public void useRedMushroom() {
        this.increaseHp(0.1*MAXHP);
    }

    /**
     * {@inheritDoc}
     * @param o object to compare
     * @return <code>true</code> if are equals <code>false</code>otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPlayers)) return false;
        AbstractPlayers players = (AbstractPlayers) o;
        return atk == players.atk && def == players.def && Double.compare(players.hp, hp) == 0 && fp == players.fp && lvl == players.lvl && inmortal == players.inmortal && character == players.character;
    }

    /**
     * {@inheritDoc}
     * @return hashCode of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(atk, def, hp, fp, lvl, inmortal, character);
    }



}
