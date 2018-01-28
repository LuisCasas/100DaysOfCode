package departments;

import employment.Employee;

public class ITDepartment implements IObserver{

	@Override
	public void callEmployee(Employee emp, String msg) {
		System.out.println(getClass().getName()+" notified!");
		System.out.println("Call to " + emp.getName() + ", msg: \n " + msg);
	};
	
	
}
