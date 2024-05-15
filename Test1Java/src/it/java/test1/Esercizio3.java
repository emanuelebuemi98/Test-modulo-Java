package it.java.test1;

/*
 *Scrivere un metodo in linguaggio Java che data una stringa s e due caratteri c1 e c2 determini
 * se il numero di occorrenze di c1 in s sia uguale o meno al numero di occorrenze di c2.
 * */

public class Esercizio3 {
    public static void main(String[] args) {
    	String stringa = "ciao";
        char carattere1 = 'i';
        char carattere2 = 'a';
        
        boolean risultato = confrontaOccorrenze(stringa, carattere1, carattere2);
        if (risultato) {
            System.out.println("Il numero di occorrenze è uguale.");
        } else {
            System.out.println("Il numero di occorrenze non è uguale.");
        }
    }
    public static boolean confrontaOccorrenze(String s, char c1, char c2) {
        int conteggioC1 = 0;
        int conteggioC2 = 0;     
        
        // Conto il numero di occorrenze di c1 e c2 nella stringa s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1) {
                conteggioC1++;
            }
            if (s.charAt(i) == c2) {
                conteggioC2++;
            }
        }
        
        // Verifico se il numero di occorrenze per entrambi è uguale 
        // restituendo un booleano
        return conteggioC1 == conteggioC2;
    }
}
