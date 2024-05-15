package it.corso.test;

import java.sql.SQLException;

public class TestMain {
	
    public static void main(String[] args) {
        
        String dbName = "test_jdbc"; 
        try {
            Metodi.createDatabase(dbName); // Creazione del database
            Metodi.createUtenteTable(dbName); // Creazione della tabella Utente
            Metodi.createLibroTable(dbName); // Creazione della tabella Libro
            Metodi.createPrestitoTable(dbName); // Creazione della tabella Prestito
            
            System.out.println("----------------------------------------------------------");
            
            //Esecuzione query
        	Metodi.query1(dbName);
        	System.out.println("----------------------------------------------------------");
        	Metodi.query2(dbName);
        	System.out.println("----------------------------------------------------------");
        	Metodi.query3(dbName);
        	System.out.println("----------------------------------------------------------");
        	Metodi.query4(dbName, "Mario", "2024-04-01", "2024-04-15");
        	System.out.println("----------------------------------------------------------");
        	Metodi.query6(dbName);
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
