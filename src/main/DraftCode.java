package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DraftCode {

	public static void main(String[]args) throws IOException {
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
		}
		
		for(String jsonDocs: jsonStrings) {
			jsonWriter.write(jsonDocs+"\n");
		}
		jsonWriter.close();
		
	}

}
