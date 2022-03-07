import java.nio.charset.StandardCharsets;
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
    public static void main(String[] args) {
        System.out.println(getHash("W#2FfkaeiE"));
    }

    public static String getHash(String str) {
        return hash(str);
    }

    static String hash(String toHash){
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
            return byte2hex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String byte2hex(byte[] toHex) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < toHex.length; i++) {
            String hex = Integer.toHexString(toHex[i] & 0xff);
            if(hex.length() == 1) {
                sb.append("0");
            }
            sb.append(hex);
        }

        return sb.toString();
    }
}
