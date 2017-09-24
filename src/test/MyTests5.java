package test;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests5 {
	
	@Test
	public final void whenJsonIsOutput() throws IOException {
		HTTPRequesting.createJson();
	}
	
	/*
	@Test(expected = UnknownHostException.class)
	public final void whenThereIsNoInternetConnection() throws IOException {
		HTTPRequesting.createJson();
	}*/
}
