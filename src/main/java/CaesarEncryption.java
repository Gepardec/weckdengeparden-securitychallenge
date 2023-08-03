/**
 * Leider haben wir den Schluessel für unsere Caesarverschluesselung verloren.
 * Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
 * <p>
 * Wir brauchen das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
 * Es muesste irgendetwas mit unserem Lieblingsraubtier sein ...
 */

class CaesarEncryption {


    static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static int offset = 1;


    public static void main(String[] args) {

        // Bitte hier dein Passwort, welches du bei der Reverse Engineering Challenge herausgefunden hast, einfuegen.
        String code = "PnyjA7m9";
        code = code.replaceAll("[0-9]", "");

        System.out.println("Alle moeglichen Verschiebungen von " + code + ":\n");
        decrypt(code);
    }

    public static void decrypt(String input) {
        StringBuilder decryption = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            decryption.append(decode(input)).append("\n");
            offset++;
        }
        String solution = decryption.toString();
        System.out.println(solution);
    }


    public static char decode(char c) {
        int x;
        if (c >= 'A' && c <= 'Z') {
            x = c;
            x -= 'A';
            x += offset;
            while (x >= 26) {
                x -= 26;
            }
            while (x < 0) {
                x += 26;
            }
            x += 'A';
            c = (char) x;

        } else if (c >= 'a' && c <= 'z') {
            x = c;
            x -= 'a';
            x += offset;
            while (x >= 26) {
                x -= 26;
            }
            while (x < 0) {
                x += 26;
            }
            x += 'a';
            c = (char) x;
        }
        return c;
    }

    public static String decode(String str) {
        StringBuilder text = new StringBuilder(str);
        for (int index = 0; index < text.length(); index++) {
            char c = text.charAt(index);
            c = decode(c);
            text.setCharAt(index, c);
        }
        return text.toString();
    }
}
