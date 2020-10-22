package plannerviaggio;

import java.util.UUID;

public class Attivita {

	UUID idAttivita;
	String nomeAttivita;
	String oraInizio;
	String oraFine;
	String luogo;

	//costruttore
	public Attivita(UUID idAttivita, String nomeAttivita, String oraInizio, String oraFine, String luogo) {
		super();
		this.idAttivita = idAttivita;
		this.nomeAttivita = nomeAttivita;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.luogo = luogo;
	}
	
	
	//Getters and Setters
	public UUID getIdAttivita() {
		return idAttivita;
	}

	public void setIdAttivita(UUID idAttivita) {
		this.idAttivita = idAttivita;
	}

	public String getNomeAttivita() {
		return nomeAttivita;
	}

	public void setNomeAttivita(String nomeAttivita){
		this.nomeAttivita = nomeAttivita;
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
	
	
	@Override
	public String toString() {
		return "Attivita [idAttivita=" + idAttivita + ", nomeAttivita=" + nomeAttivita + ", oraInizio=" + oraInizio
				+ ", oraFine=" + oraFine + ", luogo=" + luogo + "]";
	}
	

}
