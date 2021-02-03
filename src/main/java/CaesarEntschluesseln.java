
    /* Leider haben wir den Schlüssel für unsere Caesarverschlüsselung verloren.
     *  Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
     *
     * Wir bräuchten das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
     * Es müsste irgendetwas mit unserem Lieblingsraubtier sein ...
     *
     *  */

    import java.util.ArrayList;

    class CaesarEntschluesseln {

    // TODO ether all english or all german
    static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        // TODO also in comments no special german chars (e.g. umlaute)
        // Bitte hier dein Passwort, welches du bei der Reverse Engineering Challenge herausgefunden hast, einfügen.
        String code = "PnyjA7m9";
        code = code.replaceAll("[0-9]","");

        System.out.println("Alle möglichen Verschiebungen von " + code + ":\n");
        entschluesseln(code);
    }

    public static String entschluesseln(String text)
    {
        // TODO log message if code is null/empty

        String ausgabe = "";
        int index;
        int verschiebung;
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
