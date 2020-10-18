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

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import de.javasoft.synthetica.simple2d.SyntheticaSimple2DLookAndFeel;

public class ControlPanel extends JFrame implements ActionListener, ChangeListener {
	private static final long serialVersionUID = 1L;
	private MenuBar menuBar;
	private Menu file;
	private MenuItem openFile;
	private MenuItem saveFile;
	private MenuItem close;
	private JTabbedPane tabbedPane;
	private JPanel primopannello;
	private JPanel secondopannello;

	public ControlPanel() {
		menuBar = new MenuBar();
		
		file = new Menu("file");
		
		openFile = new MenuItem("Open"); 
		saveFile = new MenuItem("Save"); 
		close = new MenuItem("Close"); 
		
		primopannello = new JPanel();
		primopannello.setLayout(new GridLayout(3,1));
		secondopannello = new JPanel();
		secondopannello.setLayout(new GridLayout(3,1));
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Primo Viaggio", primopannello);
		tabbedPane.addTab("Secondo Viaggio", secondopannello);
		
		openFile.addActionListener(this);
		file.add(openFile);
		
		saveFile.addActionListener(this);
		file.add(saveFile);
		
		close.addActionListener(this);
		file.add(close);
		
		
		menuBar.add(file);
		setMenuBar(menuBar);
		
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		tabbedPane.addChangeListener(this);

		setContentPane(tabbedPane);
		primopannello.setBackground(Color.red);
		secondopannello.setBackground(Color.magenta);
		try {
			UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
