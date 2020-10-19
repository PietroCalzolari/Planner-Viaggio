package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBViaggio {
	DBManager dbV;
	DBModelViaggio modelV;

	public DBViaggio() throws SQLException{
		
		try {
			// Database manager for SQLite
			dbV = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			
			//Database manager for MySQL
			//db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL, ResultSet.TYPE_SCROLL_SENSITIVE,
			//		ResultSet.CONCUR_UPDATABLE);

			//db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL);
			
			
			dbV.executeQuery("SELECT * FROM viaggio LIMIT 1");
		} catch (SQLException e) {
			dbV.executeUpdate("DROP TABLE IF EXISTS viaggio");
			dbV.executeUpdate("CREATE TABLE viaggio (" + "idViaggio VARCHAR(50) PRIMARY KEY, " + "nomeViaggio VARCHAR(30), " + "mezzo TEXT, "
					+ "Partenza TEXT, " + "Ritorno TEXT)");
			
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		modelV = new DBModelViaggio(dbV);
	}
	
	/**
	 * Stampa la riga del ResultSet corrente
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public void printRow(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idViaggio") + ", nomeViaggio=" + rs.getString("nomeViaggio") + ", mezzo=" + rs.getString("mezzo") + ", Partenza="
				+ rs.getString("Partenza") + ", Ritorno=" + rs.getString("Ritorno"));
 
	}

	/**
	 * Reads the content of the person table Results are limited using "LIMIT 100"
	 * This is useful for very large tables
	 * 
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {
		ResultSet rs = dbV.executeQuery("SELECT * FROM viaggio LIMIT 100");
		while (rs.next()) {
			printRow(rs);
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
		modelV.insert("Milano", "Aereo", "10/05/2021", "15/05/2021");
		modelV.insert("Roma", "Treno", "22/01/2021", "30/01/2021");
		modelV.insert("Napoli", "Auto", "15/08/2021", "28/08/2021");

		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}	
	
	
	public void closeDB() {
		try {
			dbV.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}

	
}
