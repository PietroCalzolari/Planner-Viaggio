package graphicinterface;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JFrame implements ActionListener, ChangeListener {
	private static final long serialVersionUID = 1L;
	private MenuBar menuBar;
	private Menu file;
	private Menu aggiungi;
	private MenuItem openFile;
	private MenuItem saveFile;
	private MenuItem close;
	private MenuItem nuovoViaggio;
	private MenuItem nuovaAttivita;
	private JTabbedPane tabbedPane;
	private JPanel primopannello;
	private JPanel secondopannello;

	public ControlPanel() {
		menuBar = new MenuBar();
		
		file = new Menu("File");
		aggiungi = new Menu("Aggiungi");
		
		openFile = new MenuItem("Open");
		openFile.addActionListener(this);
		file.add(openFile);
		
		saveFile = new MenuItem("Save");
		saveFile.addActionListener(this);
		file.add(saveFile);
		
		close = new MenuItem("Close");
		close.addActionListener(this);
		file.add(close);
		
		nuovoViaggio = new MenuItem("Nuovo Viaggio");
		nuovoViaggio.addActionListener(this);
		aggiungi.add(nuovoViaggio);
		
		nuovaAttivita = new MenuItem("Nuova Attivita");
		nuovaAttivita.addActionListener(this);
		aggiungi.add(nuovaAttivita);
		
		primopannello = new JPanel();
		primopannello.setLayout(new GridLayout(3,1));
		secondopannello = new JPanel();
		secondopannello.setLayout(new GridLayout(3,1));
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Primo Viaggio", primopannello);
		tabbedPane.addTab("Secondo Viaggio", secondopannello);		
		
		menuBar.add(file);
		menuBar.add(aggiungi);
		setMenuBar(menuBar);
		
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		tabbedPane.addChangeListener(this);

		setContentPane(tabbedPane);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
