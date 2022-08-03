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

public class MocPlayer extends Player {
protected int move;

    public MocPlayer(Color color, Bord bord, int move) {
        super(color, bord);
        this.move = move;

    }

    @Override
    public void doTurn() throws IOException, ColumnFullException, IllegalMoveException {
        super.doDrop(move);
    }
}
