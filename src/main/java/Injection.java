/**
 * SQL INJECTION
 * <p>
 * Kannst du mithilfe einer SQL INJECTION alle Daten abfragen ohne die Zugangsdaten zu kennen? :)
 * Wir wuerden die Daten naemlich für den PasswortValidator brauchen.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Injection {

    public static void main(String[] args) {
        safeLogIn("GepaRd", "bernd' or 1=1 --", "something");
        vulnerableLogIn("GepaRd", "bernd' or 1=1 --", "something");
    }

    public static Connection openConnection(String password) {
        // Connection con = null;
        // Verbindung zum PostgreSQL Server herstellen
        // Hier brauchen wir noch das Passwort, dass du bei der CaesarEncryption herausgefunden hast :)
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gepardec", "postgres", password);
            System.out.println("Erfolgreich mit dem PostgreSQL Server verbunden!");
        } catch (Exception e) {
            System.out.println("Verbindungsversuch fehlgeschlagen!");
            System.out.println(e.getMessage());
        }
        return con;
    }

    // Hier ist Platz fuer deine Injection ;)
    public static List<String> vulnerableLogIn(String sqlPassword, String username, String password) {
        Connection con = openConnection(sqlPassword);
        // So eine LogIn Query ist natürlich sehr anfällig für eine SQL-Injection
        String query = "SELECT * FROM useraccess where username='" + username + "' and password='" + password + "'";
        // Vermutlich könnte man diese Variante auch absichern mit etwas, wie:
        //String query = "SELECT * FROM useraccess where username='" + username.replace("'", "''") + "' and password='" + password.replace("'", "''") + "'";

        List<String> passwords = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Login erfolgreich!");

            while (rs.next()) {
                String user = rs.getString("username");
                String word = rs.getString("password");
                String salary = rs.getString("salary");
                System.out.println(user + "  " + word + "   " + salary);
                passwords.add(word);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return passwords;
    }

    // So wuerde wohl ein korrekter Loginprozess ausschauen
    public static void safeLogIn(String sqlPassword, String username, String password) {
        Connection con = openConnection(sqlPassword);
//        String username = "Philipp";
//        String password = "helloWorld";

        // LogIn Query auf diese Weise dürfte sicher vor Injection sein, zumindest konnte ich keine Möglichkeit finden.
        // ' wird durch '' ersetzt, somit kommt man über Injection aus dem String nicht heraus.
        String query = "SELECT * FROM useraccess where username=? and password = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            System.out.println("Login erfolgreich!");

            while (rs.next()) {
                String user = rs.getString("username");
                String word = rs.getString("password");
                String salary = rs.getString("salary");
                System.out.println(user + "  " + word + "   " + salary);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }
}
