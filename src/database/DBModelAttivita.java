package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import graphicinterface.ControlPanel;
import plannerviaggio.Attivita;

public class DBModelAttivita {
	DBManager db;
	public static List<Attivita> la;
	int selectedIndex;
	
	public DBModelAttivita(DBManager db) {
		this.db = db;
		la = new ArrayList<Attivita>();

		try {
			ResultSet rs = db.executeQuery("SELECT * FROM attivita");
			while (rs.next()) {
				la.add(new Attivita(java.util.UUID.fromString(rs.getString("idAttivita")), rs.getString("nomeAttivita"), rs.getString("oraInizio"),
						rs.getString("oraFine"), rs.getString("luogo"), java.util.UUID.fromString(rs.getString("idViaggio"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		first();
	}
	
	public Attivita getSelectedItem() {
		return la.get(selectedIndex);
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void first() {
		selectedIndex = 0;
	}

	public void last() {
		selectedIndex = la.size() - 1;
	}

	public void next() {
		selectedIndex = Math.min(selectedIndex + 1, la.size() - 1);
	}

	public void previous() {
		selectedIndex = Math.max(selectedIndex - 1, 0);
	}

	public void insert(String nomeAttivita, String oraInizio, String oraFine, String luogo, UUID IDViaggio) {
		Attivita a = new Attivita(java.util.UUID.randomUUID(), nomeAttivita, oraInizio, oraFine, luogo, IDViaggio);
		try {
			String query = String.format(
					"INSERT INTO attivita (idAttivita, nomeAttivita, oraInizio, oraFine, luogo, idViaggio) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
					a.getIdAttivita().toString(), a.getNomeAttivita(), a.getOraInizio(), a.getOraFine(), a.getLuogo(), IDViaggio.toString());
			db.executeUpdate(query);
			la.add(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		last();
	}
	
	public void removeDaViaggio() {
		
		try {
			String query = String.format("SELECT * FROM attivita WHERE idViaggio='%s'", Database.modelViaggio.getSelectedItem().getIdViaggio());
			ResultSet rs = db.executeQuery(query);
			while (rs.next()) {
				String queryDelete = String.format("DELETE FROM attivita WHERE idAttivita='%s'", rs.getString("idAttivita"));
				db.executeUpdate(queryDelete);	
				la.remove(selectedIndex);
			}	
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		last();
	}
	
	public void remove() {
		try {
			String query = String.format("DELETE FROM attivita WHERE idAttivita='%s'", getSelectedItem().getIdAttivita());
			db.executeUpdate(query);
			la.remove(selectedIndex);
			previous();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showAttivita() {
		first();
		int c = 0;
		try {
			ResultSet rs = db.executeQuery("SELECT * FROM attivita");
			
		prova:
			while(rs.next()) {			
				if(Database.modelAttivita.getSelectedItem().getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {		
					ControlPanel.lblAttivita.setText(rs.getString("nomeAttivita"));
					ControlPanel.lblLuogo.setText(rs.getString("luogo"));
					ControlPanel.lblOraInizio.setText(rs.getString("oraInizio"));
					ControlPanel.lblOraFine.setText(rs.getString("oraFine"));
					c = 1;
					break prova;
				}	
				next();
			}	
			
		if(c == 0) {
			ControlPanel.cleanAttivita();
		}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showPrecAttivita(int index) {
		first();
		int i = index;
		try {
			ResultSet rs = db.executeQuery("SELECT * FROM attivita");		
			while(rs.next()) {		
				if(Database.modelAttivita.getSelectedIndex() < index) {
					if(Database.modelAttivita.getSelectedItem().getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {		
						ControlPanel.lblAttivita.setText(rs.getString("nomeAttivita"));
						ControlPanel.lblLuogo.setText(rs.getString("luogo"));
						ControlPanel.lblOraInizio.setText(rs.getString("oraInizio"));
						ControlPanel.lblOraFine.setText(rs.getString("oraFine"));
						i = Database.modelAttivita.getSelectedIndex();
					}
				}	
				next();
			}
			selectedIndex = i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showNextAttivita(int index) {
		first();
		try {
			ResultSet rs = db.executeQuery("SELECT * FROM attivita");
		
		prova:	
			while(rs.next()) {			
				if(Database.modelAttivita.getSelectedIndex() > index) {
					if(Database.modelAttivita.getSelectedItem().getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {		
						ControlPanel.lblAttivita.setText(rs.getString("nomeAttivita"));
						ControlPanel.lblLuogo.setText(rs.getString("luogo"));
						ControlPanel.lblOraInizio.setText(rs.getString("oraInizio"));
						ControlPanel.lblOraFine.setText(rs.getString("oraFine"));
						break prova;
					}
				}	
				next();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showAttivitaInserita() {
		try {
			String query = String.format("SELECT * FROM attivita WHERE idAttivita='%s'", getSelectedItem().getIdAttivita());
			ResultSet rs = db.executeQuery(query);
			
			ControlPanel.lblAttivita.setText(rs.getString("nomeAttivita"));
			ControlPanel.lblLuogo.setText(rs.getString("luogo"));
			ControlPanel.lblOraInizio.setText(rs.getString("oraInizio"));
			ControlPanel.lblOraFine.setText(rs.getString("oraFine"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void setnomeAttivita(String nomeAttivita) {
		String query = String.format("UPDATE attivita SET nomeAttivita=%s WHERE id='%s'", nomeAttivita, getSelectedItem().getIdAttivita());
		try {
			db.executeUpdate(query);
			getSelectedItem().setNomeAttivita(nomeAttivita);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setoraInizio(String oraInizio) {
		String query = String.format("UPDATE attivita SET oraInizio=%s WHERE id='%s'", oraInizio, getSelectedItem().getIdAttivita());
		try {
			db.executeUpdate(query);
			getSelectedItem().setOraInizio(oraInizio);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setoraFine(String oraFine) {
		String query = String.format("UPDATE attivita SET oraFine=%s WHERE id='%s'", oraFine, getSelectedItem().getIdAttivita());
		try {
			db.executeUpdate(query);
			getSelectedItem().setOraFine(oraFine);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setluogo(String luogo) {
		String query = String.format("UPDATE attivita SET luogo=%s WHERE id='%s'", luogo, getSelectedItem().getIdAttivita());
		try {
			db.executeUpdate(query);
			getSelectedItem().setLuogo(luogo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
