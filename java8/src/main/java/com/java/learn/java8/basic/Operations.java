/* Topics:
 *	Operations
 *	Statements
 */
package com.java.learn.java8.basic;

/**
 * Summary
 * 
 * 	Operation order.
 * 	Operation between different types -> smaller will be promoted to larger
 * 	All types smaller than int, will be promoted to int on operations (except unary)
 * 	Assignments also return value
 * 
 */

// Operation order: if same, then left-to-right
//	Post-unary:				x++, x--
//	Pre-unary:				++x, --x
//	Unary:					+, -, !
//	Multiplication:			*, /, %
//	Addition:				+, -
//	Shift:					<<, >>, >>>
//	Relation:				<, >, <=, >=
//	Equal:					==, !=
//	Logical:				&, ^, |
//	Short-Circuit Logical:	&&, ||
//	Ternary:				( boolean ? true : false )
//	Assignment:				=, +=, -=
public class Operations{

	public static void init() {
		// Numeric Promotion to larger types (floating-point larger than integers)
		// = automatically promoted smaller to larger types
		// casting needed when from larger to smaller (except for compound assignments like += and -=)
		{
			long x = 1 + 1L; // int promoted to long
			double y = 1.0f + 1.0; // float promoted to double
			double z = 1 + 1.0; // int promoted to double
		}
		
		// Smaller data types than int, will first be promoted to int before operations
		// (Excluding unary operations)
		{
			short a = 1;
			byte b = 1;
			int ab = a + b; // Both will be promoted to int first, then addition will be executed
		}

		// Postfix: passes value then increments after statement
		// Prefix: increments then passes value
		{
			int x = 0;
			print("Post: " + x++);	// Prints 0 then increments to 1
			print("Pre: " + ++x);	// Increment from 1 to 2 and prints value
		}

		// += and -= not allowed right after declaration
		// && has higher precedence than ||

		// Binary Operators
		{
			long x = 1;			// Automatically promotes to larger type
			int y = (int) x;	// Casting needed from larger to smaller

			// Casting not needed for compound assignment operators
			int z = 0;
			z += x;

			// Assignments also return value
			print("Assignment: " + (z = 1) );

			// Relation operators: Smaller type promoted
			// Logical operators: always both are executed
			// Short-Circuit Logical: other part can be skipped if result is already determinable
			//
			// Equality operator: == , !=
			//	Two numeric primitives
			//	Two boolean values
			//	Two object references (including null and String)
		}

		Sub sub = new Sub();

		// a instanceof b - check if reference point to same:
		//  instance of b
		//  subclass of b
		//  class that implements b
		boolean b1 = sub instanceof Super;
		System.err.println("Sub instance of Super: " + b1);

		// Compiler error if checking of unrelated types
		// boolean b = sub instanceof Other;

		// Except for interfaces -> checked on runtime
		boolean b2 = sub instanceof Interface;
		System.out.println("Sub instance of Interface: " + b2);

		// Statements
		//
		// If-then-(else) statement
		// Ternary Operator: (boolean ? true : false)
		//					left-hand		right-hand
		if(true){}
		else{}
		
		// Switch - case values must be compile-time constants and non duplicates
		// Supported types:
		//	byte, short, int, char + Object versions
		//	String
		//	Enum
		final int value = 0;
		switch(0){
			case 0: break;
			//case value: break; // Duplicate, both lines would count as compiler error

			default: break;
		}

		// while
		while(true){ break; }

		// do-while
		do{ break; }while(true);

		// for
		for(int i = 0; i < 1; i++){}

		// for-each
		int[] array = {2,3,1};
		for(int x : array){}

		// Break, Continue, Labels:
		// if			labels
		// while		labels	break	continue
		// do while		labels	break	continue
		// for			labels	break	continue
		// switch		labels	break
		LABEL: for(;;){
			array[0]++;

			INNER: while(array[0] > 5){
				continue LABEL;
			}

			break LABEL;
		}
	}

	private static void print(String str){ System.out.println(str); }
}

class Super{}
class Sub extends Super{}
class Other{}

// Marker Interface: Interface with no members
interface Interface{}
