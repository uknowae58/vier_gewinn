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
import tuc.isse.Projektaufgabe1.model.Color;

import java.io.IOException;

public class GameMain_Console {
    public static  void main (String[] args) throws ColumnFullException, IllegalMoveException, IOException,NumberFormatException {

        Bord bord = new Bord();
        Player player1 = new ConsolePlayer(Color.RED,bord);
        Player player2 = new ConsolePlayer(Color.YELLOW,bord);
        Game game = new ConsoleGame(bord);
        game.doGame(player1,player2);
    }
}
