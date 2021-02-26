package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileIO {
	private static File myFile = new File("covid_Report.txt");
	private static File readFile = new File("filterRecords.txt");

	public static void writeRecord(String recordEntry) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(myFile, true))) {
			writer.println(recordEntry);
		}
	}

	public static Object[] readRecords() throws IOException {
		Scanner scanner = new Scanner(myFile);
		ArrayList<String> data = new ArrayList<String>();
		while (scanner.hasNext()) {
			String recordEntry = scanner.nextLine();
			data.add(recordEntry);
		}
		scanner.close();
		return data.toArray();
	}

}
