package test;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests1 {
	
	//Test 1 - The program takes arguments from the command line and consumes input from stdin.
	@Test
	public final void whenInputIsGivenFromStdin() {
		HTTPRequesting.catchInput();
	}
}
