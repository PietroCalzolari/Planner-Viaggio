package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import plannerviaggio.Utente;

public class Database {
	DBManager db;
	public static DBModelViaggio modelViaggio;
	public static DBModelAttivita modelAttivita;

	
public Database() throws SQLException{
		
		try {
			// Database manager for SQLite
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			
			//Prova apertura e creazione db utente
			db.executeQuery("SELECT * FROM utente LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS utente");
			db.executeUpdate("CREATE TABLE utente (" + "idUtente VARCHAR(50) PRIMARY KEY, " + "nome TEXT, " + "cognome TEXT, " + "email TEXT, " + "citta TEXT)");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//Prova apertura e creazione db viaggio
		try {
			db.executeQuery("SELECT * FROM viaggio LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS viaggio");
			db.executeUpdate("CREATE TABLE viaggio (" + "idViaggio VARCHAR(50) PRIMARY KEY, " + "nomeViaggio VARCHAR(30), " + "mezzo TEXT, " + "Partenza TEXT, " + "Ritorno TEXT)");
		}
		
		modelViaggio = new DBModelViaggio(db);
		
		
		//prova apertura e creazione db Attivita
		try {
			db.executeQuery("SELECT * FROM attivita LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS attivita");
			db.executeUpdate("CREATE TABLE attivita (" + "idAttivita VARCHAR(50) PRIMARY KEY, " + "nomeAttivita VARCHAR(30), " + "oraInizio TEXT, " + "oraFine TEXT, " + "luogo TEXT)");
			
			//forse non serve
			db.executeUpdate("CREATE TABLE ViaggioAttivita( idViaggio VARCHAR(50) NOT NULL, idAttivita VARCHAR(50) NOT NULL, PRIMARY KEY (idViaggio, idAttivita), FOREIGN KEY (idViaggio) REFERENCES viaggio (idViaggio), FOREIGN KEY (idAttivita) REFERENCES attivita (idAttivita))");
		
		}
		
		modelAttivita = new DBModelAttivita(db);
		
	}



	public void stampaUtente(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idUtente") + ", nome=" + rs.getString("nome") + ", cognome=" + rs.getString("cognome") + ", email="
			+ rs.getString("email") + ", citta=" + rs.getString("citta"));

	}
	
	public void stampaViaggio(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idViaggio") + ", nomeViaggio=" + rs.getString("nomeViaggio") + ", mezzo=" + rs.getString("mezzo") + ", Partenza="
				+ rs.getString("Partenza") + ", Ritorno=" + rs.getString("Ritorno"));
 
	}
	
	public void stampaAttivita(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idAttivita") + ", nomeAttivita=" + rs.getString("nomeAttivita") + ", oraInizio="
				+ rs.getString("oraInizio") + ", oraFine=" + rs.getString("oraFine") + ", luogo=" + rs.getString("luogo"));

	}
	
	
	
	public void testSelect() throws SQLException {
		ResultSet rsU = db.executeQuery("SELECT * FROM utente LIMIT 100");
		System.out.println("\n- Utente");
		while (rsU.next()) {
			stampaUtente(rsU);
		}
		
		ResultSet rs = db.executeQuery("SELECT * FROM viaggio LIMIT 100");
		System.out.println("\n- Viaggi");
		while (rs.next()) {
			stampaViaggio(rs);
		}
		
		ResultSet rsA = db.executeQuery("SELECT * FROM attivita LIMIT 100");
		System.out.println("\n- Attività");
		while (rsA.next()) {
			stampaAttivita(rsA);
		}
		
	}
	
		
	public void insertUtente(String nome, String cognome, String email, String citta) {
		Utente v = new Utente(java.util.UUID.randomUUID(), nome, cognome, email, citta);
		try {
			String query = String.format(
					"INSERT INTO utente (idUtente, nome, cognome, email, citta) VALUES ('%s', '%s', '%s', '%s', '%s')",
					v.getIdUtente().toString(), v.getNome(), v.getCognome(), v.getEmail(), v.getCitta());
			db.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		try {
			insertUtente("Martina","Carella","carellamartina@gmial.com","Modena");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}

	}	
	
	
	public void closeDB() {
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}

}
