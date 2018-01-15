
public class FinalClass {
	
	private static 	int counter = 0;
	public final int instance;
	private final String name;
	
	public FinalClass(String name) {
		
		this.name = name;
		counter++;
		instance = counter;
		System.out.println(name+ " created, this instance is " + instance);
		
	}
	
	public int getInstance() {
		return instance;
	}

}
