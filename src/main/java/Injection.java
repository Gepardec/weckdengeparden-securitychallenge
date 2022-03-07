/**
 *  SQL INJECTION
 *
 * Kannst du mithilfe einer SQL INJECTION alle Daten abfragen ohne die Zugangsdaten zu kennen? :)
 * Wir wuerden die Daten naemlich für den PasswortValidator brauchen.
 *
 */

import java.lang.Thread.State;
import java.sql.*;

public class Injection {

    public static void main(String[] args) {

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
                String user = result.getString("username");
                String word = result.getString("password");
                String salary = result.getString("salary");
                System.out.println(user +"  "+word+ "   "+salary);
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


        // So wuerde wohl ein korrekter Loginprozess ausschauen
        String username = "Philipp";
        String password = "helloWorld";
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
                System.out.println(user +"  "+word+ "   "+salary);
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
