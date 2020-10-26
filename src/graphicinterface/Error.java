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

public class Error extends JDialog implements ActionListener{
	private JButton btnOK;
	
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public Error() {
		setBounds(100, 100, 409, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCompilaCampi = new JLabel("Compila tutti i campi");
		lblCompilaCampi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompilaCampi.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCompilaCampi.setBounds(120, 27, 152, 40);
		contentPanel.add(lblCompilaCampi);
		
		btnOK = new JButton("Ok");
		btnOK.addActionListener(this);
		btnOK.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnOK.setBounds(151, 97, 93, 40);
		contentPanel.add(btnOK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnOK) {
			dispose();
		}
	}
}
