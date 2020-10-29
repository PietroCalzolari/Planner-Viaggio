package graphicinterface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Error extends JDialog {
	private static final long serialVersionUID = 8712494807648038174L;
	private final JPanel contentPanel = new JPanel();
	
	public Error() {
		setBounds(425, 350, 350, 140);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		
		JLabel lblCompilaCampi = new JLabel("Compila tutti i campi");
		lblCompilaCampi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompilaCampi.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblCompilaCampi.setBounds(50, 32, 250, 26);
		contentPanel.add(lblCompilaCampi);
		
	}

}
