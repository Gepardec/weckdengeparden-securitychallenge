import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> passwords = getPasswords();

        List<String> conformPasswords = 
            passwords.stream().filter(p -> p.length() >= 5 && p.length() <= 10)
                .filter(p -> p.matches("[^ ]*[0-9]+[^ ]*"))
                .filter(p -> p.matches("[^ ]*[^0-9a-zA-z ]+[^ ]*"))
                .collect(Collectors.toList());

        for(String pw : conformPasswords) {
            System.out.println(pw);
        }
    }

    private static List<String> getPasswords() {
        List<String> passwords = new ArrayList<String>();
        Connection con=null;
        // Verbindung zum PostgreSQL Server herstellen
        // Hier brauchen wir noch das Passwort, dass du bei der CaesarEncryption herausgefunden hast :)
        try {
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/gepardec","postgres","GepaRd");
            System.out.println("Erfolgreich mit dem PostgreSQL Server verbunden!");
        }catch (Exception e){
            System.out.println("Verbindungsversuch fehlgeschlagen!");
            System.out.println(e.getMessage());
        }

        // Hier ist Platz fuer deine Injection ;)
        String sql = "select * from useraccess where username = 'any' or '1' = '1' and password = 'any' or '1' = '1'";
        Statement statement = null;

        try {
            statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                passwords.add(result.getString("password"));
            }
            result.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (Exception e) {
            }
        }


        return passwords;
    }
}
