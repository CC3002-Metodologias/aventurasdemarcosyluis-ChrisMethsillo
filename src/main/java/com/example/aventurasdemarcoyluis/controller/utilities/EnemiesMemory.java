package com.example.aventurasdemarcoyluis.controller.utilities;

import com.example.aventurasdemarcoyluis.model.npc.Boo;
import com.example.aventurasdemarcoyluis.model.npc.Goomba;
import com.example.aventurasdemarcoyluis.model.npc.Spiny;
import com.example.aventurasdemarcoyluis.model.npc.factories.EnemyFactory;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used to store the enemies that are in the game.
 * @author Christian Jesus Parra Cofre
 */
public class EnemiesMemory {
    private ArrayList<Boo> boos;
    private ArrayList<Goomba> goombas;
    private ArrayList<Spiny> spines;
    private EnemyFactory enemyFactory=new EnemyFactory();

    /**
     * Initializes the enemies memory.
     */
    public EnemiesMemory(){
        boos = new ArrayList<>();
        goombas = new ArrayList<>();
        spines = new ArrayList<>();
    }

    /**
     * Add a new boo to the memory.
     * @param boo boo to add
     */
    public void add(Boo boo){
        boos.add(boo);
    }

    /**
     * Add a new goomba to the memory.
     * @param goomba boo to add
     */
    public void add(Goomba goomba){
        goombas.add(goomba);
    }

    /**
     * Add a new spiny to the memory.
     * @param spiny spiny to add
     */
    public void add(Spiny spiny){
        spines.add(spiny);
    }

    /**
     * Generate a randoms enemies with a specific level between 1 and the given level.
     * @param Large numbers of enemies
     * @param lvl max level of the enemies.
     */
    public void generateEnemies(int Large, int lvl){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        for (int i = 0; i < Large; i++){
            if (randomNumber == 0){
                add(enemyFactory.getBoo(lvl));
                randomNumber = random.nextInt(3);
            }
            else if (randomNumber == 1){
                add(enemyFactory.getGoomba(lvl));
                randomNumber = random.nextInt(3);
            }
            else if (randomNumber == 2){
                add(enemyFactory.getSpiny(lvl));
                randomNumber = random.nextInt(3);
            }
        }
    }

    /**
     * Makes the enemies attack the player. One per turn.
     * @param marco marco to attack or
     * @param luis luis to attack
     * @return String with who attacks.
     */
    public String makeAttack(Marco marco, Luis luis) {
        if(!this.isDefeat()){
            if(!marco.isDeath()&& !luis.isDeath()){
                Random random = new Random();
                int index = random.nextInt(boos.size()+goombas.size()+spines.size());
                if(index >= 0 && index < boos.size()){
                    boos.get(index).attack(luis);
                    return index + " - Boo attacks Luis" ;
                }

                else if(index >= boos.size() && index < boos.size() + goombas.size()){
                    int attack = random.nextInt(2);
                    if(attack == 0){
                        goombas.get(index-boos.size()).attack(marco);
                        return index + " - goomba attacks Marco" ;
                    }
                    else{
                        goombas.get(index-boos.size()).attack(luis);
                        return index + " - goomba attacks Luis" ;
                    }
                }
                else{
                    int attack = random.nextInt(2);
                    if(attack == 0){
                        spines.get(index-boos.size()-goombas.size()).attack(marco);
                        return index + " - spiny attacks Marco" ;
                    }
                    else{
                        spines.get(index-boos.size()-goombas.size()).attack(luis);
                        return index + " - spiny attacks Luis" ;
                    }
                }
            }
            else if(marco.isDeath()){
                Random random = new Random();
                int index = random.nextInt(boos.size()+goombas.size()+spines.size());
                if(index >= 0 && index < boos.size()){
                    boos.get(index).attack(luis);
                    return index + " - Boo attacks Luis" ;
                }

                else if(index >= boos.size() && index < boos.size() + goombas.size()){
                    goombas.get(index-boos.size()).attack(luis);
                    return index + " - goomba attacks Luis" ;
                }
                else{
                    spines.get(index-boos.size()-goombas.size()).attack(luis);
                    return index + " - spiny attacks Luis" ;
                }
            }
            else{
                Random random = new Random();
                int index = random.nextInt(goombas.size()+spines.size()) + boos.size();
                if(index >= boos.size() && index < boos.size() + goombas.size()){
                    goombas.get(index-boos.size()).attack(marco);
                    return index + " - goomba attacks Luis" ;
                }
                else{
                    spines.get(index-boos.size()-goombas.size()).attack(marco);
                    return index + " - spiny attacks Luis" ;
                }

            }
        }
        else{
            return "All enemies are defeated";
        }
    }

    /**
     * Updates the enemies memory.
     * In case if the enemies are dead, they are removed from the memory.
     */
    public void updateLifes(){
        for(int i = 0; i < boos.size(); i++){
            if(boos.get(i).isDeath()){
                boos.remove(i);
            }
        }
        for(int i = 0; i < goombas.size(); i++){
            if(goombas.get(i).isDeath()){
                goombas.remove(i);
            }
        }
        for(int i = 0; i < spines.size(); i++){
            if(spines.get(i).isDeath()){
                spines.remove(i);
            }
        }
    }

