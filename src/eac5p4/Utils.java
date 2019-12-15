/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eac5p4;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class Utils {

    /**
     * Utilitzat pel programa principal per tal de capturar per teclat un número
     * que serà retornat al codi que li ha realitzat la crida.
     *
     * @param missatge Conté el text que es mostrarà per sol·licitar per
     * pantalla la introducció del número.
     * @param missatgeError Conté el text que es mostrarà a l'usuari en cas que
     * introdueixi un número buid o incorrecte
     * @return Valor enter que simbolitza el número que s'ha introduït per
     * teclat
     */
    public static int demanarEnter(String missatge, String missatgeError) {
        Scanner scanner = new Scanner(System.in);
        int ret;
        boolean correcte;
        do {
            System.out.println(missatge);
            correcte = scanner.hasNextInt();
            if (!correcte) {
                scanner.next();
                System.out.println(missatgeError);
            }
        } while (!correcte);
        ret = scanner.nextInt();
        scanner.nextLine();
        return ret;
    }

    /**
     * Demana per pantalla la introducció d'un text que es retornat al codi que
     * en fa la crida.
     *
     * @param missatge Conté el missatge que es mostrarà a l'usuari abans de que
     * aquest introdueixi el text.
     * @param missatgeError Conté el missatge que es mostrarà a l'usuari en cas
     * que aquest introdueixi una String buida
     * @return El text introduït
     */
    public static String demanarString(String missatge, String missatgeError) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        String textIntroduit = scanner.nextLine();
        while (textIntroduit.isEmpty()) {
            System.out.println(missatgeError);
            System.out.println(missatge);
            textIntroduit = scanner.nextLine();
        }
        return textIntroduit;
    }

    /**
     * Demana per pantalla la introducció d'un caràcter que es retornat al codi
     * que en fa la crida
     *
     * @param missatge Conté el missatge que es mostrarà a l'usuari abans de que
     * aquest introdueixi el text
     * @param missatgeError Conté el missatge que es mostrarà a l'usuari en cas
     * que aquest introdueixi un text buid
     * @return El caràcter introduït
     */
    public static char demanarChar(String missatge, String missatgeError) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        String textIntroduit = scanner.nextLine();
        while (textIntroduit.isEmpty() || textIntroduit.length() != 1) {
            System.out.println(missatgeError);
            System.out.println(missatge);
            textIntroduit = scanner.nextLine();
        }
        return textIntroduit.charAt(0);
    }

    public static String demanarPartits(String missatge, String missatgeError) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(missatge + "\n");
        String partit = scanner.nextLine();
        while (partit.isEmpty()) {
            System.out.println(missatgeError);
            System.out.print(missatge);
            partit = scanner.nextLine();
        }
        boolean error;
        do {
            error = false;
            for (int i = 0; i < partit.length(); i++) {
                char caracter = partit.charAt(i);
                if (caracter != 'A' && caracter != 'B') {
                    error = true;
                    break;
                }
            }
            if (error == true) {
                System.out.println(missatgeError);
                System.out.print(missatge);
                partit = scanner.nextLine();
            }
        } while (error == true);
        return partit;
    }
}
