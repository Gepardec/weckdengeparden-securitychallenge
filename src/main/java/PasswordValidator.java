/**
 * Wie du gesehen hast entsprechen die Passwoerter in der Datenbank keinerlei Richtlinien.
 * Kannst du uns helfen einen Validator zu schreiben der Passwoerter auf folgende Eigenschaften prueft?
 * <p>
 * Minimale Laenge: 5
 * Maximale Laenge: 10
 * Enthaelt zumindest EINE Zahl
 * Enthaelt zumindest EIN Sonderzeichen (&, +, @, $, #, %, etc.)
 * Enthaelt KEINE Leerzeichen
 * <p>
 * In der Datenbank liegt genau EIN Passwort, dass den Richtlinien entspricht.
 * Hast du es entdeckt? Sehr gut, denn dieses Passwort brauchst für deine letzte Challenge, den HashGenerator!
 */

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Please enter a password or nothing to stop: ");
            input = scanner.nextLine();
            if (input.isEmpty()) break;
            System.out.println(validatePassword(input) ? "Valid" : "Invalid");
        }
    }

    public static boolean validatePassword(String password) {
        if (password.contains(" ")) return false;
        return (password.matches("^(?=.*?[A-Za-z])(?=.*?\\d)(?=.*?[^\\dA-Za-z]).{5,10}$"));
    }
}
