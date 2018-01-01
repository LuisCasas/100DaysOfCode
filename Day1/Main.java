import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Player luis = new Player("Luis", 10, 8, "Sword");
		System.out.println(luis.toString());
		saveObject(luis);
		
		luis.setHitPoints(7);
		System.out.println(luis.toString());
		luis.setWeapon("Arrow");
		saveObject(luis);
		// loadObject(luis);
		
		System.out.println(luis.toString());
		
		ISaveable wolf = new Monster("Wolf", 20, 5);
		System.out.println(wolf);
		saveObject(wolf);
	}
	
	public static ArrayList<String> readValues(){
		
		ArrayList<String> values = new ArrayList<String>();
		
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		int index = 0;
		
		System.out.println("Press 1 to enter a value");
		System.out.println("Press 0 to stop adding values");
		
		
		while(!quit) {
			System.out.println("Choose an option:");
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
				case 0:
					quit = true;
					break;
				case 1:
					System.out.println("Enter the string:");
					String thisString = scanner.nextLine();
					values.add(index, thisString);
					index++;
					break;
				default:
					System.out.println("Please try another option");
					break;
			}
			
			// once 4 values have been added, stop the process here:
			if(index == 4) {
				quit = true;
			}
		}
		
		return values;
	}

	
	public static void saveObject(ISaveable objectToSave) {
		for(int i = 0; i < objectToSave.write().size(); i++) {
			System.out.println("Saving " + objectToSave.write().get(i) + " to storage");
		}
	}
	
	public static void loadObject(ISaveable objectToLoad) {
		ArrayList<String> values = readValues();
		objectToLoad.read(values);
	}
}
