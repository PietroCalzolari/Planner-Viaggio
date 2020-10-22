package graphicinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class FinestraIniziale extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnPrimoViaggio;

	/**
	 * Create the panel.
	 */
	public FinestraIniziale() {
		getContentPane().setBackground(new Color(255, 140, 0));
		setBackground(new Color(244, 164, 96));
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 422);
		getContentPane().setLayout(null);
		
		JLabel lblInserisciDati = new JLabel("INSERISCI I TUOI DATI");
		lblInserisciDati.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblInserisciDati.setBounds(142, 11, 240, 67);
		getContentPane().add(lblInserisciDati);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNome.setBounds(135, 114, 54, 24);
		getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCognome.setBounds(135, 164, 69, 24);
		getContentPane().add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblEmail.setBounds(135, 213, 54, 24);
		getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(229, 118, 118, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(229, 168, 118, 20);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 217, 118, 20);
		getContentPane().add(textField_1);
		
		btnPrimoViaggio = new JButton("Aggiungi il tuo primo Viaggio!");
		btnPrimoViaggio.addActionListener(this);
		btnPrimoViaggio.setForeground(Color.BLACK);
		btnPrimoViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnPrimoViaggio.setBounds(165, 263, 240, 53);
		getContentPane().add(btnPrimoViaggio);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnPrimoViaggio) {
			//Oltre che a fare ciò che ho scritto bisogna salvare sul DB i dati che sono stati scritti
			//e magari anche guardare che tutte le textfield siano state scritte(forse questo lo devo fare io)
			//Inoltre bisogna passare il giusto argomento alla riga 81: al posto di null ci va messo l'UUID giusto
			try {
				NuovoViaggio dialog = new NuovoViaggio(null);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception a) {
				a.printStackTrace();
			}
		}
	}
}
