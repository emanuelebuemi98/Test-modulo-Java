package it.java.test3;

import java.util.HashMap;
import java.util.Map;

/**
 * La classe StudentGrades gestisce i voti degli studenti utilizzando una mappa.
 * 
 * @author Emanuele Buemi
 */

public class StudentGrades {

	/** Mappa che associa il nome dello studente al suo voto. */
	private Map<String, Integer> mappaVoti;

	/**
	 * Costruttore della classe StudentGrades. Inizializza la mappa dei voti degli
	 * studenti.
	 */
	public StudentGrades() {
		this.mappaVoti = new HashMap<>();
	}

	/**
	 * Metodo che restituisce la mappa dei voti degli studenti.
	 * 
	 * @return la mappa dei voti degli studenti
	 */
	public Map<String, Integer> getMappaVoti() {
		return mappaVoti;
	}

	/**
	 * Metodo che imposta la mappa dei voti degli studenti.
	 * 
	 * @param mappaVoti la mappa dei voti degli studenti da impostare
	 */
	public void setMappaVoti(Map<String, Integer> mappaVoti) {
		this.mappaVoti = mappaVoti;
	}

	/**
	 * Metodo che aggiunge un voto per lo studente specificato.
	 * 
	 * @param studentName il nome dello studente
	 * @param grade       il voto da aggiungere
	 */
	public void addGrade(String studentName, int grade) {
		if (studentName != null) {
			mappaVoti.put(studentName, grade);
			System.out.println("Voto dello studente " + studentName + " aggiunto con successo.");
		}
	}

	/**
	 * Metodo che restituisce il voto dello studente specificato.
	 * 
	 * @param studentName il nome dello studente
	 * @return il voto dello studente, -1 se lo studente non è presente nella mappa
	 */
	public int getGrade(String studentName) {
		return mappaVoti.getOrDefault(studentName, -1);
		 /*Varifica che la chiave sia presente nella mappa con metodo containsKey
		  if (mappaVoti.containsKey(studentName)) { 
		       return mappaVoti.get(studentName);
		  } else { 
		      return -1; 
		  }
		 */
	}

	/**
	 * Metodo che stampa tutti i voti degli studenti presenti nella mappa.
	 */
	public void printGrades() {
		for (Map.Entry<String, Integer> entry : getMappaVoti().entrySet()) {
			System.out.println("Studente: " + entry.getKey() + ", Voto: " + entry.getValue());
		}
	}

}
