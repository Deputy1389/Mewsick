package model;

/**
 * Stores references to disparate model elements and allows access to them.
 * 
 * @author Sean Gallagher
 */
public class Mewsic
{
	// Holds the currently playing Songs
	private final SongQueue songQueue = new SongQueue();
	
	// Holds the set of all Songs
	private final SongLibrary library =	SongLibrary.getInstance();

	/**
	 * Gets the Song Library
	 */
	public SongLibrary getSongLibrary()
	{
		return library;
	}
	
	/**
	 * Gets the Song Queue adapted for use with JLists.
	 */
	public SongQueue getSongQueue()
	{
		return songQueue;
	}
	
	
	/**
	 * Saves the model data
	 */
	public void save()
	{
		getSongLibrary().saveLibrary();
		getSongQueue().saveQueue();
	}
	
	/**
	 * Loads the model data
	 */
	public void load()
	{
		getSongLibrary().loadLibrary();
		getSongQueue().loadQueue();
	}
}
