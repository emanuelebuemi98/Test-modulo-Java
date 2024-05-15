package it.java.test2;

/*1) Un aereoporto può essere caratterizzato tramite il nome, la città e la sigla (Es. Galilei, Pisa, PSA). 
Un passeggero di un volo può essere caratterizzato tramite il nome, la nazionalità, la sigla del volo
(Es. AZ124), il posto assegnato (Es. 16F), il tipo di pasto richiesto (Es. vegetariano). 
Scrivere due classi Aereoporto e Passeggero con gli opportuni costruttori ed i metodi
che restituiscono i valori delle variabili istanza, inoltre, nella classe Passeggero definire un metodo 
che cambia il posto assegnato ad un dato passeggero.*/

public class Passeggero {
	
    private String nomePasseggero;
    private String nazionalita;
    private String siglaVolo;
    private String postoAssegnato;
    private String pastoRichiesto;
    
    
	public Passeggero(String nomePasseggero, String nazionalita, String siglaVolo, String postoAssegnato, String pastoRichiesto) {
		super();
		this.nomePasseggero = nomePasseggero;
		this.nazionalita = nazionalita;
		this.siglaVolo = siglaVolo;
		this.postoAssegnato = postoAssegnato;
		this.pastoRichiesto = pastoRichiesto;
	}


	public String getNomePasseggero() {
		return nomePasseggero;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public String getSiglaVolo() {
		return siglaVolo;
	}

	public String getPostoAssegnato() {
		return postoAssegnato;
	}

	public void setPostoAssegnato(String postoAssegnato) {
		this.postoAssegnato = postoAssegnato;
	}

	public String getPastoRichiesto() {
		return pastoRichiesto;
	}
	
}
