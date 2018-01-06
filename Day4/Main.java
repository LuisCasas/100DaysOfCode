
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	private static LinkedList<Songs> playlistSongs = new LinkedList<Songs>();
	private static ArrayList<Songs> kornSongs = new ArrayList<Songs>();
	private static ArrayList<Songs> metallicaSongs = new ArrayList<Songs>();
	private static ArrayList<Songs> slayerSongs = new ArrayList<Songs>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		// initialise the albums and songs
		PlayList playlist = addSpongsAlbum();
		
		play(playlist);
		
	}
	
	public static void showOptions() {
		System.out.print("\nPress:");
		System.out.print("\n 0 - To see options");
		System.out.print("\n 1 - See Playlist songs");
		System.out.print("\n 2 - Play next song");
		System.out.print("\n 3 - Play previous song");
		System.out.print("\n 4 - Replay song");
		System.out.print("\n 5 - Quit application");		
	}	
	
	private static void printPlaylist(PlayList playlist) {
		
		System.out.println("Playlist name: " + playlist.getPlaylistName());
		ListIterator<Songs> songs = playlist.getPlaylist().listIterator();
		
		int count = 1;
		
		while(songs.hasNext()) {
			System.out.println("Song #" + count + " " + songs.next().toString());
			count++;
		}
	}
	
	private static boolean play(PlayList playlist) {
		
		boolean quit = false;
		boolean forward = true;
		int choice;
		ListIterator<Songs> listIterator = playlist.getPlaylist().listIterator();
		
		if(playlist.getPlaylist().size() == 0) {
			System.out.println("The playlist "+ playlist.getPlaylistName() + " is empty!");
			return false;
		} else {
			System.out.println("Start playing " + playlist.getPlaylistName() + " setlist!");
			System.out.println("Now playing " + listIterator.next().toString());
		}
		
		showOptions();
		
		while(!quit) {
			System.out.println("Pick your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				case 0:
					showOptions();
					break;
				case 1:
					printPlaylist(playlist);
					break;
				case 2:
					if(!forward) {
						if(listIterator.hasNext()) {
							listIterator.next();
						}
						forward = true;
					}
					
					if(listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
					} else {
						System.out.println("Playlist has finished playing all its songs");
						forward = false;
					}
					
					break;
				case 3:
					if(forward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward = false;
					}
					
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
					} else {
						System.out.println("Playlist is at the start of the songs");
						forward = true;
					}
					break;
				case 4:
					if(listIterator.hasPrevious()) {
						System.out.println("Replay song " + listIterator.previous().toString());
						listIterator.next();
					} else {
						System.out.println("No song selected, please press 2 to start the playlist again");
					}
					break;
				case 5:
					System.out.println("Stop setlist application.");
					quit = true;
					break;
	
			}
		}	
		
		return true;
	}
	
	private static PlayList addSpongsAlbum() {
		// Add new album with songs:
		kornSongs.add(new Songs("Make me bad", 4.10));
		kornSongs.add(new Songs("Korn", 3.34));
		kornSongs.add(new Songs("Blind", 4.40));
		kornSongs.add(new Songs("4u", 1.24));
		kornSongs.add(new Songs("Freak on a leash", 1.24));
		Album korn = new Album("Korn", kornSongs);
		
		metallicaSongs.add(new Songs("Battery",3.20));
		metallicaSongs.add(new Songs("Fade to Black",6.54));
		metallicaSongs.add(new Songs("Unforgiven",5.32));
		metallicaSongs.add(new Songs("Nothing else matters",4.17));
		Album metallica = new Album("Metallica", metallicaSongs);
		
		slayerSongs.add(new Songs("Raingin Blood", 3.12));
		slayerSongs.add(new Songs("South of heaven", 4.41));
		slayerSongs.add(new Songs("Angel of death", 2.02));
		slayerSongs.add(new Songs("Seasson in a abby", 5.12));
		Album slayer = new Album("Slayer", slayerSongs);
		
		PlayList playlist = new PlayList("Heavy Metal", playlistSongs);
		
		playlist.addNewSong(korn, "4u");	
		playlist.addNewSong(slayer, "Angel of death");	
		playlist.addNewSong(korn, "Make me bad");	
		playlist.addNewSong(metallica, "Fade to Black");	
		playlist.addNewSong(metallica, "Battery");	
		playlist.addNewSong(korn, "Blind");	
		playlist.addNewSong(metallica, "Nothing else");	
		playlist.addNewSong(metallica, "Blind");			
		
		System.out.println("==================");
		
		return playlist;
	}
	
}
