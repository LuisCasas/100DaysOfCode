
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileWriter {

	// delimeter:
	private static final String COMMA_DELIMETER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String FILE_HEADER = "id,firstName,lastName,gender,age";

	public static void writeCSVFile(String fileName) {
		

		//Create new dummy data
		DummyData data1 = new DummyData(1, "Ahmed", "Mohamed", "M", 25);
		DummyData data2 = new DummyData(2, "Sara", "Said", "F", 23);
		DummyData data3 = new DummyData(3, "Ali", "Hassan", "M", 24);
		DummyData data4 = new DummyData(4, "Sama", "Karim", "F", 20);
		DummyData data5 = new DummyData(5, "Khaled", "Mohamed", "M", 22);
		DummyData data6 = new DummyData(6, "Ghada", "Sarhan", "F", 21);	
		
		ArrayList<DummyData> data = new ArrayList<>();
		
		data.add(data1);
		data.add(data2);
		data.add(data3);
		data.add(data4);
		data.add(data5);
		data.add(data6);

		
		FileWriter fileWriter = null;
		
		try {
			
			fileWriter = new FileWriter(fileName);
			
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR.toString());
			
			for(DummyData d : data) {
				fileWriter.append(String.valueOf(d.getId()));
				fileWriter.append(COMMA_DELIMETER);
				fileWriter.append(String.valueOf(d.getFirstName()));
				fileWriter.append(COMMA_DELIMETER);
				fileWriter.append(String.valueOf(d.getLastName()));
				fileWriter.append(COMMA_DELIMETER);
				fileWriter.append(String.valueOf(d.getGender()));
				fileWriter.append(COMMA_DELIMETER);
				fileWriter.append(String.valueOf(d.getAge()));
				fileWriter.append(NEW_LINE_SEPARATOR);
				System.out.println(d.toString());
			}
			
			// System.out.println("CSV file was created successfully !!!");
			
		} catch(Exception e) {
			
			System.out.println("Error when creating the file");
			e.printStackTrace();
			
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}
}
