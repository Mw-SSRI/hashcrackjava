/**
 * La seguente classe, denominata Bruteforce, calcola l'hash di ogni stringa possibile basandosi
 * sul charset ASCII. E' possibile scegliere la lunghezza della password da crackare se è conosciuta,
 * stesso discorso per il set di caratteri.
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
    private String sceltaattacco="";

    private String hashdatrovare;

    private String algorithm;

    private String hashata = "";

    //------------------------------------------------------------------------------------------------------------------
    public void bruteforce() {

        System.out.println("Inserire l'hash di cui si vuole testare la sicurezza:");

        hashdatrovare = scegliAttacco.gethashdatrovare();

        algorithm = calcolaHash.sethashfunction();

        System.out.println("Inserire il formato della password scegliendo tra: numeri, minuscole, maiuscole,lettere,ascii");

        sceltaattacco = tastiera.next();

        if(sceltaattacco.equalsIgnoreCase("numeri")){

            scelta = numeri;

            n = numeri.length;

        }

        else if(sceltaattacco.equalsIgnoreCase("minuscole")){

            scelta = minuscole;

            n = minuscole.length;

        }

        else if(sceltaattacco.equalsIgnoreCase("maiuscole")){

            scelta = maiuscole;

            n = maiuscole.length;

        }

        else if(sceltaattacco.equalsIgnoreCase("lettere")){

            scelta = lettere;

            n = lettere.length;

        }

        else if(sceltaattacco.equalsIgnoreCase("ascii")){

            scelta = ascii;

            n = ascii.length;

        }

        else{

            System.out.println("Input non valido.");

        }

        for(int k = 0; k < 20; k++) {

            printAllKLengthRec(scelta, prefix, n, k);

        }

    }

    public void printAllKLengthRec(char[] scelta, String prefix, int n, int k) {

        if (k == 0) {

            hashata  = calcolaHash.gethash(prefix);

            System.out.println(prefix);

            if(hashata.equalsIgnoreCase(hashdatrovare)){

                System.err.println("Password trovata: " + prefix);

            }

            return;

        }

        int i = 0;

        while (i < n&&!hashata.equalsIgnoreCase(hashdatrovare)) {

            String newPrefix = prefix + scelta[i];

            printAllKLengthRec(scelta, newPrefix, n, k - 1);

            i++;

        }

    }

}