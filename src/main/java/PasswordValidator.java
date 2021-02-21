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
	private static final Pattern number = Pattern.compile(".*[0-9].*");
	private static final Pattern special = Pattern.compile(".*[&+@$#%].*");

	public static boolean passwordIsValid(final String password) {
		if (password.length() < 5) {
			return false;
		}
		if (password.length() > 10) {
			return false;
		}
		if (!number.matcher(password).matches()) {
			return false;
		}
		if (!special.matcher(password).matches()) {
			return false;
		}
		if (password.contains(" ")) {
			return false;
		}

		return true;

	}
}
