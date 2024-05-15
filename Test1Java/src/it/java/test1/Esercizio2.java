package it.java.test1;

/*
 * Scrivere un metodo che, dati un carattere c ed una stringa s, restituisce il numero 
 * delle occorrenze di c in s.
 * */

public class Esercizio2 {

	public static void main(String[] args) {	
		char carattere = 'o';
		String stringa = "cocomero";
		
		int numeroOccorrenze = contaOccorrenze(carattere, stringa);
		System.out.println("Numero di occorrenze di " + carattere + 
				" in " + stringa + " e' " + numeroOccorrenze);
	}
	
	public static int contaOccorrenze(char c, String s) {
		int conteggio = 0;
		
		// Controllo ogni carattere nella stringa e vado a aumentare
		// il conteggio se corrisponde al carattere richiesto
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				conteggio++;
			}
		}
		return conteggio;
	}
}
