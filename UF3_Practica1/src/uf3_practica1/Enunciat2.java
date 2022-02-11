/*
2. Amplia el programa anterior per tal que:
a) Si el fitxer no existeix, que el generi.
b) Si el fitxer ja existeix, que afegeixi el contingut al final.
c) Si l’usuari escriu @ESBORRA, cal esborrar el contingut del fitxer.
 */
package uf3_practica1;

import Utils.utils;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ausias
 */
public class Enunciat2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File f= new File("./exercici2.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        String missatge = (" ");
        while (!missatge.equals("")) {
            missatge = utils.LlegirString("");
            utils.FileWriter("./exercici2.txt", missatge, true);
            if(missatge.equals("@ESBORRA")){
                utils.FileWriter("./exercici2.txt", "", false);
            }
        }
    }
    
}
