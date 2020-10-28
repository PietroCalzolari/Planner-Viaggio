package graphicinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErroreNuovaAttivita extends JDialog implements ActionListener{

	private JButton btnOK;
	private JLabel lblInformativa;
	private JLabel lblInformativa1;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ErroreNuovaAttivita() {
		setBounds(100, 100, 430, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblInformativa = new JLabel("Per aggiungere una nuova attivit\u00E0,");
		lblInformativa.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativa.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblInformativa.setBounds(85, 21, 253, 46);
		contentPanel.add(lblInformativa);
		
		lblInformativa1 = new JLabel("creare prima un viaggio!");
		lblInformativa1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativa1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblInformativa1.setBounds(85, 50, 253, 46);
		contentPanel.add(lblInformativa1);
		
		btnOK = new JButton("Ok");
		btnOK.addActionListener(this);
		btnOK.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnOK.setBounds(162, 117, 93, 40);
		contentPanel.add(btnOK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnOK) {
			dispose();
		}
	}
}
