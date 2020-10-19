package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import plannerviaggio.Viaggio;

public class DBModelViaggio {
	DBManager db;
	List<Viaggio> lv;
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

	public void insert(String nomeViaggio, String mezzo, String partenza, String ritorno) {
		Viaggio v = new Viaggio(java.util.UUID.randomUUID(), nomeViaggio, mezzo, partenza, ritorno);
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
	}
	
	public void remove() {
		try {
			String query = String.format("DELETE FROM viaggio WHERE id='%s'", getSelectedItem().getIdViaggio());
			db.executeUpdate(query);
			lv.remove(selectedIndex);
			previous();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setnomeViaggio(String nomeViaggio) {
		String query = String.format("UPDATE viaggio SET nomeViaggio=%s WHERE id='%s'", nomeViaggio, getSelectedItem().getIdViaggio());
		try {
			db.executeUpdate(query);
			getSelectedItem().setNomeViaggio(nomeViaggio);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setMezzo(String mezzo) {
		String query = String.format("UPDATE viaggio SET mezzo=%s WHERE id='%s'", mezzo, getSelectedItem().getIdViaggio());
		try {
			db.executeUpdate(query);
			getSelectedItem().setMezzo(mezzo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setPartenza(String partenza) {
		String query = String.format("UPDATE viaggio SET partenza=%s WHERE id='%s'", partenza, getSelectedItem().getIdViaggio());
		try {
			db.executeUpdate(query);
			getSelectedItem().setPartenza(partenza);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setRitorno(String ritorno) {
		String query = String.format("UPDATE viaggio SET ritorno=%s WHERE id='%s'", ritorno, getSelectedItem().getIdViaggio());
		try {
			db.executeUpdate(query);
			getSelectedItem().setRitorno(ritorno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
