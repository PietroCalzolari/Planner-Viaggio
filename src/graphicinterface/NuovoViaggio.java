package graphicinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class NuovoViaggio extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNomeViaggio;
	private JTextField textFieldMezzo;
	private JTextField textFieldPartenza;
	private JTextField textFieldArrivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuovoViaggio dialog = new NuovoViaggio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuovoViaggio() {
		setBounds(100, 100, 481, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textFieldNomeViaggio = new JTextField();
			textFieldNomeViaggio.setBounds(26, 108, 127, 20);
			contentPanel.add(textFieldNomeViaggio);
			textFieldNomeViaggio.setColumns(10);
		}
		{
			JLabel lblCreazioneViaggio = new JLabel("Crea Viaggio, compila tutti i dati del tuo viaggio");
			lblCreazioneViaggio.setBounds(36, 18, 408, 36);
			lblCreazioneViaggio.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			contentPanel.add(lblCreazioneViaggio);
		}
		{
			JButton okButton = new JButton("Ok");
			okButton.setBounds(59, 235, 127, 46);
			contentPanel.add(okButton);
			okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			okButton.addActionListener(this);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(258, 236, 141, 44);
			contentPanel.add(cancelButton);
			cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel lblNomeViaggio = new JLabel("Nome del Viaggio");
		lblNomeViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNomeViaggio.setBounds(26, 65, 141, 32);
		contentPanel.add(lblNomeViaggio);
		
		JLabel lblMezzo = new JLabel("Mezzo Di Trasporto");
		lblMezzo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblMezzo.setBounds(284, 69, 160, 25);
		contentPanel.add(lblMezzo);
		
		textFieldMezzo = new JTextField();
		textFieldMezzo.setColumns(10);
		textFieldMezzo.setBounds(284, 108, 127, 20);
		contentPanel.add(textFieldMezzo);
		
		JLabel lblPartenza = new JLabel("Data di Partenza");
		lblPartenza.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblPartenza.setBounds(26, 139, 160, 36);
		contentPanel.add(lblPartenza);
		
		textFieldPartenza = new JTextField();
		textFieldPartenza.setColumns(10);
		textFieldPartenza.setBounds(26, 186, 127, 20);
		contentPanel.add(textFieldPartenza);
		
		JLabel lblArrivo = new JLabel("Data di Arrivo");
		lblArrivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblArrivo.setBounds(284, 139, 141, 36);
		contentPanel.add(lblArrivo);
		
		textFieldArrivo = new JTextField();
		textFieldArrivo.setColumns(10);
		textFieldArrivo.setBounds(284, 186, 127, 20);
		contentPanel.add(textFieldArrivo);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Fare i bottoni di OK e di Cancel
	}
}
