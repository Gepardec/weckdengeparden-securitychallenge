/**
 * Hier werden alle Challenges der Reihe nach automatisch gelöst und die jeweilige Lösung für die nächste Challenge verwendet
 * Jede Klasse hat aber auch weiterhin eine eigene main Methode, um die Challenges auch wie vorgesehen auszuführen.
 */

import java.util.Arrays;
import java.util.List;

public class Solver {

    // Einstiegspunkt, um die Lösung aller Challenges zu starten:
    public static void main(String[] args) {
        String hashedPassword = solve();
        System.out.println("\n--- FINAL RESULT ---");
        System.out.println(hashedPassword);
    }

    // Die eigentliche solve-Methode, welche am Ende das gehashte Passwort zurück gibt
    public static String solve() {
        System.out.println("-- Challenge 1 - Website.html:");
        String pw1 = solveWebsite();
        System.out.println(pw1);

        System.out.println("-- Challenge 2 - ReverseEngineering:");
        String pw2 = solveReverseEngineering(pw1);
        System.out.println(ReverseEngineering.inputCheck(pw2));

        System.out.println("-- Challenge 3 - CaesarEncryption:");
        String sqlPassword = solveCaesarEncryption(pw2);
        System.out.println("Caesar result: " + sqlPassword);

        System.out.println("-- Challenge 4 - Injection:");
        List<String> allPasswords = solveInjection(sqlPassword);

        System.out.println("-- Challenge 5 - PasswordValidator:");
        String validatedPassword = solvePasswordValidator(allPasswords);
        System.out.println(validatedPassword);

        System.out.println("-- Challenge 6 - HashGenerator:");
        String hashedPassword = HashGenerator.getHash(validatedPassword);
        System.out.println(hashedPassword);
        return hashedPassword;
    }

    // Gekürzt auf das wesentliche
    public static String solveShort() {
        return solveHashGenerator(
                solvePasswordValidator(
                        solveInjection(
                                solveCaesarEncryption(
                                        solveReverseEngineering(
                                                solveWebsite())))));
    }

    public static String solveWebsite() {
        int maxLength = 30;
        StringBuilder password = new StringBuilder(" ".repeat(maxLength));
        // if (passw.substring(0, 4) == '0x50')
        password.replace(0, 4, "0x50");
        // if (passw.substring(2*9, 4*5+2) == '0x6d')
        password.replace(2 * 9, 4 * 5 + 2, "0x6d");
        // if (passw.substring(4, 4+1) == 'n')
        password.replace(4, 4 + 1, "n");
        // if (passw.substring(4*3+1, 4*4+1) == '0x41')
        password.replace(4 * 3 + 1, 4 * 4 + 1, "0x41");
        // if (passw.substring(9, 4*3+1) == '0x6a')
        password.replace(9, 4 * 3 + 1, "0x6a");
        // if (passw.substring(4*4+1, 2*9) == '7')
        password.replace(4 * 4 + 1, 2 * 9, "7");
        // if (passw.substring(4+1, 9) == '0x79')
        password.replace(4 + 1, 9, "0x79");
        // if (passw.substring(4*5+2, 4*5+3) == '9')
        password.replace(4 * 5 + 2, 4 * 5 + 3, "9");
        return password.toString().trim();
    }

    public static String solveReverseEngineering(String password) {
        // Würde auch funktionieren, ist IMHO aber unnötig kryptisch ;)
//                return Arrays.stream(byteString.replace("'", "").split(", "))
//                .map(Solver::stringToByte)
//                .collect(ByteArrayOutputStream::new, ByteArrayOutputStream::write,
//                        (baos1, baos2) -> baos1.write(baos2.toByteArray(), 0, baos2.size())).toString();

        String byteString = ReverseEngineering.getByteString(password);
        String[] byteStrings = byteString.replace("'", "").split(", ");
        byte[] encoded = new byte[byteStrings.length];
        for (int i = 0; i < byteStrings.length; i++) {
            encoded[i] = stringToByte(byteStrings[i]);
        }
        return new String(encoded);
    }

    // Helper function for ReverseEngineering
    private static byte stringToByte(String value) {
        if (value.length() == 1) {
            return (byte) value.charAt(0);
        }
        return Byte.decode(value);
    }

    public static String solveCaesarEncryption(String password) {
        return Arrays.stream(CaesarEncryption.decrypt(password.replaceAll("\\d", "")).split("\n"))
                .filter(word -> "gepardec".contains(word.toLowerCase()))
                .findFirst()
                .orElse("not found");
    }

    public static String solvePasswordValidator(List<String> passwords) {
        return passwords.stream()
                .filter(PasswordValidator::validatePassword)
                .findFirst()
                .orElse("not found");
    }

    public static List<String> solveInjection(String password) {
        return Injection.vulnerableLogIn(password, "Name' OR 1=1 --", "something");
    }

    public static String solveHashGenerator(String password) {
        return HashGenerator.getHash(password);
    }
}
