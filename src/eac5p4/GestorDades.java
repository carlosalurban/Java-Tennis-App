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
public class GestorDades {
    //DADES DE DadesTorneig utilitzades en aquesta clase
//    static final int RANKING = 0;
//    static final int RANKING_PUNTS = 1;
//    static final int NOMBRE_CAMPS = 2;
//    static final int NOM_JUGADORA = 0;
//    static final int NOM_JUGADORB = 1;
//    static final int RESULTAT = 2;
//    public static int PUNTUACIO = 10;

    public void inicialitzarDades(DadesTorneig dadesTorneig) {
        dadesTorneig.ranking = new String[1][2];
        dadesTorneig.jugadorA = new String[4];
        dadesTorneig.jugadorB = new String[4];
        dadesTorneig.jugada = new String[4];
    }

    public void carregarPartits(DadesTorneig dadesTorneig) {
        int llargada = dadesTorneig.partits.length;
        for (int i = 0; i < llargada; i++) {
            dadesTorneig.jugadorA[i] = dadesTorneig.partits[i][dadesTorneig.NOM_JUGADORA];
            dadesTorneig.jugadorB[i] = dadesTorneig.partits[i][dadesTorneig.NOM_JUGADORB];
            dadesTorneig.jugada[i] = dadesTorneig.partits[i][2];
            introduirPartit(dadesTorneig, dadesTorneig.jugadorA[i], dadesTorneig.jugadorB[i], dadesTorneig.jugada[i]);
        }
    }

    public static void analitzarPartit(DadesTorneig dadesTorneig, String jugadorA, String jugadorB, String jugada) {
        //Dins d`aquest metode també es podria fer servir els de entrada de dades
//        String jugadorA = Utils.demanarString("Introdueix el nom del/la jugador/a 1:", "Error");
//        String jugadorB = Utils.demanarString("Introdueix el nom del/la jugador/a 2:", "Error");
//        String jugada = Utils.demanarPartits("Introdueix la seqüència de caràcters d'un partit:", "Error");
        int puntsA = 0, puntsB = 0, setsA = 0, setsB = 0, set = 6, diferencia = 2;
        int jugadaFinal = jugada.length();
        boolean empat = false;
        String guanyador = "";
        System.out.print("\nEl resultat del partit es: \n");
        System.out.print("--------------------------\n");
        for (int i = 0; i < jugadaFinal; i++) {
            char lletra = jugada.charAt(i);
            int restaLletres = jugadaFinal - i;
            if (lletra == 'A') {
                puntsA++;
            }
            if (lletra == 'B') {
                puntsB++;
            }
            if (jugada.length() - i + 1 >= set) {
                if ((puntsA >= set) && (puntsA >= puntsB + diferencia)) {
                    setsA++;
                    System.out.print("\n" + jugadorA + "  " + puntsA + " - " + jugadorB + " " + puntsB);
                    puntsA = puntsB = 0;
                }
                if ((puntsB >= set) && (puntsB >= puntsA + diferencia)) {
                    setsB++;
                    System.out.print("\n" + jugadorA + "  " + puntsA + " - " + jugadorB + " " + puntsB);
                    puntsB = puntsA = 0;
                }
            }
        }
        if (puntsA > puntsB) {
            setsA++;
        }
        if (puntsB > puntsA) {
            setsB++;
        }
        System.out.print("\n" + jugadorA + "  " + puntsA + " - " + jugadorB + " " + puntsB + "\n");
        if (setsA > setsB) {
            System.out.print("\nEl/La jugador/a guanyador del partit és: " + jugadorA + "\n");
            guanyador = jugadorA;

        } else if (setsA < setsB) {
            System.out.print("\nEl/La jugador/a guanyador del partit és: " + jugadorB + "\n");
            guanyador = jugadorB;

        } else {
            System.out.print("\nS'ha produït un empat, la classificació no varia");
            empat = true;
        }
        System.out.print("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        if (!empat) {
            int posicio = RankingUtils.trobarFilaSegonsJugador(dadesTorneig, guanyador);
            if (posicio == -1) {
                dadesTorneig.ranking = RankingUtils.afegirJugador(dadesTorneig, guanyador, dadesTorneig.PUNTUACIO);
            } else {
                RankingUtils.actualitzarPuntuacioRanking(dadesTorneig, posicio, dadesTorneig.PUNTUACIO);
            }
        }
    }

    public void introduirPartit(DadesTorneig dadesTorneig, String jugadorA, String jugadorB, String jugada) {
        dadesTorneig.jugadorA = RankingUtils.incrementarArrayDades(dadesTorneig.jugadorA);
        dadesTorneig.jugadorB = RankingUtils.incrementarArrayDades(dadesTorneig.jugadorB);
        dadesTorneig.jugada = RankingUtils.incrementarArrayDades(dadesTorneig.jugada);
        dadesTorneig.partits = RankingUtils.incrementarDadesBidi(dadesTorneig.partits, dadesTorneig.COL_PARTITS, dadesTorneig.INCREMENT);
        int posicio = dadesTorneig.jugadorA.length - 1;
        dadesTorneig.partits[posicio][dadesTorneig.NOM_JUGADORA] = jugadorA;
        dadesTorneig.partits[posicio][dadesTorneig.NOM_JUGADORB] = jugadorB;
        dadesTorneig.partits[posicio][dadesTorneig.RESULTAT] = jugada;
        analitzarPartit(dadesTorneig, jugadorA, jugadorB, jugada);
    }
}
