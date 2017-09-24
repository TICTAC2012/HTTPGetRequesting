package test;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests2 {

	//Test 2 - The program output is written to stdout and errors are written to stderr.
	@Test
	public final void whenOutputOfArgumentsFromStdinIsPrinted() {
		HTTPRequesting.writeOutput();
	}
	
	@Test(expected = RuntimeException.class)
	public final void whenAnErrorOccurs() {
		HTTPRequesting.writeOutput();
		System.err.println("Output could not be written to command line");
	}
}
