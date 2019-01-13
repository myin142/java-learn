package root.util;

import java.io.*;
import java.util.stream.Stream;

// Exceptions alters program flow when Java does not know what to do
// Types of Exceptions
//		Unchecked Exceptions: RuntimeException, can be thrown anywhere
//		Checked Exceptions: Exception \ {RuntimeException}, has to be declared or handled
//		Errors: Thrown by JVM, should not be handled or declared
public class Exceptions {

	// RuntimeException: (can be thrown anywhere, should be handled/declared)
	//		ArithmeticException						Divide by 0
	//		ArrayIndexOutOfBoundsException			Illegal Index for Array
	//		ClassCastException						Cast Object to illegal subclass
	//		NullPointerException					Object is null reference
	//		IllegalArgumentException				Illegal argument to method
	//		NumberFormatException					Convert String to numberic type, invalid format
	//
	//		ArrayStoreException						Store wrong type in array
	//		IllegalStateException					Method invoked at illegal time
	//		UnsupportedOperationException			Operation not supported
	//		time.DateTimeException					Invalid format for date/time
	//		util.MissingResourceException			Access non-existing key/resource bundle
	//
	// Checked Exception: (must be handled/declared)
	//		io.IOException							Problem read/write file, super class of all io exceptions
	//		io.FileNotFoundException				Reference non-existing file
	//
	//		io.NotSerializableException				Cannot be serialized, all variables need to be serializable
	//		text.ParseException						Convert String to a number
	//		sql.SQLException						Super class exception for database exceptions
	//
	// Errors: (can be thrown anywhere, should not be handled/declared)
	//		ExceptionInInitializerError				Exception in static initializer
	//		StackOverflowError						Method calls itself too many times -> stack overflown
	//		NoClassDefFoundError					Class is available at copmile time but not runtime

	public static void init(){

		// try needs either catch and/or finally block
		//
		// Compiler error if catch clause unreachable:
		//		When super class catched before sub class
		//		When catching checked exception that will not be thrown
		//		When catching already catched exception
		try{
			throwException();
		}

		// Multi-catch:
		//		Exception has to be unrelated
		//		Only one variable at the end
		//		Variable cannot be reassigned (effectively final)
		catch(IOException | NullPointerException e){}
		
		// Checked Exception allowed to catch
		//		Same exception
		//		Subclass of exception
		//
		// Except for Exception: Can always be caught
		catch(Exception e){}
		
		// Always called even when exception is thrown
		// Only last thrown exception will be shown at the end
		finally {}

		// try-with-resource: (curly brackets required)
		//		Multiple resources separated by ';'
		//		Class has to implement AutoCloseable (or Closeable)
		//		Resources closed in reverse order (b closed before a)
		//		When multiple exceptions thrown:
		//			-> all but first are suppressed exceptions
		//			-> only type of first exception can be caught
		//
		// interface Closeable(){ public void close() throws IOException; }
		// interface AutoCloseable(){ public void close() throws Exception; }
		try(AutoCloseable a = Stream.empty(); AutoCloseable b = Stream.empty()){}

		// Catch and Finally block optional:
		// 		But implicit finally block is called first -> resources will be closed first
		//		Checked Exception still have to be declared or handled
		catch(Exception e){

			// Get Suppressed Exceptions
			Throwable[] suppressed = e.getSuppressed();

		}
		finally{}

		// Assertions: (disabled by default !!)
		//		Boolean expression in code to verify something certain is true
		//		Enable: -enableassertions | -ea:package.name...		enable for package, package name optional
		//		Disable: -disableassertions | -da:package.class		disable for class, class name optional
		//		Throws AssertionError if boolean value is false
		//		Should not alter outcomes
		//
		// Using Assertions:
		//		Internal Invariants 		value is within certain constraint, assert x > 0
		//		Class Invariants 			validity of object state, use private method to test state of object
		//		Control Flow Invariants		line of code assumed unreachable
		//		Preconditions				certain condition before calling method
		//		Post Conditions				certain condition after calling method
		//
		// Syntax: brackets and message optional
		assert (false) : "Message";
	}

	// throws: in method declaration to declare an exception might be thrown
	// throw: actually throwing an exception
	private static void throwException() throws IOException{
		throw new FileNotFoundException();
	}

}

// Creating Custom Exception: By extending Exception (Checked) or RuntimeException (Unchecked)
class CustomException extends Exception {
	public CustomException(){ super(); }
	public CustomException(Exception e){ super(e); }
	public CustomException(String msg){ super(msg); }
}