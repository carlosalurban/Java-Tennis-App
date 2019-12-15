/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eac5p4;

/**
 *
 * @author Carlos
 */
public class DadesTorneig {

    static final int RANKING = 0;
    static final int RANKING_PUNTS = 1;
    static final int NOMBRE_CAMPS = 2;
    static final int NOM_JUGADORA = 0;
    static final int NOM_JUGADORB = 1;
    static final int RESULTAT = 2;
    public static int PUNTUACIO = 10;
    public static int COL_PARTITS = 3;
    public static int INCREMENT = 1;
    String[][] partits = {
        {"SERENA W.", "MARIA S.", "AAAAAAAAA"},
        {"VANESSA W.", "NOAMI O.", "BBBBBBBBBB"},
        {"ANDY M.", "RAFA N.", "AAAAAAAABBBBBBBBBBAABBBABB"},
        {"NOVAK J.", "ROGER F.", "B"}
    };
    String[][] ranking;
    String[] jugadorA;
    String[] jugadorB;
    String[] jugada;
    String[] resultat;
    int puntuacioPerPartit;
}
