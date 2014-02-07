package com.epam.koryagin.aquarium.print;

import java.io.PrintStream;
/**
 * Console output
 * @author Admin
 */
public class Console implements PrintBehavior {
	private static final PrintStream standardOutput = System.out;
	private static final PrintStream errorOutput = System.err;
	/**
	 * 
	 */
	public Console(){
		super();
	}
	
	
	@Override
	public void print(Object message) {
		standardOutput.print(message.toString());
	}

	@Override
	public void println(Object message) {
		standardOutput.println(message.toString());
	}

	@Override
	public void printError(Object message) {
		errorOutput.print(message);
		
	}

	@Override
	public void printlnError(Object message) {
		errorOutput.println(message);
		
	}

	@Override
	public void printInfo(Object message) {
		standardOutput.print(message);
		
	}

	@Override
	public void printlnInfo(Object message) {
		standardOutput.println(message);
		
	}

	@Override
	public void printFatal(Object message) {
		standardOutput.print(message);
		
	}

	@Override
	public void printlnFatal(Object message) {
		standardOutput.println(message);
		
	}

	@Override
	public void printDebug(Object message) {
		standardOutput.print(message);
		
	}

	@Override
	public void printlnDebug(Object message) {
		standardOutput.println(message);
		
	}

	@Override
	public void printTrace(Object message) {
		standardOutput.print(message);
		
	}

	@Override
	public void printlnTrace(Object message) {
		standardOutput.println(message);
		
	}

	@Override
	public void printWarning(Object message) {
		errorOutput.print(message);
		
	}

	@Override
	public void printlnWarning(Object message) {
		errorOutput.println(message);
		
	}

	@Override
	public void println() {
		standardOutput.println();
	}


	@Override
	public void printf(String format, Object... args) {
		standardOutput.printf(format, args);
		
	}

}
