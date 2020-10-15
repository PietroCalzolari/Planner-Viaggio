package plannerviaggio;

import src.plannerviaggio.Attività;
import src.plannerviaggio.DBAttività;
import src.plannerviaggio.DBViaggio;
import src.plannerviaggio.SQLException;
import src.plannerviaggio.Utente;
import src.plannerviaggio.Viaggio;

public class Test {
	/*
	 * Questa classe la useremo come Main per far andare la nostra applicazione e per testarla.
	 * Non ha attributi e ha il metodo main.
	 */
	public static void main(String[] args) {
		//Facciamo una prova per vedere se le classi circa vanno bene
		
		Utente piter = new Utente("Pietro", "Calzolari", 21, "12/04/1999", "CLZPTR99D12F257E", "pietrocalzolari@live.com", "Modena");
		Utente martina = new Utente("Martina", "Carella", 22, "22/01/1998", "BLABLABLA", "martinacarella@gmail.com", "Modena");
		Viaggio rome = new Viaggio("Roma", "Macchina", "23/05/2022", "26/05/2022");
		Viaggio newyork = new Viaggio("NewYork", "Aereo", "23/06/2022", "12/08/2022");
		Attività museo = new Attività("Museo di quadri di roma", " 24/05/2022", "11:30", "13:00");
		System.out.println(piter);
		System.out.println(martina);
		System.out.println(rome);
		System.out.println(newyork);
		System.out.println(museo);
		System.out.println("Se funziona sono troppo felice");

		//provo i database
		try {
			new DBViaggio().run();
			new DBAttività().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}