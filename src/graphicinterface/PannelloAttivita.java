package graphicinterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.awt.event.ActionEvent;

public class PannelloAttivita extends JPanel implements ActionListener{
	private JButton btnAggAttivita;
	private JButton btnEliminaAttivita;
	
	/**
	 * Create the panel.
	 */
	public PannelloAttivita(UUID idViaggio, UUID idAttivita) {
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 541, 463);
		add(panel_1);
		
		btnAggAttivita = new JButton("Aggiungi Attività");
		btnAggAttivita.addActionListener(this);
		btnAggAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAggAttivita.setBounds(66, 423, 188, 29);
		panel_1.add(btnAggAttivita);
		
		btnEliminaAttivita = new JButton("Elimina Attività");
		btnEliminaAttivita.addActionListener(this);
		btnEliminaAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminaAttivita.setBounds(308, 423, 188, 29);
		panel_1.add(btnEliminaAttivita);
		
		//FACCIO LA PROVA PER AGGIUNGERE UNA LABEL CHE ABBIA LE CARATTERISTICHE DELL'ATTIVITA DA AGGIUNGERE
		panel_1.add(new JLabel("QUI DENTRO CI VA IL NOME DEL VIAGGIO"));
		panel_1.add(new JLabel("QUI DENTRO CI VANNO GLI ALTRI DATI"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnAggAttivita) {
			try {
				NuovaAttivita dialog = new NuovaAttivita();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception a) {
				a.printStackTrace();
			}
		}
		if(e.getSource() == this.btnEliminaAttivita) {
			//Aprire la lista delle attività riferite a quel viaggio e eliminare dal DB una di quelle
		}
	}

}
