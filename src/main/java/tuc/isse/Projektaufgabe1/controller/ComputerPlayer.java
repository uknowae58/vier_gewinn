package tuc.isse.Projektaufgabe1.controller;

import tuc.isse.Projektaufgabe1.model.Bord;
import tuc.isse.Projektaufgabe1.model.Color;
import tuc.isse.Projektaufgabe1.model.Winner;
import tuc.isse.Projektaufgabe1.view.VierGewinntFrame;

import java.io.IOException;

public class ComputerPlayer extends Player {

    private int randomchoice;
    protected VierGewinntFrame vierGewinntFrame;

    /**
     * konstruktor von Player
     *
     * @param color RED oder YELLOW
     * @param bord  bord
     */
    public ComputerPlayer(Color color, Bord bord) {
        super(color, bord);
    }

    @Override
    public void doTurn() throws IOException, ColumnFullException, IllegalMoveException {
        Bord bord = this.bord;
        Boolean colorRed = false;
        Boolean droped = false;
        if (getColor().equals(Color.RED)) {
            colorRed = true;
        }
        if (!droped) {
            for (int row = 1; row < 6; row++) {
                for (int col = 0; col < 7; col++) {
                    if (this.bord.getTokenColor(row, col) == getColor()) {
                        droped = true;
                        if (col == 0) {
                            randomchoice = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 2 + 1);
                            super.doDrop(randomchoice);
                        } else if (col == 6) {
                            randomchoice = java.util.concurrent.ThreadLocalRandom.current().nextInt(6, 7 + 1);
                            super.doDrop(randomchoice);
                        } else {
                            randomchoice = java.util.concurrent.ThreadLocalRandom.current().nextInt(col, col + 1);
                            super.doDrop(randomchoice);
                        }
                        row = 6;
                        break;
                    }
                }
            }
            if (!droped) {
                super.doDrop(4);
            }
        }
    }
}

