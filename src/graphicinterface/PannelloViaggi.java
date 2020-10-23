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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class PannelloViaggi extends JPanel implements ActionListener{

	private JButton btnAggViaggio;
	private JButton btnEliminaViaggio;
	
	
	public PannelloViaggi(UUID idViaggio) {
		setLayout(null);
		
		JPanel panelViaggio = new JPanel();
		panelViaggio.setLayout(null);
		panelViaggio.setBorder(new LineBorder(Color.GRAY));
		panelViaggio.setBackground(Color.ORANGE);
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
		/*
		 * panelViaggio.add(new JLabel("NOMEVIAGGIO").addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e))
					System.out.println("provissima");
			}
		}));
		*/
		//Marti qui dobbiamo mettere il nome del viaggio con l'ID che questo pannello prende come input
		//contentPanel.add(new JLabel("QUI CI VA IL NOME DEL VIAGGIO"));
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
