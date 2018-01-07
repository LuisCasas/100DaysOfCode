import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
	
	private String name;
	private ArrayList<T> league = new ArrayList<>();

	public League(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<T> getTeams(){
		return this.league;
	}
	
	public boolean addTeam(T team) {
		if(this.league.contains(team)) {
			System.out.println("Team already exists on this league");
			return false;
		} else {
			this.league.add(team);
			System.out.println("Team added to the league");
			return true;
		}
	}
	
	public void leagueTable() {
		Collections.sort(league);
		for(T t : league) {
			System.out.println(t.getName() + " : " + t.ranking());
		}
	}
}
