package plannerviaggio;

public class Utente {
	/*
	 * Questa è la classe con cui definiamo ogni Utente.
	 * Ha come attributi i seguenti:
	 * name: nome dell'utente
	 * surname: cognome dell'utente
	 * eta: eta dell'utente
	 * born: data di nascita dell'utente
	 * codicefiscale: codicefiscale dell'utente
	 * email: email dell'utente
	 * citta: la citta di residenza dell'utente
	 */
	String nome;
	String cognome;
	double eta;
	String dataNascita;
	String codiceFiscale;
	String email;
	String citta;
	
	//Costruttore
	public Utente(String nome, String cognome, double eta, String dataNascita, String codiceFiscale, String email, String citta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.email = email;
		this.citta = citta;
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
	
	public double getEta() {
		return eta;
	}

	public void setEta(double eta) {
		this.eta = eta;
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
		return citta;
	}

	public void setCittà(String citta) {
		this.citta = citta;
	}

	//toString
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", dataNascita=" + dataNascita
				+ ", codiceFiscale=" + codiceFiscale + ", email=" + email + ", citta=" + citta + "]";
	}
	
}
