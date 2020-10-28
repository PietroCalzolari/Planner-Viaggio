package graphicinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import database.DBModelAttivita;
import database.DBModelViaggio;
import database.Database;
import java.sql.SQLException;

import javax.swing.SwingConstants;


public class ControlPanel extends JFrame implements ActionListener {

	private static final long serialVersionUID = -2785150052774704558L;
	private JPanel contentPane; 
	private JPanel panelViaggio;
	private JButton btnAggViaggio;
	private JButton btnAggAttivita;
	private JButton btnEliminaViaggio;
	private JButton btnEliminaAttivita;
	private JPanel panel_1;
	public static JLabel lblViaggio;
	public static JLabel lblCiao;
	private JLabel lblTitoloViaggioBellezza;
	private JLabel lblTitoloAttivitaBellezza;
	public static JLabel lblAttivita;
	private static JLabel lblLuogoBellezza;
	public static JLabel lblLuogo;
	private static JLabel lblOraInizioBellezza;
	public static JLabel lblOraInizio;
	private static JLabel lblOraFineBellezza;
	public static JLabel lblOraFine;
	private JButton btnViaggioPrecedente;
	private JButton btnViaggioSuccessivo;
	private JButton btnAttivitaPrecedente;
	private JButton btnAttivitaSuccessiva;
	private static JLabel lblTrasportoBellezza;
	private static JLabel lblDataPartenzaViaggioBellezza;
	private static JLabel lblDataRitornoViaggioBellezza;
	public static JLabel lblTrasporto;
	public static JLabel lblDataPartenzaViaggio;
	public static JLabel lblDataRitornoViaggio;
	public static JLabel lblIndiceViaggio;
	public static JLabel lblIndiceAttivita;
	public static JLabel lblNumeroViaggiTotali;
	public static JLabel lblNumeroAttivitaTotali;
	private JLabel lblBarraViaggi;	
	private JLabel lblBarraAttivita;

