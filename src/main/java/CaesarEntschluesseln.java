
    /* Leider haben wir den Schlüssel für unsere Caesarverschlüsselung verloren.
     *  Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
     *
     * Wir bräuchten das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
     * Es müsste irgendetwas mit unserem Lieblingsraubtier sein ...
     *
     *  */

class CaesarEntschluesseln {


    static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        // Bitte hier dein Passwort, welches du bei der HTML-Website herausgefunden hast, einfügen.
        String code = "QbanHqnzCsFpuvssnuEGFtrFryyFpunsGFxnCvGnrA";

        System.out.println("Alle möglichen Verschiebungen von " + code + ":\n");
        entschluesseln(code);
    }

    public static String entschluesseln(String text)
    {
        String loesungswort = text +  "      WHAAAAAT? bitte übersetzen!!";
        System.out.println(loesungswort);
        return loesungswort;
    }
}
