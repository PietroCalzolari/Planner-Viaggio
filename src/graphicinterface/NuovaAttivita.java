package graphicinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import database.DBAttivita;
import database.Database;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NuovaAttivita extends JDialog implements ActionListener {
	private JButton okButton;
	private JButton cancelButton;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNomeAttivita;
	private JTextField textFieldLuogo;
	private JTextField textFieldOraInizio;
	private JTextField textFieldOraFine;
	private UUID IDViaggio;

	
	public NuovaAttivita(UUID IDViaggio) {
		this.IDViaggio = IDViaggio;
		
		setBounds(100, 100, 559, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			okButton = new JButton("Ok");
			okButton.addActionListener(this);
			okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			okButton.setBounds(80, 270, 127, 45);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(this);
			cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			cancelButton.setBounds(328, 270, 127, 45);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel lblNuovaAttivita = new JLabel("Creazione nuova Attivit�! Compila tutti i dati sottostanti");
		lblNuovaAttivita.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNuovaAttivita.setBounds(25, 11, 496, 53);
		contentPanel.add(lblNuovaAttivita);
		
		JLabel lblNomeAttivita = new JLabel("Nome Attivit�");
		lblNomeAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNomeAttivita.setBounds(71, 60, 136, 35);
		contentPanel.add(lblNomeAttivita);
		
		JLabel lblLuogo = new JLabel("Luogo");
		lblLuogo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblLuogo.setBounds(328, 60, 136, 35);
		contentPanel.add(lblLuogo);
		
		JLabel lblOraFine = new JLabel("Ora di Fine");
		lblOraFine.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraFine.setBounds(328, 158, 136, 35);
		contentPanel.add(lblOraFine);
		
		JLabel lblOraInizio = new JLabel("Ora di Inizio");
		lblOraInizio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOraInizio.setBounds(71, 158, 136, 35);
		contentPanel.add(lblOraInizio);
		
		textFieldNomeAttivita = new JTextField();
		textFieldNomeAttivita.setBounds(71, 106, 136, 35);
		contentPanel.add(textFieldNomeAttivita);
		textFieldNomeAttivita.setColumns(10);
		
		textFieldLuogo = new JTextField();
		textFieldLuogo.setColumns(10);
		textFieldLuogo.setBounds(328, 106, 136, 35);
		contentPanel.add(textFieldLuogo);
		
		textFieldOraInizio = new JTextField();
		textFieldOraInizio.setColumns(10);
		textFieldOraInizio.setBounds(71, 204, 136, 35);
		contentPanel.add(textFieldOraInizio);
		
		textFieldOraFine = new JTextField();
		textFieldOraFine.setColumns(10);
		textFieldOraFine.setBounds(328, 204, 136, 35);
		contentPanel.add(textFieldOraFine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.okButton) {
			
			Database.modelAttivita.insert(textFieldNomeAttivita.getText(),textFieldOraInizio.getText(),textFieldOraFine.getText(),textFieldLuogo.getText(), IDViaggio);
			dispose();
		}
		if(e.getSource() == this.cancelButton) {
			dispose();
		}
	}
}
