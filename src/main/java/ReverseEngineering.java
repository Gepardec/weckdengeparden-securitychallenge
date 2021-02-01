/* Finde das Passwort dieser Challenge heraus.
 * Du kannst natürlich den Code nach belieben ändern.
 * Bevor du mit der Challenge beginnst, musst du das Passwort der Website Challenge in die "passwd" Variable einfügen und den generierten Code in die "encoded" Variable.
 * */

import java.util.Scanner;

public class ReverseEngineering {
    public static void main(String args[])
    {
        String input;
        String passwd = ""; //Bitte hier das Passwort der Website einfügen und das Programm ausführen.


        System.out.println("Bitte kopiere folgenden Code in die Klammern der encoded Variable, dann kannst du auch schon loslegen:\n"+passwd.substring(0,4)+", '"+passwd.substring(4,5)+"', "+passwd.substring(5,9)+", "+passwd.substring(9,13)+", "+passwd.substring(13,17)+", '"+passwd.substring(17,18)+"', "+passwd.substring(18,22)+", '"+passwd.substring(22,23)+"'");
        System.out.println("Password:");
        Scanner scanner = new Scanner(System.in);
        input = scanner.next();

        if(inputCheck(input))
        {
            System.out.println("\nGlückwunsch das war das korrekte Passwort ;)");
            System.out.println("Du hast diese Challenge geschafft.\nDas Passwort benötigst du für die Caesar Entschlüsselung");
        }else
        {
            System.out.println("Das Passwort war nicht korrekt.");
        }
    }

    public static boolean inputCheck(String input)
    {
        byte[] encoded = {
                // Füge hier das konvertierte Passwort von der Konsolenausgabe ein.
                // (Achtung bitte exakt eingeben, auch die Hochkomma und die Beistriche)
        };

        for (int i=0; i<encoded.length; i++)
        {
            if (input.getBytes()[i] != encoded[i])
            {
                return false;
            }

        }
        return true;
    }
}
