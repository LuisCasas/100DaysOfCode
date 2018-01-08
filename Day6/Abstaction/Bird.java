
public abstract class Bird extends Animal implements CanFly{

	public Bird(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(getName() + " bird is eating!");
	}

	@Override
	public void breath() {
		System.out.println("Bird breaths");
		
	}

	public void fly() {
		System.out.println(getName()+" can fly");
	}
	
}
