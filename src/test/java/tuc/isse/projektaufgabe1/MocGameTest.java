/////////////////////////////////////
/*
 * atchin.hecantty.ange-emmanuel.kouassi@tu-clausthal.de
 *franklin.leugue@tu-clausthal.de
 *  * Vorname1: Atchin Hecantty Ange Emmanuel
 * Nachname1: kouassi
 * Vorname2:Franklin
 * Nachname2:Leugue
 */
package tuc.isse.projektaufgabe1;


import org.junit.Before;
import org.junit.Test;
import tuc.isse.Projektaufgabe1.controller.*;
import tuc.isse.Projektaufgabe1.model.Bord;
import tuc.isse.Projektaufgabe1.model.Color;
import tuc.isse.Projektaufgabe1.model.Winner;
import tuc.isse.Projektaufgabe1.view.BordObserver;
import tuc.isse.Projektaufgabe1.view.ObservableBord;

import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class MocGameTest implements BordObserver {


    ObservableBord bord;
    Bord bord1;
    Bord saveBord;
    Player player1;
    Player player2;
    Game game;
    @Before

    public void setUp() throws ColumnFullException, IllegalMoveException, IOException {
        saveBord = new Bord();
        player1 = new ComputerPlayer(Color.RED,saveBord);
        player2 = new ComputerPlayer(Color.YELLOW,saveBord);
        game = new ConsoleGame(saveBord);
        game.doGame(player1,player2);

        bord1 = new Bord();
        bord = new ObservableBord();
        bord.addObserver(this);
        bord1.dropToken(bord1.getToken(Color.RED), 7);
        bord1.dropToken(bord1.getToken(Color.RED), 7);
        bord1.dropToken(bord1.getToken(Color.RED),7);
        bord1.save("/Users/uknowae/Desktop/gruppe_35/src/main/java/tuc/isse/Projektaufgabe1/save.txt");
        bord1.load("/Users/uknowae/Desktop/gruppe_35/src/main/java/tuc/isse/Projektaufgabe1/save.txt");



    }
    @Test
    public void testSave() {
      String a = "[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@\n"+
    "[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@\n"+
    "[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@\n"+
    "[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@[X]@\n"+
    "[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@[X]@\n"+
    "[ ]@[ ]@[ ]@[ ]@[ ]@[ ]@[X]@\n";


      assertEquals(a,bord1.toString());
    }
    @Test
    public void test(){
       update(bord);
    }

    @Override
    public void update(ObservableBord bord) {
        assertEquals(this,bord.getBordObservers().get(0));
        bord.removeObserver(this);
        assertEquals(0,bord.getBordObservers().size());
    }
}

