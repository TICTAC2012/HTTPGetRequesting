package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public void RunTest1() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(MyTests1.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
	    }	
		System.out.println("MyTests1 Success: " + result.wasSuccessful());
	}
	
	public void RunTest2() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(MyTests2.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
	    }	
		System.out.println("MyTests2 Success: " + result.wasSuccessful());
	}
	
	public void RunTest3() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(MyTests3.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
	    }	
		System.out.println("MyTests3 Success: " + result.wasSuccessful());
	}
	
	public void RunTest4() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(MyTests4.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
	    }	
		System.out.println("MyTests4 Success: " + result.wasSuccessful());
	}
	
	public void RunTest5() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(MyTests5.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
	    }	
		System.out.println("MyTests5 Success: " + result.wasSuccessful());
	}
	
	public void RunTest6() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(MyTests6.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
	    }
		System.out.println("MyTests6 Success: " + result.wasSuccessful());
	}
}
