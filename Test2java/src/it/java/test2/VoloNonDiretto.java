package it.java.test2;

/*
Un volo non diretto è un volo con scali intermedi, ovvero gli aereoporti in cui il volo sosta prima di
raggiungere l’ aereoporto di destinazione. Scrivere una classe VoloNonDiretto, il cui numero massimo di
scali intermedi viene impostato dal costruttore della classe. 
Oltre ai metodi che restituiscono i valori delle variabili istanza, definire i seguenti metodi:
- un metodo che aggiunge uno scalo intermedio;
- un metodo che restituisce una stringa che descrive un volo non diretto tramite sigla del volo, città e nome
dell’ aereoporto di partenza, città e nome dell’ aereoporto di destinazione e città e nome degli scali
intermedi, ad esempio "Volo BA202 Londra Heathrow - Pisa Galilei via Parigi C. De Gaulle - Milano Malpensa".
N.B.
Si consiglia per il punto due l’ utilizzo di 
private Aereoporto[] scali;
private int cont;
super;*/

public class VoloNonDiretto extends Volo {
	
    private Aereoporto[] scaliIntermedi;
    private int numScali;

	public VoloNonDiretto(String sigla, Aereoporto aeroportoP, Aereoporto aeroportoD, String aereomobile, 
			int numMaxPasseggeri, int numMaxScali) {
		super(sigla, aeroportoP, aeroportoD, aereomobile, numMaxPasseggeri);	
        this.scaliIntermedi = new Aereoporto[numMaxScali];
        this.numScali = 0;
	}

	public Aereoporto[] getScaliIntermedi() {
		return scaliIntermedi;
	}

	public int getNumScali() {
		return numScali;
	}
	
	//metodo che aggiunge uno scalo intermedio
	public void addScalo (Aereoporto scaloI) {
		if (numScali < scaliIntermedi.length) {
			scaliIntermedi[numScali] = scaloI;
			numScali++;
		}
		
	}
	
	//un metodo che restituisce una stringa che descrive un volo non diretto tramite sigla del volo, 
	//città e nome dell’ aereoporto di partenza, città e nome dell’ aereoporto di destinazione 
	//e città e nome degli scali intermedi
	@Override
	public String descrizioneVolo() {     
	    String descrizione = super.descrizioneVolo();
	    if (numScali > 0) {
	        //Costruzione della stringa degli scali intermedi
	        String descrizioneScali = "";
	        for (int i = 0; i < numScali; i++) {
	            descrizioneScali += scaliIntermedi[i].getCitta() + " " + scaliIntermedi[i].getNomeAereoporto();
	            if (i < numScali - 1) {
	                descrizioneScali += " - ";
	            }
	        }
	        //Inserimento degli scali intermedi nella descrizione del volo
	        int index = descrizione.indexOf("-") + 1;
	        descrizione = descrizione.substring(0, index) + " " + descrizioneScali + " - " + descrizione.substring(index);
	    }
	    return descrizione;
	}
}
