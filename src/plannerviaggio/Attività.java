package plannerviaggio;

public class Attivit� {
	
	/* PER IL MOMENTO L'HO USATA COME CLASSE SEPARATA E NON SOTTOCLASSE DI VIAGGIO
	 * 
	 * (Questa � una classe che implementa la classe Viaggio poich� ogni Attivit� sar�
	 * incorporata in un viaggio.) 
	 * Gli attributi sono:
	 *  * nomeactivity: la stringa che usiamo per chiamare la attivit� o per descriverla a parole
	 * dataactivity: la data in cui sar� la attivit�
	 * orainizio: l'ora iniziale dell'attivit�
	 * orafine: l'ora in cui l'attivit� finisce
	 */

	String nomeAttivit�;
	String oraInizio;
	String oraFine;
	String luogo;

	//costruttore
	public Attivit�(String nomeAttivit�, String oraInizio, String oraFine, String luogo) {
		super();
		this.nomeAttivit� = nomeAttivit�;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.luogo = luogo;
	}
	//Getters and Setters
	public String getNomeAttivit�() {
		return nomeAttivit�;
	}

	public void setNomeAttivit�(String nomeAttivit�) {
		this.nomeAttivit� = nomeAttivit�;
	}

	public String getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}

	public String getOraFine() {
		return oraFine;
	}

	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	//toString
	@Override
	public String toString() {
		return "Attivit� [nomeAttivit�=" + nomeAttivit� + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine
				+ ", luogo=" + luogo + "]";
	}

}
