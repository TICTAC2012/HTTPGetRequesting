package test;

import org.junit.Test;

import main.HTTPRequesting;

//Test 1 - The program takes arguments from the command line and consumes input from stdin.
public class Test1 {
	
	@Test
	public final void whenInputIsGivenFromStdin() {
		HTTPRequesting.catchInput();
	}
	

}
