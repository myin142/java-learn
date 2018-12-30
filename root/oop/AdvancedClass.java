/* Topics:
 *	Access Modifiers
 *	Optional Specifiers
 *	Overriding / Overloading / Hidding
 *	Encapsulation
 *  Inheritance
 *  Polymorphism
 */
package root.oop;

// Access Modifiers:
//  public: accessible from everywhere
//  protected: accessible from subclasses and package
//  [default]: accessible from package
//  private: accessible from same class
//
// Optional Specifiers:
//  static: belongs to class, can be called with instance (even if pointing to NULL)
//  abstract: not full object
//  final: no changes allowed (prevent reassignment or overriding)
//
// Can only extend one class (All classes extend Object)
// Can implement multiple interfaces
//
// Outer class can be only public or [default]
public class AdvancedClass extends Abstract implements Interface{

    static final String TEXT = "Advanced Class";

    // Varargs: String... strings
    // Treated like array
    // Only allowed at the end of method parameters -> only one per method

    /* Java is pass-by-value */

    // Hidden: Inside child/parent their own members are used
    //
    // Variables hidden
    static String hiddenStaticVariable = TEXT;
    String hiddenVariable = TEXT;

    // Static methods hidden
    static void hiddenMethod(){ System.out.println("Hidden Method: " + TEXT); }

    // Overriding: always overridden methods used (also inside parent)
    //  Same name and parameter
    //  Same return type otherwise compile error
    //  Same or more accessible
    //  Can throw none, same or subclass of Exception
    //
    // Final Methods cannot be overridden
    // Re-declaring private methods: not treated as overriding, like hidding
    void overridableMethod(){ System.out.println("Overridable: " + TEXT); }

    // Overloading:
    //  Same name but different parameter
    //  Everything else can be different
    // 
    // Java will use most specific parameter: (Note: will only be converted once)
    //  Exact match by type
    //  Larger primitive type
    //  Autoboxed type
    //  Varargs
    private final static int overridableMethod(int i){ return i; }

    // Polymorphism:
    // Using superclass in method parameter to allow more classes to be passed
    // 
    // Type of object determines which properties exists
    // Type of reference determines which members are accessible
    //
    // Casting from sub to superclass, no explicit cast
    // Casting from super to subclass, requires explicit cast
    // Compiler does not allow casting to unrelated types (Abstract cannot be converted to CoreApi)
    //
    // Virtual Methods: All non-final. non-static, non-private methods, they can all be overridden
    private void polymorphMethod(Interface i, Abstract a){
        //CoreApi x = (CoreApi)a;
    }

    public AdvancedClass(){
        System.out.println("Advanced:");
        System.out.println("Static Variable: " + hiddenStaticVariable);
        System.out.println("Variable: " + hiddenVariable);
        hiddenMethod();
        overridableMethod();
        overridableMethod(0);
        System.out.println();

        polymorphMethod(this, this);
    }

    // Implement all abstract methods
    void abstractMethod(){}
    public void interfaceMethod(){}

    // Normal Method Structure: (Note: static, final order does not matter)
    // (Access) | (Specifiers) | Return | Name | Brackets/(Parameter) | (Exception) | Body
    public static final void method() throws Exception{}

    // Encapsulation
    // All Fields are private
    // JavaBeans Naming:
    //  Getter for boolean: isXXX
    //  Getter for non boolean: getXXX
    //  Setter for all: setXXX
    //  set/get/is + propertyName (first uppercase)
    //
    // Make class immutable by removing all setters
    // And use defensive copy to prevent change by reference
    private int number;
    private boolean binary;

    public int getNumber(){return number;}
    public boolean isBinary(){return binary;}
    public void setNumber(int i){number = i;}
    public void setBinary(boolean b){binary = b;}
}
