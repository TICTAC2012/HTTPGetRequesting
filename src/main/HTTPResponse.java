package main;

//Used to simplify the translation of the the response details into JSON
public class HTTPResponse {
	private String url; 
	private int responseCode;
	private int contentLength;
	private String responseDate;
	private String error;
	
	public HTTPResponse(String u, int rC, int cL, String rD) {
		url = u;
		responseCode = rC;
		contentLength = cL;
		responseDate = rD;
	}
	
	public HTTPResponse(String u, String eM) {
		url = u;
		error = eM;
	}
	
	public String getUrl() {
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
