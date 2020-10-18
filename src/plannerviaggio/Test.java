package plannerviaggio;
import database.DBAttivita;
import database.DBViaggio;
import graphicinterface.ControlPanel;

import java.sql.SQLException;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class Test {
	/*
	 * Questa classe la useremo come Main per far andare la nostra applicazione e per testarla.
	 * Non ha attributi e ha il metodo main.
	 */
	public static void main(String[] args) {
		new ControlPanel();
		try {
			new DBViaggio().run();
			new DBAttivita().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}