/* Topics:
 *	Exceptions
 */

package root.util;

import java.io.*;

/**
 * Summary
 * 
 *  Runtime Exception can be thrown anywhere
 *  Checked Exception has to be declared or handled
 * 	Error should not be handled by programmer, but can also be declared and handled
 *	Try block needs catch or finally block
 *	Unreachable catch clauses causes compiler error
 * 
 */

// Exceptions alters program flow when Java does not know what to do
// Types of Exceptions
//	Unchecked Exceptions: RuntimeException, can be thrown anywhere
//	Checked Exceptions: Exception \ {RuntimeException}, has to be declared or handled
//	Errors: Thrown by JVM, should not be handled or declared
//
//	RuntimeException and Errors can be thrown anywhere even without declaration
public class Exceptions {

	public Exceptions(){

		// try needs either catch and/or finally block
		try{
		/* Runtime Exceptions thrown by JVM */
			String[] array = new String[2];

			// ArithmeticException
			//int error = 2 / 0;

			// ArrayIndexOutOfBoundsException
			//array[2] = null;
			
			// NullPointerException
			//array[0].toString();

			// ClassCastException
			//Object obj = new Object();
			//array[0] = (String)obj;

		/* Runtime Exceptions thrown by programmer */

			// When illegal or inappropriate argument passed to a method
			//throw new IllegalArgumentException("wrong argument");

			// NumberFormatException
			//Integer.parseInt("abc");
		}
		
		// If exception is catch and handled, code continues normally after catch/finally
		catch(RuntimeException e){ throw e; }
		catch(Exception e){ throw e; }

		// If a catch clause is unreachable -> compiler error
		//catch(ArithmeticException e){}

		// Only last thrown exception will be shown at the end
		finally{
			//throw new RuntimeException();
		}
	}

	/* Checked Exceptions */
	private void throwFileNotFound() throws FileNotFoundException{ throw new FileNotFoundException("No File"); }
	private void throwIO() throws IOException{ throw new IOException("IO Problem"); }

	/* Errors */
	private void throwExceptionInInitializer(){
		throw new ExceptionInInitializerError("Exception inside static initializer"); }
	private void throwStackOverflowError(){ throw new StackOverflowError("Stack is overflown"); }
	private void throwNoClassDefFound(){ throw new NoClassDefFoundError("Class not found at runtime"); }

}
