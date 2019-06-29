/**
 * La classe Wordlist contiene un metodo chiamato wordlist il quale fa in modo che l'utente
 * possa trovare l'hash originale basandosi su una lista di password comuni contenute in un file
 * txt. Il suddetto metodo prende ogni linea del file txt indicato, ne calcola l'hash attraverso
 * il metodo calcolahash della classe CalcolaHash e le confronta con l'hash inserito dall'utente fino
 * a quando non trova una corrispondenza.
 */

package hashcrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wordlist {

    //------------------------------------------------------------------------------------------------------------------
    //variabili
    private CalcolaHash calcolaHash;

    private String hashdatrovare;

    private String hashata = "";

    private Scanner tastiera;

    public Wordlist(String hashdatrovare) {

        this.hashdatrovare = hashdatrovare;

        calcolaHash = new CalcolaHash();

        tastiera = new Scanner(System.in);
    }

    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    //Metodo che esegue l'attacco wordlist
    public void wordlist() throws FileNotFoundException {

        System.out.println("Inserire il path della wordlist:");

        File file = new File(tastiera.nextLine());

        Scanner leggifile = new Scanner(file);

        calcolaHash.sethashfunction();

        while ((!hashata.equalsIgnoreCase(hashdatrovare)) && (leggifile.hasNextLine())) {

                String linea = leggifile.nextLine();

                hashata = calcolaHash.calcolahash(linea);

                System.out.println(linea);

                if (hashata.equalsIgnoreCase(hashdatrovare))

                    System.err.println("Password trovata: " + linea);

        }

        if(!hashata.equalsIgnoreCase(hashdatrovare)){

            System.err.println("Password non trovata nella wordlist.");

        }

    }
    //------------------------------------------------------------------------------------------------------------------

}