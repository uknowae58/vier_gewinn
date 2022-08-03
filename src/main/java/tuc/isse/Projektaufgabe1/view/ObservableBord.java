package tuc.isse.Projektaufgabe1.view;

import tuc.isse.Projektaufgabe1.controller.ColumnFullException;
import tuc.isse.Projektaufgabe1.controller.IllegalMoveException;
import tuc.isse.Projektaufgabe1.model.Bord;
import tuc.isse.Projektaufgabe1.model.Token;

import java.io.IOException;
import java.util.ArrayList;

public class ObservableBord extends Bord {
private ArrayList<BordObserver> bordObservers;

public ObservableBord(){
    super();
    bordObservers = new ArrayList<BordObserver>();
}

    public void addObserver(BordObserver bordObserver){
        if(bordObserver!=null) {
            bordObservers.add(bordObserver);
        }
        else {
            System.err.println("error");
        }
    }
    public void removeObserver(BordObserver bordObserver){
        if(bordObserver !=null) {
            bordObservers.remove(bordObserver);
        }
        else {
            System.err.println("error");
        }
    }
    public void notifyObserver() throws ColumnFullException, IllegalMoveException, IOException {
        for (BordObserver b : this.bordObservers) {
            b.update(this);
        }
    }
    public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException, IOException {
        super.dropToken(token,columnIndex);
        notifyObserver();
    }

    public ArrayList<BordObserver> getBordObservers() {
        return bordObservers;
    }
}
