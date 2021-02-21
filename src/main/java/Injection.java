
/**
 *  SQL INJECTION
 *
 * Kannst du mithilfe einer SQL INJECTION alle Daten abfragen ohne die Zugangsdaten zu kennen? :)
 * Wir wuerden die Daten naemlich für den PasswortValidator brauchen.
 *
 */

import java.sql.*;

public class Injection {

	private static Connection getCon() throws SQLException {
		// Verbindung zum PostgreSQL Server herstellen
		// Hier brauchen wir noch das Passwort, dass du bei der CaesarEncryption herausgefunden hast :)
		try {
			//TODO connection reuse
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/gepardec", "postgres", "GepaRd");
		} catch (final SQLException e) {
			System.out.println("Verbindungsversuch fehlgeschlagen!");
			//System.out.println(e.getMessage());
			throw e;
		}
	}

	public static int safeLogin(final String username, final String password) throws SQLException {
		try (final Connection con = getCon()) {
			final String query = "SELECT * FROM useraccess where username=? and password = ?";
			final PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);

			return printAndCloseResultSet(stmt.executeQuery());
		}
	}

	public static int vulnerableLogin(final String username, final String password) throws SQLException {
		try (final Connection con = getCon()) {
			final String query = String.format("SELECT * FROM useraccess where username='%s' and password='%s'", username, password);
			//Prepared Statement means I'm safe, right?
			final ResultSet rs = con.prepareStatement(query).executeQuery();
			return printAndCloseResultSet(rs);
		}
	}

	private static int printAndCloseResultSet(final ResultSet rs) throws SQLException {
		int count = 0;

		while (rs.next()) {
			count++;
			final String user = rs.getString("username");
			final String word = rs.getString("password");
			final int salary = rs.getInt("salary");
			System.out.printf("%2d. %20s has password %20s (%s) and earns %5d.\n", count, user, "'" + word + "'", (PasswordValidator.passwordIsValid(word) ? "  valid" : "invalid"), salary);
		}
		rs.close();
		return count;
	}

	public static void main(final String[] args) throws SQLException {
		System.out.println("Normal login");
		vulnerableLogin("Philipp", "helloWorld");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("SQL Injection");
		vulnerableLogin("anything really", "' OR 1=1--");
	}
}
