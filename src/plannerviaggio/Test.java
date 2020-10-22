package plannerviaggio;

import database.Database;
import graphicinterface.ControlPanel;

import java.awt.EventQueue;
import java.sql.SQLException;

public class Test {
	/*
	 * Questa classe la useremo come Main per far andare la nostra applicazione e per testarla.
	 * Non ha attributi e ha il metodo main.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel frame = new ControlPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//Apro la connessione ai database
		try {
			new Database().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//Chiudo la connessione ai database
		/*
		try {
			System.out.println("\n- closing database...");
			new Database().closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}
	
}