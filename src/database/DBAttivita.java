package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import plannerviaggio.Attivita;

public class DBAttivita{
	protected DBManager db;

	public DBAttivita() throws SQLException{
		
		try {
			// Database manager for SQLite
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			
			//Database manager for MySQL
			//db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL);
			
			
			db.executeQuery("SELECT * FROM attività LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS attività");
			db.executeUpdate("CREATE TABLE attività (" + "id INTEGER PRIMARY KEY, " + "nomeAttività VARCHAR(30), "
					+ "oraInizio TEXT, " + "oraFine TEXT, " + "luogo VARCHAR(30))");
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints the current ResultSet row
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public void printRow(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getInt("id") + ", nomeAttivita=" + rs.getString("nomeAttivita") + ", oraInizio="
				+ rs.getString("oraInizio") + ", oraFine=" + rs.getString("oraFine") + ", luogo=" + rs.getString("luogo"));

	}

	/**
	 * Reads the content of the person table Results are limited using "LIMIT 100"
	 * This is useful for very large tables
	 * 
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM attivita LIMIT 100");
		while (rs.next()) {
			printRow(rs);
		}
	}

	/**
	 * Update the content of the attività table
	 * 
	 * @throws SQLException
	 */
	
	Attivita museo = new Attivita("Museo di quadri di roma", "11:30", "13:00", "Piazza");
	
	public void testUpdate() throws SQLException {
	
		String query = String.format(
				"INSERT INTO attivit� (id, nomeAttivita, oraInizio, oraFine, luogo) VALUES (3, '%s', '%s', '%s', '%s')",
				 museo.getNomeAttivita(), museo.getOraInizio(), museo.getOraFine(), museo.getLuogo());
		db.executeUpdate(query);
		
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