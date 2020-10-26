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
	private JLabel lblViaggioPrecedenteBellezza2;
	private JLabel lblViaggioSuccessivoBellezza2;
	private JLabel lblViaggioSuccessivoBellezza;
	private JButton btnViaggioPrecedente;
	private JButton btnViaggioSuccessivo;
	private JLabel lblViaggioPrecedenteBellezza;
	private JButton btnAttivitaPrecedente;
	private JButton btnAttivitaSuccessiva;

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
		lblViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblViaggio.setBounds(30, 78, 170, 73);
		panelViaggio.add(lblViaggio);

		lblTitoloViaggioBellezza = new JLabel("VIAGGIO");
		lblTitoloViaggioBellezza.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblTitoloViaggioBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitoloViaggioBellezza.setBounds(10, 11, 194, 41);
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
		
		lblViaggioPrecedenteBellezza = new JLabel("Viaggio");
		lblViaggioPrecedenteBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblViaggioPrecedenteBellezza.setBounds(42, 224, 50, 41);
		panelViaggio.add(lblViaggioPrecedenteBellezza);
		
		lblViaggioPrecedenteBellezza2 = new JLabel("Precedente");
		lblViaggioPrecedenteBellezza2.setHorizontalAlignment(SwingConstants.CENTER);
		lblViaggioPrecedenteBellezza2.setBounds(30, 244, 70, 41);
		panelViaggio.add(lblViaggioPrecedenteBellezza2);
		
		lblViaggioSuccessivoBellezza2 = new JLabel("Successivo");
		lblViaggioSuccessivoBellezza2.setHorizontalAlignment(SwingConstants.CENTER);
		lblViaggioSuccessivoBellezza2.setBounds(148, 244, 70, 41);
		panelViaggio.add(lblViaggioSuccessivoBellezza2);
		
		lblViaggioSuccessivoBellezza = new JLabel("Viaggio");
		lblViaggioSuccessivoBellezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblViaggioSuccessivoBellezza.setBounds(160, 224, 50, 41);
		panelViaggio.add(lblViaggioSuccessivoBellezza);

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
			try {
				Database.modelViaggio.remove();
			} catch (IndexOutOfBoundsException ex) {
				Toolkit.getDefaultToolkit().beep();
			}
			//FORSE manca la condizione che l'indice del viaggio sia non negativo
			if(Database.modelViaggio.getSelectedIndex() < (DBModelViaggio.lv.size() - 1)) {
				Database.modelViaggio.showItem();
				if(Database.modelAttivita.getSelectedIndex() >= 0) {
					Database.modelAttivita.showAttivitaDaViaggio();
				}
				else {
					cleanAttivita();
				}
			}
			else {
				cleanViaggio();
				cleanAttivita();
			}
				
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
				Database.modelAttivita.showAttivitaDaViaggio();
			}
			else {
				Toolkit.getDefaultToolkit().beep();
			}
		}
		
		if(e.getSource() == this.btnViaggioSuccessivo) {
			if(Database.modelViaggio.getSelectedIndex() < DBModelViaggio.lv.size() - 1) {
				Database.modelViaggio.next();
				Database.modelViaggio.showItem();
				Database.modelAttivita.showAttivitaDaViaggio();
			}
			else {
				Toolkit.getDefaultToolkit().beep();
			}
		}
		
		//ANCORA NON FUNZIONA
		if(e.getSource() == this.btnAttivitaPrecedente) {
			System.out.println("A" + Database.modelAttivita.getSelectedIndex());
			System.out.println("V" + Database.modelViaggio.getSelectedIndex());
	
		prova:
			while (Database.modelAttivita.getSelectedIndex() > 0) {
				Database.modelAttivita.previous();
				
				System.out.println("A" + Database.modelAttivita.getSelectedIndex());
				System.out.println("V" + Database.modelViaggio.getSelectedIndex());
				
				if(Database.modelAttivita.getSelectedItem().getIdViaggioA() == Database.modelViaggio.getSelectedItem().getIdViaggio()) {
					Database.modelAttivita.showAttivitaDaViaggio();
					break prova;
				}			
			}
			
			if(Database.modelAttivita.getSelectedIndex() == 0) {
				Toolkit.getDefaultToolkit().beep();
			}
		}		
		
		//ANCORA NON FUNZIONA
		if(e.getSource() == this.btnAttivitaSuccessiva) {
		
			System.out.println("A" + Database.modelAttivita.getSelectedIndex());
			System.out.println("V" + Database.modelViaggio.getSelectedIndex());
			
			prova:
			while(Database.modelAttivita.getSelectedIndex() < (DBModelAttivita.la.size() - 1)) {
				Database.modelAttivita.next();
				
				System.out.println("A" + Database.modelAttivita.getSelectedIndex());
				System.out.println("V" + Database.modelViaggio.getSelectedIndex());
				
				if(Database.modelAttivita.getSelectedItem().getIdViaggioA() == Database.modelViaggio.getSelectedItem().getIdViaggio()) {
					Database.modelAttivita.showAttivitaDaViaggio();
					break prova;
				}		
			}
			
			if(Database.modelAttivita.getSelectedIndex() == (DBModelAttivita.la.size() - 1)) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	}
}
