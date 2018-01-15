
public class Password {
	
	private static final int key = 492385;
	private final int encryptedPassword;
	
	public Password(int password) {
		this.encryptedPassword = encrypt(password);
	}

	private int encrypt(int password) {
		return password ^ key;
	}
	
	public final void storePassword() {
		System.out.println("Saving password "+ this.encryptedPassword);
	}
	
	public boolean checkPassword(int password) {
		if(encrypt(password) == this.encryptedPassword) {
			System.out.println("Welcome to the application!");
			return true;
		}
		
		System.out.println("Unable to login with this password");
		return false;
	}
	
}
