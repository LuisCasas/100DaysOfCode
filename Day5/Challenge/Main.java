
public class Main {

	public static void main(String[] args) {
		
		League<Team<FootballPlayer>> laLiga = new League<>("La Liga");
		Team<FootballPlayer> realMadrid = new Team<>("Real Madrid");
		Team<FootballPlayer> barcelona = new Team<>("Barcelona");
		Team<FootballPlayer> atletico = new Team<>("Atletico");
		
		laLiga.addTeam(realMadrid);
		laLiga.addTeam(atletico);
		laLiga.addTeam(barcelona);
		

		realMadrid.matchResult(barcelona, 4, 1);
		realMadrid.matchResult(atletico, 2, 0);
		atletico.matchResult(barcelona, 2, 2);
		
		laLiga.leagueTable();
		
//		FootballPlayer ronaldo = new FootballPlayer("Cristiano Ronaldo");
//		FootballPlayer bale = new FootballPlayer("Bale");
		
	}

}
