import java.util.LinkedList;
import java.util.ArrayList;

public class PlayList {
	
	private String playlistName;
	private LinkedList<Songs> playlist;
	
	public PlayList(String playlistName, LinkedList<Songs> playlist) {
		this.playlistName = playlistName;
		this.playlist = playlist;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public LinkedList<Songs> getPlaylist() {
		return playlist;
	}
	

	public boolean addNewSong(Album album, String song) {
		
		// check if exits:
		Songs thisSong = album.findSong(song);
		
		if(thisSong == null) {
			System.out.println("The song " + song + " doesn't exists in the album " + album.getName());
			return false;
		} 
		
		this.playlist.add(thisSong);
		
		return true;
	}
}
