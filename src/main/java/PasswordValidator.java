   /*
    * Wie du gesehen hast entsprechen die Passwörter in der Datenbank keinerlei Richtlinien.
    * Kannst du uns helfen einen Validator zu schreiben der Passwörter auf folgende Eigenschaften prüft?
    *
    * Minimale Länge: 5
    * Maximale Länge: 10
    * Enthält zumindest EINE Zahl
    * Enthält zumindest EIN Sonderzeichen (&, +, @, $, #, %, etc.)
    * Enthält KEINE Leerzeichen
    *
    * In der Datenbank liegt genau EIN Passwort, dass den Richtlinien entspricht.
    * Hast du es entdeckt? Sehr gut, denn dieses Passwort brauchst für deine letzte Challenge, den HashGenerator!
    *
    * */

   import java.util.Scanner;

   public class PasswordValidator {

    public static void main(String[] args) {
        int min = 5;
        int max = 10;
        System.out.println("Passwort prüfen");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();

        System.out.println("Your password: " + password);

        int length = password.length();

        //Länge zwischen 5 und 10

        if(length < min || length > max){

            System.out.println("not a valid password");
        }

        char c;
        //Anzahl Nummern und Spezialzeichen
        int[] counter = {0,0};

        for(int i = 0; i < length; i++){

            c = password.charAt(i);

            if(Character.isWhitespace(c) == true){

                System.out.println("not a valid password");
                System.exit(0);
            }

            if(Character.isDigit(c) == true){

                counter[0]++;
            }

            //ASCII

            if((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 127)){

                counter[1]++;
            }
        }

        //Min eine Nummer und einen Spezialcharakter

        if(counter[0] == 0 || counter[1] == 0){

            System.out.println("not a valid password");

        }else{

            System.out.println("valid password");
        }
    }



}
