package plannerviaggio;

import graphicinterface.ControlPanel;
import java.awt.EventQueue;

public class Test {
	
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