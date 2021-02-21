import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import de.mkammerer.argon2.Argon2Helper;

/** FAST GESCHAFFT!
 *
 * Du hast das Passwort gefunden! Aber vielleicht waere es besser wenn wir dieses Passwort als Hash-Wert speichern.
 * Kannst du eine Methode, die einen Hash-Wert aus unseren Passwort generiert, programmieren?
 *
 *Ob SHA-1,SHA-256 etc. bleibt ganz dir ueberlassen ;-)
 *
 *Du hast einen Hash-Wert generiert? Gratuliere, du hast den Geparden in dir geweckt!
 * Jetzt bitte nur noch einen Pull-Request erstellen und deine Bewerbung mit resources/Abgabeformular.jar abschicken!
 *
 */

public class HashGenerator {

    public static String getHash(final String str) {
        return hash(str);
    }

	//Note: Argon2 adds Salt by itself
	private static final Argon2 ARGON2 = Argon2Factory.create(Argon2Types.ARGON2id);
    static String hash(final String toHash){

		return ARGON2.hash(ITERATIONS, MEMORY, PARALLELISM, toHash.toCharArray());
    }

	//TODO fine tune parameters for the server which will do the hashing
	private static final int TIME = 200; //milliseconds
	private static final int MEMORY = 64 * 1000;//kibibyte
	private static final int PARALLELISM = 1;
	private static final int ITERATIONS = 5;

	public static void main(final String[] args) {

		System.out.println("Suggested iterations: ");
		Argon2Helper.findIterations(ARGON2, TIME * 2, MEMORY, PARALLELISM, (iterations, milliseconds) -> {
			System.out.printf("%2d Iteration(s): %dms\n", iterations, milliseconds);
		});
		System.out.println();
		System.out.println(hash("W#2FfkaeiE"));
		System.out.println(hash("W#2FfkaeiE"));
		assert ARGON2.verify(hash("W#2FfkaeiE"), "W#2FfkaeiE".toCharArray());
	}
}
