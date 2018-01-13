
public class Main {

	public static void main(String[] args) {
		String varMain = "this a private var from Main()";
		
		Scope scope = new Scope();
		scope.useInner();
		

//		Scope.InnerClass innerClass = scope.new InnerClass();
//		System.out.println("varThree inner class is: " + innerClass.varThree);
		
		
		System.out.println("scope instant private varOne is " + scope.getVarOne());
		System.out.println("main scope private var is " + varMain);

		scope.timesTwo();
		System.out.println("========================");
		Scope.InnerClass innerScope = scope.new InnerClass();
		innerScope.timesTwo();
	}

}
