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

    public static String decrypt(String text) {

        if(text == null || text.isEmpty()){
            System.out.println("Kein Wert uebergeben!");
        }

        String output = "";
        int index;
        int offset;
        ArrayList<String> outputArray = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < text.length(); j++) {
                index = range.indexOf(text.charAt(j));
                if((index + i) > 25) {
                    offset = index + i - 26;
                } else {
                    offset = index + i;
                }
                output = output.concat(String.valueOf(range.charAt(offset)));

            }
            outputArray.add(output);
            System.out.println(outputArray.get(i) + "\n");
            output = "";
        }
        return outputArray.toString();
    }
}
