// Single line comment
//
// Optional, but has to be first statement in file
package root;

// Optional, has to be after package
// Wildcards must be at the end
// Specific import prefered over wildcards (when conflicting class names)
import root.util.*;
import root.oop.*;
import root.oop.Class;

// Will be automatically imported
// import java.lang.*

/*	Multi line comment
 *
 *	public class name has to be the same as file name
 *	only one public class allowed
 */
public class Main {

	/**	Java Doc
	 *
	 *	Benefits of Java
	 *		Object Oriented
	 *		Encapsulation
	 *		Platform Independent
	 *		Robust - Prevents memory leaks
	 *		Simple - No pointers or operator overloading
	 *		Secure - Inside JVM
	 *
	 *	Entry point of program
	 */
	public static void main(String[] args){
		Class c = new Class();

		// Local Variables have no default initialization
		// Multiple Variables of same type separated by comma
		int number, anotherNum;

		// Octal, Hexa and Binary numbers
		number = 072;
		number = 0xA2;
		number = 0b110;
	}
}
