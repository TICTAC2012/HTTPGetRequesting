package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import test.TestRunner;

public class DraftCode {

	//A full run of the program as intended.
	public static void main(String[]args) throws IOException {
		System.out.println("Would you like to \"Test\" or \"Run\" the program?");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if(choice.equalsIgnoreCase("test")) {
			TestRunner tr = new TestRunner();
			System.out.println("Which test will you run? (Enter a number from 1-6)");
			Scanner scanner2 = new Scanner(System.in);
			String testChoice = scanner2.next();
			scanner2.close();
			switch (testChoice) {
            case "1":  tr.RunTest1();
                     break;
            case "2":  tr.RunTest2();
                     break;
            case "3":  tr.RunTest3();
                     break;
            case "4":  tr.RunTest4();
                     break;
            case "5":  tr.RunTest5();
                     break;
            case "6":  tr.RunTest6();
                     break;
			}
		}else if(choice .equalsIgnoreCase("run")) {
			createJson();
		}
		
	}
	public static void createJson() throws IOException {
		try {
		System.out.println("Enter URL addresses to make a request of, leave blank to end input");
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
			connection.setConnectTimeout(100);
			connection.setRequestMethod("GET");
			connection.connect();
			
			//Code needed to convert UNIX timestamp into a readable date format.
			Date requestDate = new Date(connection.getDate());
			DateFormat dateFormatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
			
			
			//Output of HTTP response information in JSON
			HTTPResponse response = new HTTPResponse(connection.getURL().toString(),connection.getResponseCode(),connection.getContentLength(),dateFormatter.format(requestDate));
			jsonStrings.add(obj.toJson(response));
			
			}
			//We don't want to halt the whole program because a URL is invalid.
			catch(MalformedURLException e) {
				HTTPResponse response = new HTTPResponse(urls,"invalid url");
				jsonStrings.add(obj.toJson(response));
				//Will hand control back into the loop
				continue;
			}
			catch(SocketTimeoutException e) {
				continue;
			}
		}
		
		for(String jsonDocs: jsonStrings) {
			jsonWriter.write(jsonDocs+"\n");
		}
		jsonWriter.close();
		
	}

}
