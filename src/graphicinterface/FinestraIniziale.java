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
import javax.swing.UIManager;

public class FinestraIniziale extends JPanel implements ActionListener{
	private JTextField textFieldNome;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnPrimoViaggio;

	/**
	 * Create the panel.
	 */
	public FinestraIniziale() {
		setBackground(new Color(244, 164, 96));
		setForeground(Color.BLACK);
		setLayout(null);
		
		JLabel lblInserisciDati = new JLabel("INSERISCI I TUOI DATI");
		lblInserisciDati.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblInserisciDati.setBounds(142, 11, 240, 67);
		add(lblInserisciDati);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNome.setBounds(135, 114, 54, 24);
		add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCognome.setBounds(135, 164, 69, 24);
		add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblEmail.setBounds(135, 213, 54, 24);
		add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(229, 118, 118, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(229, 168, 118, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 217, 118, 20);
		add(textField_1);
		
		btnPrimoViaggio = new JButton("Aggiungi il tuo primo Viaggio!");
		btnPrimoViaggio.addActionListener(this);
		btnPrimoViaggio.setForeground(Color.BLACK);
		btnPrimoViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnPrimoViaggio.setBounds(142, 266, 240, 53);
		add(btnPrimoViaggio);

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
