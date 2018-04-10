package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ListenerFactory;


@SuppressWarnings("serial")
public class Panel extends JPanel
{
	private static final Color BG_COLOR = Color.WHITE;
	
	// Text field for the username
	private JTextField username;
	
	// Password field
	private JPasswordField password;
	
	// Gives user information about current login
	private JLabel statusText = new JLabel("Not currently signed in");
	
	/**
	 * Constructs a JPanel that has appropriate log in/out components
	 * @param factory A factory used to create event listeners.
	 */
	public Panel(ListenerFactory factory)
	{
		addComponents(factory);
	}
	
	/**
	 * Adds the username and password textfields and the login/logout buttons
	 * as well as the information text.
	 * 
	 * @param factory The ListenerFactory used to add listeners to the buttons
	 */
	private void addComponents(ListenerFactory factory)
	{
		JPanel componentPanel = new JPanel();
		componentPanel.setLayout(new GridLayout(0, 1));
		componentPanel.setBackground(BG_COLOR);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.setBackground(BG_COLOR);
		usernamePanel.add(new JLabel("Username"));
		username = new JTextField(8);
		usernamePanel.add(username);
		componentPanel.add(usernamePanel);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBackground(BG_COLOR);
		passwordPanel.add(new JLabel("Password"));
		password = new JPasswordField(8);
		passwordPanel.add(password);
		componentPanel.add(passwordPanel);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(BG_COLOR);
		statusPanel.setPreferredSize(new Dimension(400, 0));
		statusPanel.add(statusText);
		componentPanel.add(statusPanel);
		
		add(componentPanel);
	}
	
}
