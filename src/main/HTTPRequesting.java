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

	//Gives multiple lines of input to the program and adds them to an ArrayList
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

	//Takes in a list of potential URLs and attempts to connect to them.
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
			
			//For each URL string, we perform the same connection process.
			for(String urls : urlAddresses) {
				try{
				HttpURLConnection connection;
				URL webAddress = new URL(urls);
				connection = (HttpURLConnection) webAddress.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				System.out.println(connection.getURL());
				System.out.println(connection.getResponseCode());
				System.out.println(connection.getContentLength());
				System.out.println(connection.getDate());
				}
				//We don't want to halt the whole program because a URL is invalid.
				catch(MalformedURLException e) {
					System.out.println("An invalid URL is contained within the list.");
					//Will hand control back into the loop
					continue;
				}
			}
			
		}
		catch(RuntimeException e) {
			System.err.println("An error occurred");
		}
		catch(IOException e) {
			System.err.println("Could not open connection to webpage");
		}
		
		
	}
	
	

}
