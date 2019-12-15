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
public class AppTennis {

    public static void main(String[] args) {
        AppTennis prg = new AppTennis();
        prg.inici();
    }

    void inici() {
        int opcio = 0;
        String[] menu = {
            "MENÚ",
            "1. Introducció partit", "2. Càrrega de partits", "3. Visualitzar rànking", "0. Sortir"
        };

        DadesTorneig dadesTorneig = new DadesTorneig();

        GestorDades gestorDades = new GestorDades();

        gestorDades.inicialitzarDades(dadesTorneig);
        do {
            InterficieUsuari.mostrarMenu(menu);
            opcio = Utils.demanarEnter("Tria una opció", "Error");
            switch (opcio) {
                case 1:
//                    gestorDades.carregarPartits(dadesTorneig);
                    String jugadorA = Utils.demanarString("Introdueix el nom del/la jugador/a 1:", "Error");
                    String jugadorB = Utils.demanarString("Introdueix el nom del/la jugador/a 2:", "Error");
                    String jugada = Utils.demanarPartits("Introdueix la seqüència de caràcters d'un partit:", "Error");
                    gestorDades.introduirPartit(dadesTorneig, jugadorA, jugadorB, jugada);
                    InterficieUsuari.mostrarRanking(dadesTorneig);
                    break;
                case 2:
                    gestorDades.carregarPartits(dadesTorneig);
                    InterficieUsuari.mostrarRanking(dadesTorneig);
                    break;
                case 3:
                    InterficieUsuari.mostrarRanking(dadesTorneig);
                    break;
                case 0:
                    System.out.print("Fins la propera!\n");
                    break;
                default:

            }
        } while (opcio != 0);
    }
}
