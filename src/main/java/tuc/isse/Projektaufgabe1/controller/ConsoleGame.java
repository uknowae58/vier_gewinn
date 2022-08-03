/////////////////////////////////////
/*
 * atchin.hecantty.ange-emmanuel.kouassi@tu-clausthal.de
 *franklin.leugue@tu-clausthal.de
 *  * Vorname1: Atchin Hecantty Ange Emmanuel
 * Nachname1: kouassi
 * Vorname2:Franklin
 * Nachname2:Leugue
 */
package tuc.isse.Projektaufgabe1.controller;

import tuc.isse.Projektaufgabe1.model.Bord;
import tuc.isse.Projektaufgabe1.model.Winner;

import java.io.IOException;

public class ConsoleGame extends Game {

    int randomNumber = java.util.concurrent.ThreadLocalRandom.current().nextInt(0,1 + 1);
    public ConsoleGame(Bord bord) {
        super(bord);
    }

    /**
     *doGame ist die methode von Game
     * @param player1 player1
     * @param player2 player2
     * @throws ColumnFullException
     * @throws IllegalMoveException
     * @throws IOException
     */
    @Override
    public void doGame(Player player1, Player player2) throws ColumnFullException, IllegalMoveException, IOException {
        this.player1 = player1;
        this.player2 = player2;
        if(randomNumber == 0){
            this.currentPlayer = player1;
        }
        else{
            this.currentPlayer = player2;
        }
         while(this.bord.testVictory().equals(Winner.NONE)){

             System.out.println(bord.toString());
             this.currentPlayer.doTurn();
             this.swapPlayer();
         }
         this.swapPlayer();
         System.out.println(bord.toString());
         System.out.println("And the winner is "+ currentPlayer.color);
    }
}
