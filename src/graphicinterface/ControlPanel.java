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
import javax.swing.border.LineBorder;

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
	private JLabel lblLuogoBellezza;
	public static JLabel lblLuogo;
	private JLabel lblOraInizioBellezza;
	public static JLabel lblOraInizio;
	private JLabel lblOraFineBellezza;
	public static JLabel lblOraFine;
	private JButton btnViaggioPrecedente;
	private JButton btnViaggioSuccessivo;
	private JButton btnAttivitaPrecedente;
	private JButton btnAttivitaSuccessiva;
	private JLabel lblTrasportoBellezza;
	private JLabel lblDataPartenzaViaggioBellezza;
	private JLabel lblDataArrivoViaggioBellezza;
	private JLabel lblTrasporto;
	private JLabel lblDataPartenzaViaggio;
	private JLabel lblDataArrivoViaggio;
	
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
		panelViaggio.setBorder(new LineBorder(Color.GRAY));
		panelViaggio.setBackground(Color.ORANGE);
		panelViaggio.setBounds(0, 0, 259, 463);
		contentPane.add(panelViaggio);
		panelViaggio.setLayout(null);

		btnAggViaggio = new JButton("Aggiungi Viaggio");
		btnAggViaggio.setForeground(Color.BLACK);
		btnAggViaggio.setBackground(Color.WHITE);
		btnAggViaggio.addActionListener(this);
		btnAggViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAggViaggio.setBounds(30, 369, 188, 29);
		panelViaggio.add(btnAggViaggio);

		btnEliminaViaggio = new JButton("Elimina Viaggio");
		btnEliminaViaggio.addActionListener(this);
		btnEliminaViaggio.setForeground(Color.BLACK);
		btnEliminaViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminaViaggio.setBackground(Color.WHITE);
		btnEliminaViaggio.setBounds(30, 423, 188, 29);
		panelViaggio.add(btnEliminaViaggio);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(256, 0, 541, 463);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnAggAttivita = new JButton("Aggiungi Attivita'");
		btnAggAttivita.addActionListener(this);
		btnAggAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAggAttivita.setBounds(66, 423, 188, 29);
		panel_1.add(btnAggAttivita);

		btnEliminaAttivita = new JButton("Elimina Attivita'");
		btnEliminaAttivita.addActionListener(this);
		btnEliminaAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminaAttivita.setBounds(308, 423, 188, 29);
		panel_1.add(btnEliminaAttivita);

		lblViaggio = new JLabel("");
		lblViaggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblViaggio.setBounds(42, 67, 169, 48);
		panelViaggio.add(lblViaggio);

		lblTitoloViaggioBellezza = new JLabel("VIAGGIO");
		lblTitoloViaggioBellezza.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblTitoloViaggioBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitoloViaggioBellezza.setBounds(30, 11, 194, 41);
		panelViaggio.add(lblTitoloViaggioBellezza);
		
		btnViaggioPrecedente = new JButton("<");
		btnViaggioPrecedente.addActionListener(this);
		btnViaggioPrecedente.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnViaggioPrecedente.setBounds(30, 296, 70, 54);
		panelViaggio.add(btnViaggioPrecedente);
		
		btnViaggioSuccessivo = new JButton(">");
		btnViaggioSuccessivo.addActionListener(this);
		btnViaggioSuccessivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnViaggioSuccessivo.setBounds(148, 296, 70, 54);
		panelViaggio.add(btnViaggioSuccessivo);
		
		//QUESTA LABEL E' SOLO PER BELLEZZA, VA LASCIATA COSI'
		lblTrasportoBellezza = new JLabel("Trasporto");
		lblTrasportoBellezza.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblTrasportoBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrasportoBellezza.setBounds(30, 134, 95, 22);
		panelViaggio.add(lblTrasportoBellezza);
		
		//QUESTA LABEL E' SOLO PER BELLEZZA, VA LASCIATA COSI'
		lblDataPartenzaViaggioBellezza = new JLabel("Dal");
		lblDataPartenzaViaggioBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataPartenzaViaggioBellezza.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDataPartenzaViaggioBellezza.setBounds(30, 167, 95, 22);
		panelViaggio.add(lblDataPartenzaViaggioBellezza);
		
		//QUESTA LABEL E' SOLO PER BELLEZZA, VA LASCIATA COSI'
		lblDataArrivoViaggioBellezza = new JLabel("Al");
		lblDataArrivoViaggioBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataArrivoViaggioBellezza.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDataArrivoViaggioBellezza.setBounds(30, 200, 95, 22);
		panelViaggio.add(lblDataArrivoViaggioBellezza);
		
		//QUI VA CANCELLATA LA PAROLA "Treno" E CI VA MESSO IL GIUSTO MEZZO DI TRASPORTO DAL DB
		lblTrasporto = new JLabel("Treno");
		lblTrasporto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrasporto.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblTrasporto.setBounds(148, 134, 95, 22);
		panelViaggio.add(lblTrasporto);
		
		//QUI VA CANCELLATA LA DATA E CI VA MESSA LA DATA DI INIZIO DEL VIAGGIO DAL DB
		lblDataPartenzaViaggio = new JLabel("00/00/0000");
		lblDataPartenzaViaggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataPartenzaViaggio.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblDataPartenzaViaggio.setBounds(148, 167, 95, 22);
		panelViaggio.add(lblDataPartenzaViaggio);
		
		//QUI VA CANCELLATA LA DATA E CI VA MESSA LA DATA DI ARRIVO DEL VIAGGIO DAL DB
		lblDataArrivoViaggio = new JLabel("11/11/1111");
		lblDataArrivoViaggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataArrivoViaggio.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblDataArrivoViaggio.setBounds(148, 200, 95, 22);
		panelViaggio.add(lblDataArrivoViaggio);

		lblCiao = new JLabel("");
		lblCiao.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCiao.setBounds(359, 11, 143, 40);
		panel_1.add(lblCiao);

		lblTitoloAttivitaBellezza = new JLabel("ATTIVITA'");
		lblTitoloAttivitaBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitoloAttivitaBellezza.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblTitoloAttivitaBellezza.setBounds(60, 11, 194, 41);
		panel_1.add(lblTitoloAttivitaBellezza);

		lblAttivita = new JLabel("");
		lblAttivita.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblAttivita.setBounds(60, 63, 197, 73);
		panel_1.add(lblAttivita);

		lblLuogoBellezza = new JLabel("Luogo");
		lblLuogoBellezza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblLuogoBellezza.setBounds(66, 147, 60, 35);
		panel_1.add(lblLuogoBellezza);

		lblLuogo = new JLabel("");
		lblLuogo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblLuogo.setBounds(203, 147, 231, 35);
		panel_1.add(lblLuogo);

		lblOraInizioBellezza = new JLabel("Ora di Inizio");
		lblOraInizioBellezza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraInizioBellezza.setBounds(60, 208, 136, 35);
		panel_1.add(lblOraInizioBellezza);

		lblOraInizio = new JLabel("");
		lblOraInizio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraInizio.setBounds(203, 208, 231, 35);
		panel_1.add(lblOraInizio);

		lblOraFineBellezza = new JLabel("Ora di Fine");
		lblOraFineBellezza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraFineBellezza.setBounds(60, 266, 136, 35);
		panel_1.add(lblOraFineBellezza);

		lblOraFine = new JLabel("");
		lblOraFine.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraFine.setBounds(203, 266, 231, 35);
		panel_1.add(lblOraFine);
		
		btnAttivitaPrecedente = new JButton("<");
		btnAttivitaPrecedente.addActionListener(this);
		btnAttivitaPrecedente.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnAttivitaPrecedente.setBounds(115, 358, 70, 54);
		panel_1.add(btnAttivitaPrecedente);
		
		btnAttivitaSuccessiva = new JButton(">");
		btnAttivitaSuccessiva.addActionListener(this);
		btnAttivitaSuccessiva.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnAttivitaSuccessiva.setBounds(364, 358, 70, 54);
		panel_1.add(btnAttivitaSuccessiva);
		
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
	}
	
	public static void cleanViaggio() {
		lblViaggio.setText("Aggiungi un viaggio!");
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
		
		//ANCORA NON FUNZIONA
		if(e.getSource() == this.btnEliminaViaggio) {
			Toolkit.getDefaultToolkit().beep();
			
				
		}
		
		if(e.getSource() == this.btnAggAttivita) {
			try {
				NuovaAttivita dialog = new NuovaAttivita(Database.modelViaggio.getSelectedItem().getIdViaggio());
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception a) {
				a.printStackTrace();
			}
		}
		
		//ANCORA NON FUNZIONA
		if(e.getSource() == this.btnEliminaAttivita) {	
			Toolkit.getDefaultToolkit().beep();
			//Database.modelAttivita.remove();
			//mostrare a video la nuova attivita' o le label vuote se non ci sono attività
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
