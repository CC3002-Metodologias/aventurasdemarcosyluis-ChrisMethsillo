package com.example.aventurasdemarcoyluis.model.items.factories;

import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;

/**
 * This class is a factory of the different items in the game.
 * @author Christian Jesus Parra Cofre
 */
public class ItemFactory {
    private static HoneySyrupFlyweight honeySyrupFlyweight = HoneySyrupFlyweight.getInstance();
    private static RedMushroomFlyweight redMushroomFlyweight = RedMushroomFlyweight.getInstance();

    /**
     * This method create a item factory
     */
    public ItemFactory() {
    }

    /**
     * This method create a honey syrup item
     * @return HoneySyrup
     */
    public HoneySyrup createHoneySyrup() {
        return honeySyrupFlyweight.create();
    }

    /**
     * This method create a red mushroom item
     * @return RedMushroom
     */
    public RedMushroom createRedMushroom(){
        return redMushroomFlyweight.create();
    }

}
