package root.oop;

// Outer class can be only public or [default]
public class Class {

	// Order of Initialization:
	// Super class
	// Static Variables and Initializers (only once)
	// Instance Variables and Initializers
	// Constructor

	int number;
	String text;
	boolean binary;
	char character;

	// Instance Initializer Block
	// Called everytime class gets instantiated
	{ System.out.println("Instance Initializer"); }

	// Static Initializer Block
	// Called once when class is used the first time
	static { System.out.println("Static Initializer"); }

	// Default Constructor. If not specified, automatically inserted from compiler
	// Default Constructor != User-defined Constructor
	// All constructors without explicit super call, gets default super() call inserted
	// this() and super() has to be the first statement in constructors
	public Class() {
		System.out.println("Constructor");
	}

	// Overloading Constructors possible
	// Use this() to call this classes constructors
	public Class(int i){
		this();
	}

	public static void init(){
		new Class(); new Class(0);
	}
}
