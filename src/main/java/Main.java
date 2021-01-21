import java.util.ArrayList;

public class Main {


    public static void main(String[] args){

        String code = "QbanHqnzCsFpuvssnuEGFtrFryyFpunsGFxnCvGnrA";

        System.out.println("Alle möglichen Verschiebungen von " + code + ":\n");
        entschluesseln(code);

    }


    static String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static String entschluesseln(String text)
    {
       String loesungswort = text +  "      WHAAAAAT? bitte übersetzen!!";
       System.out.println(loesungswort);
       return loesungswort;
    }


}

