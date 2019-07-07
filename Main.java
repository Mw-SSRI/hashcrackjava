/**
 * Il seguente programma serve, dato un hash, a calcolare la stringa iniziale. Il programma
 * ha tre funzionalità principali: attacco di tipo bruteforce, wordlist e ricerca all'interno
 * di un database. Lo scopo del programma è quello di poter verificare se le proprie password
 * sono facili da craccare o se sono già presenti all'interno di un database. La classe Main
 * crea un oggetto chiamato scegli dalla classe ScegliAttacco per poter invocare un metodo
 * della suddetta classe chiamato choose, il quale permette di scegliere quale dei tre
 * attacchi effettuare. Le tre funzionalità del programma sono spiegate meglio nelle loro
 * rispettive classi.
 */


package hashcrack;

public class Main {

    public static void main(String[] args) {

        ScegliAttacco scegli = new ScegliAttacco();

        scegli.choose();

    }

}