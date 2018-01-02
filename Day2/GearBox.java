import java.util.ArrayList;

public class GearBox {
	
	private ArrayList<Gear> gears;
	private int maxGears;
	private int currentGear = 0;
	private boolean cluntch;
	
	public GearBox(int maxGears) {
		this.maxGears = maxGears;
		this.gears = new ArrayList<Gear>();
		Gear neutral = new Gear(0, 0.0);
		this.gears.add(neutral);
	}
	
	public void clutch(boolean in) {
		this.cluntch = in;
	}
	
	public void addGear(int number, double ratio) {
		if(number > 0 && number <= maxGears) {
			this.gears.add(new Gear(number, ratio));
		}
	}

	
	public void changeGear(int newGear) {
		if(newGear >= 0 && newGear < this.gears.size() && this.cluntch) {
			this.currentGear = newGear;
			System.out.println("Gear changed to "+ newGear);
		} else {
			this.currentGear = 0;
			System.out.println("Grind!!");
		}
	}
	
	public double wheelSpeed(int revs) {
		if(this.cluntch) {
			System.out.println("Ouch!!!");
			return 0.0;
		}
		
		return revs * gears.get(currentGear).getRatio();
	}
	
	private class Gear{
		private int gearNumber;
		private double ratio;
		
		public Gear(int gearNumber, double ratio) {
			
			this.gearNumber = gearNumber;
			this.ratio = ratio;
		}
		
		public double driveSpeed(int revs) {
			return revs * (this.ratio);
		}

		public double getRatio() {
			return ratio;
		}
		
		
	}
	
}
