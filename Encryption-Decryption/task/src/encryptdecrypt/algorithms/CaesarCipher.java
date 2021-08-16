package encryptdecrypt.algorithms;

/**
 * Encryption-Decryption Class Using Caesar Cipher
 */

public class CaesarCipher {

    public static String perform(String line, int shift, String mode) {

        StringBuilder sb = new StringBuilder();

        int shiftPosition = 0;

        for (int i = 0; i < line.length(); i++) {

            String character = line.substring(i, i + 1);

            // 'a' = 97, 'z' = 122 (ASCII table)
            if (character.matches("[a-z]")) {

                if (mode.equals("enc")) {
                    shiftPosition = character.charAt(0) + shift;

                    if (shiftPosition > 122) {

                        shiftPosition = 97 + (shiftPosition - 122 - 1);

                    }

                } else if (mode.equals("dec")) {

                    shiftPosition = character.charAt(0) - shift;

                    if (shiftPosition < 97) {

                        shiftPosition = 122 - (97 - shiftPosition - 1);

                    }

                }

                sb.append((char) shiftPosition);

                // 'A' = 65, 'Z' = 90 (ASCII table)
            } else if (character.matches("[A-Z]")) {

                if (mode.equals("enc")) {

                    shiftPosition = character.charAt(0) + shift;

                    if (shiftPosition > 90) {

                        shiftPosition = 65 + (shiftPosition - 90 - 1);

                    }

                } else if (mode.equals("dec")) {
                    shiftPosition = character.charAt(0) - shift;

                    if (shiftPosition < 65) {

                        shiftPosition = 90 - (65 - shiftPosition - 1);

                    }
                }

                sb.append((char) shiftPosition);

            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }
}

