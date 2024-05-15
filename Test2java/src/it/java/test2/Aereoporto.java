package it.java.test2;

/*1) Un aereoporto può essere caratterizzato tramite il nome, la città e la sigla (Es. Galilei, Pisa, PSA). 
Un passeggero di un volo può essere caratterizzato tramite il nome, la nazionalità, la sigla del volo
(Es. AZ124), il posto assegnato (Es. 16F), il tipo di pasto richiesto (Es. vegetariano). 
Scrivere due classi Aereoporto e Passeggero con gli opportuni costruttori ed i metodi
che restituiscono i valori delle variabili istanza, inoltre, nella classe Passeggero definire un metodo 
che cambia il posto assegnato ad un dato passeggero.*/

public class Aereoporto {
	
    private String nomeAereoporto;
    private String citta;
    private String sigla;
    
	public Aereoporto(String nomeAereoporto, String citta, String sigla) {
		super();
		this.nomeAereoporto = nomeAereoporto;
		this.citta = citta;
		this.sigla = sigla;
	}

	public String getNomeAereoporto() {
		return nomeAereoporto;
	}

	public String getCitta() {
		return citta;
	}
	
	public String getSigla() {
		return sigla;
	}
	
}
