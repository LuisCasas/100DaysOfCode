import java.util.List;
import java.util.ArrayList;

public interface ISaveable {
	
	List<String> write();
	void read(List<String> savedValues);

}
