    /** Leider haben wir den Schluessel für unsere Caesarverschluesselung verloren.
     *  Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
     *
     * Wir brauchen das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
     * Es muesste irgendetwas mit unserem Lieblingsraubtier sein ...
     *
     */

    import java.util.ArrayList;
    import java.util.List;

    class CaesarEncryption {


    static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        // Bitte hier dein Passwort, welches du bei der Reverse Engineering Challenge herausgefunden hast, einfuegen.
        String code = "PnyjA7m9";
        code = code.replaceAll("[0-9]","");

        System.out.println("Alle moeglichen Verschiebungen von " + code + ":\n");
        decrypt(code);
    }

    public static String decrypt(String input)
    {
        String solution = input +  "      WHAAAAAT? bitte uebersetzen!!";
        System.out.println(solution);
        List<String> results = new ArrayList<>(27);
        String code = input;
        for (int i = 0; i < 26; i++) {
            StringBuilder shifted = new StringBuilder();
            for (char c : code.toCharArray()) {
                c++;
                if (c > 'Z' && c < 'a') c = 'A';
                else if (c > 'z') c = 'a';
                shifted.append(c);
            }
            results.add(code = shifted.toString());
        }
        solution = String.join("\n", results);
        System.out.println(solution);
        return solution;
    }
}
