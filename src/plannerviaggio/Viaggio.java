package plannerviaggio;

public class Viaggio {
	
	/*
	 * Questa classe rappresenta i viaggi.
	 * Un oggetto viaggio avrà i seguenti attributi:
	 * nomeViaggio: nome del viaggio
	 * mezzo: il mezzo di trasporto del viaggio(aereo, treno, autobus, macchina, camper, ...)
	 * partenza: data di partenza del viaggio
	 * ritorno: data di ritorno o arrivo del viaggio
	 */

	String nomeViaggio;
	String mezzo;
	String partenza;
	String ritorno;
	
	//costruttore
	public Viaggio(String nomeViaggio, String mezzo, String partenza, String ritorno) {
		super();
		this.nomeViaggio = nomeViaggio;
		this.mezzo = mezzo;
		this.partenza = partenza;
		this.ritorno = ritorno;
	}
	//Getters and Setters
	public String getNomeViaggio() {
		return nomeViaggio;
	}
	public void setNomeViaggio(String nomeViaggio) {
		this.nomeViaggio = nomeViaggio;
	}
	public String getMezzo() {
		return mezzo;
	}
	public void setMezzo(String mezzo) {
		this.mezzo = mezzo;
	}
	public String getPartenza() {
		return partenza;
	}
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}
	public String getRitorno() {
		return ritorno;
	}
	public void setRitorno(String ritorno) {
		this.ritorno = ritorno;
	}
	//toString
	@Override
	public String toString() {
		return "Viaggio [nomeViaggio=" + nomeViaggio + ", mezzo=" + mezzo + ", partenza=" + partenza + ", ritorno=" + ritorno
				+ "]";
	}
	

}