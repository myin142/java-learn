/* Topics:
 *	package
 *	import
 *	comments
 *	general
 */

// Single line comment
//
// Optional, but has to be first statement in file
package root;

// Optional, has to be after package (needs full packages name)
// Wildcards must be at the end
// Specific import prefered over wildcards (when conflicting class names)
import root.util.*;
import root.oop.*;
import root.oop.Class;
import root.oop.Enum;

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
		if(args.length < 1) return;

		out.println("Starting: " + args[0]);
		out.println();
		switch(args[0].toLowerCase()){
			case "defaultclass": new Class(); break;
			case "exception": new Exceptions(); break;
			case "operation": new Operations(); break;
			case "coreapi": new CoreApi(); break;
			case "advancedclass": new AdvancedClass(); break;
			case "lambda": new Lambda(); break;

			// OCP
			case "enum": new Enum(); break;

			default: System.out.println("No Default Program specified");
		}
	}
}
