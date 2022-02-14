/*
3. Amplia el programa anterior per tal que:
a) Mostri per pantalla tot el contingut del fitxer
b) Mostri per pantalla el contingut de la línia X, sent X un número que li
demanarem a l’usuari.
c) Inserti una línia al començament del fitxer
 */
package uf3_practica1;

import Utils.files;
import Utils.utils;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Sergi i Mario
 */
public class Enunciat3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        final String ADRECA = "./exercici2.txt";
        files.IfNotExistCreateFile(ADRECA);
        int opc;
        do {
            imprimirMenu();
            opc = elegirOpc(ADRECA);
        } while (opc != 0);
        System.out.println("Abandonant programa...");
    }

    private static void imprimirMenu() {
        System.out.println("1- Mostrar contingut");
        System.out.println("2- Mostrar linea");
        System.out.println("3- Insertar contingut");
        System.out.println("4- Insertar contigut inici");
    }

    private static int elegirOpc(String ADRECA) throws IOException {
        int opc = utils.LlegirIntLimitat("Esculleix una opció: ", 0, 4);
        switch (opc) {
            case 1:
                files.FileReader(ADRECA);
                break;
            case 2:
                files.FileLineReader(ADRECA, "Quina linea del fitxer vols llegir? ", "No ha sigut posible trobar la linea indicada :(");
                break;
            case 3:
                IntroduirContingut(ADRECA);
                break;
            case 4:
                InsertarLineaInici(ADRECA);
                break;
        }
        return opc;
    }

    static void IntroduirContingut(String ADRECA) throws IOException {
        String missatge = (" ");
        while (!missatge.equals("")) {
            missatge = utils.LlegirString("");
            files.FileWriter(ADRECA, missatge, true);
            if (missatge.equals("@ESBORRA")) {
                files.FileWriter(ADRECA, "", false);
            }
        }
    }

    private static void InsertarLineaInici(String ADRECA) throws IOException {
        final String ADRECA_AUX = "./aux.txt";
        File f = new File(ADRECA_AUX);
        FileReader reader = new FileReader(ADRECA);
        BufferedReader buffer = new BufferedReader(reader);
        String missatge = utils.LlegirString("");
        files.FileWriter(ADRECA_AUX, missatge, false);
        Copiar_texto(buffer, ADRECA_AUX);
        Renombrar(ADRECA, f);
    }

    static void Renombrar(String ADRECA, File f) {
        File EXERCICI_3 = new File(ADRECA);
        f.renameTo(EXERCICI_3);
    }

    static void Copiar_texto(BufferedReader buffer, final String ADRECA_AUX) throws IOException {
        String linea = ("");
        while (linea != null) {
            linea = buffer.readLine();
            if (linea != null) {
                files.FileWriter(ADRECA_AUX, linea, true);
            }
        }
    }
}
