/**
 * La classe CalcolaHash contiene due importanti metodi, sethashfunction e gethash. sethashfunction serve
 * per settare il tipo di hash inserito dall'utente. Gethash invece, attraverso il metodo getInstance
 * della classe Java MessageDigest, calcola l'hash di ogni linea del file txt utilizzato dalla classe
 * Wordlist. Viene utilizzato anche nella classe bruteforce per calcolare ogni hash corrispondente alle
 * stringhe generate.
 */

package hashcrack;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CalcolaHash {

        Scanner tastiera = new Scanner(System.in);

        private String algorithm;

        //--------------------------------------------------------------------------------------------------------------
        //Metodo per settare l'algoritmo di cifratura scelto dall'utente
        public String sethashfunction() {

            System.out.println("Inserire il tipo di hash scegliendo tra: MD5, SHA-1, SHA-256, SHA-384, SHA-512");

            System.out.println("Se si utilizza l'attacco di tipo wordlist oppure bruteforce scrivere esattamente come sopra" +
                    "indicato, altrimenti, se si utilizza l'attacco di tipo database scrivere " +
                    "in minuscolo e senza trattini.");

            System.out.println("Se il tipo di hash non è uno di quelli indicati provare comunque ad inserirlo, il " +
                    "metodo getInstance della classe MessageDigest potrebbe supportarlo.");

            algorithm = tastiera.nextLine();

            return algorithm;

        }
        //--------------------------------------------------------------------------------------------------------------



        //--------------------------------------------------------------------------------------------------------------
        //Metodo per calcolare l'hash delle password da confrontare con l'hash dato
        public String gethash(String input) {

            try {

                MessageDigest md = MessageDigest.getInstance(algorithm);

                byte[] messageDigest = md.digest(input.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                String hashtext = no.toString(16);

                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }

                return hashtext;
            }
            //Se non va a buon fine il try
            //-----------------------------------------------------------------------
            catch (NoSuchAlgorithmException e) {

                System.out.println("Algoritmo non corretto: ");

                return null;

            }
            //-----------------------------------------------------------------------

        }
        //--------------------------------------------------------------------------------------------------------------
    }
