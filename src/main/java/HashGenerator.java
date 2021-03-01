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

        long ml = toHash.length()*8;

        //make msg multiple of 64 bytes (-8 bytes)
        bytes.add((byte)0x80);
        while (bytes.size() % 64 != 56) {
          bytes.add((byte)0x00);
        }
        //add 8 byte msg length
        bytes.add((byte)((ml >> 56) & 0xFF));
        bytes.add((byte)((ml >> 48) & 0xFF));
        bytes.add((byte)((ml >> 40) & 0xFF));
        bytes.add((byte)((ml >> 32) & 0xFF));
        bytes.add((byte)((ml >> 24) & 0xFF));
        bytes.add((byte)((ml >> 16) & 0xFF));
        bytes.add((byte)((ml >> 8) & 0xFF));
        bytes.add((byte)((ml >> 0) & 0xFF));

        int h0 = 0x67452301;
        int h1 = 0xEFCDAB89;
        int h2 = 0x98BADCFE;
        int h3 = 0x10325476;
        int h4 = 0xC3D2E1F0;

        //for each 64 byte fragment
        for(int p=0; p < bytes.size(); p+= 64)
        {
          //generate 80 x 32 bit words by xoring
          ArrayList<Integer> intlist = fragmentToInteger(bytes, p);
          for (int i=16; i < 80; i++) {
            int w = leftRotate(intlist.get(i-3) ^ intlist.get(i-8) ^ intlist.get(i-14) ^ intlist.get(i-16), 1);
            intlist.add(w);
          }

          //init fragment values
          int a = h0;
          int b = h1;
          int c = h2;
          int d = h3;
          int e = h4;
          int f = 0;
          int k = 0;

          //do the hashing work
          for (int i = 0; i < 80; i++) {
            if (i < 20) {
              f = (b & c) | ((~b) & d);
              k = 0x5A827999;
            } else if (i < 40) {
              f = b ^ c ^ d;
              k = 0x6ED9EBA1;
            } else if (i < 60) {
              f = (b & c) | (b & d) | (c & d);
              k = 0x8F1BBCDC;
            } else {
              f = b ^ c ^ d;
              k = 0xCA62C1D6;
            }

            int temp = leftRotate(a, 5) + f + e + k + intlist.get(i);
            e = d;
            d = c;
            c = leftRotate(b, 30);
            b = a;
            a = temp;
          }

          // add up fragment values
          h0 += a;
          h1 += b;
          h2 += c;
          h3 += d;
          h4 += e;
        }

        //produce final hash
        String hash = "";
        hash += String.format("%08X", h0);
        hash += String.format("%08X", h1);
        hash += String.format("%08X", h2);
        hash += String.format("%08X", h3);
        hash += String.format("%08X", h4);
        return hash;
    }

    /**
     * Breaks up 64 x 8 bit fragment into 16 x 32 bit word list
     * @param  bytes byte array
     * @param  p     the fragment pointer
     * @return       the 16 x 32 bit word list
     */
    static ArrayList<Integer> fragmentToInteger(ArrayList<Byte> bytes, int p)
    {
      ArrayList<Integer> intlist = new ArrayList<Integer>();
      for (int i=p; i < p+64; i+=4) {
        int insert = 0x00000000;
        insert |= (bytes.get(i) & 0xff) << 24;
        insert |= (bytes.get(i+1) & 0xff) << 16;
        insert |= (bytes.get(i+2) & 0xff) << 8;
        insert |= (bytes.get(i+3) & 0xff);
        intlist.add(insert);
      }

      return intlist;
    }


    static int leftRotate(int input, int shift)
    {
      return (input << shift) | (input >>> (32 - shift));
    }
}
