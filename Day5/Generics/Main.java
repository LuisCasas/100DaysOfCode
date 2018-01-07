import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		FootballPlayer ronaldo = new FootballPlayer("Cristiano Ronaldo");
//		FootballPlayer mesi = new FootballPlayer("Mesi");
		BasketPlayer lebron = new BasketPlayer("LeBron");
		BasketPlayer pauGasol = new BasketPlayer("Pau Gasol");
		
		Team<BasketPlayer> chicagoBulls = new Team<>("Chicago Bulls");
		chicagoBulls.addPlayer(lebron);
		
		Team<BasketPlayer> lakers = new Team<>("LA Lakers");
		lakers.addPlayer(pauGasol);
		
		
		Team<FootballPlayer> barcelona = new Team<>("FC Barcelona");
		Team<FootballPlayer> atletico = new Team<>("Atletico Madrid");
		
		Team<FootballPlayer> realMadrid = new Team<>("Real Madrid");
		realMadrid.addPlayer(ronaldo);		
		
		realMadrid.matchResult(barcelona, 4, 1);
		realMadrid.matchResult(atletico, 2, 0);
		atletico.matchResult(barcelona, 2, 2);
		
		System.out.println("Rankings:");
		System.out.println(realMadrid.getName() + " " + realMadrid.ranking());
		System.out.println(atletico.getName() + " " + atletico.ranking());
		System.out.println(barcelona.getName() + " " + barcelona.ranking());
		
		System.out.println(realMadrid.compareTo(barcelona));
		System.out.println(realMadrid.compareTo(atletico));

		System.out.println(barcelona.compareTo(realMadrid));
		System.out.println(atletico.compareTo(realMadrid));
		
	//	System.out.println(chicagoBulls.numPlayers());
		
//		ArrayList<Team> teams;
//		Collections.sort(teams);
	}

}
