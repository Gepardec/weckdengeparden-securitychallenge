    /** Leider haben wir den Schluessel für unsere Caesarverschluesselung verloren.
     *  Kannst du bitte die Verschiebungen 1-26 probieren und schauen wie unser Passwort im Klartext lautet?
     *
     * Wir brauchen das Passwort dringend, weil es in der Klasse Injection das Passwort für die Datenbank ist! :(
     * Es muesste irgendetwas mit unserem Lieblingsraubtier sein ...
     *
     */

	import java.sql.DriverManager;

    class CaesarEncryption {


		static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static void main(final String[] args) {

        // Bitte hier dein Passwort, welches du bei der Reverse Engineering Challenge herausgefunden hast, einfuegen.
		String code = "PnyjA7m9";
        code = code.replaceAll("[0-9]","");

		System.out.println("Alle moeglichen Verschiebungen von '" + code + "':");
        decrypt(code);
    }

	public static String decrypt(final String input)
    {
		String solution = null;
		for (int shift = 0; shift < 26; shift++) {
			System.out.printf("\n%2d: ", shift);
			String curr = "";

			for (final char ch : input.toCharArray()) {
				final int position = range.indexOf(ch);

				//Non-branching version of the Case-fixer below
				//final int modifier = ((position % 26) + shift) / 26;
				//position -= modifier * 26;
				char newChar = (char) range.codePointAt((shift + position) % 52);
				//The above works if we assume caesar encryption with an alphabet of size 52. But we want one with size 26 where
				//case is preserved, so we need to restore the correct case here.
				if (Character.isUpperCase(ch)) {
					newChar = Character.toUpperCase(newChar);
				} else {
					newChar = Character.toLowerCase(newChar);
				}

				System.out.print(newChar);
				curr += newChar;
			}

			try {
				DriverManager.getConnection("jdbc:postgresql://localhost:5432/gepardec", "postgres", curr).close();
				System.out.print(" -> SUCCESS");
				solution = curr;
			} catch (final Exception e) {
				System.out.print(" -> Fail");
			}

		}
		return solution;
    }
}
