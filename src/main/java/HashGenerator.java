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

import java.util.ArrayList;

public class HashGenerator {

    public static void main(String[] args) {
      String str = "Hallo Welt";
      String hash = getHash(str);
      System.out.println(hash);
    }

    public static String getHash(String str) {
        return hash(str);
    }

    static String hash(String toHash){
        ArrayList<Byte> bytes= new ArrayList<Byte>();
        for (char a : toHash.toCharArray()) {
          bytes.add((byte)(0xff & a));
        }

        int h0 = 0x67452301;
        int h1 = 0xEFCDAB89;
        int h2 = 0x98BADCFE;
        int h3 = 0x10325476;
        int h4 = 0xC3D2E1F0;
        long ml = toHash.length()*8;

        //prepare
        bytes.add((byte)0x80);
        while (bytes.size() % 64 != 56) {
          bytes.add((byte)0x00);
        }
        //add 64 bit msg length
        bytes.add((byte)((ml >> 56) & 0xFF));
        bytes.add((byte)((ml >> 48) & 0xFF));
        bytes.add((byte)((ml >> 40) & 0xFF));
        bytes.add((byte)((ml >> 32) & 0xFF));
        bytes.add((byte)((ml >> 24) & 0xFF));
        bytes.add((byte)((ml >> 16) & 0xFF));
        bytes.add((byte)((ml >> 8) & 0xFF));
        bytes.add((byte)((ml >> 0) & 0xFF));


        //debug output
        String o = "";
        for (byte b : bytes) {
          o += String.format("%02X ", b);
        }
        System.out.println(o);


        return String.valueOf(bytes.size());
    }
}
