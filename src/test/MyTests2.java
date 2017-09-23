package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests2 {

	//Test 3 - Input format is a newline separated list of public web addresses
	@Test
	public final void whenInputIsAListOfStrings() {
		HTTPRequesting.getListOfAddresses();
	}
	
	//Test 4 - The program should make an http GET request to each valid address in its input and record particular properties of the http response in the program output. 
	@Test
	public final void whenSuccessfulRequestsAreMade() throws IOException {
		HTTPRequesting.makeGetRequest();
	}
	
	@Test(expected = MalformedURLException.class)
	public final void whenFailedRequestsAreMade() throws IOException, MalformedURLException {
		HTTPRequesting.makeGetRequest();
	}
}
