import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album(String _name, String _artist) {
		this.name = _name;
		this.artist = _artist;
		this.songs = new ArrayList<Song>();
	}

	public Song findSong(String _title) { // check whether the new song already exists in the album or not
		for (Song s : songs) {
			if (s.title.equals(_title))
				return s;
		}
		return null;
	}
	
	public boolean addSong(String _title, double _duration) { // add song to playlist
		if (findSong(_title) == null) {
			songs.add(new Song(_title, _duration));
//			System.out.println(_title + " Successfully added");
			return true;
		} else {
//			System.out.println("Already Exists");
			return false;
		}
	}
	
	public void addToPlayList(int trackNumber, LinkedList<Song> PlayList) { // add song to playlist via trackNumber
		int index = trackNumber - 1; // cause trackNumber is 1 based index
		if (index > 0 && index <= songs.size()) {
			PlayList.add(songs.get(index));
		} else {
			System.out.println("Searched song doesn't exist in the Album");
		}
	}
	
	public void addToPlayList(String _title, LinkedList<Song> PlayList) { // add song to playlist via title
		Song song = findSong(_title);
		if (song != null) {
			PlayList.add(song);
		} else {
			System.out.println("Searched song doesn't exist in the Album");
		}
	}
}	
