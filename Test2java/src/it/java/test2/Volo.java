package it.java.test2;

/*Un volo può essere caratterizzato tramite la sigla (Es. AZ124), l’ aereoporto di partenza, l ’aereoporto di
destinazione, l’aereomobile (Es. Airbus300) e l ’elenco dei passeggeri. Scrivere una classe Volo,
il cui costruttore imposta il numero massimo di passeggeri. 
Oltre ai metodi che restituiscono i valori delle variabili istanza, definire i seguenti metodi:
- un metodo che aggiunge un passeggero ad un volo;
- un metodo che restituisce una stringa che descrive un volo tramite sigla del volo, città e nome 
dell’ aereoporto di partenza e città e nome dell’ aereoporto di destinazione, ad esempio 
"Volo AZ108 Roma Fiumicino - Londra Heathrow";
- un metodo che restituisce l’elenco dei nomi dei passeggeri di un volo;
- un metodo che restituisce l’elenco dei posti dei passeggeri che hanno richiesto un pasto vegetariano.*/

public class Volo {
	
    private String sigla;
    private Aereoporto aeroportoPartenza;
    private Aereoporto aeroportoDestinazione;
    private String aereomobile;
    private Passeggero[] elencoPasseggeri;
    private int numPasseggeri;
    
    public Volo(String sigla, Aereoporto aeroportoP, Aereoporto aeroportoD, String aereomobile, int numMaxPasseggeri) {
        this.sigla = sigla;
        this.aeroportoPartenza = aeroportoP;
        this.aeroportoDestinazione = aeroportoD;
        this.aereomobile = aereomobile;
        this.elencoPasseggeri = new Passeggero[numMaxPasseggeri];
        this.numPasseggeri = 0;
    }

	public String getSigla() {
		return sigla;
	}

	public Aereoporto getAeroportoPartenza() {
		return aeroportoPartenza;
	}


	public Aereoporto getAeroportoDestinazione() {
		return aeroportoDestinazione;
	}

	public String getAereomobile() {
		return aereomobile;
	}

	public Passeggero[] getElencoPasseggeri() {
		return elencoPasseggeri;
	}

	public int getNumPasseggeri() {
		return numPasseggeri;
	}
	
	//metodo che aggiunge un passeggero ad un volo;
    public void addPasseggero (Passeggero p) {
    	if(numPasseggeri < elencoPasseggeri.length) {
    		elencoPasseggeri[numPasseggeri] = p;
    		numPasseggeri++;
    	}
    }
    
    //un metodo che restituisce una stringa che descrive un volo tramite sigla del volo, 
    //città e nome dell’ aereoporto di partenza e città e nome dell’ aereoporto di destinazione
    public String descrizioneVolo () {
    	//Es. Volo AZ108 Roma Fiumicino - Londra Heathrow
    	return "Volo " + sigla + " " + aeroportoPartenza.getCitta() + " " + aeroportoPartenza.getNomeAereoporto() + " - " +
    			aeroportoDestinazione.getCitta() + " " +  aeroportoDestinazione.getNomeAereoporto() ;
    }
    
    //metodo che restituisce l’elenco dei nomi dei passeggeri di un volo
    public String[] elencoNomiPasseggeri() {
        String[] nomi = new String[numPasseggeri];
        for (int i = 0; i < numPasseggeri; i++) {
            nomi[i] = elencoPasseggeri[i].getNomePasseggero();
        }
        return nomi;
    }
    
    //metodo che restituisce l’elenco dei posti dei passeggeri che hanno richiesto un pasto vegetariano.
    public String[] postiConPastoVegetariano() {
    	//Conteggio passeggeri con pasto vegetariano
        int count = 0;
        for (Passeggero p : elencoPasseggeri) {
            if (p != null && p.getPastoRichiesto().equalsIgnoreCase("vegetariano")) {
                count++;
            }
        }
        //Elenco dei pasti vegetariani
        String[] pastiVegetariani = new String[count];
        count = 0;
        for (Passeggero p : elencoPasseggeri) {
            if (p != null && p.getPastoRichiesto().equalsIgnoreCase("vegetariano")) {
                pastiVegetariani[count] = p.getPostoAssegnato();
                count++;
            }
        }
        return pastiVegetariani;
    }

}
