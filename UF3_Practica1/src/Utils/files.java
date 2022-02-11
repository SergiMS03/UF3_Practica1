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
 * @author SergiMS03
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
    
    public static void FileReader(String adress) throws FileNotFoundException, IOException {
        declare_FR_BR(adress);
        String line = buffer.readLine();
        while (line != null) {
            System.out.println(line);
            line = buffer.readLine();
        }
        reader.close();
    }

        public static void FileLineReader(String adress, String message, String defaultResult) throws FileNotFoundException, IOException {
        int llegirLinea = utils.LlegirInt(message);
        declare_FR_BR(adress);
        String line = defaultResult;
        int currentLine = 1;
        do {
            if (currentLine == (llegirLinea)) {
                line = buffer.readLine();
            }
            currentLine++;
        } while (buffer.readLine() != null);
        System.out.println(line);
    }
    
    public static void FileWriter(String adress, String message, boolean dontOverwrite) throws IOException {
        declare_FW_PW(adress, dontOverwrite);
        pw.println(message);
        pw.flush();
        writer.close();
    }

    public static void IfNotExistCreateFile(final String adress) throws IOException {
        File f = new File(adress);
        if (!f.exists()) {
            f.createNewFile();
        }
    }


    
}
