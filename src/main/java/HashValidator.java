import java.util.HashSet;
import java.util.Set;

public class HashValidator {

    public static void main(String[] args) {

        // Hier bitte das Passwort vom PasswordValidator einfügen :)
        String toHash = "";

       String überprüfen = HashGenerator.getHash(toHash).toString();

        if (isValid(HashGenerator.getHash(toHash))){
            System.out.println("Gratuliere! \nDu hast den Geparden in dir geweckt und alle Herausforderungen gemeistert!" +
                    "\nJetzt bitte nur noch einen GitHub-Pullrequest erstellen und deine Bewerbung mittels /resources/Abgabeformular.jar abschicken!");
        } else {
            System.out.println("Hmm. Da dürfte entweder beim Passwort oder beim HashGenerator etwas noch nicht passen!");
        }

    }

    // Hier sind die gängigsten Hashes dabei. Solltest du einen anderen gewählt haben bitte einfach hinzufügen ;-)
    static boolean isValid(String hash) {
        Set<String> hashes = new HashSet<String>();
        hashes.add("dffeb369a8b0d9ed61429667090d04363bf262c0");
        hashes.add("1a251e7c6826e0b62ab4f1d158d84afdc3aadcfb999026754adbcacf241e9cdf");
        hashes.add("fa2f53c570362c1bfcc6260b9e10c15d5f2404a2045033b4f2f06631ac5473bd8127a5cab2b8ed0d5689b3a80e3e6396fd8821c6f08a2961fedde73ba1f972d0");
        hashes.add("1108eca51b7763874174f9b42b7300fe");
        hashes.add("14bf0c16a6010aea20b4054bfdf231341617fb8c");
        hashes.add("e1f4e9ad1f6a8c1db8117375675497bad2e468897eb02ff88fef312a02429f8b");
        hashes.add("6e39d2a546980503381eec44085471ed906606e54847c4ee778b4dc331ac338c");
        hashes.add("0bfb84647c449c2ebe6f044a047718e791e16ed6bce93354c58605df7497b1831c3f95c19222f893a87d3c80dcff7caf616156b2609263c9539d693d89b7998d");
        if (hashes.contains(hash)){
            return true;
        }
        return false;
    }
}