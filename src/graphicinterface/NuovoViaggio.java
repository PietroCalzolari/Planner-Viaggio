package graphicinterface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBModelAttivita;
import database.Database;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class NuovoViaggio extends JDialog implements ActionListener {
	private static final long serialVersionUID = -1904910491700065906L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldNomeViaggio;
	private JTextField textFieldTrasporto;
	private JTextField textFieldRitorno;
	private JTextField textFieldPartenza;
	private UUID IDViaggio;
	private JLabel lblCreazioneViaggio;
	private JLabel lblNomeViaggio;
	private JLabel lblMezzo;
	private JLabel lblPartenza;
	private JLabel lblRitorno;

	public NuovoViaggio(UUID IDViaggio) {
		this.IDViaggio = IDViaggio;
		
		setBounds(320, 265, 560, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCreazioneViaggio = new JLabel("CREAZIONE NUOVO VIAGGIO");
		lblCreazioneViaggio.setForeground(new Color(255, 165, 0));
		lblCreazioneViaggio.setBounds(130, 12, 300, 36);
		lblCreazioneViaggio.setFont(new Font("Shree Devanagari 714", Font.BOLD, 22));
		contentPanel.add(lblCreazioneViaggio);

		okButton = new JButton("Ok");
		okButton.setBounds(70, 267, 127, 45);
		contentPanel.add(okButton);
		okButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		okButton.addActionListener(this);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setBounds(310, 268, 127, 45);
		contentPanel.add(cancelButton);
		cancelButton.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		cancelButton.setActionCommand("Cancel");

		lblNomeViaggio = new JLabel("Nome del viaggio");
		lblNomeViaggio.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblNomeViaggio.setBounds(70, 80, 141, 25);
		contentPanel.add(lblNomeViaggio);

		lblMezzo = new JLabel("Mezzo di trasporto");
		lblMezzo.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblMezzo.setBounds(310, 80, 160, 25);
		contentPanel.add(lblMezzo);

		lblPartenza = new JLabel("Data di Partenza");
		lblPartenza.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblPartenza.setBounds(70, 165, 150, 25);
		contentPanel.add(lblPartenza);

		lblRitorno = new JLabel("Data di Ritorno");
		lblRitorno.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblRitorno.setBounds(310, 165, 150, 25);
		contentPanel.add(lblRitorno);

		textFieldNomeViaggio = new JTextField();
		textFieldNomeViaggio.setColumns(10);
		textFieldNomeViaggio.setBounds(70, 108, 170, 30);
		contentPanel.add(textFieldNomeViaggio);

		textFieldTrasporto = new JTextField();
		textFieldTrasporto.setColumns(10);
		textFieldTrasporto.setBounds(310, 108, 170, 30);
		contentPanel.add(textFieldTrasporto);

		textFieldRitorno = new JTextField();
		textFieldRitorno.setColumns(10);
		textFieldRitorno.setBounds(310, 193, 170, 30);
		contentPanel.add(textFieldRitorno);

		textFieldPartenza = new JTextField();
		textFieldPartenza.setColumns(10);
		textFieldPartenza.setBounds(70, 193, 170, 30);
		contentPanel.add(textFieldPartenza);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.okButton) {
			if((textFieldPartenza.getText().length() == 0) || (textFieldRitorno.getText().length() == 0) || (textFieldTrasporto.getText().length() == 0) || (textFieldNomeViaggio.getText().length() == 0)) {
				try {
					Error dialog = new Error();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			} else {
				Database.modelViaggio.insert(IDViaggio, textFieldNomeViaggio.getText(),textFieldTrasporto.getText(),textFieldRitorno.getText(),textFieldPartenza.getText());
				Database.modelViaggio.showItem();
				
				ControlPanel.lblCiao.setText("Ciao" + Database.nomeUtente());
				ControlPanel.showLabelViaggioBellezza();
				ControlPanel.lblIndiceViaggio.setText(Database.IndiceViaggio());
			
				dispose();
				
				ControlPanel.cleanAttivita();
				ControlPanel.lblNumeroAttivitaTotali.setText("0");
				ControlPanel.indiceAttivita = 0;
				DBModelAttivita.convertIndexAttivita();
				
				try {
					NuovaAttivita dialog = new NuovaAttivita(Database.modelViaggio.getSelectedItem().getIdViaggio());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		}
		if(e.getSource() == this.cancelButton) {
			ControlPanel.lblCiao.setText("Ciao" + Database.nomeUtente());
			dispose();
		}
	}
}
