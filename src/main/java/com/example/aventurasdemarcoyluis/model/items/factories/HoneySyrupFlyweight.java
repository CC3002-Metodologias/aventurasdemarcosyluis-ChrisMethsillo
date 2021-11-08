package com.example.aventurasdemarcoyluis.model.items.factories;

import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;

/**
 * This class represent a flyweight factory of HoneySyrup objects.
 * @author Christian Jesus Parra Cofre
 */
public class HoneySyrupFlyweight {
    private static HoneySyrupFlyweight instance;
    private HoneySyrup cache;

    /**
     * This method create the Honey Syrup flyweight factory.
     */
    private HoneySyrupFlyweight() {
    }

    /**
     * This method return the instance of the HoneySyrup flyweight factory.
     * @return instance of the HoneySyrup flyweight factory.
     */
    public static HoneySyrupFlyweight getInstance() {
        if (instance == null) {
            instance = new HoneySyrupFlyweight();
        }
        return instance;
    }

    /**
     * This method return the HoneySyrup object.
     * @return HoneySyrup object.
     */
    public HoneySyrup create() {
        if(cache==null){
            cache = new HoneySyrup();
        }
        return cache;
    }
}
