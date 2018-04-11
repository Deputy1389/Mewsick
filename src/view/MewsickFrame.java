package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.ListenerFactory;

/**
 * Contains a main method that creates a window whose GUI is defined by the
 * code in the view package.
 * 
 * @author Sean Gallagher
 */
@SuppressWarnings("serial")
public class MewsickFrame extends JFrame
{
	
	
	// A JPanel containing song information
	private final SongListPanel songlist;
	private final PlaylistPanel playlist;
	
	/**
	 * Creates a JukeboxStartGUI
	 */
	public MewsickFrame()
	{
		ListenerFactory factory = new ListenerFactory(this);
		songlist = new SongListPanel(factory);
		playlist = new PlaylistPanel(factory);
		
		this.addWindowListener(factory.makeWindowSaveListener());
		setupWindow();
	}

	/**
	 * Sets the window properties.
	 */
	public void setupWindow()
	{
		this.setSize(1500, 900);
		this.setLocationRelativeTo(null);
		this.add(playlist, BorderLayout.WEST);
		this.add(songlist, BorderLayout.EAST);
		//this.add(songView, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
