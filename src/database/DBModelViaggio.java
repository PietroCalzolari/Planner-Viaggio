package database;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import graphicinterface.ControlPanel;
import plannerviaggio.Viaggio;

public class DBModelViaggio {
	DBManager db;
	public static List<Viaggio> lv;
	int selectedIndex;
	
	
	public DBModelViaggio(DBManager db) {
		this.db = db;
		lv = new ArrayList<Viaggio>();

		try {
			ResultSet rs = db.executeQuery("SELECT * FROM viaggio");
			while (rs.next()) {
				lv.add(new Viaggio(java.util.UUID.fromString(rs.getString("idViaggio")), rs.getString("nomeViaggio"), rs.getString("mezzo"),
						rs.getString("partenza"), rs.getString("ritorno")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		first();
	}
	
	public Viaggio getSelectedItem() {
		return lv.get(selectedIndex);
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void first() {
		selectedIndex = 0;
	}

	public void last() {
		selectedIndex = lv.size() - 1;
	}

	public void next() {
		selectedIndex = Math.min(selectedIndex + 1, lv.size() - 1);
	}

	public void previous() {
		selectedIndex = Math.max(selectedIndex - 1, 0);
	}
	

	public void insert(UUID idViaggio, String nomeViaggio, String mezzo, String partenza, String ritorno) {
		Viaggio v = new Viaggio(idViaggio, nomeViaggio, mezzo, partenza, ritorno);
		try {
			String query = String.format(
					"INSERT INTO viaggio (idViaggio, nomeViaggio, mezzo, partenza, ritorno) VALUES ('%s', '%s', '%s', '%s', '%s')",
					v.getIdViaggio().toString(), v.getNomeViaggio(), v.getMezzo(), v.getPartenza(), v.getRitorno());
			db.executeUpdate(query);
			lv.add(v);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		last();
		
		int num = lv.size();
		String s = String.valueOf(num);
		ControlPanel.lblNumeroViaggiTotali.setText(s);
	}
	
	
	public void remove() {
		Database.modelAttivita.removeDaViaggio();
		
		try {
			String query = String.format("DELETE FROM viaggio WHERE idViaggio='%s'", getSelectedItem().getIdViaggio());
			db.executeUpdate(query);
			lv.remove(selectedIndex);
			previous();
			showItem();
			Database.modelAttivita.showAttivita();
		} catch (IndexOutOfBoundsException e) {
			last();
			ControlPanel.cleanViaggio();
			Toolkit.getDefaultToolkit().beep();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int num = lv.size();
		String s = String.valueOf(num);
		ControlPanel.lblNumeroViaggiTotali.setText(s);
	}
	
	
	public void showItem() {
		try {
			String query = String.format("SELECT * FROM viaggio WHERE idViaggio='%s'", getSelectedItem().getIdViaggio());
			ResultSet rs = db.executeQuery(query);
			
			ControlPanel.lblViaggio.setText(rs.getString("nomeViaggio"));
			ControlPanel.lblTrasporto.setText(rs.getString("mezzo"));
			ControlPanel.lblDataPartenzaViaggio.setText(rs.getString("partenza"));
			ControlPanel.lblDataRitornoViaggio.setText(rs.getString("ritorno"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
