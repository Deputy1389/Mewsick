package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ControlCoord;
import controller.ListenerFactory;
import controller.ListenerFactory.SongGetter;
import model.Mewsic;
import model.Song;
import model.SongLibrary;
import model.SongQueue;

/**
 * Defines a JPanel that contains a JTable and JList for the SongLibrary
 * and playlist, respectively, as well as a button to play songs.
 * 
 * @author Sean Gallagher
 */
@SuppressWarnings("serial")
public class SongListPanel extends JPanel
{
	private JTable songLibTable;
	private JList<Song> playlist;
	
	/**
	 * Constructor for the JukeboxTable
	 * 
	 * @param factory A factory to create a listener for our "Add songs" button.
	 */
	public SongListPanel(ListenerFactory factory)
	{
		Mewsic model = ControlCoord.getInstance().getModel();
		setLayout(new BorderLayout());
		setupSongTable(factory);
	}
	
	/**
	 * Creates the table that lists the song library
	 * 
	 * @param the factory for the button listener
	 */
	private void setupSongTable(ListenerFactory factory)
	{
		SongLibrary lib = SongLibrary.getInstance();
		JPanel tablePanel = new JPanel();
		
		songLibTable = new JTable(lib);
		songLibTable.setFillsViewportHeight(true);
		RowSorter<TableModel> rs = new TableRowSorter<TableModel>(lib);
		songLibTable.setRowSorter(rs);
		
		songLibTable.setFillsViewportHeight(true);
		
		JScrollPane pane = new JScrollPane(songLibTable);
		int width = songLibTable.getPreferredSize().width + 200;
		int height = songLibTable.getRowHeight() * lib.getRowCount() + 1;
		
		//pane.setPreferredSize(new Dimension(600, 900));
		
		tablePanel.add(pane);
		
		
		add(tablePanel, BorderLayout.CENTER);
		
		JButton button = new JButton("Add to playlist");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);
		//add(buttonPanel, BorderLayout.WEST);
		
		SongGetter songGetter = () ->
		{
			int row = songLibTable.getSelectedRow();
			int col = songLibTable.convertColumnIndexToView(1);
			String name = null;
			if (row != -1)
			{
				name = (String) songLibTable.getValueAt(row, col);
			}
			return SongLibrary.getInstance().getSong(name);
		};
		button.addActionListener(factory.makeSongListener(songGetter));
	}
}
