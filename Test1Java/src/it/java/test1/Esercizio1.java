package it.java.test1;

/*
 * Scrivere un metodo che, dati un carattere c ed una stringa s, restituisce true se c 
 * occorre in s, false altrimenti.
 * */

public class Esercizio1 {

	public static void main(String[] args) {
		char carattere = 'a';
		String stringa = "ciao";
		
		boolean risultato = verificaOccorrenza(carattere, stringa);
		System.out.println("Risultato true o false? " + risultato);
	}
	
	public static boolean verificaOccorrenza(char c, String s) {
		
		// Controllo se il carattere è presente nella stringa scorrendo tutti 
		// i caratteri della stringa
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}
}
