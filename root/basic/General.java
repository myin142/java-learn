// Package: Optional, but has to be first statement in file
package root.basic;

// Import: Optional, has to be after package (needs full packages name)
//      Wildcards must be at the end
//      Specific import prefered over wildcards (when conflicting class names)
import root.*;
import root.basic.General;

// Import Static: Used to import static members
import static java.lang.System.out;

// Will be automatically imported
// import java.lang.*

// Access Modifiers:
//      public: accessible from everywhere
//      protected: accessible from subclasses and package
//      [default]: accessible from package
//      private: accessible from same class
//
// Optional Specifiers:
//      static: belongs to class, can be called with instance (even if pointing to NULL)
//      abstract: not full object
//      final: no changes allowed (prevent reassignment or overriding)
//
// public class name has to be the same as file name
// only one public class allowed
public class General{

    // Single line comment
    /*	Multi line comment */
    /** Java Doc */

    // Java is:
	//		pass-by-value
	//		case-sensitive 

    // Benefits of Java
    //		Object Oriented
    //		Encapsulation
    //		Platform Independent
    //		Robust - Prevents memory leaks
    //		Simple - No pointers or operator overloading
    //		Secure - Inside JVM

	// Instance and Class Fields get default initialization ( + arrays )
	//	    byte, short, int, long: 0
	//	    float, double: 0.0
	//	    boolean: false
	//	    char: '\u0000'(NUL)
	//	    Objects: null
	//
	// Identifiers / Names for class, variables, methods:
	//	    Start with letter, $ or _
	//	    After start including numbers
	//	    Not Java reserved words

	// Annotation:
	//  Used to indicate specific actions like override of methods
	//  If done incorrectly -> compiler error
	//  Can be written on same line

    public static void init(){

		// Local Variables have no default initialization
		// Multiple Variables of same type separated by comma
		int number, anotherNum;

		// Octal, Hexa and Binary numbers
		number = 072;
		number = 0xA2;
        number = 0b110;

        // Underscore allowed inside numbers
        // Only not at start/end or after/before decimal point.
        number = 1_000;

        // Float Postfix: f
        // Long Postfix: L / l

    }

}