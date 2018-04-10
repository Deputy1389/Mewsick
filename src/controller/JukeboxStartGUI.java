package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import view.Panel;
import view.SongPanel;

/**
 * Contains a main method that creates a window whose GUI is defined by the
 * code in the view package.
 * 
 * @author Sean Gallagher
 */
@SuppressWarnings("serial")
public class JukeboxStartGUI extends JFrame
{
	public static void main(String[] args)
	{
		JukeboxStartGUI gui = new JukeboxStartGUI();
		gui.setVisible(true);	
	}
	
	// A JPanel containing login interface
	private final Panel loginView;
	
	// A JPanel containing song information
	private final SongPanel songView;
	
	/**
	 * Creates a JukeboxStartGUI
	 */
	public JukeboxStartGUI()
	{
		ListenerFactory factory = new ListenerFactory(this);
		loginView = new Panel(factory);
		songView = new SongPanel(factory);
		this.addWindowListener(factory.makeWindowSaveListener());
		setupWindow();
	}
	
	/**
	 * Returns a reference to the view.
	 */
	public Panel getLoginView()
	{
		return loginView;
	}
	
	/**
	 * Returns a reference to the song view.
	 */
	public SongPanel getSongView()
	{
		return songView;
	}
	
	/**
	 * Sets the window properties.
	 */
	public void setupWindow()
	{
		this.setSize(900, 400);
		this.setLocationRelativeTo(null);
		this.add(loginView, BorderLayout.SOUTH);
		this.add(songView, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
