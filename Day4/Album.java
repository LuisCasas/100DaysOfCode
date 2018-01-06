
import java.util.ArrayList;

public class Album {
	
	private String name;
	// private ArrayList<Songs> songList;
	private SongList songList;
	
	
	public Album(String name, ArrayList<Songs> songList) {
		this.name = name;
		this.songList = new SongList(songList);
	}


	public String getName() {
		return name;
	}


	public SongList getSongsList() {
		return songList;
	}
	
	public Songs findSong(String song) {
		return this.songList.findSong(song);
	}
	
	private class SongList {

		private ArrayList<Songs> songsList = new ArrayList<Songs>();
		
		public SongList(ArrayList<Songs> songsList) {
			this.songsList = songsList;
		}
		
		public ArrayList<Songs> getSongsList() {
			return songsList;
		}
		
		public void addSong(Songs song) {
			if(!this.songsList.contains(song)) {
				this.songsList.add(song);
			}
		}
		
		private Songs findSong(String song) {
			
			ArrayList<Songs> songs = this.getSongsList();
			
			for(int i = 0; i < songs.size(); i++) {
				if(songs.get(i).getName().equals(song)) {
					return songs.get(i);
				}
			}
			
			return null;
		}	
	}	

}
