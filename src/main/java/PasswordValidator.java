import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    * Wie du gesehen hast entsprechen die Passwoerter in der Datenbank keinerlei Richtlinien.
    * Kannst du uns helfen einen Validator zu schreiben der Passwoerter auf folgende Eigenschaften prueft?
    *
    * Minimale Laenge: 5
    * Maximale Laenge: 10
    * Enthaelt zumindest EINE Zahl
    * Enthaelt zumindest EIN Sonderzeichen (&, +, @, $, #, %, etc.)
    * Enthaelt KEINE Leerzeichen
    *
    * In der Datenbank liegt genau EIN Passwort, dass den Richtlinien entspricht.
    * Hast du es entdeckt? Sehr gut, denn dieses Passwort brauchst für deine letzte Challenge, den HashGenerator!
    *
    */

public class PasswordValidator {

    public PasswordValidator() {
    }

    public boolean passwordIsValid(String password)  {
        String passwordRegex = "(?=.*\\d)(?=.*[\\W_])[^\\s]{5,10}";
        Pattern pattern = Pattern.compile(passwordRegex);
           Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("Please enter password:");
        Scanner inputScanner = new Scanner(System.in);
        String password = inputScanner.nextLine();
        PasswordValidator validator = new PasswordValidator();
        if(validator.passwordIsValid(password)){
            System.out.println("Password \"" + password + "\" is valid");
        }else {
            System.out.println("Password \"" + password + "\" is invalid");
        }
    }

}
