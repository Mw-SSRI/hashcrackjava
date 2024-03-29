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
    private long start;
    private Scanner tastiera = new Scanner(System.in);
    private CalcolaHash calcolaHash = new CalcolaHash();
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

    private String hashdatrovare;

    private int lunghezzacharset;

    private char[] scelta;

    private String hashata = "";

    public Bruteforce(String hashdatrovare) {

        this.hashdatrovare = hashdatrovare;

    }

    //------------------------------------------------------------------------------------------------------------------
    public void bruteforce() {

        calcolaHash.sethashfunction();

        System.out.println("Inserire il formato della password scegliendo tra: numeri, minuscole, maiuscole,lettere, " +
                "altrimenti ascii se non si sa com'è formata la password.");

        String sceltaformato = tastiera.next();

        if(sceltaformato.equalsIgnoreCase("numeri")){

            scelta = numeri;

            lunghezzacharset = numeri.length;

        }

        else if(sceltaformato.equalsIgnoreCase("minuscole")){

            scelta = minuscole;

            lunghezzacharset = minuscole.length;

        }

        else if(sceltaformato.equalsIgnoreCase("maiuscole")){

            scelta = maiuscole;

            lunghezzacharset = maiuscole.length;

        }

        else if(sceltaformato.equalsIgnoreCase("lettere")){

            scelta = lettere;

            lunghezzacharset = lettere.length;

        }

        else if(sceltaformato.equalsIgnoreCase("ascii")){

            scelta = ascii;

            lunghezzacharset = ascii.length;

        }

        else{

            System.out.println("Input non valido.");

            return;

        }

        int lunghezzaPassword = 1;

        String prefisso = "";

        start = System.currentTimeMillis();

        while((lunghezzaPassword < 20) && (!hashata.equalsIgnoreCase(hashdatrovare))) {

            genera(prefisso, lunghezzaPassword);

            lunghezzaPassword++;

        }

    }

    private void genera(String prefisso, int lunghezzaPassword) {

        if (lunghezzaPassword == 0) {

            hashata  = calcolaHash.calcolahash(prefisso);

            System.out.println(prefisso);

            if(hashata.equalsIgnoreCase(hashdatrovare)){

                System.err.println("Password trovata: " + prefisso);

                System.err.println("Tempo impiegato: " + CalcolaTempoImpiegato.convertimillisecondi(System.currentTimeMillis() - start));

            }

            return;

        }

        int i = 0;

        while ((i < lunghezzacharset) && (!hashata.equalsIgnoreCase(hashdatrovare))) {

            String nuovoPrefisso = prefisso + scelta[i];

            genera(nuovoPrefisso, lunghezzaPassword -1);

            i++;

        }

    }

}