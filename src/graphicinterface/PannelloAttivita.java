package graphicinterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PannelloAttivita extends JPanel implements ActionListener{
	private JButton btnAggAttivita;
	private JButton btnEliminaAttivita;
	
	/**
	 * Create the panel.
	 */
	public PannelloAttivita() {
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 541, 463);
		add(panel_1);
		
		btnAggAttivita = new JButton("Aggiungi Attivit\u00E0");
		btnAggAttivita.addActionListener(this);
		btnAggAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAggAttivita.setBounds(66, 423, 188, 29);
		panel_1.add(btnAggAttivita);
		
		btnEliminaAttivita = new JButton("Elimina Attivit\u00E0");
		btnEliminaAttivita.addActionListener(this);
		btnEliminaAttivita.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminaAttivita.setBounds(308, 423, 188, 29);
		panel_1.add(btnEliminaAttivita);

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
