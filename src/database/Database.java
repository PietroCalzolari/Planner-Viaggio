package database;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import graphicinterface.ControlPanel;
import graphicinterface.FinestraIniziale;
import plannerviaggio.Utente;

public class Database {
	static DBManager db;
	public static DBModelViaggio modelViaggio;
	public static DBModelAttivita modelAttivita;

	
public Database() throws SQLException{
		
		try {
			// Database manager for SQLite
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			
			db.executeQuery("SELECT * FROM utente LIMIT 1");
			ControlPanel.lblCiao.setText("Ciao" + Database.nomeUtente());
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS utente");
			db.executeUpdate("CREATE TABLE utente (" + "idUtente VARCHAR(10) PRIMARY KEY, " + "nome TEXT, " + "cognome TEXT, " + "email TEXT)");
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FinestraIniziale login = new FinestraIniziale();
						login.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet rs = db.executeQuery("SELECT * FROM viaggio LIMIT 1");
			ControlPanel.lblViaggio.setText(rs.getString("nomeViaggio"));
			ControlPanel.lblTrasporto.setText(rs.getString("mezzo"));
			ControlPanel.lblDataPartenzaViaggio.setText(rs.getString("partenza"));
			ControlPanel.lblDataRitornoViaggio.setText(rs.getString("ritorno"));
			
			ControlPanel.giorni(rs.getString("partenza"));
			
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS viaggio");
			db.executeUpdate("CREATE TABLE viaggio (" + "idViaggio VARCHAR(10) PRIMARY KEY, " + "nomeViaggio VARCHAR(30), " + "mezzo TEXT, " + "Partenza TEXT, " + "Ritorno TEXT)");
			
			ControlPanel.cleanViaggio();
			ControlPanel.lblNumeroViaggiTotali.setText("0");
			ControlPanel.lblIndiceViaggio.setText("0");
		}
		
		modelViaggio = new DBModelViaggio(db);
		
		if(DBModelViaggio.lv.size() != 0) {
			int num = DBModelViaggio.lv.size();
			String s = String.valueOf(num);
			ControlPanel.lblNumeroViaggiTotali.setText(s);
			ControlPanel.lblIndiceViaggio.setText(IndiceViaggio());
		}
		
		try {	
			db.executeQuery("SELECT * FROM attivita");
			
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS attivita");
			db.executeUpdate("CREATE TABLE attivita (" + "idAttivita VARCHAR(10) PRIMARY KEY, " + "nomeAttivita VARCHAR(30), " + "oraInizio TEXT, " + "oraFine TEXT, " + "luogo TEXT, "
					+ "idViaggio VARCHAR(50) REFERENCES viaggio(idViaggio))");
			
			ControlPanel.cleanAttivita();	
			ControlPanel.lblNumeroAttivitaTotali.setText("0");
			ControlPanel.indiceAttivita = 0;
			DBModelAttivita.convertIndexAttivita();
		} 
		
		modelAttivita = new DBModelAttivita(db);
		
		Database.modelAttivita.setNumAttivitaTotali(Database.modelAttivita.getSelectedIndex());
		Database.modelAttivita.showAttivita();
	}

	public static String IndiceViaggio() {
		int i = modelViaggio.getSelectedIndex() + 1;
		String s = String.valueOf(i);
		return s;
	}

	public void stampaUtente(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idUtente") + ", nome=" + rs.getString("nome") + ", cognome=" + rs.getString("cognome") + ", email=" + rs.getString("email"));

	}
	
	public void stampaViaggio(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idViaggio") + ", nomeViaggio=" + rs.getString("nomeViaggio") + ", mezzo=" + rs.getString("mezzo") + ", Partenza="
				+ rs.getString("Partenza") + ", Ritorno=" + rs.getString("Ritorno"));
 
	}
	
	public void stampaAttivita(ResultSet rs) throws SQLException {
		System.out.println("id=" + rs.getString("idAttivita") + ", nomeAttivita=" + rs.getString("nomeAttivita") + ", oraInizio="
				+ rs.getString("oraInizio") + ", oraFine=" + rs.getString("oraFine") + ", luogo=" + rs.getString("luogo"));

	}
	
	
	
	public void testDB() throws SQLException {
		ResultSet rsU = db.executeQuery("SELECT * FROM utente LIMIT 100");
		System.out.println("\n- Utente");
		while (rsU.next()) {
			stampaUtente(rsU);
		}
		
		ResultSet rs = db.executeQuery("SELECT * FROM viaggio LIMIT 100");
		System.out.println("\n- Viaggi");
		while (rs.next()) {
			stampaViaggio(rs);
		}
		
		ResultSet rsA = db.executeQuery("SELECT * FROM attivita LIMIT 100");
		System.out.println("\n- Attività");
		while (rsA.next()) {
			stampaAttivita(rsA);
		}
		
	}
			
	public static void insertUtente(String nome, String cognome, String email) {
		Utente v = new Utente(java.util.UUID.randomUUID(), nome, cognome, email);
		try {
			String query = String.format(
					"INSERT INTO utente (idUtente, nome, cognome, email) VALUES ('%s', '%s', '%s', '%s')",
					v.getIdUtente().toString(), v.getNome(), v.getCognome(), v.getEmail());
			db.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String nomeUtente() {
		ResultSet rs;
		try {
			 rs = db.executeQuery("SELECT * FROM utente LIMIT 1");
			 return " " + rs.getString("nome") + "!";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "!";
	}
	
	public void closeDB() {
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}

}
