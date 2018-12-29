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

// Used to import static members
import static java.lang.System.out;

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
		// Local Variables have no default initialization
		// Multiple Variables of same type separated by comma
		int number, anotherNum;

		// Octal, Hexa and Binary numbers
		number = 072;
		number = 0xA2;
		number = 0b110;

		if(args.length < 1) return;

		out.println("Starting: " + args[0]);
		switch(args[0]){
			case "defaultClass": new Class(); break;
			case "exception": new Exceptions(); break;
			case "operation": new Operations(); break;
			case "coreApi": new CoreApi(); break;
		}
	}
}
