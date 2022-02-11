/*
3. Amplia el programa anterior per tal que:
a) Mostri per pantalla tot el contingut del fitxer
b) Mostri per pantalla el contingut de la línia X, sent X un número que li
demanarem a l’usuari.
c) Inserti una línia al començament del fitxer
 */
package uf3_practica1;

import Utils.utils;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ausias
 */
public class Enunciat3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        final String ADRECA = "./exercici2.txt";
        File f = new File(ADRECA);
        if (!f.exists()) {
            f.createNewFile();
        }
        imprimirMenu();
        elegirOpc(ADRECA);

        utils.FileReader(ADRECA);
    }

    private static void imprimirMenu() {
        System.out.println("1- Mostrar contingut");
        System.out.println("2- Mostrar linea");
        System.out.println("3- Insertar contingut");
        System.out.println("4- Insertar contigut inici");
        System.out.println("Esculleix una opció: ");
    }

    private static void elegirOpc(String ADRECA) throws IOException {
        int opc = utils.LlegirInt();
        switch (opc) {
            case 1:
                utils.FileReader(ADRECA);
                break;
            case 2:
                llegirLinea(ADRECA);
                break;
            case 3:
                IntroduirContingut(ADRECA);
                break;
        }
    }

    static void IntroduirContingut(String ADRECA) throws IOException {
        String missatge = (" ");
        while (!missatge.equals("")) {
            missatge = utils.LlegirString("");
            utils.FileWriter(ADRECA, missatge, true);
            if (missatge.equals("@ESBORRA")) {
                utils.FileWriter(ADRECA, "", false);
            }
        }
    }

    private static void llegirLinea(String ADRECA) {
        
    }

}
