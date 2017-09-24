package test;

import java.io.IOException;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests5 {
	
	@Test
	public final void whenJsonIsOutput() throws IOException {
		HTTPRequesting.createJson();
	}
}
