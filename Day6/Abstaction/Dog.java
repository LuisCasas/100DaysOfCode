
public class Dog extends Animal{

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		System.out.println(getName() + " the dog is eating dog food!");
	}

	@Override
	public void breath() {
		System.out.println("Dog is breathing");
	}

	
	
}
