package com.example.aventurasdemarcoyluis.controller.GameStates;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.model.PlayerType;

/**
 * This class is the state of the game when the player is selecting an action.
 */
public class SelectAction extends AbstractGameState{
    @Override
    public String getAction() {
        if (controller.getMarco().isDeath() && controller.getLuis().isDeath()) {
            return "Tus personajes han sido derrotados.";
        }
        else{
            String u = "Selecciona una acción: \n1. Ataque normal \n2. Ataque con martillo \n3. Usar objeto \n4. Pasar turno";
            if(controller.getMarco().isDeath()){
                return "Turno de Luis: HP = " + controller.getLuis().getHp() + ", FP = "+ controller.getLuis().getFp() + " " + u;
            }
            else if(controller.getLuis().isDeath()){
                return "Turno de Marco: HP = " + controller.getMarco().getHp() + ", FP = "+ controller.getMarco().getFp() + " " + u;
            }
            else{
                if(controller.getActionPlayer() == PlayerType.MARCO){
                    return "Turno de Marco: HP = " + controller.getMarco().getHp() + ", FP = "+ controller.getMarco().getFp() + " " + u;
                }
                else{
                    return "Turno de Luis: HP = " + controller.getLuis().getHp() + ", FP = "+ controller.getLuis().getFp() + " " + u;
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     * Do an action depending on the input, 1 for normal attack, 2 for hammer attack, 3 for use item, 4 for pass turn.
     * @param action action to do
     */

    @Override
    public void doAction(String action) {
        if(controller.getMarco().isDeath() && controller.getLuis().isDeath()){
            controller.setGameState(new LoseState());
        }
        if(controller.getMarco().isDeath()){
            controller.setActionPlayer(PlayerType.LUIS);
        }
        if(controller.getLuis().isDeath()){
            controller.setActionPlayer(PlayerType.MARCO);
        }
        if("1".equals(action)){
            this.controller.setGameState(new NormalAttackTurn());
        }
        else if("2".equals(action)){
            this.controller.setGameState(new HammerAttackTurn());
        }
        else if("3".equals(action)){
            this.controller.setGameState(new UseItem());
        }
        else if("4".equals(action)){
            if(controller.getActionPlayer() == PlayerType.MARCO){
                controller.setActionPlayer(PlayerType.LUIS);
                controller.setGameState(new SelectAction());
            }
            else{
                controller.setGameState(new EnemiesTurn());
            }
        }
    }

    /**
     * {@inheritDoc}
     * This game state is not final.
     * @return False
     */
    @Override
    public boolean isFinal() {
        return false;
    }


}
