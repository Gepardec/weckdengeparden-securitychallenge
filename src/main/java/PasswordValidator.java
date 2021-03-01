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


  public static void main(String[] args) {
    String[] pw = {
      "helloWorld",
      "W#2FfkaeiE",
      "password",
      "TestTest1",
      "safePassword",
      "dockerContainer",
      "java4life",
      "3JdweKK",
      "3hello33",
      "invalid353",
      "dts4l",
      "fdjiefJJ"
    };

    for(int i=0; i < pw.length; i++) {
      if (validatePassword(pw[i])) {
        System.out.println(pw[i]);
      }
    }

  }



  public static boolean validatePassword(String pw) {
    /*if (pw.length() < 5 || pw.length() > 10) {
      return false;
    }*/

    // Länge 5 - 10
    // Mindestens EINE Zahl
    // Mindestens EIN Sonderzeichen -_&+@$#%
    // KEINE Leerzeichen
    if (!pw.matches("^(?=.*[\\-_&+@$#%])(?=.*\\d)[A-Za-z\\d\\-_&+@$#%]{5,10}$")) {
      return false;
    }
    
    return true;
  }



}
