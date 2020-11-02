package graphicinterface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Error extends JDialog {
	private static final long serialVersionUID = 8712494807648038174L;
	private final JPanel contentPanel = new JPanel();
	
	public Error(String error) {
		setBounds(375, 350, 450, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		
		JLabel lblError = new JLabel(error);
		lblError.setForeground(Color.red);
		lblError.setFont(new Font("Shree Devanagari 714", Font.PLAIN, 16));
		lblError.setBounds(90, 32, 270, 26);
		contentPanel.add(lblError);
		
	}

}
