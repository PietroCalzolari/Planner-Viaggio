package graphicinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class NuovoViaggio extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private UUID IDViaggio;
	private JLabel lblCreazioneViaggio;
	private JLabel lblNomeViaggio;
	private JLabel lblMezzo;
	private JLabel lblPartenza;
	private JLabel lblArrivo;
	
	public NuovoViaggio(UUID IDViaggio) {
		this.IDViaggio = IDViaggio;
		
		setBounds(100, 100, 559, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCreazioneViaggio = new JLabel("Creazione nuovo Viaggio! Compila tutti i dati del tuo viaggio");
		lblCreazioneViaggio.setBounds(53, 11, 447, 36);
		lblCreazioneViaggio.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		contentPanel.add(lblCreazioneViaggio);

		okButton = new JButton("Ok");
		okButton.setBounds(67, 267, 127, 45);
		contentPanel.add(okButton);
		okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		okButton.addActionListener(this);
		getRootPane().setDefaultButton(okButton);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setBounds(303, 268, 127, 45);
		contentPanel.add(cancelButton);
		cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		cancelButton.setActionCommand("Cancel");

		lblNomeViaggio = new JLabel("Nome del Viaggio");
		lblNomeViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNomeViaggio.setBounds(53, 65, 141, 32);
		contentPanel.add(lblNomeViaggio);

		lblMezzo = new JLabel("Mezzo Di Trasporto");
		lblMezzo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblMezzo.setBounds(303, 69, 160, 25);
		contentPanel.add(lblMezzo);

		lblPartenza = new JLabel("Data di Partenza");
		lblPartenza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblPartenza.setBounds(53, 146, 160, 36);
		contentPanel.add(lblPartenza);

		lblArrivo = new JLabel("Data di Arrivo");
		lblArrivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblArrivo.setBounds(303, 146, 141, 36);
		contentPanel.add(lblArrivo);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(53, 108, 136, 35);
		contentPanel.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(303, 108, 136, 35);
		contentPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 193, 136, 35);
		contentPanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(53, 193, 136, 35);
		contentPanel.add(textField_3);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.okButton) {
			
			//inserimento dati nel database
			Database.modelViaggio.insert(IDViaggio, textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
		    
			//Qui ci va messa la funzione che mette in lblViaggio il nome del Viaggio corrente
			ControlPanel.lblViaggio.setText(textField.getText());
			
			//stampo l'indice del viaggio corrente
			System.out.println(Database.modelViaggio.getSelectedIndex());
			dispose();

		}
		if(e.getSource() == this.cancelButton) {
			dispose();
		}
	}
}
