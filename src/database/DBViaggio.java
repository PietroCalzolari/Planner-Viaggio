package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import graphicinterface.ControlPanel;
import plannerviaggio.Test;

public class DBViaggio extends JFrame{
	DBManager dbV;
	public static DBModelViaggio modelV;
	private JLabel inizio;

	public DBViaggio() throws SQLException{
		
		try {
			// Database manager for SQLite
			dbV = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);		
			
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
	
	
	public void printRow(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idViaggio") + ", nomeViaggio=" + rs.getString("nomeViaggio") + ", mezzo=" + rs.getString("mezzo") + ", Partenza="
				+ rs.getString("Partenza") + ", Ritorno=" + rs.getString("Ritorno"));
 
	}

	
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
