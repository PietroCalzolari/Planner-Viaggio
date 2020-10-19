package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBViaggio {
	DBManager db;
	DBModelViaggio model;

	public DBViaggio() throws SQLException{
		
		try {
			// Database manager for SQLite
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			
			//Database manager for MySQL
			//db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL, ResultSet.TYPE_SCROLL_SENSITIVE,
			//		ResultSet.CONCUR_UPDATABLE);

			//db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL);
			
			
			db.executeQuery("SELECT * FROM viaggio LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS viaggio");
			db.executeUpdate("CREATE TABLE viaggio (" + "id VARCHAR(50) PRIMARY KEY, " + "nomeViaggio VARCHAR(30), " + "mezzo TEXT, "
					+ "Partenza TEXT, " + "Ritorno TEXT)");
			
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		model = new DBModelViaggio(db);
	}
	
	/**
	 * Stampa la riga del ResultSet corrente
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public void printRow(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("id") + ", nomeViaggio=" + rs.getString("nomeViaggio") + ", Partenza="
				+ rs.getString("Partenza") + ", Ritorno=" + rs.getString("Ritorno"));
 
	}

	/**
	 * Reads the content of the person table Results are limited using "LIMIT 100"
	 * This is useful for very large tables
	 * 
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM viaggio LIMIT 100");
		while (rs.next()) {
			printRow(rs);
		}
	}
	
	/**
	 * Modifiche alla tabella viaggio 
	 * 
	 * @throws SQLException
	 */
	public void testUpdate() throws SQLException {
		
		String query = String.format(
				"INSERT INTO viaggio (id, nomeViaggio, mezzo, Partenza, Ritorno) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 'Roma', 'Auto', '22/01/2021', '27/01/2021')");
		db.executeUpdate(query);
					
		String query2 = String.format(
				"INSERT INTO viaggio (id, nomeViaggio, mezzo, Partenza, Ritorno) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae80', 'Napoli', 'Aereo', '22/07/2021', '27/08/2021')");
		db.executeUpdate(query2);
		
	}

	
	public void run() {
		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}

		try {
			System.out.println("\n- updating database...");
			testUpdate();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}

		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}

		try {
			System.out.println("\n- closing database...");
			db.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}

	
}
