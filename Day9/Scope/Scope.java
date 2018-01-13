
public class Scope {
	
	public int publicVar = 0;
	private int varOne = 1;
	
	public Scope() {
		System.out.println("Calling the Scope Class, public var " + publicVar + ": private var" + varOne);
	}

	public int getVarOne() {
		return varOne;
	}
	
	public void timesTwo() {
		
		int varTwo = 2;
		
		for(int i = 0; i < 10; i++) {
			System.out.println( i + " times " + varTwo + " = " + i*varTwo );
		}
	}
	
	public void useInner() {
		
		InnerClass inner = new InnerClass();
		System.out.println("varThree from outter class: "+inner.varThree);
		
	}
	
	public class InnerClass{
		
		private int varThree = 3;
		
		public InnerClass() {
			System.out.println("Calling Inner class constructor, varOne is " + varOne + " and varThree is " + varThree);
		}
		
		
		public void timesTwo() {
			// int privateVar = 3;
			
			for(int i = 0; i < 10; i++) {
				System.out.println( i + " times " + varThree + " = " + (i*varThree) );
			}			
		}
	}
	
}
