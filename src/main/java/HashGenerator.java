import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(toHash.getBytes());
            byte[] digest = md.digest();
            for (byte oneByte : digest){
                String hex = Integer.toHexString(0XFF & oneByte);
                if (hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        String password = "W#2FfkaeiE";
        System.out.println(hash(password)); //should be: "1a251e7c6826e0b62ab4f1d158d84afdc3aadcfb999026754adbcacf241e9cdf"
    }
}
