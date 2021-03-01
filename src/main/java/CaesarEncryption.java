    /** Leider haben wir den Schluessel für unsere Caesarverschluesselung verloren.
     *  Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
     *
     * Wir brauchen das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
     * Es muesste irgendetwas mit unserem Lieblingsraubtier sein ...
     *
     */

    import java.util.ArrayList;

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
        String solution = "";

        for (int i=1; i <= 26; i++) {
          solution = caesarShift(input, i);
          System.out.println(solution);
        }


        return solution;
    }

    public static String caesarShift(String input, int shift)
    {
      String output = "";
      for (int i=0; i < input.length(); i++) {
        int new_index = (range.indexOf(input.charAt(i)) - shift + range.length()) % range.length();
        output += range.charAt(new_index);
      }
      return output;
    }
}
