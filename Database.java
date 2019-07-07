/**
 * La classe Database contiene un metodo chiamato database il quale fa utilizzo delle API
 * di un sito internet che contiene un enorme database di hashes. Viene effettuato il
 * confronto tra l'hash inserito dall'utente e quelli contenuti nel database. Nel caso
 * in cui venga trovata una corrispondenza la password verrà stampata, se invece non
 * c'è corrispondenza viene stampato che la password non è stata trovata.
 */

package hashcrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Database {

    private String hashdatrovare;

    private CalcolaHash calcolaHash;

    public Database(String hashdatrovare) {

        this.hashdatrovare = hashdatrovare;

        calcolaHash = new CalcolaHash();

    }

    public void database() {

        try {

            String algorithm = calcolaHash.sethashfunction();

            System.out.println("Sto cercando...");

            URL indirizzo = new URL("https://md5decrypt.net/en/Api/api.php?hash=" + hashdatrovare + "&hash_type="
                    + algorithm + "&email=golodeteji@intempmail.com&code=cb51e9ebaeb4394f");

            HttpURLConnection connessione = (HttpURLConnection) indirizzo.openConnection();

            BufferedReader input = new BufferedReader(new InputStreamReader(connessione.getInputStream()));

            String risposta = input.readLine();

            if (risposta == null || risposta.isBlank()) {

                System.err.println("Password non trovata all'interno del database.");

            }

            else {

                System.err.println("Password trovata: " + risposta);

            }
        }
        catch (IOException e){

            System.out.println("Si è verificato un errore, il server potrebbe essere down.");

        }

    }

}