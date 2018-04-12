package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ControlCoord;
import controller.ListenerFactory;
import model.Mewsic;
import model.Song;
import model.SongQueue;

public class PlaylistPanel extends JPanel {
	private JList<Song> playlist;
	/**
	 * Create the panel.
	 */
	public PlaylistPanel(ListenerFactory factory)
	{
		Mewsic model = ControlCoord.getInstance().getModel();
		SongQueue songs = model.getSongQueue();
		setLayout(new BorderLayout());
		setupPlayList(songs);
	}
	
	private void setupPlayList(SongQueue songs)
	{
		JPanel playlistPanel = new JPanel();
		playlistPanel.setLayout(new BorderLayout());
		
		playlist = new JList<Song>(songs);
		JScrollPane pane = new JScrollPane(playlist);	
		//pane.setPreferredSize(new Dimension(600, 400));
		playlistPanel.add(pane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Playlist");
		pane.setColumnHeaderView(label);
		
		add(playlistPanel, BorderLayout.WEST);
	}
}
