/* Topics:
 *	Operations
 *	Statements
 */
package root.util;

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

	public Operations() {
		// Numeric Promotion to larger types (floating-point larger than integers)
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

		// Statements
		//
		// If-then-(else) statement
		// Ternary Operator: (boolean ? true : false)
		if(true){}
		else{}
		
		// Switch - case values must be compile-time constants
		// Supported types:
		//	byte, short, int, char + Object versions
		//	String
		//	Enum
		switch(0){
			case 0: break;
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

			INNER: while(array[0] > 0){
				continue LABEL;
			}

			break LABEL;
		}
	}

	private void print(String str){ System.out.println(str); }
}
