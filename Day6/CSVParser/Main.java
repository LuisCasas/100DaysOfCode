
public class Main {

	public static void main(String[] args) {
		
		String fileName = System.getProperty("user.home")+"/Documents/data.csv";
		
		System.out.println(fileName);

		System.out.println("Write CSV file:");
		CSVFileWriter writeFile = new CSVFileWriter();
		writeFile.writeCSVFile(fileName);
		
		System.out.println("Read CSV file:");
		CSVFileReader readFile = new CSVFileReader();
		readFile.readCSVFile(fileName);
		
		
	}

}
