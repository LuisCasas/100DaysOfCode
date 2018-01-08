
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVFileReader {
	

	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	//Student attributes index
	private static final int STUDENT_ID_IDX = 0;
	private static final int STUDENT_FNAME_IDX = 1;
	private static final int STUDENT_LNAME_IDX = 2;
	private static final int STUDENT_GENDER = 3; 
	private static final int STUDENT_AGE = 4;
	
	public static void readCSVFile(String fileName) {
		
		BufferedReader fileReader = null;

		try {
			
			ArrayList<DummyData> data = new ArrayList<>();
			
			String line = "";
			
			fileReader = new BufferedReader(new FileReader(fileName));
			
			fileReader.readLine();
			
			while((line = fileReader.readLine()) != null) {
				
				String[] columns = line.split(COMMA_DELIMITER);
				
				if (columns.length > 0) {
					DummyData thisData = new DummyData(
							Long.parseLong(columns[STUDENT_ID_IDX]), 
							columns[STUDENT_FNAME_IDX], 
							columns[STUDENT_LNAME_IDX], 
							columns[STUDENT_GENDER], 
							Integer.parseInt(columns[STUDENT_AGE])
					);
					
					data.add(thisData);
				}
			}

			for(DummyData d : data) {
				System.out.println(d.toString());
			}
			
		} catch (Exception e) {
			System.out.println("Error while trying to read CSV file");
			e.printStackTrace();
		} finally {
			
			try {
				fileReader.close();
			} catch(IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		} 
		
	}

}
