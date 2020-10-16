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
		//Facciamo una prova per vedere se le classi circa vanno bene
		
		Utente piter = new Utente("Pietro", "Calzolari", 21, "12/04/1999", "CLZPTR99D12F257E", "pietrocalzolari@live.com", "Modena");
		Utente martina = new Utente("Martina", "Carella", 22, "22/01/1998", "BLABLABLA", "martinacarella@gmail.com", "Modena");
		Attivita museo = new Attivita("Museo di quadri di roma", " 24/05/2022", "11:30", "13:00");
		System.out.println(piter);
		System.out.println(martina);
		System.out.println(museo);
		System.out.println("Se funziona sono troppo felice");
		System.out.println("Speriamo funzioni anche questa volta");
		new ControlPanel();
		
		try {
			new DBViaggio().run();
			new DBAttivita().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}