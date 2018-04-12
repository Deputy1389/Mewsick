package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controller.ListenerFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
	private final JPanel parent;
	
	/**
	 * Creates a JukeboxStartGUI
	 */
	public MewsickFrame()
	{
		ListenerFactory factory = new ListenerFactory(this);
		parent = new JPanel();
		songlist = new SongListPanel(factory);
		playlist = new PlaylistPanel(factory);
		
		PlaylistPanel playlistPanel_1 = new PlaylistPanel((ListenerFactory) null);
		
		JButton btnNewButton = new JButton("<<");
		
		JButton button = new JButton(">>");
		
		JProgressBar progressBar = new JProgressBar();
		playlistPanel_1.add(progressBar, BorderLayout.NORTH);
		
		JButton btnPlayAll = new JButton("Play All");
		
		JButton btnAdd = new JButton("Add");
		GroupLayout gl_playlist = new GroupLayout(playlist);
		gl_playlist.setHorizontalGroup(
			gl_playlist.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playlist.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPlayAll))
				.addComponent(playlistPanel_1, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
		);
		gl_playlist.setVerticalGroup(
			gl_playlist.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playlist.createSequentialGroup()
					.addGroup(gl_playlist.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button)
						.addComponent(btnPlayAll)
						.addComponent(btnAdd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playlistPanel_1, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addGap(13))
		);
		playlist.setLayout(gl_playlist);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("   File     ");
		menuBar.add(mnFile);
		
		JMenuItem mntmAddSong = new JMenuItem("Add Song");
		mnFile.add(mntmAddSong);
		
		this.addWindowListener(factory.makeWindowSaveListener());
		setupWindow();
	}

	/**
	 * Sets the window properties.
	 */
	public void setupWindow()
	{
		this.setSize(750, 628);
		this.setLocationRelativeTo(null);
		//this.add(playlist, BorderLayout.WEST);
		//this.add(songlist, BorderLayout.EAST);
		JSplitPane pane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, playlist, songlist);
		GroupLayout gl_parent = new GroupLayout(parent);
		gl_parent.setHorizontalGroup(
			gl_parent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_parent.createSequentialGroup()
					.addGap(5)
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_parent.setVerticalGroup(
			gl_parent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_parent.createSequentialGroup()
					.addGap(5)
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		parent.setLayout(gl_parent);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(parent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(parent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		getContentPane().setLayout(groupLayout);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.pack();
	}
}
