package test;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests3 {

	//Test 3 - Input format is a newline separated list of public web addresses
	@Test
	public final void whenInputIsAListOfStrings() {
		HTTPRequesting.getListOfAddresses();
	}
	
}
