package graphicinterface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBModelAttivita;
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
	private JLabel lblNuovaAttivita;
	private JLabel lblNomeAttivita;
	private JLabel lblLuogo;
	private JLabel lblOraFine;
	private JLabel lblOraInizio;

	public NuovaAttivita(UUID IDViaggio) {
		this.IDViaggio = IDViaggio;
	
		setBounds(320, 265, 560, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		okButton = new JButton("Ok");
		okButton.addActionListener(this);
		okButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		okButton.setBounds(80, 270, 127, 45);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		cancelButton.setBounds(328, 270, 127, 45);
		contentPanel.add(cancelButton);
		cancelButton.setActionCommand("Cancel");

		lblNuovaAttivita= new JLabel("CREAZIONE NUOVA ATTIVITA'");
		lblNuovaAttivita.setForeground(new Color(255, 165, 0));
		lblNuovaAttivita.setFont(new Font("Shree Devanagari 714", Font.BOLD, 22));
		lblNuovaAttivita.setBounds(115, 12, 320, 36);
		contentPanel.add(lblNuovaAttivita);

		lblNomeAttivita = new JLabel("Nome Attivita'");
		lblNomeAttivita.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblNomeAttivita.setBounds(71, 60, 136, 35);
		contentPanel.add(lblNomeAttivita);

		lblLuogo = new JLabel("Luogo");
		lblLuogo.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblLuogo.setBounds(328, 60, 136, 35);
		contentPanel.add(lblLuogo);

		lblOraFine = new JLabel("Ora di Fine");
		lblOraFine.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblOraFine.setBounds(328, 158, 136, 35);
		contentPanel.add(lblOraFine);

		lblOraInizio = new JLabel("Ora di Inizio");
		lblOraInizio.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblOraInizio.setBounds(71, 158, 136, 35);
		contentPanel.add(lblOraInizio);

		textFieldNomeAttivita = new JTextField();
		textFieldNomeAttivita.setBounds(71, 106, 163, 35);
		contentPanel.add(textFieldNomeAttivita);
		textFieldNomeAttivita.setColumns(10);

		textFieldLuogo = new JTextField();
		textFieldLuogo.setColumns(10);
		textFieldLuogo.setBounds(328, 106, 169, 35);
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
		
		if(e.getSource() == this.okButton) {
			if((textFieldNomeAttivita.getText().length() == 0) || (textFieldOraFine.getText().length() == 0) || (textFieldOraInizio.getText().length() == 0) || (textFieldLuogo.getText().length() == 0)) {
				try {
					Error dialog = new Error();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			} else {
				Database.modelAttivita.insert(textFieldNomeAttivita.getText(),textFieldOraInizio.getText(),textFieldOraFine.getText(),textFieldLuogo.getText(), IDViaggio);
				Database.modelAttivita.showAttivitaInserita();
				
				ControlPanel.indiceAttivita = Integer.valueOf(ControlPanel.lblNumeroAttivitaTotali.getText());
				DBModelAttivita.convertIndexAttivita();
				
				dispose();
			}
		}
		if(e.getSource() == this.cancelButton) {
			dispose();
		}
	}
}
