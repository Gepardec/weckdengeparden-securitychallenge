import java.util.HashSet;
import java.util.Set;


/*
IN ARBEIT!
* */


public class Main {

    public static void main(String[] args) {

        String htmlPassword = "a";
        String vaultDoor = "b";
        String caesar = "c";
        String sqlInjection = "d";
        String passwordValidator = "e";

        String toHash = htmlPassword+vaultDoor+caesar+sqlInjection+passwordValidator;

        /*
         *Hash.getHash(toHash);
         * */

        String test = "03de6c570bfe24bfc328ccd7ca46b76eadaf4334";
        if (isValid(test)){
            System.out.println("Du hast den Geparden in dir geweckt!");
        } else {
            System.out.println("Da dürfte etwas noch nicht passen!");
        }

    }
    static boolean isValid(String hash) {
        Set<String> hashes = new HashSet<String>();
        hashes.add("03de6c570bfe24bfc328ccd7ca46b76eadaf4334");
        hashes.add("36bbe50ed96841d10443bcb670d6554f0a34b761be67ec9c4a8ad2c0c44ca42c");
        hashes.add("878ae65a92e86cac011a570d4c30a7eaec442b85ce8eca0c2952b5e3cc0628c2e79d889ad4d5c7c626986d452dd86374b6ffaa7cd8b67665bef2289a5c70b0a1");
        hashes.add("ab56b4d92b40713acc5af89985d4b786");
        if (hashes.contains(hash)){
            return true;
        }
        return false;
    }
}