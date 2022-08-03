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

public abstract class Player {
    protected Color color;
    protected Bord bord;
    /**
     *konstruktor von Player
     * @param color RED oder YELLOW
     * @param bord bord
     */
    public Player(Color color,Bord bord){
        this.color= color;
        this.bord= bord;
    }

    /**
     * doDrop
     * @param columnindex [1..7]
     * @throws ColumnFullException
     * @throws IllegalMoveException
     */
    protected void doDrop(int columnindex) throws ColumnFullException, IllegalMoveException, IOException {
        bord.dropToken(bord.getToken(color),columnindex);
    }
    /**
     *doTurn Fragt den Nutzer über Konsole nach einer Eingabe und einen Token mit hilfe der Methode doDrop fallen lassen
     * @throws IOException
     * @throws ColumnFullException
     * @throws IllegalMoveException
     */
    public abstract void doTurn() throws IOException, ColumnFullException, IllegalMoveException;

    public Color getColor() {
        return color;
    }
}
