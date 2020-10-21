package graphicinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import database.DBViaggio;

public class ControlPanelA extends JFrame implements ActionListener {

	private static final long serialVersionUID = -2785150052774704558L;
	private JPanel contentPane, panelViaggio;
	private JButton btnAggViaggio;
	
	public ControlPanelA() {
		super("PLANNER VIAGGIO");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelViaggio = new JPanel();
		panelViaggio.setBorder(new LineBorder(Color.GRAY));
		panelViaggio.setBackground(Color.WHITE);
		panelViaggio.setBounds(0, 0, 400, 478);
		contentPane.add(panelViaggio);
		panelViaggio.setLayout(null);
		
		btnAggViaggio = new JButton("Aggiungi Viaggio");
		btnAggViaggio.addActionListener(this);
		btnAggViaggio.setFont(new Font("Galvji", Font.PLAIN, 13));
		btnAggViaggio.setBounds(106, 432, 188, 29);
		panelViaggio.add(btnAggViaggio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(6, 6, 388, 80);
		panelViaggio.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Viaggio 1");
		lblNewLabel.setFont(new Font("Galvji", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 6, 61, 16);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(400, 0, 400, 478);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Aggiungi Attività");
		btnNewButton_1.setFont(new Font("Galvji", Font.PLAIN, 13));
		btnNewButton_1.setBounds(106, 432, 188, 29);
		panel_1.add(btnNewButton_1);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnAggViaggio) {
			DBViaggio.modelV.insert("Napoli", "Auto", "15/08/2021", "28/08/2021");
			System.out.println("PROVA");
		}	
	}

}
