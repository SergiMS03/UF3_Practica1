/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author CASA
 */
public class files {

    static FileReader reader;
    static BufferedReader buffer;
    static FileWriter writer;
    static PrintWriter pw;
    
    private static void declare_FR_BR(String adress) throws FileNotFoundException{
        reader = new FileReader(adress);
        buffer = new BufferedReader(reader);
    }
    
    private static void declare_FW_PW(String adress, boolean dontOverwrite) throws FileNotFoundException, IOException{
        writer = new FileWriter(adress, dontOverwrite);
        pw = new PrintWriter(writer);
    }
    
    public static void FileReader(String adreca) throws FileNotFoundException, IOException {
        declare_FR_BR(adreca);
        String linea = buffer.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = buffer.readLine();
        }
        reader.close();
    }

        public static void FileLineReader(String adreca, String missatge) throws FileNotFoundException, IOException {
        int llegirLinea = utils.LlegirInt(missatge);
        declare_FR_BR(adreca);
        String line = "No s'ha trobat la linea que s'indica...";
        int lineaActual = 1;
        do {
            if (lineaActual == (llegirLinea)) {
                line = buffer.readLine();
            }
            lineaActual++;
        } while (buffer.readLine() != null);
        System.out.println(line);
    }
    
    public static void FileWriter(String adreca, String missatge, boolean sobreEscriure) throws IOException {
        declare_FW_PW(adreca, sobreEscriure);
        pw.println(missatge);
        pw.flush();
        writer.close();
    }

    public static void IfNotExistCreateFile(final String ADRECA) throws IOException {
        File f = new File(ADRECA);
        if (!f.exists()) {
            f.createNewFile();
        }
    }


    
}
