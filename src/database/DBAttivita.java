package database;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DBAttivita{
	DBManager dbA;
	DBModelAttivita modelA;

	public DBAttivita() throws SQLException{
		
		try {
			// Database manager for SQLite
			dbA = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			
			//Database manager for MySQL
			//db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL);
			
			
			dbA.executeQuery("SELECT * FROM attivita LIMIT 1");
		} catch (SQLException e) {
			dbA.executeUpdate("DROP TABLE IF EXISTS attività");
			dbA.executeUpdate("CREATE TABLE attivita (" + "idAttivita VARCHAR(50) PRIMARY KEY, " + "nomeAttivita VARCHAR(30), "
					+ "oraInizio TEXT, " + "oraFine TEXT, " + "luogo VARCHAR(30))");
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		modelA = new DBModelAttivita(dbA);
	}
	
	/**
	 * Stampa la riga corrente del ResultSet
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public void printRow(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idAttivita") + ", nomeAttivita=" + rs.getString("nomeAttivita") + ", oraInizio="
				+ rs.getString("oraInizio") + ", oraFine=" + rs.getString("oraFine") + ", luogo=" + rs.getString("luogo"));

	}

	/**
	 * Reads the content of the person table Results are limited using "LIMIT 100"
	 * This is useful for very large tables
	 * 
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {
		ResultSet rs = dbA.executeQuery("SELECT * FROM attivita LIMIT 100");
		while (rs.next()) {
			printRow(rs);
		}
	}

	/**
	 * Update the content of the attività table
	 * 
	 * @throws SQLException
	 */
	public void testUpdate() throws SQLException {
		
		modelA.insert("Museo di Roma", "14,00", "15,30", "Piazza");
		
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

	}
	
	public void closeDB() {
		try {
			System.out.println("\n- closing database...");
			dbA.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}
	
}