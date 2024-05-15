package it.java.test2;

import java.util.Arrays;

public class VoloTest {

	public static void main(String[] args) {
		
		//volo diretto "Volo AZ108 Roma Fiumicino - Londra Heathrow"
	    //volo con scalo "Volo BA202 Londra Heathrow - Pisa Galilei via Parigi C. De Gaulle - Milano Malpensa"
		
        //Creazione degli aeroporti
        Aereoporto aPartenza1 = new Aereoporto("Fiumicino", "Roma", "AZ10B");
        Aereoporto aDestinazione1 = new Aereoporto("Heathrow", "Londra", "AZ10B");
        Aereoporto aPartenza2 = new Aereoporto("Heathrow", "Londra", "BA202");
        Aereoporto aDestinazione2 = new Aereoporto("Malpensa", "Milano", "BA202");

        //Creazione dei passeggeri
        Passeggero passeggero1 = new Passeggero("Luca Vialli", "Italiana", "AZ10B", "16F", "vegetariano");
        Passeggero passeggero2 = new Passeggero("Andreas Iniesta", "Spagnola", "AZ10B", "17F", "standard");
        Passeggero passeggero3 = new Passeggero("Alessandro Del Piero", "Italiana", "AZ10B", "18F", "vegetariano");

        //Creazione voli (diretti e con scalo)
        Volo voloDiretto = new Volo("AZ10B", aPartenza1, aDestinazione1, "Ryanair", 200);
        voloDiretto.addPasseggero(passeggero1);
        voloDiretto.addPasseggero(passeggero2);
        voloDiretto.addPasseggero(passeggero3);
        VoloNonDiretto voloNonDiretto = new VoloNonDiretto("BA202", aPartenza2, aDestinazione2, "Volotea", 250, 3);
        //Aggiunta degli scali intermedi 
        Aereoporto scalo1 = new Aereoporto("Galilei", "Pisa", "BA202");
        Aereoporto scalo2 = new Aereoporto("C. De Gaulle", "Parigi", "BA202");
        voloNonDiretto.addScalo(scalo1);
        voloNonDiretto.addScalo(scalo2);

        // Test dei metodi delle classi Volo e VoloNonDiretto
        System.out.println("Descrizione volo diretto: " + voloDiretto.descrizioneVolo());
        System.out.println("Elenco passeggeri volo diretto: " + Arrays.toString(voloDiretto.elencoNomiPasseggeri()));
        System.out.println("Posti con pasto vegetariano nel volo diretto: " + Arrays.toString(voloDiretto.postiConPastoVegetariano()));
        System.out.println("Descrizione volo non diretto: " + voloNonDiretto.descrizioneVolo());
	}

}
