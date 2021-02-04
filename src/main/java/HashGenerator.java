import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public static String getHash(String str) {
        return hash(str);
    }

    static String hash(String toHash){
        String result = "";
        MessageDigest md;
        String algo = "SHA-256";

        try {

            md = MessageDigest.getInstance(algo);
            byte[] hashes = md.digest(toHash.getBytes());
            for (int i = 0; i < hashes.length; i++){
                String hex = Integer.toHexString(0xff & hashes[i]);
                if (hex.length() == 1) result+=0;
                result += hex;
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;


    }
}