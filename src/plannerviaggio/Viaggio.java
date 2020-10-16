package plannerviaggio;

import java.util.UUID;

public class Viaggio {
	
	/*
	 * Questa classe rappresenta i viaggi.
	 * Un oggetto viaggio avr� i seguenti attributi:
	 * nomeViaggio: nome del viaggio
	 * mezzo: il mezzo di trasporto del viaggio(aereo, treno, autobus, macchina, camper, ...)
	 * partenza: data di partenza del viaggio
	 * ritorno: data di ritorno o arrivo del viaggio
	 */

	UUID id;
	String nomeViaggio;
	String mezzo;
	String partenza;
	String ritorno;
	
	//costruttore
	public Viaggio(UUID id, String nomeViaggio, String mezzo, String partenza, String ritorno) {
		super();
		this.id = id;
		this.nomeViaggio = nomeViaggio;
		this.mezzo = mezzo;
		this.partenza = partenza;
		this.ritorno = ritorno;
	}
	//Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
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