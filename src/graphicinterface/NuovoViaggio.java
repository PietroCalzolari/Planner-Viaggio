package graphicinterface;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class NuovoViaggio extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldNomeViaggio;
	private JTextField textFieldTrasporto;
	private JTextField textFieldArrivo;
	private JTextField textFieldPartenza;
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

		textFieldNomeViaggio = new JTextField();
		textFieldNomeViaggio.setColumns(10);
		textFieldNomeViaggio.setBounds(53, 108, 136, 35);
		contentPanel.add(textFieldNomeViaggio);

		textFieldTrasporto = new JTextField();
		textFieldTrasporto.setColumns(10);
		textFieldTrasporto.setBounds(303, 108, 136, 35);
		contentPanel.add(textFieldTrasporto);

		textFieldArrivo = new JTextField();
		textFieldArrivo.setColumns(10);
		textFieldArrivo.setBounds(303, 193, 136, 35);
		contentPanel.add(textFieldArrivo);

		textFieldPartenza = new JTextField();
		textFieldPartenza.setColumns(10);
		textFieldPartenza.setBounds(53, 193, 136, 35);
		contentPanel.add(textFieldPartenza);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.okButton) {
			if((textFieldPartenza.getText().length() == 0) || (textFieldArrivo.getText().length() == 0) || (textFieldTrasporto.getText().length() == 0) || (textFieldNomeViaggio.getText().length() == 0)) {
				try {
					Error dialog = new Error();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			}

			//SE VUOI METTERE ANCHE DELLE CONDIZIONI SULLE DATE VANNO FATTE TUTTE IN JAVA E POI PASSATE COME STRINGHE ALLA FUNZIONE insert PERCHE' IN SQLITE NON ESISTE IL TIPO "DATA"
			//Bisognerebbe cambiare il tipo all'interno della classe originaria, ora le date sono di tipo string

			//VANNO AGGIUNTE LE TEXTFIELD NELL'INTERFACCIA GRAFICA PER MOSTRARE LE CARATTERISTICHE DEL VIAGGIO (MEZZO, DATA INIIO E DATA FINE)
			else {
				Database.modelViaggio.insert(IDViaggio, textFieldNomeViaggio.getText(),textFieldTrasporto.getText(),textFieldArrivo.getText(),textFieldPartenza.getText());
				Database.modelViaggio.showItem();
				ControlPanel.lblCiao.setText("Ciao" + Database.nomeUtente());
				ControlPanel.cleanAttivita();
				dispose();
			}
		}
		if(e.getSource() == this.cancelButton) {
			dispose();
		}
	}
}
