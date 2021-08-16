package encryptdecrypt;

import encryptdecrypt.algorithms.CaesarCipher;
import encryptdecrypt.algorithms.Unicode;

import java.io.*;
import java.nio.CharBuffer;

public class DataHandler {

    static String newMessage;

    public static String cipher(String message, int key, String mode, String alg) {

        if ("shift".equals(alg)) {
            return CaesarCipher.perform(message, key, mode);
        } else if ("unicode".equals(alg)) {
            return Unicode.perform(message, key, mode);
        } else {
           return "";
        }
    }

    // It gets data from command line and prints using standard output
    public static void handle(String mode, String message, int key, String alg) {

        newMessage = cipher(message, key, mode, alg);

        System.out.println(newMessage);

    }

    // It gets data from command line and saves to output file
    public static void handle(String mode, String message, File out, int key, String alg) {

        newMessage = cipher(message, key, mode, alg);

        try (FileWriter fileWriter = new FileWriter(out)) {

            fileWriter.write(newMessage);

        } catch (IOException e) {
            System.out.println("Error: something bad happened during writing to file "
                    + out.getAbsolutePath());
        }
    }

    // It gets data from input file and prints using standard output
    public static void handle(String mode, File in, int key, String alg) {

        String message = "";

        try (FileReader fileReader = new FileReader(in)) {

            fileReader.read(CharBuffer.wrap(message));

        } catch (IOException e) {
            System.out.println("Error: something bad happened during opening file "
                    + in.getAbsolutePath());
        }

        newMessage = cipher(message, key, mode, alg);

        System.out.println(newMessage);

    }

    // It gets data from input file and saves to output file
    public static void handle(String mode, File in, File out, int key, String alg) {

        String message = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(in))) {

            message = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("Error: something bad happened during opening file "
                    + in.getAbsolutePath());
        }

        newMessage = cipher(message, key, mode, alg);

        try (FileWriter fileWriter = new FileWriter(out)) {

            fileWriter.write(newMessage);

        } catch (IOException e) {
            System.out.println("Error: something bad happened during writing to file "
                    + out.getAbsolutePath());
        }

    }


}
