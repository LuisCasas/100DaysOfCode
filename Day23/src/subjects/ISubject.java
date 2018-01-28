package subjects;

import com.luiscasas.*;

import departments.IObserver;
import employment.Employee;

public interface ISubject {

	public void registerObserver(IObserver o);	
	public void removeObserver(IObserver o);
	public void notifyObserver(Employee emp, String msg);
	
}
