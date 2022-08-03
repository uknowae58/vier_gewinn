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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePlayer extends Player {
    public ConsolePlayer(Color color, Bord bord) {
        super(color, bord);
    }

    /**
     * doTurn ist die Methode von Player
     * @throws IOException
     * @throws ColumnFullException
     * @throws IllegalMoveException
     */
    @Override
    public void doTurn() throws IOException, ColumnFullException, IllegalMoveException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Spieler " + color + ",was ist dein nächster Zug?");
        System.out.print("Eingabe:");
        int columnIndex = Integer.parseInt(consoleReader.readLine());
        super.doDrop(columnIndex);

    }
}
