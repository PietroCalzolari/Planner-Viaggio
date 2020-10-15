package plannerviaggio;

public class Attività {
	
	/* PER IL MOMENTO L'HO USATA COME CLASSE SEPARATA E NON SOTTOCLASSE DI VIAGGIO
	 * 
	 * (Questa è una classe che implementa la classe Viaggio poichè ogni Attività sarà
	 * incorporata in un viaggio.) 
	 * Gli attributi sono:
	 *  * nomeactivity: la stringa che usiamo per chiamare la attività o per descriverla a parole
	 * dataactivity: la data in cui sarà la attività
	 * orainizio: l'ora iniziale dell'attività
	 * orafine: l'ora in cui l'attività finisce
	 */

	String nomeAttività;
	String oraInizio;
	String oraFine;
	String luogo;

	//costruttore
	public Attività(String nomeAttività, String oraInizio, String oraFine, String luogo) {
		super();
		this.nomeAttività = nomeAttività;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.luogo = luogo;
	}
	//Getters and Setters
	public String getNomeAttività() {
		return nomeAttività;
	}

	public void setNomeAttività(String nomeAttività) {
		this.nomeAttività = nomeAttività;
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
		return "Attività [nomeAttività=" + nomeAttività + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine
				+ ", luogo=" + luogo + "]";
	}

}
