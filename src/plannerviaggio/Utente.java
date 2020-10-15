package plannerviaggio;

public class Utente {
	/*
	 * Questa � la classe con cui definiamo ogni Utente.
	 * Ha come attributi i seguenti:
	 * name: nome dell'utente
	 * surname: cognome dell'utente
	 * age: et� dell'utente
	 * born: data di nascita dell'utente
	 * codicefiscale: codicefiscale dell'utente
	 * email: email dell'utente
	 * city: la citt� di residenza dell'utente
	 */
	String nome;
	String cognome;
	double et�;
	String dataNascita;
	String codiceFiscale;
	String email;
	String citt�;
	
	//Costruttore
	public Utente(String nome, String cognome, double et�, String dataNascita, String codiceFiscale, String email, String citt�) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.et� = et�;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.email = email;
		this.citt� = citt�;
	}

	//Getters and Setters
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
	
	public double getEt�() {
		return et�;
	}

	public void setEt�(double et�) {
		this.et� = et�;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCitt�() {
		return citt�;
	}

	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}

	//toString
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", et�=" + et� + ", dataNascita=" + dataNascita
				+ ", codiceFiscale=" + codiceFiscale + ", email=" + email + ", citt�=" + citt� + "]";
	}
	
}
