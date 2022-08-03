/////////////////////////////////////
/*
 * atchin.hecantty.ange-emmanuel.kouassi@tu-clausthal.de
 *franklin.leugue@tu-clausthal.de
 * Vorname1: Atchin Hecantty Ange Emmanuel
 * Nachname1: kouassi
 * Vorname2:Franklin
 * Nachname2:Leugue
 */
package tuc.isse.Projektaufgabe1.controller;

import tuc.isse.Projektaufgabe1.model.Bord;

import java.io.IOException;

public abstract class Game {
    protected Bord bord;
    protected Player player1;
    protected Player player2;
    protected Player currentPlayer;


    /**
     *Konstruktor von Game
     * @param bord bord
     */
    public Game(Bord bord){
        this.bord=bord;
    }

    /**
     *swapPlayer wechselt den aktuellen Spieler
     */
    protected void swapPlayer(){
        if(currentPlayer.color.toString().equals(player2.color.toString())){
            currentPlayer = player1;
        }
        else{
            currentPlayer = player2;
        }
    }

    /**
     *doGame Spielablauf
     * @param player1 player1
     * @param player2 player2
     * @throws ColumnFullException
     * @throws IllegalMoveException
     * @throws IOException
     */
    public abstract void doGame(Player player1,Player player2) throws ColumnFullException, IllegalMoveException, IOException;
}
