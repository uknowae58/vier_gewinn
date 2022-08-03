package tuc.isse.Projektaufgabe1.view;

import tuc.isse.Projektaufgabe1.controller.ColumnFullException;
import tuc.isse.Projektaufgabe1.controller.IllegalMoveException;
import tuc.isse.Projektaufgabe1.view.ObservableBord;

import java.io.IOException;

public interface BordObserver {
    public void update(ObservableBord bord) throws ColumnFullException, IllegalMoveException, IOException;
}