	public ControlPanel() {
		super("PLANNER VIAGGIO");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelViaggio = new JPanel();
		panelViaggio.setBackground(new Color(255, 165, 0));
		panelViaggio.setBounds(0, 0, 259, 478);
		contentPane.add(panelViaggio);
		panelViaggio.setLayout(null);

		btnAggViaggio = new JButton("Aggiungi Viaggio");
		btnAggViaggio.setForeground(Color.BLACK);
		btnAggViaggio.setBackground(Color.WHITE);
		btnAggViaggio.addActionListener(this);
		btnAggViaggio.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		btnAggViaggio.setBounds(30, 369, 188, 30);
		panelViaggio.add(btnAggViaggio);

		btnEliminaViaggio = new JButton("Elimina Viaggio");
		btnEliminaViaggio.addActionListener(this);
		btnEliminaViaggio.setForeground(Color.BLACK);
		btnEliminaViaggio.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		btnEliminaViaggio.setBackground(Color.WHITE);
		btnEliminaViaggio.setBounds(30, 423, 188, 30);
		panelViaggio.add(btnEliminaViaggio);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(258, 0, 542, 478);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnAggAttivita = new JButton("Aggiungi Attivita'");
		btnAggAttivita.addActionListener(this);
		btnAggAttivita.setVerticalAlignment(SwingConstants.CENTER);
		btnAggAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAggAttivita.setBounds(66, 423, 188, 29);
		panel_1.add(btnAggAttivita);

		btnEliminaAttivita = new JButton("Elimina Attivita'");
		btnEliminaAttivita.addActionListener(this);
		btnEliminaAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminaAttivita.setBounds(308, 423, 188, 29);
		panel_1.add(btnEliminaAttivita);

		lblViaggio = new JLabel("");
		//lblViaggio.setForeground(Color.DARK_GRAY);
		lblViaggio.setForeground(Color.BLACK);
		lblViaggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblViaggio.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 24));
		lblViaggio.setBounds(42, 80, 169, 40);
		panelViaggio.add(lblViaggio);

		lblTitoloViaggioBellezza = new JLabel("V I A G G I O");
		lblTitoloViaggioBellezza.setForeground(Color.WHITE);
		lblTitoloViaggioBellezza.setFont(new Font("Shree Devanagari 714", Font.BOLD, 22));
		lblTitoloViaggioBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitoloViaggioBellezza.setBounds(30, 32, 194, 41);
		panelViaggio.add(lblTitoloViaggioBellezza);

		btnViaggioPrecedente = new JButton("<");
		btnViaggioPrecedente.addActionListener(this);
		btnViaggioPrecedente.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnViaggioPrecedente.setBounds(30, 296, 55, 40);
		panelViaggio.add(btnViaggioPrecedente);

		btnViaggioSuccessivo = new JButton(">");
		btnViaggioSuccessivo.addActionListener(this);
		btnViaggioSuccessivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnViaggioSuccessivo.setBounds(148, 296, 55, 40);
		panelViaggio.add(btnViaggioSuccessivo);

		lblTrasportoBellezza = new JLabel("Trasporto:");
		lblTrasportoBellezza.setForeground(Color.DARK_GRAY);
		lblTrasportoBellezza.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblTrasportoBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrasportoBellezza.setBounds(30, 157, 95, 22);
		panelViaggio.add(lblTrasportoBellezza);

		lblDataPartenzaViaggioBellezza = new JLabel("Partenza:");
		lblDataPartenzaViaggioBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataPartenzaViaggioBellezza.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDataPartenzaViaggioBellezza.setBounds(30, 203, 95, 22);
		panelViaggio.add(lblDataPartenzaViaggioBellezza);

		lblDataRitornoViaggioBellezza = new JLabel("Ritorno:");
		lblDataRitornoViaggioBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataRitornoViaggioBellezza.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDataRitornoViaggioBellezza.setBounds(30, 236, 95, 22);
		panelViaggio.add(lblDataRitornoViaggioBellezza);

		lblTrasporto = new JLabel("");
		lblTrasporto.setHorizontalAlignment(SwingConstants.CENTER);
		lblViaggio.setForeground(Color.DARK_GRAY);
		lblTrasporto.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblTrasporto.setBounds(148, 157, 95, 22);
		panelViaggio.add(lblTrasporto);

		lblDataPartenzaViaggio = new JLabel("");
		lblDataPartenzaViaggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataPartenzaViaggio.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblDataPartenzaViaggio.setBounds(148, 203, 95, 22);
		panelViaggio.add(lblDataPartenzaViaggio);

		lblDataRitornoViaggio = new JLabel("");
		lblDataRitornoViaggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataRitornoViaggio.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblDataRitornoViaggio.setBounds(148, 236, 95, 22);
		panelViaggio.add(lblDataRitornoViaggio);

		//METTERE L'INDICE GIUSTO DEL VIAGGIO IN CUI SI E'
		lblIndiceViaggio = new JLabel("1");
		lblIndiceViaggio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIndiceViaggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndiceViaggio.setBounds(89, 296, 22, 29);
		panelViaggio.add(lblIndiceViaggio);

		lblBarraViaggi = new JLabel("/");
		lblBarraViaggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarraViaggi.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraViaggi.setBounds(103, 296, 22, 29);
		panelViaggio.add(lblBarraViaggi);

		//METTERE IL NUMERO GIUSTO DI VIAGGI TOTALI DAL DB
		lblNumeroViaggiTotali = new JLabel("1");
		lblNumeroViaggiTotali.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroViaggiTotali.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroViaggiTotali.setBounds(121, 296, 22, 29);
		panelViaggio.add(lblNumeroViaggiTotali);

		lblCiao = new JLabel("");
		lblCiao.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 13));
		lblCiao.setBounds(390, 10, 143, 20);
		panel_1.add(lblCiao);

		lblTitoloAttivitaBellezza = new JLabel("A T T I V I T A'");
		lblTitoloAttivitaBellezza.setForeground(new Color(255, 165, 0));
		lblTitoloAttivitaBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitoloAttivitaBellezza.setFont(new Font("Shree Devanagari 714", Font.BOLD, 22));
		//centro a 271
		lblTitoloAttivitaBellezza.setBounds(174, 32, 194, 41);
		panel_1.add(lblTitoloAttivitaBellezza);

		lblAttivita = new JLabel("");
		lblAttivita.setForeground(Color.DARK_GRAY);
		lblAttivita.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttivita.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 20));
		lblAttivita.setBounds(115, 100, 319, 40);
		panel_1.add(lblAttivita);

		lblLuogoBellezza = new JLabel("Luogo");
		lblLuogoBellezza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblLuogoBellezza.setBounds(213, 162, 60, 35);
		panel_1.add(lblLuogoBellezza);

		lblLuogo = new JLabel("");
		lblLuogo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblLuogo.setBounds(283, 162, 231, 35);
		panel_1.add(lblLuogo);

		lblOraInizioBellezza = new JLabel("Ora di Inizio");
		lblOraInizioBellezza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraInizioBellezza.setBounds(213, 218, 136, 35);
		panel_1.add(lblOraInizioBellezza);

		lblOraInizio = new JLabel("");
		lblOraInizio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraInizio.setBounds(321, 218, 136, 35);
		panel_1.add(lblOraInizio);

		lblOraFineBellezza = new JLabel("Ora di Fine");
		lblOraFineBellezza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraFineBellezza.setBounds(213, 266, 136, 35);
		panel_1.add(lblOraFineBellezza);

		lblOraFine = new JLabel("");
		lblOraFine.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraFine.setBounds(321, 266, 113, 35);
		panel_1.add(lblOraFine);

		btnAttivitaPrecedente = new JButton("<");
		btnAttivitaPrecedente.addActionListener(this);
		btnAttivitaPrecedente.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnAttivitaPrecedente.setBounds(115, 358, 55, 40);
		panel_1.add(btnAttivitaPrecedente);

		btnAttivitaSuccessiva = new JButton(">");
		btnAttivitaSuccessiva.addActionListener(this);
		btnAttivitaSuccessiva.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnAttivitaSuccessiva.setBounds(364, 358, 55, 40);
		panel_1.add(btnAttivitaSuccessiva);

		//METTERE IL NUMERO GIUSTO DI ATTIVITA IN CUI SI E'
		lblIndiceAttivita = new JLabel("1");
		lblIndiceAttivita.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndiceAttivita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIndiceAttivita.setBounds(232, 358, 22, 29);
		panel_1.add(lblIndiceAttivita);

		lblBarraAttivita = new JLabel("/");
		lblBarraAttivita.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraAttivita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarraAttivita.setBounds(264, 358, 22, 29);
		panel_1.add(lblBarraAttivita);

		//METTERE IL NUMERO GIUSTO DI ATTIVITA TOTALI DAL DB
		lblNumeroAttivitaTotali = new JLabel("1");
		lblNumeroAttivitaTotali.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroAttivitaTotali.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroAttivitaTotali.setBounds(306, 358, 22, 29);
		panel_1.add(lblNumeroAttivitaTotali);


		try {
			new Database().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}


	public static void cleanAttivita() {
		lblAttivita.setText("");
		lblLuogo.setText("");
		lblOraInizio.setText("");
		lblOraFine.setText("");

		lblLuogoBellezza.setVisible(false);
		lblOraInizioBellezza.setVisible(false);
		lblOraFineBellezza.setVisible(false);
	}

	public static void showLabelAttivitaBellezza() {
		lblLuogoBellezza.setVisible(true);
		lblOraInizioBellezza.setVisible(true);
		lblOraFineBellezza.setVisible(true);	
	}

	public static void cleanViaggio() {
		lblViaggio.setText("");
		lblTrasporto.setText("");
		lblDataPartenzaViaggio.setText("");
		lblDataRitornoViaggio.setText("");

		lblTrasportoBellezza.setVisible(false);
		lblDataPartenzaViaggioBellezza.setVisible(false);
		lblDataRitornoViaggioBellezza.setVisible(false);		
	}

	public static void showLabelViaggioBellezza() {
		lblTrasportoBellezza.setVisible(true);
		lblDataPartenzaViaggioBellezza.setVisible(true);
		lblDataRitornoViaggioBellezza.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.btnAggViaggio) {
			try {
				NuovoViaggio dialog = new NuovoViaggio(java.util.UUID.randomUUID());
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception a) {
				a.printStackTrace();
			}
		}

		if(e.getSource() == this.btnEliminaViaggio) {
			Database.modelViaggio.remove();	
		}

		if(e.getSource() == this.btnAggAttivita) {

			/*FARE LA CONDIZIONE DELL'IF COSI:
			if(non ci sono viaggi nel db){
					try {
							ErroreNuovaAttivita dialog = new ErroreNuovaAttivita();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
			}
			SE QUESTA COSA NON AVVIENE ALLORA SI FA IL RESTO TUTTO NORMALE. QUINDI QUANDO HAI FINITO DI FARE
			QUESTO IF BASTA AGGIUNGERE UN ELSE E METTERE TRA PARENTESI GRAFFE TUTTE CIò CHE C'é QUI SOTTO FINO
			AL BOTTONE SUCCESSIVO, CIOè FINO ALLA RIGA PRIMA DI	"if(e.getSource() == this.btnEliminaAttivita) {"
			*/
			try {
				NuovaAttivita dialog = new NuovaAttivita(Database.modelViaggio.getSelectedItem().getIdViaggio());
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception a) {
				a.printStackTrace();
			}
		}

		if(e.getSource() == this.btnEliminaAttivita) {	
			Database.modelAttivita.remove();
		}

		if(e.getSource() == this.btnViaggioPrecedente) {
			if(Database.modelViaggio.getSelectedIndex() > 0) {
				Database.modelViaggio.previous();
				Database.modelViaggio.showItem();
				Database.modelAttivita.showAttivita();
			}
			else {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		if(e.getSource() == this.btnViaggioSuccessivo) {
			if(Database.modelViaggio.getSelectedIndex() < DBModelViaggio.lv.size() - 1) {
				Database.modelViaggio.next();
				Database.modelViaggio.showItem();
				Database.modelAttivita.showAttivita();
			}
			else {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		if(e.getSource() == this.btnAttivitaPrecedente) {
			if(Database.modelAttivita.getSelectedIndex() > 0) {
				Database.modelAttivita.showPrecAttivita(Database.modelAttivita.getSelectedIndex());
			}
			else {
				Toolkit.getDefaultToolkit().beep();
			}	
		}		

		if(e.getSource() == this.btnAttivitaSuccessiva) {
			if(Database.modelAttivita.getSelectedIndex() < (DBModelAttivita.la.size() - 1)) {
				Database.modelAttivita.showNextAttivita(Database.modelAttivita.getSelectedIndex());		
			}
			else {
				Toolkit.getDefaultToolkit().beep();
			}			
		}
	}
}
