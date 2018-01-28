package departments;

import employment.Employee;

public interface IObserver {
	
	public void callEmployee(Employee emp, String msg);

}
