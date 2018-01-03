
import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Button button = new Button("Print");
	

	public static void main(String[] args) {
		
//		class ClickListener implements Button.onClickListener{
//			
//			public ClickListener() {
//				System.out.println("I've been called");
//			}
//			
//			@Override
//			public void onClick(String title) {
//				System.out.println(title +" was clicked!");
//			}
//		}

		//button.setOnClickListener(new ClickListener());
		
		//example of anonymous class:
		button.setOnClickListener(new Button.onClickListener() {
			
			@Override
			public void onClick(String title) {
				System.out.println(title + " was clicked!");
			}
		});
		listen();
	}
	
	private static void listen() {
		boolean quit = false;
		
		while(!quit) {
			
			int choice = scanner.nextInt();
			
			if(choice == 0) {
				System.out.println("Terminate application");
				quit = true;
			} else {
				button.onClick();
			}
		}
		
	}
}
