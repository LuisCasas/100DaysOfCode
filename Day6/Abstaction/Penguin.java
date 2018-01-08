
public class Penguin extends Bird {

	public Penguin(String name) {
		super(name);
	}

	@Override
	public void fly() {
		System.out.println("Penguins can't fly");
	}
	
	

}
