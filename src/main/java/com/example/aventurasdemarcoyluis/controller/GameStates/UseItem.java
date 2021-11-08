package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.model.PlayerType;
import com.example.aventurasdemarcoyluis.model.items.ItemType;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;

/**
 * This class represents the state of the game when the player is using an item.
 */
public class UseItem extends AbstractGameState{
    /**
     * {@inheritDoc}
     * Show the items that can be used in the chest.
     * @return String with the items that can be used in the chest.
     */
    @Override
    public String getAction() {
        String items="Items disponibles: \n" + controller.getChest().getStringItems();
        return "Selecciona item:\n 1-Red mushroom, 2-Honey Syrup (En caso de usar uno que no hay, se pierde turno) \n" + items;
    }

    /**
     * {@inheritDoc}
     * Use an item in the chest.
     * @param action 1 - Red mushroom, 2 - Honey syrup
     */
    @Override
    public void doAction(String action) {

        if(action.equals("1")){
            if(controller.getActionPlayer()== PlayerType.MARCO){
                Marco marco = controller.getMarco();
                controller.getChest().useItem(ItemType.REDMUSHROOM,marco);
                controller.setMarco(marco);
            }
            if(controller.getActionPlayer()== PlayerType.LUIS){
                Luis luis = controller.getLuis();
                controller.getChest().useItem(ItemType.REDMUSHROOM,luis);
                controller.setLuis(luis);
            }
        }
        if(action.equals("2")){
            if(controller.getActionPlayer()== PlayerType.MARCO){
                Marco marco = controller.getMarco();
                controller.getChest().useItem(ItemType.HONEYSYRUP,marco);
                controller.setMarco(marco);
            }
            if(controller.getActionPlayer()== PlayerType.LUIS){
                Luis luis = controller.getLuis();
                controller.getChest().useItem(ItemType.HONEYSYRUP,luis);
                controller.setLuis(luis);
            }
        }
        if(controller.getActionPlayer()==PlayerType.MARCO){
            if(controller.getLuis().isDeath()){
                controller.setGameState(new EnemiesTurn());
            }
            else{
                controller.setActionPlayer(PlayerType.LUIS);
                controller.setGameState(new SelectAction());
            }
        }
        else if(controller.getActionPlayer()==PlayerType.LUIS){
            if(controller.getMarco().isDeath()) {
                controller.setGameState(new EnemiesTurn());
            }
            else{
                controller.setActionPlayer(PlayerType.MARCO);
                controller.setGameState(new EnemiesTurn());
            }
        }
    }

    /**
     * {@inheritDoc}
     * This state is not final.
     * @return False
     */
    @Override
    public boolean isFinal() {
        return false;
    }


}
