package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Llibreria d'utilitats
 *
 * @author Sergi
 * @version 1.5
 *
 */
public class utils {
    private static Scanner scan = null;

    /**
     *
     * @return <h2>result torna amb un valor que s'ha llegit a través de
     * l'scanner</h2>
     */
    public static int LlegirInt() {
        int result;

        if (scan == null) {
            scan = new Scanner(System.in);
        }
        result = LlegirInt(scan);

        return result;
    }

    /**
     *
     * @param missatge
     * @return <h2>torna el nombre enter llegit per l'scanner</h2>
     */
    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null) {
            scan = new Scanner(System.in);
        }
        result = LlegirInt(scan, missatge);

        return result;
    }

    /**
     *
     * @param scan <h2>es el valor que hem introduit avants en missatge
     * (llegirInt)</h2>
     * @return
     */
    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }

    /**
     *
     * @param scan
     * @param missatge
     * @param valorMin
     * @param valorMax
     * @return
     */
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax) {
        int result = 0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);

        return result;
    }

    /**
     *
     * @param scan
     * @param missatge
     * @return
     */
    public static int LlegirInt(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        int result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextInt();
            if (dadesCorrectes) {
                result = scan.nextInt();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }

    public static int LlegirIntLimitat(String missatge, int limitMin, int limitMax) {
        Scanner scann = new Scanner(System.in);
        int result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextInt()) {
                result = scann.nextInt();
                if (result >= limitMin && result <= limitMax) {
                    correcte = true;
                }
            } else {
                scann.next();
            }
        }
        return result;
    }
    
    public static int LlegirIntLimitMinim(String missatge, int limitMin) {
        Scanner scann = new Scanner(System.in);
        int result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextInt()) {
                result = scann.nextInt();
                if (result >= limitMin) {
                    correcte = true;
                }
            } else {
                scann.next();
            }
        }
        return result;
    }
    
    public static int LlegirIntLimitMaxim(String missatge, int limitMax) {
        Scanner scann = new Scanner(System.in);
        int result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextInt()) {
                result = scann.nextInt();
                if (result <= limitMax) {
                    correcte = true;
                }
            } else {
                scann.next();
            }
        }
        return result;
    }

    public static double LlegirDouble(String missatge) {
        Scanner scann = new Scanner(System.in);
        double result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextDouble()) {
                result = scann.nextDouble();
                correcte = true;
            } else {
                scann.next();
            }
        }
        return result;
    }

    public static float LlegirFloat(String missatge) {
        Scanner scann = new Scanner(System.in);
        float result = 0;
        boolean correcte = false;
        while (!correcte) {
            System.out.print(missatge);
            if (scann.hasNextFloat()) {
                result = scann.nextFloat();
                correcte = true;
            } else {
                scann.next();
            }
        }
        return result;
    }
    
    public static String LlegirString(String missatge){
        String result;
        System.out.print(missatge);
        Scanner scann = new Scanner(System.in);
        result = scann.nextLine();
        return result;
    }
    
    public static void FileReader(String adreca) throws FileNotFoundException, IOException{
        File arxiu = new File(adreca);
        FileReader reader = new FileReader(arxiu);
        BufferedReader buffer = new BufferedReader(reader);
        
        String linea = buffer.readLine();
        while (linea != null){
            System.out.println(linea);
            linea = buffer.readLine();
        }
        reader.close();
    }
    
    //https://stackhowto.com/how-to-read-a-specific-line-from-a-text-file-in-java/
    
        public static void FileWriter(String adreca, String missatge, boolean sobreEscriure) throws IOException{
        File arxiu = new File(adreca);
        FileWriter writer= new FileWriter(arxiu, sobreEscriure);
        PrintWriter pw = new PrintWriter(writer);
        
        pw.println(missatge);
        pw.flush();
        writer.close();
    }
    
}