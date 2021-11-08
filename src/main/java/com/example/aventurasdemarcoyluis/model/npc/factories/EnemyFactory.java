package com.example.aventurasdemarcoyluis.model.npc.factories;

import com.example.aventurasdemarcoyluis.model.npc.Boo;
import com.example.aventurasdemarcoyluis.model.npc.Goomba;
import com.example.aventurasdemarcoyluis.model.npc.Spiny;

/**
 * This methods is a factory that creates enemies.
 * @author Christian Jesus Parra Cofre
 */
public class EnemyFactory {

    /**
     * This method is the constructor of the enemy factory.
     */
    public EnemyFactory() {
    }

    /**
     * This method creates a goomba with a certain level and their respective characteristics
     * @param lvl level of the goomba
     * @return Goomba
     */
    public Goomba getGoomba(int lvl){
        return new Goomba(20*(1+0.15*lvl), 10*(1+0.15*lvl), 20*(1+0.15*lvl), lvl);
    }

    /**
     * This method creates a boo with a certain level and their respective characteristics
     * @param lvl level of the boo
     * @return Boo
     */
    public Boo getBoo(int lvl){
        return new Boo(25*(1+0.15*lvl), 10*(1+0.15*lvl), 20*(1+0.15*lvl), lvl);
    }

    /**
     * This method creates a spiny with a certain level and their respective characteristics
     * @param lvl level of the spiny
     * @return Spiny
     */
    public Spiny getSpiny(int lvl){
        return new Spiny(20*(1+0.15*lvl), 15*(1+0.15*lvl), 20*(1+0.15*lvl), lvl);
    }

}
