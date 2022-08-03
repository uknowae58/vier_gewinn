
/////////////////////////////////////
/*
* atchin.hecantty.ange-emmanuel.kouassi@tu-clausthal.de
*franklin.leugue@tu-clausthal.de
*  * Vorname1: Atchin Hecantty Ange Emmanuel
        * Nachname1: kouassi
        * Vorname2:Franklin
        * Nachname2:Leugue
        */

package tuc.isse.Projektaufgabe1.model;

import tuc.isse.Projektaufgabe1.controller.ColumnFullException;
import tuc.isse.Projektaufgabe1.controller.IllegalMoveException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bord baut 42 cells an
 */
public class  Bord extends GameObjekt {

    private ArrayList <Cell> cells;
    private int currentRow;
    public int numberOfRedToken = 21;
    public int numberOfYellowToken =21;
    private Token currentToken;




    /**
     * der konstruktor von Bord
     */
    public Bord() {
       cells = new ArrayList<>();
        for (int i = 1; i <=42; i++) {
                cells.add(new Cell(Color.NONE)) ;
            }
        }

    public void save(String Path) throws IOException {
        FileWriter file = new FileWriter(Path);
        file.write(toString());
        file.close();
    }

    public void load(String Path) throws FileNotFoundException {
        Scanner loader = new Scanner(new File(Path));
        int row = 0;
        while(loader.hasNextLine()){
          String data[] = loader.nextLine().split("@");
          for(int col = 0; col< data.length;col ++){
              if(data[col].equals("[X]")){
                  cells.set(7*row+ col,new Cell(Color.RED));
              }
              else if(data[col].equals("[O]")){
                  cells.set(7*row+col,new Cell(Color.YELLOW));
              }
          }
            row ++;
        }
    }
    /**
     *
     * @param row, column
     * @return color
     */

    public Color getTokenColor(int row, int column){
        if(!cells.get(7*row+column).isEmpty()){
            return cells.get(7*row+column).getToken().getColor();
        }
        else {
            return null;
        }
    }


    /**
     *getToken entfernt einen Token mit der angegebenen Farbe aus dem Lager und liefert diesen zurück
     * @param color RED oder YELLOW
     * @return currentToken
     */
    public Token getToken(Color color ){
       if(Color.YELLOW.toString().equals(color.toString())) {
           currentToken = new Token(color);
           numberOfYellowToken-=1;
       }
       else if(Color.RED.toString().equals(color.toString())){
           currentToken = new Token(color);
           numberOfRedToken -=1;


       }
       return currentToken;
    }

