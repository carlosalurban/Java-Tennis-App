/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eac5p4;

import java.util.Arrays;

/**
 *
 * @author Carlos
 */
public class RankingUtils {

    static final int INDEX_NOM = 0;
    static final int INDEX_PUNTS = 1;
    static final int NUM_COLUMNES_RANKING = 2;
    static final int NUM_COLUMNES_PARTITS = 3;

    /**
     * A partir de les dades del torneig i el nom del darrer guanyador, mira si
     * existeix dins el ranking. En cas que així sigui en retorna la fila
     * corresponent a la seva posició. Altrament retorna -1
     *
     * @param ranking conté el ranking i el jugador que s'hi cerca
     * @param participant conté el nom del darrer jugador guanyador
     * @return la fila del jungador en el ranking o -1 si no el troba
     */
    public static int trobarFilaSegonsJugador(DadesTorneig dadesTorneig, String nomParticipant) {
        int fila = -1;
        for (int i = 0; i < dadesTorneig.ranking.length; i++) {
            if (dadesTorneig.ranking[i][0] != null && dadesTorneig.ranking[i][0].equalsIgnoreCase(nomParticipant)) {
                fila = i;
            }
        }
        return fila;
    }

    /**
     * Afegeix una nova posició al ranking amb el nou jugador que ha guanyat el
     * darrer partit. Amplia el ranking en una posició per fer-ho.
     *
     * @param dades conté el ranking dels jugadors on s'afegirà el darrer
     * guanyador
     */
    public static String[][] afegirJugador(DadesTorneig dadesTorneig, String nomParticipant, int puntuacio) {
        if (dadesTorneig.ranking[0][0] != null) {
            dadesTorneig.ranking = RankingUtils.incrementarDadesBidi(dadesTorneig.ranking, 2, 1);
        }
        dadesTorneig.ranking[dadesTorneig.ranking.length - 1][INDEX_NOM] = nomParticipant.toUpperCase();
        dadesTorneig.ranking[dadesTorneig.ranking.length - 1][INDEX_PUNTS] = Integer.toString(puntuacio);
        return dadesTorneig.ranking;
    }

    /**
     * A partir de la posició del darrer jugador que ha guanyat el darrer partir
     * n'incrementa la seva puntuació al ranking en tants punts com valor té una
     * victoria (constant)
     *
     * @param ranking conté el ranking en el que s'han d'actualitzar els punts.
     * @param posicioJugador conté la posició del jugador en el ranking que cal
     * actualitzar-li els punts
     * @param puntuacio
     */
    public static void actualitzarPuntuacioRanking(DadesTorneig dadesTorneig, int posicioJugador, int puntuacio) {
        int puntuacioEnter = Integer.parseInt(dadesTorneig.ranking[posicioJugador][dadesTorneig.RANKING_PUNTS]);
        puntuacioEnter += puntuacio;
        dadesTorneig.ranking[posicioJugador][dadesTorneig.RANKING_PUNTS] = Integer.toString(puntuacioEnter);
    }

    public static String[] incrementarArrayDades(String[] dades) {
        String[] updateDades = new String[dades.length + 1];
        updateDades = Arrays.copyOfRange(dades, 0, dades.length + 1);
        String[] dadesAnteriors = new String[dades.length + 1];
        dadesAnteriors = Arrays.copyOfRange(updateDades, 0, dades.length + 1);
        return dadesAnteriors;
    }

    public static String[][] incrementarDadesBidi(String[][] dades, int tamanyArray, int sumarArray) {
        int tamany = dades.length + sumarArray;
        String[][] updateDades = new String[tamany][tamanyArray];
        for (int i = 0; i < dades.length; i++) {
            for (int j = 0; j < tamanyArray; j++) {
                updateDades[i][j] = dades[i][j];
            }
        }
        String[][] partitsAnteriors = new String[tamany][tamanyArray];
        for (int i = 0; i < dades.length; i++) {
            for (int j = 0; j < tamanyArray; j++) {
                partitsAnteriors[i][j] = dades[i][j];
            }
        }
        return partitsAnteriors;
    }

    public static String[][] ordenarRanking(String[][] ranking) {
        for (int i = 0; i < ranking.length; i++) {
            for (int j = 0; j < ranking.length - 1; j++) {
                if (Integer.parseInt(ranking[j][1]) < Integer.parseInt(ranking[j + 1][1])) {
                    String[] intercanvi = ranking[j + 1];
                    ranking[j + 1] = ranking[j];
                    ranking[j] = intercanvi;
                }
            }
        }
        return ranking;
    }
}
