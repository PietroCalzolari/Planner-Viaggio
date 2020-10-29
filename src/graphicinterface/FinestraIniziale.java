package graphicinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import database.Database;

public class FinestraIniziale extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldEmail;
	private JButton btnPrimoViaggio;


	public FinestraIniziale() {
		getContentPane().setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 265, 560, 370);
		getContentPane().setLayout(null);

		JLabel lblInserisciDati = new JLabel("INSERISCI I TUOI DATI");
		lblInserisciDati.setForeground(Color.white);
		lblInserisciDati.setFont(new Font("Shree Devanagari 714", Font.BOLD, 22));
		lblInserisciDati.setBounds(160, 30, 240, 36);
		getContentPane().add(lblInserisciDati);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.DARK_GRAY);
		lblNome.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblNome.setBounds(120, 114, 75, 24);
		getContentPane().add(lblNome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setForeground(Color.DARK_GRAY);
		lblCognome.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblCognome.setBounds(120, 164, 75, 24);
		getContentPane().add(lblCognome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblEmail.setBounds(120, 213, 75, 24);
		getContentPane().add(lblEmail);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(229, 111, 190, 30);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldCognome = new JTextField();
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(229, 161, 190, 30);
		getContentPane().add(textFieldCognome);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(229, 210, 190, 30);
		getContentPane().add(textFieldEmail);

		btnPrimoViaggio = new JButton("Aggiungi il tuo primo Viaggio!");
		btnPrimoViaggio.addActionListener(this);
		btnPrimoViaggio.setForeground(Color.BLACK);
		btnPrimoViaggio.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		btnPrimoViaggio.setBounds(165, 263, 240, 40);
		getContentPane().add(btnPrimoViaggio);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnPrimoViaggio) {
			//QUI CERCO DI VEDERE SE TUTTE LE TEXTFIELD SONO PIENE
			if((textFieldEmail.getText().length() == 0) || (textFieldCognome.getText().length() == 0) || (textFieldNome.getText().length() == 0)) {
				try {
					Error dialog = new Error();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			} else {
				Database.insertUtente(textFieldNome.getText(),textFieldCognome.getText(),textFieldEmail.getText());
				dispose();
				
				try {
					NuovoViaggio dialog = new NuovoViaggio(java.util.UUID.randomUUID());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}

			}
		}
	}
}
