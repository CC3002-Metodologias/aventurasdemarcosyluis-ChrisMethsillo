package com.example.aventurasdemarcoyluis.model.items.factories;


import com.example.aventurasdemarcoyluis.model.items.RedMushroom;

/**
 * This class represents a flyweight factory of RedMushrooms.
 * @author Christian Jesus Parra Cofre
 */
public class RedMushroomFlyweight {
    private static RedMushroomFlyweight instance = null;
    private RedMushroom redMushroom;

    /**
     * This method create a new RedMushroom factory.
     */
    private RedMushroomFlyweight() {
    }

    /**
     * This method return the instance of the Red mushroom flyweight factory.
     * @return the instance of the factory.
     */
    public static RedMushroomFlyweight getInstance() {
        if (instance == null) {
            instance = new RedMushroomFlyweight();
        }
        return instance;
    }

    /**
     * This method returns a RedMushroom.
     * @return RedMushroom
     */
    public RedMushroom create() {
        if (redMushroom == null) {
            redMushroom = new RedMushroom();
        }
        return redMushroom;
    }
}
