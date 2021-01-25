import java.util.Scanner;

public class ReverseEngineering {
    public static void main(String args[])
    {
        String input;
        System.out.print("Password:");
        Scanner scanner = new Scanner(System.in);
        input = scanner.next();

        if(inputCheck(input))
        {
            System.out.println("Glückwunsch das war das korrekte Passwort ;)");
        }else
        {
            System.out.println("Das Passwort war nicht korrekt.");
        }
    }

    public static boolean inputCheck(String input)
    {
        byte[] encoded = {
                'd', 0x30 , 0x27  , 0142 , 0x55  , 077  , 0123  , 0x5f  ,
                0154, 'l', 0x32, 0x25, 0x52, '5', 0x61, 0x3f,
                055, 0124, 'l', 063 , 066, 044, 'h'
        };

        for (int i=0; i<encoded.length; i++)
        {
            if (encoded[i] != encoded[i])
            {
                return false;
            }
            System.out.print((char)encoded[i]);
        }
        return true;
    }
}