    /**
     *hasToken prüft,ob es noch Steine mit der angegebenen Farbe im Lager gibt
     * @param color RED oder YELLOW
     * @return true oder false
     */
    public boolean hasToken(Color color) {
        if (Color.RED == color) {
            if (numberOfRedToken > 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (numberOfYellowToken > 0) {
                return true;
            }
            else {
                return false;
            }
        }

    }

    /**
     * isTie prüft, ob ein Gleichstand aufgetreten ist
     * @return true oder false
     */
    private boolean isTie(){
        if (numberOfYellowToken == 0 && numberOfRedToken == 0){
            return true;
        }
        return false;
    }

    /**
     *Diese Methode prüfen, ob sich an einer Stelle des Bretts vier Steine der angegebenen Farbe in einer Spalte befinden
     * @param color RED or YELLOW
     * @return true or false
     */

    private boolean isRowVictory(Color color){
        for(int i=0; i<=35; i+=7){
            for (int j=i; j<=3+i;j++){
                    String currentCell = cells.get(j).getToken().getColor().toString();
                    if (currentCell.equals(color.toString()) &&
                            cells.get(j+1).getToken().toString().equals(currentCell) &&
                            cells.get(j+2).getToken().toString().equals(currentCell) &&
                            cells.get(j+3).getToken().toString().equals(currentCell)) {
                        return true;
                    }
            }


        }return false;
    }

    /**
     *Diese Methode prüfen, ob sich an einer Stelle des Bretts vier Steine der angegebenen Farbe in einer Spalte befinden
     * @param color RED oder YELLOW
     * @return true oder false
     */

    private boolean isColumnVictory(Color color) {
            for (int i = 0; i <= 6; i++) {
                for (int j = i; j <= 14+i; j++) {
                    String currentCell = cells.get(j).getToken().getColor().toString();
                    if (currentCell.equals(color.toString()) &&
                            cells.get(j+7).getToken().toString().equals(currentCell) &&
                            cells.get(j+14).getToken().toString().equals(currentCell) &&
                            cells.get(j+21).getToken().toString().equals(currentCell)){
                        return true;

                    }

            }
        }return false;
    }

    /**
     *Diese Methode prüfen, ob sich an einer Stelle des Bretts vier Steine der angegebenen Farbe in einer Diagonalen befinden
     * @param color RED oder YELLOW
     * @return true oder false
     */


    private boolean isDiagonalVictory(Color color) {
        for (int i = 14; i >= 0; i-=7) {
            for (int j = i; j <= 3+i; j++) {
                    String currentCell = cells.get(j).getToken().getColor().toString();
                    if (currentCell.equals(color.toString()) &&
                            cells.get(j+8).getToken().toString().equals(currentCell) &&
                            cells.get(j+16).getToken().toString().equals(currentCell) &&
                            cells.get(j+24).getToken().toString().equals(currentCell) ){
                        return true;
                    }

            }
        }
        for (int i = 20; i >= 6; i-=7) {
            for (int j = i; j >=i-3; j--) {
                String currentCell = cells.get(j).getToken().getColor().toString();
                    if (currentCell.equals(color.toString()) &&
                            cells.get(j+6).getToken().toString().equals(currentCell) &&
                            cells.get(j+12).getToken().toString().equals(currentCell) &&
                            cells.get(j+18).getToken().toString().equals(currentCell) ){
                        return true;
                    }

            }

        }return false;
    }

    /**
     *testVictory es prüft, ob es einen Gewinner oder ein Gleichstand gibt
     *@Methode: isRowVictory,isColumnVictory,isDiagonalVictory
     *@return TIE,NONE,RED,YELLOW
     */

    public Winner testVictory() {
        boolean redVictory = isRowVictory(Color.RED) || isColumnVictory(Color.RED) || isDiagonalVictory(Color.RED);
        boolean yellowVictory = isRowVictory(Color.YELLOW) || isColumnVictory(Color.YELLOW) || isDiagonalVictory(Color.YELLOW);

       if (isTie()){
           return Winner.TIE;
       }
       else if (redVictory && yellowVictory) {
            return Winner.NONE;
        }
        else if (redVictory) {
            return Winner.RED;
        }
        else if (yellowVictory) {
            return Winner.YELLOW;
        }

      return Winner.NONE;

    }


    /**
     *dropToken einen Spielstein (Token) in eine bestimmte Spalte des Spielbretts fallen zu lassen
     * @param token token
     * @param columnIndex [0..41]
     * @throws ColumnFullException
     * @throws IllegalMoveException
     */

    public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException, IOException {
       if (testVictory().equals(Winner.NONE)||testVictory().equals(Winner.TIE)) {
           if (canDrop(columnIndex)) {
               cells.set(currentRow, new Cell(token.getColor()));
           }
           else {
               throw new ColumnFullException();
           }
       }
       else {
           throw new IllegalMoveException();
       }
    }

    /**
     *canDrop prüft, ob noch Platz ist
     * @param columnIndex [0..41]
     * @return true oder false
     */
    public boolean canDrop(int columnIndex){
       for(int i=34+columnIndex;i>=columnIndex-1;i-=7){
           if(cells.get(i).isEmpty()){
               currentRow = i;
               return true;
           }
       }
        return false;}

    /**
     * Methode toString
     * @return results
     */

    @Override
    public String toString(){
        String results = "";

        for(int i = 0; i<=35; i+=7){
            for (int j = i; j<=6+i; j++){
               results += cells.get(j).toString() + "@";

            }
            results += "\n";
        }

        return results;
    }

}