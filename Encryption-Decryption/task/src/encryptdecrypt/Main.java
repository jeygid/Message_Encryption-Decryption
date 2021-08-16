package encryptdecrypt;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int key = 0;
        String mode = "enc";
        String data = "";
        String in = "";
        String out = "";
        String alg = "shift";


        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                data = args[i + 1];
            }
            if (args[i].equals("-in")) {
                in = args[i + 1];
            }
            if (args[i].equals("-out")) {
                out = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }

            // Condition implements case, when both parameters <data> and <in> are active
        if (!data.equals("") && !in.equals("") && !out.equals("")) {
            DataHandler.handle(mode, data, key, alg);

            // It takes <data> and prints message on the screen
        } else if (!data.equals("") && in.equals("") && out.equals("")) {

            DataHandler.handle(mode, data, key, alg);

            // It gets <data> and saves message to <out> file
        } else if (!data.equals("") && !out.equals("")) {

            File outFile = new File(out);
            DataHandler.handle(mode, data, outFile, key, alg);

            // It takes data from <in> file and prints message on the screen
        } else if (data.equals("") && !in.equals("") && out.equals("")) {

            File inFile = new File(in);
            DataHandler.handle(mode, inFile, key, alg);

            // It gets data from <in> file and saves message to <out> file
        } else if (data.equals("") && !in.equals(" ") && !out.equals("")) {

            File inFile = new File(in);
            File outFile = new File(out);

            try {
                outFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Error: creating file error!");
            }

            DataHandler.handle(mode, inFile, outFile, key, alg);
        }


    }
}
