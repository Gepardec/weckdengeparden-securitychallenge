import java.sql.*;

public class Injection {

    /*TO DO
     * 1) Installation Docker
     * 2) docker-init.cmd aufrufen
     * */

    public static void main(String[] args) {

        Connection con=null;
        // Verbindung zum PostgreSQL Server herstellen
        try {
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/gepardec","postgres","dbpw");
            System.out.println("Connected to the PostgreSQL server successfully.");
        }catch (Exception e){
            System.out.println("Failed to connect!");
            System.out.println(e.getMessage());
        }

        /*
         * SQL INJECTION
         *
         * Kannst du mithilfe einer SQL INJECTION alle Daten abfragen ohne die Zugangsdaten zu kennen? :)
         *
         * */

        // So würde ein korrekter Zugriff ausschauen
        String username = "Philipp";
        String password = "helloWorld";
        String query = "SELECT * FROM useraccess where username=? and password = ?";

        PreparedStatement stmt = null;
        boolean success =false;
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            System.out.println("Login erfolgreich!");

            while (rs.next()) {
                success = true;
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
