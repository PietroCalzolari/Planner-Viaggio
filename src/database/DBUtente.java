package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import plannerviaggio.Utente;

public class DBUtente {
	DBManager dbU;
	
public DBUtente() throws SQLException{
		
		try {
			// Database manager for SQLite
			dbU = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			
			dbU.executeQuery("SELECT * FROM utente LIMIT 1");
		} catch (SQLException e) {
			dbU.executeUpdate("DROP TABLE IF EXISTS utente");
			dbU.executeUpdate("CREATE TABLE utente (" + "idUtente VARCHAR(50) PRIMARY KEY, " + "nome TEXT, " + "cognome TEXT, "
					+ "email TEXT, " + "citta TEXT)");
			
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	public void printRow(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idUtente") + ", nome=" + rs.getString("nome") + ", cognome=" + rs.getString("cognome") + ", email="
			+ rs.getString("email") + ", citta=" + rs.getString("citta"));

	}
	
	
	public void testSelect() throws SQLException {
		ResultSet rs = dbU.executeQuery("SELECT * FROM utente LIMIT 100");
		while (rs.next()) {
			printRow(rs);
		}
	}
	
		
	public void insert(String nome, String cognome, String email, String citta) {
		Utente v = new Utente(java.util.UUID.randomUUID(), nome, cognome, email, citta);
		try {
			String query = String.format(
					"INSERT INTO utente (idUtente, nome, cognome, email, citta) VALUES ('%s', '%s', '%s', '%s', '%s')",
					v.getIdUtente().toString(), v.getNome(), v.getCognome(), v.getEmail(), v.getCitta());
			dbU.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}

		System.out.println("\n- updating database...");
		insert("Martina","Carella","carellamartina@gmial.com","Modena");

		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}	
	
	
	public void closeDB() {
		try {
			dbU.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}

}
