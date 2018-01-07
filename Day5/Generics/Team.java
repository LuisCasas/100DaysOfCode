import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
	
	private String name;
	int played = 0;
	int won = 0;
	int tied = 0;
	int lost = 0;
	
	
	private ArrayList<T> players = new ArrayList<>();
	
	public Team(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean addPlayer(T player) {
		if(players.contains(player)) {
			System.out.println(player.getName() + " player already exits");
			return false;
		}
		
		players.add(player);
		System.out.println(player.getName() +" added to the team");
		return true;
	}
	
	public int numPlayers() {
		return this.players.size();
	}
	
	public void matchResult(Team<T> opponent, int ourScore, int theirScore ) {
		
		played++;
		String message;
		
		if(ourScore > theirScore) {
			won++;
			message = this.name + "  beat ";
		} else if(ourScore == theirScore) {
			tied++;
			message = this.name + "  drew ";
		} else {
			lost++;
			message = this.name + "  lost with ";
		}
		
		if(opponent != null) {
			matchResult(null, theirScore, ourScore);
			System.out.println(message + opponent.getName());
		}
		
	}
	
	public int ranking() {
		return (won * 2) + tied;
	}

	@Override
	public int compareTo(Team<T> team) {

		if(this.ranking() < team.ranking()) {
			return -1;
		} else if(this.ranking() > team.ranking()) {
			return 1;
		}
		
		return 0;
	}
	
	
}
