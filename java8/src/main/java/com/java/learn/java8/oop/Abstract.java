/* Topics:
 *  Abstract
 */
package com.java.learn.java8.oop;

/**
 * Summary
 * 
 *  First concrete class implements all abstract methods
 *  Variables can only be hidden
 *  Static Methods can only be hidden
 *  Methods can be overridden
 * 
 */

// Abstract methods has to be inside abstract class
//  Cannot be instantiated directly
//  Cannot be private or final
//  Can contain zero or more abstract methods
//  Can contain zero or more normal methods
abstract class Abstract{
    
    static final String TEXT = "Abstract Class";

    // Variables can only be hidden
    static String hiddenStaticVariable = TEXT;
    String hiddenVariable = TEXT;

    // Static Methods can only be hidden
    static void hiddenMethod(){ System.out.println("Hidden Method: " + TEXT); }

    public Abstract(){
        System.out.println("Abstract:");
        System.out.println("Static Variable: " + hiddenStaticVariable);
        System.out.println("Variable: " + hiddenVariable);
        hiddenMethod();
        overridableMethod();
        System.out.println();
    }

    // Normal Methos can be overridden
    void overridableMethod(){ System.out.println("Overridable: " + TEXT); }

    // First concrete class has to implement all abstract methods
    // Abstract method cannot be final -> overriding would not be possible
    // Abstract method cannot be private -> would not be accessible from sub class
    abstract void abstractMethod();
}
