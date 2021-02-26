package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileIO {
	private static File myFile = new File("studentData.txt");

	public static void writeStudent(String studentEntry) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(myFile, true))) {
			writer.println(studentEntry);
		}
	}

	public static Object[] readStudents() throws IOException {
		Scanner scanner = new Scanner(myFile);
		ArrayList<String> Userdata = new ArrayList<String>();
		while (scanner.hasNext()) {
			String studentEntry = scanner.nextLine();
			Userdata.add(studentEntry);
		}
		scanner.close();
		return Userdata.toArray();
	}

}
