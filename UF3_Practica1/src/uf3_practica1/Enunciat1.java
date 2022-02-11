/*
Crea un programa que llegeixi frases per teclat i les vagi guardant en un fitxer
“textos.txt”. El programa finalitzarà quan s’entri una cadena buida.
 */
package uf3_practica1;

import Utils.utils;
import java.io.IOException;

/**
 *
 * @author ausias
 */
public class Enunciat1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String missatge = (" ");
        while (!missatge.equals("")) {
            missatge = utils.LlegirString("");
            utils.FileWriter("./textos.txt", missatge, true);
        }
    }

}
