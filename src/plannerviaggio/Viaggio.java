package plannerviaggio;

import java.util.UUID;

public class Viaggio {
	
	UUID idViaggio;
	String nomeViaggio;
	String mezzo;
	String partenza;
	String ritorno;
	
	//costruttore
	public Viaggio(UUID idViaggio, String nomeViaggio, String mezzo, String partenza, String ritorno) {
		super();
		this.idViaggio = idViaggio;
		this.nomeViaggio = nomeViaggio;
		this.mezzo = mezzo;
		this.partenza = partenza;
		this.ritorno = ritorno;
	}
	
	
	//Getters and Setters
	public UUID getIdViaggio() {
		return idViaggio;
	}

	public void setIdViaggio(UUID idViaggio) {
		this.idViaggio = idViaggio;
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
		return "Viaggio [idViaggio=" + idViaggio + ", nomeViaggio=" + nomeViaggio + ", mezzo=" + mezzo + ", partenza="
				+ partenza + ", ritorno=" + ritorno + "]";
	}
	
}