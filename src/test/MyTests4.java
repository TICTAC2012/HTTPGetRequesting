package test;

import java.io.IOException;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests4 {

	//Test 4 - The program should make an http GET request to each valid address in its input and record particular properties of the http response in the program output. 
		@Test
		public final void whenSuccessfulRequestsAreMade() throws IOException {
			HTTPRequesting.makeGetRequest();
		}
		
		/*
		//Not necessary for right now? For use with proper command line arguments instead?
		@Test(expected = IOException.class)
		public final void whenFailedRequestsAreMade() throws IOException {
			HTTPRequesting.makeGetRequest();
		}*/
}
