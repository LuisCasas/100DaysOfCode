
public class SIBTest {
	
	public static final String owner;
	
	static {
		owner = "Luis";
		System.out.println("static initiation blocked call");
	}

	public SIBTest() {
		System.out.println("SIBTest constructor called");
	}

	static {
		System.out.println("static second initiation blocked call");
	}
	
	public void someMethod() {
		System.out.println("someMethod called");
	}
	
}
