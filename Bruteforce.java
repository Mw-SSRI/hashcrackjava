/**
 * La seguente classe, denominata Bruteforce, attraverso il metodo bruteforce insieme al metodo calcolahash,
 * calcola l'hash di ogni stringa possibile basandosi sul charset ASCII e le confronta con l'hash dato. E'
 * possibile scegliere il set di caratteri per evitare di perdere tempo, nel caso in cui si sappia il charset
 * utilizzato e si voglia accorciare i tempi.
 */

package hashcrack;

import java.util.Scanner;

public class Bruteforce {
    //------------------------------------------------------------------------------------------------------------------
    //variabili
    Scanner tastiera = new Scanner(System.in);
    ScegliAttacco scegliAttacco = new ScegliAttacco();
    CalcolaHash calcolaHash = new CalcolaHash();
    private char [] scelta;
    private char[] numeri = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private char[] minuscole = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] maiuscole = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] lettere = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] ascii = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<',
            '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'};
    private int k =0;
    private int n;
    private String prefix = "";

    private String sceltaformato ="";

    private String hashdatrovare;

    private String algorithm;

    private String hashata = "";

    //------------------------------------------------------------------------------------------------------------------
    public void bruteforce() {

        hashdatrovare = scegliAttacco.gethashdatrovare();

        algorithm = calcolaHash.sethashfunction();

        System.out.println("Inserire il formato della password scegliendo tra: numeri, minuscole, maiuscole,lettere,ascii");

        sceltaformato = tastiera.next();

        if(sceltaformato.equalsIgnoreCase("numeri")){

            scelta = numeri;

            n = numeri.length;

        }

        else if(sceltaformato.equalsIgnoreCase("minuscole")){

            scelta = minuscole;

            n = minuscole.length;

        }

        else if(sceltaformato.equalsIgnoreCase("maiuscole")){

            scelta = maiuscole;

            n = maiuscole.length;

        }

        else if(sceltaformato.equalsIgnoreCase("lettere")){

            scelta = lettere;

            n = lettere.length;

        }

        else if(sceltaformato.equalsIgnoreCase("ascii")){

            scelta = ascii;

            n = ascii.length;

        }

        else{

            System.out.println("Input non valido.");

        }

        for(int k = 0; k < 20; k++) {

            genera(scelta, prefix, n, k);

        }

    }

    public void genera(char[] scelta, String prefix, int n, int k) {

        if (k == 0) {

            hashata  = calcolaHash.calcolahash(prefix);

            System.out.println(prefix);

            if(hashata.equalsIgnoreCase(hashdatrovare)){

                System.err.println("Password trovata: " + prefix);

            }

            return;

        }

        int i = 0;

        while (i < n&&!hashata.equalsIgnoreCase(hashdatrovare)) {

            String newPrefix = prefix + scelta[i];

            genera(scelta, newPrefix, n, k - 1);

            i++;

        }

    }

}