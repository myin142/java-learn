package root.oop;

// public: accessible from everywhere
// protected: accessible from subclasses and package
// [default]: accessible from package
// private: accessible from same class
//
// Outer class can be only public or [default]
public class Class {

	// Order of Initialization:
	// Super class
	// Static Variables and Initializers (only once)
	// Instance Variables and Initializers
	// Constructor

	// Instance and Class Fields get default initialization
	//	byte, short, int, long: 0
	//	float, double: 0.0
	//	boolean: false
	//	char: '\u0000'(NUL)
	//	Objects: null
	//
	// Identifiers / Names for class, variables, methods: (Java is case-sensitive)
	//	Start with letter, $ or _
	//	After start including numbers
	//	Not Java reserved words
	public int number;
	protected String text;
	boolean binary;
	private char character;

	// Instance Initializer Block. Called everytime class gets instantiated
	// Underscore allowed inside numbers. Only not at start/end or after/before decimal point.
	{ number = 1_000; System.out.println("Instance Initializer"); }

	// Static Field and Static Initializer. Called once when class is used the first time
	// Float Postfix: f
	// Long Postfix: L / l
	static float decimal;
	static { decimal = 1.0f; System.out.println("Static Initializer"); }

	// Default Constructor. If not specified, automatically inserted from compiler
	// All constructors without explicit super call, gets default super() call inserted
	// this() and super() has to be the first statement in constructors
	public Class() {
		System.out.println("Constructor");

		// Local Variables have no default initialization
		// Multiple Variables of same type separated by comma
		int number, anotherNum;

		// Octal, Hexa and Binary numbers
		number = 072;
		number = 0xA2;
		number = 0b110;

	}

	// Called at most once, when object is garbage collecting
	// System.gc() - suggests garbage collection, but can be ignored
	protected void finalize() {
		System.out.println("Garbage collecting");
	}
}
