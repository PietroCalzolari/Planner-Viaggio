package graphicinterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class ControlPanel extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton iniziamo;
	private JTextField nome;
	private JLabel label;

	public ControlPanel() {
		nome = new JTextField();
		label = new JLabel("Come ti chiami?");
		iniziamo = new JButton("INIZIAMO");
		iniziamo.addActionListener(this);
		
		JPanel p1 = new JPanel(new GridLayout(3,1));
		p1.add(label);
		p1.add(nome);
		p1.add(iniziamo);
		
		setContentPane(p1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 150);
		setVisible(true);
		try 
		{
		  UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} 
		catch (Exception e) 
		{
		  e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
