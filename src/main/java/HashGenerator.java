import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
