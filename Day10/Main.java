
public class Main {

	public static void main(String[] args) {
		
//		FinalClass one = new FinalClass("One");
//		FinalClass two = new FinalClass("Two");
//		FinalClass three = new FinalClass("Three");
//		
//		System.out.println(one.getInstance());
//		System.out.println(two.getInstance());
//		System.out.println(three.getInstance());
//		
//		int pw = 649302;
//		Password password = new ExtendsPassword(pw);
//		password.storePassword();
//		
//		password.checkPassword(0);
//		password.checkPassword(024232);
//		password.checkPassword(9401);
//		password.checkPassword(pw);
		
		System.out.println("Main class called");
		SIBTest test = new SIBTest();
		test.someMethod();
		System.out.println("Owner of this: " + test.owner);
		
		
	}

}
