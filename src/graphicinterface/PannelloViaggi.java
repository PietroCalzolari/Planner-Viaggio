package graphicinterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;

public class PannelloViaggi extends JPanel implements ActionListener{

	private JButton btnAggViaggio;
	private JButton btnEliminaViaggio;
	/**
	 * Create the panel.
	 */
	public PannelloViaggi() {
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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnAggViaggio) {
			try {
				//Bisogna mettere il giusto parametro al posto di null
				NuovoViaggio dialog = new NuovoViaggio(null);
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
