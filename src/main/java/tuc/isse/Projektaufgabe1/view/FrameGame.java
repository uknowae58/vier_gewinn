package tuc.isse.Projektaufgabe1.view;

import tuc.isse.Projektaufgabe1.controller.ColumnFullException;
import tuc.isse.Projektaufgabe1.controller.Game;
import tuc.isse.Projektaufgabe1.controller.IllegalMoveException;
import tuc.isse.Projektaufgabe1.controller.Player;
import tuc.isse.Projektaufgabe1.model.Bord;
import tuc.isse.Projektaufgabe1.model.Winner;

import javax.swing.*;
import java.io.IOException;

public class FrameGame extends Game implements BordObserver{
    int randomNumber = java.util.concurrent.ThreadLocalRandom.current().nextInt(0,1 + 1);
    protected VierGewinntFrame vierGewinntFrame;

    /**
     * Konstruktor von Game
     *
     * @param bord bord
     */
    public FrameGame(Bord bord, VierGewinntFrame vierGewinntFrame) {
        super(bord);
        this.vierGewinntFrame = vierGewinntFrame;
        this.vierGewinntFrame.observableBord.addObserver(this);
    }

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
        this.currentPlayer.doTurn();
    }

    @Override
    public void update(ObservableBord bord) throws ColumnFullException, IllegalMoveException, IOException {
        int j = 0;
        for (int i =0; i<7;i++) {
            if (vierGewinntFrame.row[i]==0) {
                vierGewinntFrame.jButtons.get(i).setEnabled(false);
                j+=1;
            }
        }
        if (j ==7){
            this.vierGewinntFrame.jlabel.setText("Is tie!");
        }

        else if(bord.testVictory().equals(Winner.NONE)){
            this.swapPlayer();
            this.currentPlayer.doTurn();

        }else {


            this.vierGewinntFrame.jlabel.setText("And the winner is " + this.currentPlayer.getColor());
            for (JButton b : vierGewinntFrame.jButtons) {
                b.setEnabled(false);
            }
        }
    }
}
