package test;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.junit.Test;

import main.HTTPRequesting;

public class MyTests6 {

	@Test(expected = SocketTimeoutException.class)
	public final void whenConnectionTimesout() throws IOException {
		HTTPRequesting.waitForTimeout();
		System.out.println("Connection Timed Out");
	}
}
