package database;

import java.awt.Toolkit;
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
		first();
		
		try {
			String queryDelete = String.format("DELETE FROM attivita WHERE idViaggio='%s'", Database.modelViaggio.getSelectedItem().getIdViaggio());
			db.executeUpdate(queryDelete);	
			
			while(selectedIndex < la.size()) {
				if(la.get(selectedIndex).getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {
					la.remove(selectedIndex);
					continue;
				}
				next();
				
				if(selectedIndex == (la.size() - 1)) {
					if(la.get(selectedIndex).getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {
						la.remove(selectedIndex);
					}
					break;
				}
			}	
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		last();
		ControlPanel.cleanAttivita();
	}
	
	public void remove() {
		int index, returnIndex;
		try {
			
			if(getSelectedIndex() < (la.size() - 1)) {
				index = getSelectedIndex();
				showNextAttivita(getSelectedIndex());
				returnIndex = getSelectedIndex();
				
				if(getSelectedItem().getIdViaggioA().toString().equals(la.get(index).getIdViaggioA().toString())) {		
					selectedIndex = index;
					String query = String.format("DELETE FROM attivita WHERE idAttivita='%s'", getSelectedItem().getIdAttivita());
					db.executeUpdate(query);
					la.remove(selectedIndex);
					selectedIndex = returnIndex - 1;
					return;
				}
				selectedIndex = index;
			}
			
			if(getSelectedIndex() > 0) {
				index = getSelectedIndex();
				showPrecAttivita(getSelectedIndex());
				returnIndex = getSelectedIndex();
				
				if((index != getSelectedIndex()) && getSelectedItem().getIdViaggioA().toString().equals(la.get(index).getIdViaggioA().toString())) {	
					selectedIndex = index;
					
					String query = String.format("DELETE FROM attivita WHERE idAttivita='%s'", getSelectedItem().getIdAttivita());
					db.executeUpdate(query);
					la.remove(selectedIndex);
					selectedIndex = returnIndex;
					return;
				}
				selectedIndex = index;
				
				String query = String.format("DELETE FROM attivita WHERE idAttivita='%s'", getSelectedItem().getIdAttivita());
				db.executeUpdate(query);
				la.remove(selectedIndex);
				ControlPanel.cleanAttivita();
			}else {
				String query = String.format("DELETE FROM attivita WHERE idAttivita='%s'", getSelectedItem().getIdAttivita());
				db.executeUpdate(query);
				la.remove(selectedIndex);
				ControlPanel.cleanAttivita();
			}
			
		} catch (IndexOutOfBoundsException e) {
			Toolkit.getDefaultToolkit().beep();
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
				if(getSelectedItem().getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {		
					ControlPanel.lblAttivita.setText(rs.getString("nomeAttivita"));
					ControlPanel.lblLuogo.setText(rs.getString("luogo"));
					ControlPanel.lblOraInizio.setText(rs.getString("oraInizio"));
					ControlPanel.lblOraFine.setText(rs.getString("oraFine"));
					c = 1;
					break prova;
				}	
				next();
			}	
			
		ControlPanel.showLabelAttivitaBellezza();
			
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
				if(getSelectedIndex() < index) {
					if(getSelectedItem().getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {		
						ControlPanel.lblAttivita.setText(rs.getString("nomeAttivita"));
						ControlPanel.lblLuogo.setText(rs.getString("luogo"));
						ControlPanel.lblOraInizio.setText(rs.getString("oraInizio"));
						ControlPanel.lblOraFine.setText(rs.getString("oraFine"));
						i = getSelectedIndex();
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
				if(getSelectedIndex() > index) {
					if(getSelectedItem().getIdViaggioA().toString().equals(Database.modelViaggio.getSelectedItem().getIdViaggio().toString())) {		
						ControlPanel.lblAttivita.setText(rs.getString("nomeAttivita"));
						ControlPanel.lblLuogo.setText(rs.getString("luogo"));
						ControlPanel.lblOraInizio.setText(rs.getString("oraInizio"));
						ControlPanel.lblOraFine.setText(rs.getString("oraFine"));
						break prova;
					}
				}	
				next();
			}
			ControlPanel.showLabelAttivitaBellezza();
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
			ControlPanel.showLabelAttivitaBellezza();
			
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
