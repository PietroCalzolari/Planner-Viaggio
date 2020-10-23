package graphicinterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import database.DBModelViaggio;
import database.Database;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseWheelListener;
import java.sql.SQLException;
import java.awt.event.MouseWheelEvent;

public class PannelloViaggi extends JPanel implements ActionListener{

	private JButton btnAggViaggio;
	private JButton btnEliminaViaggio;
	private UUID idViaggio;
	
	
	public PannelloViaggi(UUID idViaggio) {
		this.idViaggio = idViaggio;
		setLayout(null);
		
		JPanel panelViaggio = new JPanel();
		panelViaggio.setLayout(null);
		panelViaggio.setBorder(new LineBorder(Color.GRAY));
		//Avevo impostato il colore bianco per vedere se succedeva qualcosa una volta invocato dall'evento "Ok" della finestra di dialogo
		panelViaggio.setBackground(Color.WHITE);
		panelViaggio.setBounds(0, 0, 259, 463);
		add(panelViaggio);
		
		btnAggViaggio = new JButton("Aggiungi Viaggio");
		btnAggViaggio.addActionListener(this);
		btnAggViaggio.setForeground(Color.BLACK);
		btnAggViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAggViaggio.setBackground(Color.WHITE);
		btnAggViaggio.setBounds(30, 369, 188, 29);
		panelViaggio.add(btnAggViaggio);
		
		btnEliminaViaggio = new JButton("Elimina Viaggio");
		btnEliminaViaggio.addActionListener(this);
		btnEliminaViaggio.setForeground(Color.BLACK);
		btnEliminaViaggio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminaViaggio.setBackground(Color.WHITE);
		btnEliminaViaggio.setBounds(30, 423, 188, 29);
		panelViaggio.add(btnEliminaViaggio);
	
		panelViaggio.add(new JLabel("nome"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnAggViaggio) {
			try {
				NuovoViaggio dialog = new NuovoViaggio(java.util.UUID.randomUUID());
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception a) {
				a.printStackTrace();
			}
		}
		if(e.getSource() == this.btnEliminaViaggio) {
			//Aprire la lista dei viaggi e scegliere quale
		}
	}
}
