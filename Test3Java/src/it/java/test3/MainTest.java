package it.java.test3;

/**
 * La classe MainTest contiene il metodo main per testare la classe StudentGrades.
 * @author Emanuele Buemi
 */

public class MainTest {

    /**
     * Metodo main per testare la classe StudentGrades.
     * 
     * @param args gli argomenti della riga di comando (non utilizzati)
     */
	public static void main(String[] args) {
		
        StudentGrades votiStudenti = new StudentGrades();

        //Aggiunta dei voti in base alle diverse chiavi
        votiStudenti.addGrade("Emanuele", 85);
        votiStudenti.addGrade("Filippo", 90);
        votiStudenti.addGrade("Alessandra", 75);
        
        System.out.println("-----------------------------------------------------");

        //Test del metodo getGrade 
        System.out.println("Voto: " + votiStudenti.getGrade("Emanuele"));
        System.out.println("Voto: " + votiStudenti.getGrade("Filippo"));
        System.out.println("Voto: " + votiStudenti.getGrade("Alessandra"));
        System.out.println("Voto: " + votiStudenti.getGrade("Pietro")); // Studente non presente
        
        System.out.println("-----------------------------------------------------");

        //Test del metodo getGrade printGrades
        System.out.println("Lista totale di voti:");
        votiStudenti.printGrades();

	}

}
