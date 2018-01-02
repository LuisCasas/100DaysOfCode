
public class Main {

	public static void main(String[] args) {
		
		GearBox mcLaren = new GearBox(6);
//		GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//		System.out.println(first.driveSpeed(1000));
		mcLaren.addGear(1, 5.3);
		mcLaren.addGear(2, 10.6);
		mcLaren.addGear(3, 15.9);
		mcLaren.clutch(true);
		mcLaren.changeGear(1);
		mcLaren.clutch(false);
		System.out.println(mcLaren.wheelSpeed(1000));
		mcLaren.changeGear(2);
		System.out.println(mcLaren.wheelSpeed(3000));
		mcLaren.clutch(true);
		mcLaren.changeGear(3);
		mcLaren.clutch(false);
		System.out.println(mcLaren.wheelSpeed(6000));
	}

}
