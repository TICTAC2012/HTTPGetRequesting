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
	
	//Test 4 - The program should make an http GET request to each valid address in its input
	@Test
	public final void whenSuccessfulRequestsAreMade() throws IOException {
		HTTPRequesting.makeGetRequest();
	}
	
	@Test(expected = MalformedURLException.class)
		HTTPRequesting.makeGetRequest();
	}
}
