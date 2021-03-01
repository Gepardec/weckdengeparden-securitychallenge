/** Finde das Passwort dieser Challenge heraus.
 * Du kannst natuerlich den Code nach belieben aendern.
 * Bevor du mit der Challenge beginnst, musst du das Passwort der Website Challenge in die "passwd" Variable einfügen und den generierten Code in die "encoded" Variable.
 */

import java.util.Scanner;

public class ReverseEngineering {

    public static void main(String args[]) {
        String input;
        String passwd = "0x50n0x790x6a0x4170x6d9"; //Bitte hier das Passwort der Website einfuegen und das Programm ausfuehren.

        System.out.println("Bitte kopiere folgenden Code in die Klammern der encoded Variable, dann kannst du auch schon loslegen:\n"+passwd.substring(0,4)+", '"+passwd.substring(4,5)+"', "+passwd.substring(5,9)+", "+passwd.substring(9,13)+", "+passwd.substring(13,17)+", '"+passwd.substring(17,18)+"', "+passwd.substring(18,22)+", '"+passwd.substring(22,23)+"'");
        System.out.println("Password:");
        Scanner scanner = new Scanner(System.in);
        input = scanner.next();

        if ( inputCheck(input) ) {
            System.out.println("\nGlueckwunsch das war das korrekte Passwort ;)");
            System.out.println("Du hast diese Challenge geschafft.\nDas Passwort benoetigst du fuer die CaesarEncryption");
        } else {
            System.out.println("Das Passwort war nicht korrekt.");
        }
    }

    public static boolean inputCheck(String input) {
        byte[] encoded = {
                // Fuege hier das konvertierte Passwort von der Konsolenausgabe ein.
                // (Achtung bitte exakt eingeben, auch die Hochkomma und die Beistriche)
                0x50, 'n', 0x79, 0x6a, 0x41, '7', 0x6d, '9'
        };

        for (int i=0; i<encoded.length; i++) {
            if (input.getBytes()[i] != encoded[i]) {
                return false;
            }
        }
        return true;
    }
}
