package controller;

import model.Mewsic;

/**
 * A singleton coordinator object for appropriate portions of the controller code.
 * Certain aspects of the controller code, such as ListenerFactory, rely on instances
 * of view objects, and are not suitable for inclusion here.
 * 
 * @author Sean Gallagher
 */
public class ControlCoord
{
	// single instance
	private static final ControlCoord instance = new ControlCoord();
	
	// our model
	private final Mewsic model;
	
	// controls song plays
	private final SongController songController;
	
	/**
	 * Makes a single ControlCoord
	 */
	private ControlCoord()
	{
		model = new Mewsic();
		songController = new SongController(model.getSongQueue());
	}
	
	/**
	 * Returns the single existing instance of ControlCoord
	 */
	public static ControlCoord getInstance()
	{
		return instance;
	}
	
	/**
	 * Returns the model
	 */
	public Mewsic getModel()
	{
		return model;
	}
	
	/**
	 * Returns the SongController
	 */
	public SongController getSongController()
	{
		return songController;
	}
}
