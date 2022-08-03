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
 *hier wird die Attributen Red und Yellow in entsprechenden caracter  X und O  umgewandelt
 * wir erstellen ein Konstruktor fuer die Klasse Color ,  der als Parameter caracter nimmt
 */
public enum Color {
    RED("X"), YELLOW("O"),NONE(" ");

    private String caracter;
    private Color(String caracter){
        this.caracter = caracter;
    }

    /**
     * toString
     * @return X mit farbe red oder O mit farbe yellow
     */

    @Override
    public String toString() {
        return caracter;
    }



}
