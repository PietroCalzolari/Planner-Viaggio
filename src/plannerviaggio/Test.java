package plannerviaggio;
import database.DBAttivita;
import database.DBUtente;
import database.DBViaggio;
import graphicinterface.ControlPanel;

import java.sql.SQLException;

public class Test {
	/*
	 * Questa classe la useremo come Main per far andare la nostra applicazione e per testarla.
	 * Non ha attributi e ha il metodo main.
	 */
	
	public static void main(String[] args) {
		new ControlPanel();
		
		//Apro la connessione ai database
		try {
			new DBViaggio().run();
			new DBAttivita().run();
			//new DBUtente().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//Chiudo la connessione ai database
		try {
			System.out.println("\n- closing database...");
			new DBViaggio().closeDB();
			new DBAttivita().closeDB();
			//new DBUtente().closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}