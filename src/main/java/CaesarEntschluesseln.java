
    /* Leider haben wir den Schlüssel für unsere Caesarverschlüsselung verloren.
     *  Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
     *
     * Wir bräuchten das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
     * Es müsste irgendetwas mit unserem Lieblingsraubtier sein ...
     *
     *  */

    import java.util.ArrayList;

    class CaesarEntschluesseln {


    static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        // Bitte hier dein Passwort, welches du bei der Reverse Engineering Challenge herausgefunden hast, einfügen.
        String code = ""; //TODO hier fehlt das Passwort aus der vorigen Aufgabe
        code = code.replaceAll("[0-9]","");

        System.out.println("Alle möglichen Verschiebungen von " + code + ":\n");
        entschluesseln(code);
    }

    public static String entschluesseln(String text)
    {
        String ausgabe = "";
        int index = 0;
        int verschiebung = 0;
        ArrayList<String> ausgabeArray = new ArrayList<String>();

        for(int i = 0; i < 26; i++)
        {
            for(int j = 0; j < text.length(); j++)
            {
                index = range.indexOf(text.charAt(j));
                if((index + i) > 25)
                {
                    verschiebung = index + i - 26;
                } else {
                    verschiebung = index + i;
                }
                ausgabe = ausgabe.concat(String.valueOf(range.charAt(verschiebung)));

            }
            ausgabeArray.add(ausgabe);
            System.out.println(ausgabeArray.get(i) + "\n");
            ausgabe = "";
        }
        return ausgabeArray.toString();
    }
}
