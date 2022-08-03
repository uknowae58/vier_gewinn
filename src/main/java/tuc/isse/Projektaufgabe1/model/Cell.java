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

/**
 * Cell erhält die Color Red oder Yellow,wenn ein spieltein (Token) lassen fallen geworden.Und NONE,wenn kein spieltein(Token) lassen fallen geworden
 */
public class Cell extends GameObjekt {
    private Token token;
    private boolean isempty;

    /**
     * Konstruktor von Cell
     * @param color RED,YELLOW,NONE
     */
    public Cell(Color color ){
        this.token = new Token(color);

        if(this.token.getColor() == Color.NONE ){ //prüfen ein Token ob leer ist
            isempty = true;
        }
        else{
            isempty = false;
        }
    }

    /**
     * toString
     * @return [X] oder [O]
     */

    @Override
    public String toString(){

        if (isempty){
            return "[ ]";

        }else{
            return "["+token.toString()+"]";
        }
    }


    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public boolean isEmpty() {
        return isempty;
    }

    public void setIsempty(boolean isempty) {
        this.isempty = isempty;
    }
}
