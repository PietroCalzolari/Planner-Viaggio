package plannerviaggio;

import java.util.UUID;

public class Utente {
	
	UUID idUtente;
	String nome;
	String cognome;
	String email;
	String citta;
	
	//Costruttore
	public Utente(UUID idUtente, String nome, String cognome, String email) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
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


	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + "]";
	}
	
	
}
