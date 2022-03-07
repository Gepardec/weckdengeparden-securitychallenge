import java.util.ArrayList;

/** Leider haben wir den Schluessel für unsere Caesarverschluesselung verloren.
     *  Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
     *
     * Wir brauchen das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
     * Es muesste irgendetwas mit unserem Lieblingsraubtier sein ...
     *
     */

    class CaesarEncryption {


    static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static String rangeSmall = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        // Bitte hier dein Passwort, welches du bei der Reverse Engineering Challenge herausgefunden hast, einfuegen.
        String code = "PnyjA7m9";
        code = code.replaceAll("[0-9]","");

        System.out.println("Alle moeglichen Verschiebungen von " + code + ":\n");
        decrypt(code);
    }

    private static char cipherLowerCase(int c, int offset) {
        return rangeSmall.charAt((range.indexOf(c) + offset)%26);
    }

    public static String decrypt(String input)
    {
        String solution = input +  "      WHAAAAAT? bitte uebersetzen!!";

        for(int i = 1; i <= 26; i++) {
            final int n = i;

            input.chars().forEach((int c) -> {
                char sol;
                if(Character.isLowerCase(c)) {
                    sol = cipherLowerCase(c, n);
                } else {
                    sol = Character.toUpperCase(cipherLowerCase(Character.toLowerCase(c), n));
                }
                System.out.print(sol);
            });
            System.out.println();
        }

        System.out.println(solution);
        return solution;
    }
    
}
