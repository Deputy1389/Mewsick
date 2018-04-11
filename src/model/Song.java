package model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;



public class Song implements Serializable{
	private String name, artist, album, genre, filename, duration;
	private int seconds;
	
	public Song(String file){
		this.filename = file;
		getMetaData(file);
	}
	
	private void getMetaData(String file) {	
		File testFile = new File(file);
		AudioFile f = null;
		try {
			f = AudioFileIO.read(testFile);
		} catch (CannotReadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TagException e) {
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			e.printStackTrace();
		}
		Tag tag = f.getTag();
		
	
		name = tag.getFirst(FieldKey.TITLE);
		artist = tag.getFirst(FieldKey.ARTIST);
		album = tag.getFirst(FieldKey.ALBUM);
		genre = tag.getFirst(FieldKey.GENRE);
		
		seconds = f.getAudioHeader().getTrackLength();
		duration = "" + seconds/60 + ":" + seconds%60;
	}

	public String getName(){
		return name;
	}
	public String getArtist(){
		return artist;
	}
	public String getAlbum(){
		return album;
	}
	public String getGenre(){
		return album;
	}

	public String getFileName() {
		return filename;
	}

	public int getLength() {
		// TODO Auto-generated method stub
		return seconds;
	}
}
