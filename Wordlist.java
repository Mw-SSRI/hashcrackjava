/**
 * La classe Wordlist contiene un metodo chiamato wordlist il quale fa in modo che l'utente
 * possa trovare l'hash originale basandosi su una lista di password comuni contenute in un file
 * txt. Il suddetto metodo prende ogni linea del file txt indicato, ne calcola l'hash attraverso
 * il metodo gethash della classe CalcolaHash e le confronta con l'hash inserito dall'utente fino
 * a quando non trova una corrispondenza.
 */

package hashcrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wordlist {

    Scanner tastiera = new Scanner(System.in);

    CalcolaHash calcolaHash = new CalcolaHash();

    ScegliAttacco scegliAttacco = new ScegliAttacco();

    private String hashdatrovare;
    //------------------------------------------------------------------------------------------------------------------
    //Metodo che esegue l'attacco wordlist
    public void wordlist() {

        System.out.println("Inserire l'hash di cui si vuole testare la sicurezza:");

        hashdatrovare = scegliAttacco.gethashdatrovare();

        calcolaHash.sethashfunction();

        File file = new File("C:\\Users\\Galaxy\\Desktop\\paroleitaliane-master\\rockyou.txt");

        try {

            Scanner sc = new Scanner(file);

            String hashata = "";

            while (!hashata.equalsIgnoreCase(hashdatrovare) && sc.hasNextLine()) {

                    String i = sc.nextLine();

                    hashata = calcolaHash.gethash(i);

                    System.out.println(i);

                    if (hashata.equalsIgnoreCase(hashdatrovare))

                        System.err.println("Password trovata: " + i);

            }

            if(!hashata.equalsIgnoreCase(hashdatrovare)){

                System.err.println("Password non trovata nella wordlist");

            }

            sc.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }
    //------------------------------------------------------------------------------------------------------------------

}
