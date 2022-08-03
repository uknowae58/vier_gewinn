package tuc.isse.Projektaufgabe1.view;

import tuc.isse.Projektaufgabe1.controller.*;
import tuc.isse.Projektaufgabe1.model.Bord;
import tuc.isse.Projektaufgabe1.model.Color;

import java.io.IOException;

public class GameMain_Frame {

    public static  void main (String[] args) throws ColumnFullException, IllegalMoveException, IOException,NumberFormatException {

        Bord bord = new Bord();
        VierGewinntFrame vierGewinntFrame = new VierGewinntFrame(bord);
        Player player1 = new FramePlayer(Color.RED,bord,vierGewinntFrame);
        Player player2 = new FramePlayer(Color.YELLOW,bord,vierGewinntFrame);
        Game game = new FrameGame(bord,vierGewinntFrame);
        game.doGame(player1,player2);
    }
}