    /**
     * Receive a normal attack from the player.
     * @param marco marco to make the attack
     * @param list 0 if attacks boo, 1 if attacks goomba, 2 if attacks spiny
     * @param index index of the enemy to attack.
     */
    public void attackNormal(Marco marco, int list, int index){
        if(list == 0) {
            marco.attackNormal(boos.get(index));
        }
        else if(list == 1) {
            marco.attackNormal(goombas.get(index));
        }
        else if(list == 2) {
            marco.attackNormal(spines.get(index));
        }
    }

    /**
     * Receive a normal attack from the player.
     * @param luis luis to make the attack
     * @param list 0 if attacks boo (Luis cant attack boos), 1 if attacks goomba, 2 if attacks spiny
     * @param index index of the enemy to attack.
     */
    public void attackNormal(Luis luis, int list, int index) {
        if (list == 0) {
            return;
        } else if (list == 1) {
            luis.attackNormal(goombas.get(index));
        } else if (list == 2) {
            luis.attackNormal(spines.get(index));
        }
    }

    /**
     * Receive a hammer attack from the player.
     * @param marco marco to make the attack
     * @param list 0 if attacks boo, 1 if attacks goomba, 2 if attacks spiny
     * @param index index of the enemy to attack.
     */
    public void attackHammer(Marco marco, int list, int index){
        if(list == 0) {
            marco.attackHammer(boos.get(index));
        }
        else if(list == 1) {
            marco.attackHammer(goombas.get(index));
        }
        else if(list == 2) {
            marco.attackHammer(spines.get(index));
        }
    }

    /**
     * Receive a hammer attack from the player.
     * @param luis luis to make the attack
     * @param list 0 if attacks boo (Luis cant attack boos), 1 if attacks goomba, 2 if attacks spiny
     * @param index index of the enemy to attack.
     */
    public void attackHammer(Luis luis, int list, int index) {
        if (list == 0) {
            return;
        } else if (list == 1) {
            luis.attackHammer(goombas.get(index));
        } else if (list == 2) {
            luis.attackHammer(spines.get(index));
        }
    }

    /**
     * Verifies if the enemies are dead.
     * @return true if all enemies are dead, false if not.
     */
    public boolean isDefeat(){
        return boos.isEmpty() && goombas.isEmpty() && spines.isEmpty();
    }

    /**
     * Make a normal attack to one enemy.
     * @param luis Luis to make the attack
     * @param index index of the enemy to attack.
     */
    public void selectAttackNormal(Luis luis, int index){
        if(index >= 0 && index < boos.size()){
            attackNormal(luis, 0, index);
        }

        else if(index >= boos.size() && index < boos.size() + goombas.size()){
            attackNormal(luis, 1, index - boos.size());
        }

        else if(index >= boos.size() + goombas.size() && index < boos.size() + goombas.size() + spines.size()){
            attackNormal(luis, 2, index - boos.size() - goombas.size());
        }
    }

    /**
     * Make a normal attack to one enemy.
     * @param marco Marco to make the attack
     * @param index index of the enemy to attack.
     */
    public void selectAttackNormal(Marco marco, int index){
        if(index >= 0 && index < boos.size()){
            attackNormal(marco, 0, index);
        }
        else if (index >= boos.size() && index < boos.size() + goombas.size()){
            attackNormal(marco, 1, index - boos.size());
        }
        else if (index >= boos.size() + goombas.size() && index < boos.size() + goombas.size() + spines.size()){
            attackNormal(marco, 2, index - boos.size() - goombas.size());
        }
    }

    /**
     * Make a Hammer attack to one enemy.
     * @param marco Marco to make the attack
     * @param index index of the enemy to attack.
     */
    public void selectAttackHammer(Marco marco, int index){
        if(index >= 0 && index < boos.size()){
            attackHammer(marco, 0, index);
        }
        else if (index >= boos.size() && index < boos.size() + goombas.size()){
            attackHammer(marco, 1, index - boos.size());
        }
        else if (index >= boos.size() + goombas.size() && index < boos.size() + goombas.size() + spines.size()){
            attackHammer(marco, 2, index - boos.size() - goombas.size());
        }
    }

    /**
     * Make a Hammer attack to one enemy.
     * @param luis Luis to make the attack
     * @param index index of the enemy to attack.
     */
    public void selectAttackHammer(Luis luis, int index){
        if(index >= 0 && index < boos.size()){
            attackHammer(luis, 0, index);
        }
        else if (index >= boos.size() && index < boos.size() + goombas.size()){
            attackHammer(luis, 1, index - boos.size());
        }
        else if (index >= boos.size() + goombas.size() && index < boos.size() + goombas.size() + spines.size()){
            attackHammer(luis, 2, index - boos.size() - goombas.size());
        }
    }

    /**
     * Get the total number of enemies.
     * @return total number of enemies.
     */
    public int getLargeEnemies(){
        return boos.size() + goombas.size() + spines.size();
    }

    /**
     * Return a string with the information of the enemies. (index, type, hp and level)
     * @return string with the information of the enemies.
     */
    public String getStringEnemies(){
        String s = "";
        int index=0;
        for(Boo boo: boos){
            s +=  index +"- Boo : HP:" + boo.getHp() +", LVL:" + boo.getLvl()+ "\n";
            index++;
        }
        for(Goomba goomba : goombas){
            s += index + "- Goomba HP:" + goomba.getHp()+", LVL:" + + goomba.getLvl()+ "\n";
            index++;
        }
        for(Spiny spiny : spines){
            s += index + "- Spiny : HP:" + spiny.getHp() +", LVL:" + spiny.getLvl()+ "\n";
            index++;
        }
        return s;
    }

}



