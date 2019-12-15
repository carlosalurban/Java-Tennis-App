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
public class InterficieUsuari {

    static final String JUGADOR = "JUGADORS";
    static final String PUNTUACIO = "PUNTUACIO";

    /**
     * Mostra el ranking per pantalla amb el format de les columnes alineat
     *
     * @param ranking variable amb els jugadors i les puntuacions.
     */
    public static void mostrarRanking(DadesTorneig dadesTorneig) {
        dadesTorneig.ranking = RankingUtils.ordenarRanking(dadesTorneig.ranking);
        System.out.println("------------------------------");
        System.out.println(String.format("%-20s %-10s", JUGADOR, PUNTUACIO));
        System.out.println("------------------------------");
        for (int i = 0; i < dadesTorneig.ranking.length; i++) {
            System.out.println(String.format("%-25s %-10s", dadesTorneig.ranking[i][0], dadesTorneig.ranking[i][1]));
        }
        System.out.println();
    }

    /**
     * Funció que mostra per pantalla les diferents opcions que formen el menú
     * que es rep com a paràmetre. La primera posició de l'array menú és el
     * títol del mateix mentre que la resta són les opcions. Aquesta variable ja
     * ve inicialitzada des del codi que en fa la crida.
     *
     * @param menu Conté les diferents opcions que es mostraran per pantalla a
     * l'usuari.
     */
    public static void mostrarMenu(String[] menu) {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(menu[0]);
        System.out.println("--------------------------------------------------------------------------------");
        for (int pos = 1; pos < menu.length; pos++) {
            System.out.println(menu[pos]);
        }
    }

    /**
     * Funció que encapsula un simple volcat d'informació per pantalla
     *
     * @param missatge Missatge a mostrar per pantalla
     */
    public static void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }
}
