/**
 * Questa classe riceve in input il tempo, in millisecondi, impiegato a trovare la password attraverso
 * gli attacci bruteforce e wordlist, non attraverso l'attacco database, in quanto quest'ultimo, se
 * presenti all'interno del database, trova le password istantaneamente.
 */

package hashcrack;

public class CalcolaTempoImpiegato {

    public static String convertimillisecondi(long tempoimpiegato) {

        int ore = 0, minuti = 0, secondi = 0, millisecondi = 0;

        int ora = 3600000;

        int minuto = 60000;

        int secondo = 1000;

        if(tempoimpiegato >= ora) {

            ore = (int) (tempoimpiegato / ora);

            tempoimpiegato = tempoimpiegato% ora;

        }

        tempoimpiegato = (int) tempoimpiegato;

        if(tempoimpiegato >= minuto) {

            minuti = (int) (tempoimpiegato / minuto);

            tempoimpiegato = tempoimpiegato % minuto;

        }

        if(tempoimpiegato >= secondo) {

            secondi = (int) (tempoimpiegato / secondo);

            millisecondi = (int) (tempoimpiegato % secondo);

        }

        return (ore + " ore, " + minuti + " minuti, " + secondi + " secondi e " + millisecondi + " millisecondi");

    }

}