
public class Main {

	public static void main(String[] args) {
		Dog dog = new Dog("Tobi");
		
		dog.breath();
		dog.eat();
	
		Parrot parrot = new Parrot("Parrot");
		parrot.breath();
		parrot.eat();
		parrot.fly();
		
		Penguin penguin = new Penguin("Penguin");
		penguin.breath();
		penguin.eat();
		penguin.fly();
	}

}
