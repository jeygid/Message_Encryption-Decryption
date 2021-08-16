package encryptdecrypt.algorithms;

/**
 * Encryption-Decryption Class Using Standard Unicode Based Shift
 */

public class Unicode {

    public static String perform(String line, int shift, String mode) {

        StringBuilder sb = new StringBuilder();

        int shiftPosition = 0;

        for (int i = 0; i < line.length(); i++) {

            String character = line.substring(i, i + 1);

            if (mode.equals("enc")) {
                shiftPosition = character.charAt(0) + shift;
            } else if (mode.equals("dec")) {
                shiftPosition = character.charAt(0) - shift;
            }

            sb.append((char) shiftPosition);

        }

        System.out.println(sb);

        return sb.toString();

    }


}

