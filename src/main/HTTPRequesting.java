package main;

import java.util.Scanner;

public class HTTPRequesting {
	
	//Gives a single input to the program.
	public static void catchInput() {
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextLine()) {
			String stringUrl = scanner.nextLine();
		}
		scanner.close();
	}
	
	//Gives input to program and output what was entered.
	public static void writeOutput() {
		try {
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNextLine()) {
				String stringUrl = scanner.nextLine();
				System.out.println(stringUrl);
			}
			scanner.close();
		}
		catch(RuntimeException e) {
			System.err.println("Output could not be written to command line");
		}
	}
	
	

}
