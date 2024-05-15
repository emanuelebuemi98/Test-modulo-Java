package it.corso.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Metodi {

	private static Connection con;

	public static Connection startConnection(String dbName) throws SQLException {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("127.0.0.1");
		dataSource.setPortNumber(3306);
		dataSource.setUser("root");
		dataSource.setPassword("admin");
		dataSource.setDatabaseName(dbName);

		Connection con = dataSource.getConnection();
		System.out.println("Connessione al database " + dbName + " stabilita.");
		return con;
	}

	public static void createDatabase(String dbName) throws SQLException {
		con = startConnection("");
		PreparedStatement ps = null;

		String sqlQueryCreazioneDB = "CREATE DATABASE IF NOT EXISTS " + dbName;
		ps = con.prepareStatement(sqlQueryCreazioneDB);
		ps.executeUpdate();
		System.out.println("Database " + dbName + " creato con successo.");

		ps.close();
		con.close();

	}

	public static void createUtenteTable(String dbName) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;

		String sqlQueryCreazioneTabellaUtente = "CREATE TABLE IF NOT EXISTS Utente (" + 
		                                              "id INT NOT NULL PRIMARY KEY," + 
				                                      "Cognome VARCHAR(255) NOT NULL," + 
		                                              "Nome VARCHAR(255) NOT NULL" + 
				                                 ")";
		ps = con.prepareStatement(sqlQueryCreazioneTabellaUtente);
		ps.executeUpdate();
		System.out.println("Tabella Utente creata con successo.");
		ps.close();
		con.close();

	}

	public static void createLibroTable(String dbName) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;
		String sqlQueryCreazioneTabellaLibro = "CREATE TABLE IF NOT EXISTS Libro (" + 
		                                             "id INT NOT NULL PRIMARY KEY," + 
				                                     "Titolo VARCHAR(255) NOT NULL," + 
		                                             "Autore VARCHAR(255) NOT NULL" + 
				                                ")";
		ps = con.prepareStatement(sqlQueryCreazioneTabellaLibro);
		ps.executeUpdate();
		System.out.println("Tabella Libro creata con successo.");

		ps.close();
		con.close();

	}

	public static void createPrestitoTable(String dbName) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;
		String sqlQueryCreazioneTabellaPrestito = "CREATE TABLE IF NOT EXISTS Prestito (" + 
		                                                "id INT NOT NULL PRIMARY KEY," + 
				                                        "inizio DATE," + 
		                                                "fine DATE," + 
				                                        "id_utente INT," + 
		                                                "id_libro INT," + 
				                                        "FOREIGN KEY (id_utente) REFERENCES Utente(id)," + 
		                                                "FOREIGN KEY (id_libro) REFERENCES Libro(id)" + 
				                                   ")";
		ps = con.prepareStatement(sqlQueryCreazioneTabellaPrestito);
		ps.executeUpdate();
		System.out.println("Tabella Prestito creata con successo.");

		ps.close();
		con.close();

	}

	// Query 1 - Tutti i libri prestati a all'utente Vallieri in ordine cronologico.
	public static void query1(String dbName) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery1 = "SELECT l.Titolo, u.Cognome " + 
		                   "FROM Libro l "+ 
				           "INNER JOIN Prestito p ON l.id = p.id_libro " + 
		                   "INNER JOIN Utente u ON p.id_utente = u.id " + 
				           "WHERE u.Cognome = 'Vallieri' " + 
		                   "ORDER BY p.inizio";
		ps = con.prepareStatement(sqlQuery1);
		rs = ps.executeQuery();
		System.out.println("Titolo " + "Cognome");
		while (rs.next()) {
			String titoloLibro = rs.getString("Titolo");
			String cognomeUtente = rs.getString("Cognome");
			System.out.println(titoloLibro + " " + cognomeUtente);
		}

		rs.close();

		ps.close();

		con.close();

	}

	// Query 2 - Individua i primi tre lettori che hanno letto più libri.
	public static void query2(String dbName) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery2 = "SELECT u.Nome, u.Cognome, COUNT(p.id_libro) AS NumeroLibriLetti " + 
		                   "FROM Utente u "+ 
				           "INNER JOIN Prestito p ON u.id = p.id_utente " + 
		                   "GROUP BY u.Cognome, u.Nome "+ 
				           "ORDER BY NumeroLibriLetti DESC LIMIT 3";
		ps = con.prepareStatement(sqlQuery2);
		rs = ps.executeQuery();
		System.out.println("Nome " + "Cognome " + "NumeroLibriLetti");
		while (rs.next()) {
			String nomeUtente = rs.getString("Nome");
			String cognomeUtente = rs.getString("Cognome");
			int numeroLibriLetti = rs.getInt("NumeroLibriLetti");
			System.out.println(nomeUtente + " " + cognomeUtente + " " + numeroLibriLetti);
		}
		rs.close();
		ps.close();
		con.close();
	}

	// Query 3 - Individua tutti i possessori dei libri non ancora rientrati e il
	// titolo degli stessi.
	public static void query3(String dbName) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery3 = "SELECT u.Nome, u.Cognome, l.Titolo " + 
		                   "FROM Utente u " + 
				           "INNER JOIN Prestito p ON u.id = p.id_utente " + 
		                   "INNER JOIN Libro l ON p.id_libro = l.id " + 
				           "WHERE p.fine IS NULL";
		ps = con.prepareStatement(sqlQuery3);
		rs = ps.executeQuery();
		System.out.println("Nome " + "Cognome " + "Titolo");
		while (rs.next()) {
			String nomeUtente = rs.getString("Nome");
			String cognomeUtente = rs.getString("Cognome");
			String titoloLIbro = rs.getString("Titolo");
			System.out.println(nomeUtente + " " + cognomeUtente + " " + titoloLIbro);
		}
		rs.close();
		ps.close();
		con.close();
	}

	// Query 4 - Dare lo storico dei libri chiesti in prestito da un utente
	// indicando il periodo.
	public static void query4(String dbName, String userName, String startDate, String endDate) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery4 = "SELECT l.Titolo, p.inizio, p.fine " + 
		                   "FROM Libro l " + 
				           "INNER JOIN Prestito p ON l.id = p.id_libro " + 
		                   "INNER JOIN Utente u ON p.id_utente = u.id " + 
				           "WHERE u.Nome = ? AND p.inizio >= ? AND p.fine <= ?";
		ps = con.prepareStatement(sqlQuery4);
		ps.setString(1, userName);
		ps.setString(2, startDate);
		ps.setString(3, endDate);
		rs = ps.executeQuery();
		System.out.println("Titolo " + "Inizio " + "Fine");
		while (rs.next()) {
			String titoloLibro = rs.getString("Titolo");
			String dataInizio = rs.getString("Inizio");
			String dataFine = rs.getString("Fine");
			System.out.println(titoloLibro + " " + dataInizio + " " + dataFine);
		}
		rs.close();
		ps.close();
		con.close();
	}

	// Query 6 - Individua prestiti la cui durata supera i 15gg.
	public static void query6(String dbName) throws SQLException {
		con = startConnection(dbName);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery6 = "SELECT l.Titolo, u.Nome, u.Cognome, p.inizio, p.fine " + 
		                   "FROM Libro l "+ 
				           "INNER JOIN Prestito p ON l.id = p.id_libro " + 
		                   "INNER JOIN Utente u ON p.id_utente = u.id " + 
				           "WHERE DATEDIFF(p.fine, p.inizio) > 15";
		ps = con.prepareStatement(sqlQuery6);
		rs = ps.executeQuery();
		System.out.println("Titolo " + "Nome " + "Cognome " + "Inizio " + "Fine");
		while (rs.next()) {
			String titoloLibro = rs.getString("Titolo");
			String nomeUtente = rs.getString("Nome");
			String cognomeUtente = rs.getString("Cognome");
			String dataInizio = rs.getString("Inizio");
			String dataFine = rs.getString("Fine");
			System.out
					.println(titoloLibro + " " + nomeUtente + " " + cognomeUtente + " " + dataInizio + " " + dataFine);
		}
		rs.close();
		ps.close();
		con.close();
	}

}
