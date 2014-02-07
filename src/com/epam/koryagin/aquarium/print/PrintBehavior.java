package com.epam.koryagin.aquarium.print;
/**
 * Interface for print polymorphism
 * @author Koryagin
 * @date 2014.02.07
 */
public interface PrintBehavior {
	public void print(Object message);
	public void println(Object message);
	public void println();
	public void printf(String format, Object...args);
	public void printError(Object message);
	public void printlnError(Object message);
	public void printInfo(Object message);
	public void printlnInfo(Object message);
	public void printFatal(Object message);
	public void printlnFatal(Object message);
	public void printDebug(Object message);
	public void printlnDebug(Object message);
	public void printTrace(Object message);
	public void printlnTrace(Object message);
	public void printWarning(Object message);
	public void printlnWarning(Object message);
}
