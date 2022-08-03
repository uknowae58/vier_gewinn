package tuc.isse.Projektaufgabe1.view;

import tuc.isse.Projektaufgabe1.controller.ColumnFullException;
import tuc.isse.Projektaufgabe1.controller.IllegalMoveException;
import tuc.isse.Projektaufgabe1.controller.Player;
import tuc.isse.Projektaufgabe1.model.Bord;
import tuc.isse.Projektaufgabe1.model.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FramePlayer extends Player implements ActionListener{

    protected VierGewinntFrame vierGewinntFrame;
    /**
     * konstruktor von Player
     *
     * @param color RED oder YELLOW
     * @param bord  bord
     */
    public FramePlayer(Color color, Bord bord,VierGewinntFrame vierGewinntFrame) {
        super(color, bord);
        this.vierGewinntFrame = vierGewinntFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Path = "/Users/uknowae/Desktop/gruppe_35/src/main/java/tuc/isse/Projektaufgabe1/save.txt";
        int event = Integer.parseInt(e.getActionCommand());
        vierGewinntFrame.removeButtonListener(this);
        if(event== 9){
            try {
                vierGewinntFrame.observableBord.save(Path);
                doTurn();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ColumnFullException columnFullException) {
                columnFullException.printStackTrace();
            } catch (IllegalMoveException illegalMoveException) {
                illegalMoveException.printStackTrace();
            }


        }
        else if(event == 8){
            try {
                vierGewinntFrame.observableBord.load(Path);
                vierGewinntFrame.observableBord.notifyObserver();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (ColumnFullException columnFullException) {
                columnFullException.printStackTrace();
            } catch (IllegalMoveException illegalMoveException) {
                illegalMoveException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
        else {


            try {
                vierGewinntFrame.row[event - 1] -= 1;
                vierGewinntFrame.observableBord.dropToken(this.bord.getToken(this.color), event);

            } catch (ColumnFullException columnFullException) {
                columnFullException.printStackTrace();
            } catch (IllegalMoveException illegalMoveException) {
                illegalMoveException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public void doTurn() throws IOException, ColumnFullException, IllegalMoveException {
        vierGewinntFrame.jlabel.setText("Spieler " + color + ",was ist dein nächster Zug?");
        vierGewinntFrame.addButtonListener(this);
    }
}
