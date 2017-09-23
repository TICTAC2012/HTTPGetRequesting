package main;

import java.net.URL;

//Used to simplify the translation of the the response details into JSON
public class HTTPResponse {
	private URL url;
	private int responseCode;
	private int contentLength;
	private String responseDate;
	
	public HTTPResponse(URL u, int rC, int cL, String rD) {
		url = u;
		responseCode = rC;
		contentLength = cL;
		responseDate = rD;
	}
	
	public URL getUrl() {
		return url;
	}
	
	public int getResponseCode() {
		return responseCode;
	}
	
	public int getContentLength() {
		return contentLength;
	}
	
	public String getResponseDate() {
		return responseDate;
	}
}
