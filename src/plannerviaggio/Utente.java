package plannerviaggio;

import java.util.UUID;

public class Utente {
	/*
	 * Con questa classe definiamo l'utente che utilizza l'applicaizone
	 * Ha come attributi i seguenti:
	 * nome: nome dell'utente
	 * cognome: cognome dell'utente
	 * email: email dell'utente
	 * citta: la citta di residenza dell'utente
	 */
	
	UUID idUtente;
	String nome;
	String cognome;
	String email;
	String citta;
	
	//Costruttore
	public Utente(UUID idUtente, String nome, String cognome, String email, String citta) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.citta = citta;
	}

	//Getters and Setters

	public UUID getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(UUID idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", citta="
				+ citta + "]";
	}
	
	
}
