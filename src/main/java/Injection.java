import java.sql.*;

/*SET UP

* 1) Docker installieren: https://www.docker.com/get-started
* 2) docker-compose up -d im Directory install aufrufen
*
* */

public class Injection {

    public static void main(String[] args) {

        Connection con=null;
        // Verbindung zum PostgreSQL Server herstellen
        // Hier bräuchten wir noch das Passwort, dass du bei der Caesarverschlüsselung herausgefunden hast :)
        try {
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/gepardec","postgres","GepaRd");
            System.out.println("Connected to the PostgreSQL server successfully.");
        }catch (Exception e){
            System.out.println("Failed to connect!");
            System.out.println(e.getMessage());
        }

        /*
         * SQL INJECTION
         *
         * Kannst du mithilfe einer SQL INJECTION alle Daten abfragen ohne die Zugangsdaten zu kennen? :)
         * Wir würden die Daten nämlich für den PasswortValidator brauchen.
         *
         * */
        try {
            String sql = "SELECT * FROM useraccess WHERE username ='admin' OR '1'='1'-- ' AND password = 'whatever'";
            Statement statement = null;
            statement = con.createStatement();

            ResultSet rsa = statement.executeQuery(sql);

            System.out.println("SQL Injection erfolgreich!");

            while (rsa.next()) {
                String user = rsa.getString("username");
                String word = rsa.getString("password");
                String salary = rsa.getString("salary");
                System.out.println(user + "  " + word+ "   "+salary);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        // So würde wohl ein korrekter Loginprozess ausschauen
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
