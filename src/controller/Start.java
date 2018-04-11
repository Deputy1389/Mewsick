package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import view.MewsickFrame;
import view.SongListPanel;

/**
 * Contains a main method that creates a window whose GUI is defined by the
 * code in the view package.
 * 
 * @author Sean Gallagher
 */
@SuppressWarnings("serial")
public class Start
{
	public static void main(String[] args)
	{
		MewsickFrame gui = new MewsickFrame();
		gui.setVisible(true);	
	}
}
