package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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

	public static void getListOfAddresses() {
		try {
			Scanner scanner = new Scanner(System.in);
			ArrayList<String> urlAddresses = new ArrayList<String>();
			String stringUrl = "";
			while(scanner.hasNextLine()) {
				stringUrl = scanner.nextLine();
				if(stringUrl.equals("")) {
					break;
				}else {
					urlAddresses.add(stringUrl);
				}
			}
			for(int i=0;i<urlAddresses.size();i++) {
				System.out.println(urlAddresses.get(i));
			}
			scanner.close();
		}
		catch(RuntimeException e) {
			System.err.println("An error occurred");
		}
	}

	public static void makeGetRequest() throws IOException, MalformedURLException {
		try {
			Scanner scanner = new Scanner(System.in);
			ArrayList<String> urlAddresses = new ArrayList<String>();
			String stringUrl = "";
			while(scanner.hasNextLine()) {
				stringUrl = scanner.nextLine();
				if(stringUrl.equals("")) {
					break;
				}else {
					urlAddresses.add(stringUrl);
				}
			}
			scanner.close();
			
			for(String urls : urlAddresses) {
				HttpURLConnection connection;
				URL webAddress = new URL(urls);
				connection = (HttpURLConnection) webAddress.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
			}
			
		}
		catch(RuntimeException e) {
			System.err.println("An error occurred");
		}
		catch(MalformedURLException e) {
			System.err.println("An invalid URL is contained within the list");
		}
		catch(IOException e) {
			System.err.println("Could not open connection to webpage");
		}
		
		
	}
	
	

}
