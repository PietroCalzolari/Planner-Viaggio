package graphicinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ErroreNuovaAttivita extends JDialog {
	private static final long serialVersionUID = -6848333350516068912L;
	private JLabel lblInformativa;
	private JLabel lblInformativa1;
	private final JPanel contentPanel = new JPanel();
	
	public ErroreNuovaAttivita() {
		setBounds(425, 350, 350, 140);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		
		lblInformativa = new JLabel("Per aggiungere una nuova attivit\u00E0,");
		lblInformativa.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativa.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblInformativa.setBounds(50, 15, 250, 46);
		contentPanel.add(lblInformativa);
		
		lblInformativa1 = new JLabel("creare prima un viaggio!");
		lblInformativa1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativa1.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblInformativa1.setBounds(50, 45, 250, 46);
		contentPanel.add(lblInformativa1);
		
	}
}
