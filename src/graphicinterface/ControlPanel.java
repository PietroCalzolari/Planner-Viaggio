package graphicinterface;

import java.awt.BorderLayout;
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
import de.javasoft.synthetica.aluoxide.SyntheticaAluOxideLookAndFeel;

public class ControlPanel extends JFrame implements ActionListener, ChangeListener {
	private static final long serialVersionUID = 1L;
	private MenuBar menuBar;
	private Menu file;
	private Menu aggiungi;
	private MenuItem openFile;
	private MenuItem saveFile;
	private MenuItem close;
	private JButton nuovoViaggio;
	private JButton nuovaAttivita;
	private JTabbedPane tabbedPane;
	private JPanel primopannello;
	private JPanel secondopannello;
	private JPanel aggiungere;
	private JPanel controllo;
	
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
		
		nuovoViaggio = new JButton("Aggiungi Viaggio");
		nuovoViaggio.addActionListener(this);
		nuovaAttivita = new JButton("Aggiungi Attività");
		nuovaAttivita.addActionListener(this);
		
		primopannello = new JPanel();
		
		primopannello.setLayout(new GridLayout(3,1));
		
		secondopannello = new JPanel();
		
		secondopannello.setLayout(new GridLayout(3,1));
		
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Primo Viaggio", primopannello);
		tabbedPane.addTab("Secondo Viaggio", secondopannello);	
		
		aggiungere = new JPanel(new GridLayout(1,2));
		
		aggiungere.add(nuovoViaggio);
		aggiungere.add(nuovaAttivita);
		
		menuBar.add(file);
		setMenuBar(menuBar);
		
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		tabbedPane.addChangeListener(this);
		
		controllo = new JPanel(new BorderLayout());

		controllo.add(tabbedPane,BorderLayout.CENTER);
		controllo.add(aggiungere,BorderLayout.PAGE_END);
		
		add(controllo);
		
		try {
			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.nuovoViaggio) {
			new DialogoViaggio();
		}
		if(e.getSource() == this.nuovaAttivita) {
			new DialogoAttivita();
		}
		if(e.getSource() == this.openFile) {
			
		}
		if(e.getSource() == this.saveFile) {
			
		}
		if(e.getSource() == this.close) {
			this.dispose();
		}
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
