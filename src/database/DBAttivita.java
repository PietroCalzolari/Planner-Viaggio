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
			
			
			dbA.executeQuery("SELECT * FROM attivita LIMIT 1");
		} catch (SQLException e) {
			dbA.executeUpdate("DROP TABLE IF EXISTS attivita");
			dbA.executeUpdate("CREATE TABLE attivita (" + "idAttivita VARCHAR(50) PRIMARY KEY, " + "nomeAttivita VARCHAR(30), " + "oraInizio TEXT, " + "oraFine TEXT, " + "luogo TEXT)");
			dbA.executeUpdate("CREATE TABLE ViaggioAttivita( idViaggio VARCHAR(50) NOT NULL, idAttivita VARCHAR(50) NOT NULL, PRIMARY KEY (idViaggio, idAttivita), FOREIGN KEY (idViaggio) REFERENCES viaggio (idViaggio), FOREIGN KEY (idAttivita) REFERENCES attivita (idAttivita))");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		modelA = new DBModelAttivita(dbA);
	}
	
	
	public void printRow(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idAttivita") + ", nomeAttivita=" + rs.getString("nomeAttivita") + ", oraInizio="
				+ rs.getString("oraInizio") + ", oraFine=" + rs.getString("oraFine") + ", luogo=" + rs.getString("luogo"));

	}

	
	public void testSelect() throws SQLException {
		ResultSet rs = dbA.executeQuery("SELECT * FROM attivita LIMIT 100");
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
		modelA.insert("Museo di Roma", "14,00", "15,30", "Piazza");

		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}

	}
	
	public void closeDB() {
		try {
			dbA.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}
	
}