package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HTTPRequesting {
	
	//Gives a single input to the program.
	public static void catchInput() {
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextLine()) {
			scanner.nextLine();
		}
		scanner.close();
	}
	
	//Gives input to program and output what was entered.
	public static void writeOutput() {
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextLine()) {
			String stringUrl = scanner.nextLine();
			System.out.println(stringUrl);
		}
		scanner.close();
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
	public static void makeGetRequest() throws IOException {
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
			makeConnection(urlAddresses);
		}
		catch(RuntimeException e) {
			System.err.println("An error occurred");
		}
	}
	
	//Helper for the makeGetRequest method
	private static void makeConnection(ArrayList<String> urlAddresses) throws IOException {
		//For each URL string, we perform the same connection process.
		for(String urls : urlAddresses) {
			try{
			HttpURLConnection connection;
			URL webAddress = new URL(urls);
			connection = (HttpURLConnection) webAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			//Code needed to convert UNIX timestamp into a readable date format.
			Date requestDate = new Date(connection.getDate());
			DateFormat dateFormatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
			
			//Output of HTTP response information
			System.out.println(connection.getURL());
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getContentLength());
			System.out.println(dateFormatter.format(requestDate));
			}
			//We don't want to halt the whole program because a URL is invalid.
			catch(MalformedURLException e) {
				System.out.println("An invalid URL is contained within the list.");
				//Will hand control back into the loop
				continue;
			}
		}
	}
	
	public static void waitForTimeout() throws IOException {
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
				
				//Force a timeout to occur
				connection.setConnectTimeout(1);
				connection.connect();
				}
				catch(MalformedURLException e) {
					//Will hand control back into the loop
					continue;
				}
			}
		}
		catch(RuntimeException e) {
			System.err.println("An error occurred");
		}
		
	}

	public static void createJson() throws IOException {
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
		generateJson(urlAddresses);
		}
		catch(RuntimeException e) {
			System.err.println("An error occurred");
		}
	}

	//Helper for the createJson method above
	public static void generateJson(ArrayList<String> urlAddresses) throws IOException {
		//For each URL string, we perform the same connection process.
		ArrayList<String> jsonStrings = new ArrayList<String>();
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson obj = gsonBuilder.create();
		PrintWriter jsonWriter = new PrintWriter(new FileOutputStream(new File("HTTPRequests.json"),false));
		
		for(String urls : urlAddresses) {
			try{
			HttpURLConnection connection;
			URL webAddress = new URL(urls);
			connection = (HttpURLConnection) webAddress.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			//Code needed to convert UNIX timestamp into a readable date format.
			Date requestDate = new Date(connection.getDate());
			DateFormat dateFormatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
			
			
			//Output of HTTP response information in JSON
			HTTPResponse response = new HTTPResponse(connection.getURL().toString(),connection.getResponseCode(),connection.getContentLength(),dateFormatter.format(requestDate));
			
			System.out.println(obj.toJson(response));
			jsonWriter.write(obj.toJson(response));
			
			}
			//We don't want to halt the whole program because a URL is invalid.
			catch(MalformedURLException e) {
				HTTPResponse response = new HTTPResponse(urls,"invalid url");
				System.out.println(obj.toJson(response));
				jsonWriter.write(obj.toJson(response));
				//Will hand control back into the loop
				continue;
			}
		}
		
		for(String jsonDocs: jsonStrings) {
			jsonWriter.write(jsonDocs+"\n");
		}
		jsonWriter.close();
		
	}
}
