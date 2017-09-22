package test;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests1 {
	
	//Test 1 - The program takes arguments from the command line and consumes input from stdin.
	@Test
	public final void whenInputIsGivenFromStdin() {
		HTTPRequesting.catchInput();
	}
	
	//Test 2 - The program output is written to stdout and errors are written to stderr.
	@Test
	public final void whenOutputOfArgumentsFromStdinIsPrinted() {
		HTTPRequesting.writeOutput();
	}
	
	@Test(expected = RuntimeException.class)
	public final void whenAnErrorOccurs() {
		HTTPRequesting.writeOutput();
	}

}
