package com.example.aventurasdemarcoyluis.model;

import com.example.aventurasdemarcoyluis.model.npc.Enemies;
import com.example.aventurasdemarcoyluis.model.npc.EnemyType;

/**
 * This class represent a playable character in the game.
 * A playable character has many features, as life points and levels.
 * It also possesses combat characteristics such as attack, defense, fighting points, and a state of immortality.
 *
 *  @author Christian Jesus Parra Cofre.
 */
public abstract class AbstractPlayers implements ItemUse{
    private int atk;
    private int def;
    private double hp;
    private static double MAXHP;
    private int fp;
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
     * @param LVL level of the Unit
     * @param CHARACTER Character Type
     */
    public AbstractPlayers(int ATK, int DEF, double HP, double maxHP, int FP, int LVL, PlayerType CHARACTER){
        atk=ATK;
        def=DEF;
        MAXHP=maxHP;
        hp=HP;
        fp=FP;
        lvl=LVL;
        character=CHARACTER;
    }

    /**
     *Set the hp of the character
     * @param hp new hp
     */
    private void setHp(double hp){this.hp=hp;}

    /**
     *Set the fp of the character
     * @param fp new fp
     */
    private void setFp(int fp){this.fp=fp;}

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
    public int getAtk(){
        return atk;
    }

    /**
     * Return the Defense points of the character
     * @return def
     */
    public int getDef(){
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
    public int getFp(){return fp;}

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
    protected void makeInmortal(){
        this.inmortal=true;
    }

    /**
     *Increase the character fp
     * @param fp fp to increase
     */
    protected void increaseFp(int fp){
        setFp(getFp()+fp);
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
    protected void increaseHp(double hp){
        if(getHp()+hp>MAXHP){
            setHp(MAXHP);
        }
        else{
            setHp(getHp()+hp);
        }
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
        increaseFp(3);
    }

    /**
     * Use the Star item
     * @see com.example.aventurasdemarcoyluis.model.items.Item
     * @see com.example.aventurasdemarcoyluis.model.items.Star
     */
    @Override
    public void useStar() {
        makeInmortal();
    }

    /**
     *Use the RedMushroom item
     * @see com.example.aventurasdemarcoyluis.model.items.Item
     * @see com.example.aventurasdemarcoyluis.model.items.RedMushroom
     */
    @Override
    public void useRedMushroom() {
        increaseHp(0.1*MAXHP);
    }
    /**
     * {@inheritDoc}
     * @param o Object to compare
     * @return <code>true</code> If are the same object <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPlayers)) return false;
        AbstractPlayers players = (AbstractPlayers) o;
        return atk == players.atk && def == players.def && hp == players.hp && lvl == players.lvl && MAXHP == players.MAXHP
                && fp== players.fp && inmortal==players.inmortal && character==players.character;
    }
}
