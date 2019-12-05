/* Topics:
 *  Interface
 */
package root.oop;

/**
 * Summary:
 * 
 *  Variables are always public, static and final
 *  Static methods do not get inherited and assumed public
 *  Default methods have implementation and only inside interface
 *  Normal methods assumed public and abstract
 * 
 */

// Everything assumed abstract, cannot be final. And vice-versa
// Everything assumed public, cannot be private and protected.
//
// Interfaces assumed abstract
interface Interface extends A,B{

    // Interface variables assumed public, static and final
    String variable = "Variable";

    // Like normal static method
    // + will not be inherited from subclass -> only accessible with Interface name
    static void interfaceStatic(){}

    // Interface methods assumed public and abstract
    void interfaceMethod();

    // Default interface methods assumed public
    // And cannot be static/final/abstract
    // default only within interface usable
    // mainly for backward compatibility
    //
    // If there are 2 same default methods in different interfaces within one class
    // Multi-inheritance problem -> compiler error
    // Solution: override methods
    default void defaultMethod(){}
}

interface A{}
interface B{}