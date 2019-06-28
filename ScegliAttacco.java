/**
 * La classe ScegliAttacco contiene un metodo chiamato choose che serve per dare all'utente
 * la possibilità di scegliere quale tipo di attacco vuole provare ad effettuare per testare
 * la sicurezza della propria password. Il metodo gethashdatrovare serve per essere chiamato
 * dalle altre classi nel momento in cui l'utente deve inserire l'hash da trovare.
 */

package hashcrack;

import java.io.IOException;
import java.util.Scanner;


public class ScegliAttacco {

    Scanner tastiera = new Scanner(System.in);

    private String hashdatrovare;

    private String scelta;

    //------------------------------------------------------------------------------------------------------------------
    //Metodo che serve a impostare l'hash che l'utente vuole crackare
    public String gethashdatrovare(){

        System.out.println("Inserire l'hash di cui si vuole testare la sicurezza:");

        hashdatrovare = tastiera.nextLine();

        return hashdatrovare;

    }
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //Metodo che serve per far scegliere all'utente l'attacco da effettuare per crackare l'hash
    public void choose() throws IOException {

        System.out.println("Inserire il tipo di attacco da effettuare scegliendo tra bruteforce, wordlist e database: ");

        scelta = tastiera.nextLine();

        if(scelta.equalsIgnoreCase("bruteforce")){

            Bruteforce bruteForce = new Bruteforce();

            bruteForce.bruteforce();

        }

        else if(scelta.equalsIgnoreCase("wordlist")){

            Wordlist wordList = new Wordlist();

            wordList.wordlist();

        }

        else if(scelta.equalsIgnoreCase("database")){

            Database dataBase = new Database();

            dataBase.database();

        }

        else{

            System.out.println("Input non corretto.");

        }

    }
    //------------------------------------------------------------------------------------------------------------------

}