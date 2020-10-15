package plannerviaggio;

public class Utente {
	/*
	 * Questa è la classe con cui definiamo ogni Utente.
	 * Ha come attributi i seguenti:
	 * name: nome dell'utente
	 * surname: cognome dell'utente
	 * age: età dell'utente
	 * born: data di nascita dell'utente
	 * codicefiscale: codicefiscale dell'utente
	 * email: email dell'utente
	 * city: la città di residenza dell'utente
	 */
	String nome;
	String cognome;
	double età;
	String dataNascita;
	String codiceFiscale;
	String email;
	String città;
	
	//Costruttore
	public Utente(String nome, String cognome, double età, String dataNascita, String codiceFiscale, String email, String città) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.età = età;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.email = email;
		this.città = città;
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
	
	public double getEtà() {
		return età;
	}

	public void setEtà(double età) {
		this.età = età;
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

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	//toString
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", età=" + età + ", dataNascita=" + dataNascita
				+ ", codiceFiscale=" + codiceFiscale + ", email=" + email + ", città=" + città + "]";
	}
	
}
