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
 * Hier wird ein spieltein Token, der die Attributen color erhält
 */
public class Token extends GameObjekt {

    private Color color;
    private Winner winner;

//constructor

    public Token(Color color){
       this.color = color;
    }

//getter and setter

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    /**
     * toString
     * @return color.toString()
     */
    @Override
    public String toString(){      // wandelt color zu String (caracter X,caracter O) um
        return color.toString();
    }

}
