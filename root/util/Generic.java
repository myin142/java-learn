package root.util;

// Declare formal type parameter in angle brackets: <T>
// Any data type can be passed as T
//
// Naming Conventions:
//  E for Element
//  K for Map Key
//  V for Map Value
//  N for Number
//  T for Generic Data Type
//  S,U,V and so forth for multiple generic types
//
// Behind the scene, compiler replaces T with Object -> type erasure
public class Generic<T>{
    private T field;

    public void setField(T f){ field = f; }
    public T getField(){ return field; }

    public Generic(){

        // Calling Generic Method
        // Missing type also allowed, compiler can figure type out
        Generic.<Generic<T>>genericMethod(this);

        // Lower Bound: Only same or subclass allowed to be mutable
        Generic<? super Test01> g = new Generic<Super>();
        g.setField(new Test01());
        g.setField(new Sub());

        // Superclass not allowed -> compiler error
        // g.setField(new Super());
        
        passLower(new Generic<Test01>());
    }

    // Bounds:
    //  bounded parameter type - generic type specifying a bound for generics
    //      generic type + extends + another class/interface
    //  wildcard generic type - unknown generic type represented by ?
    //      Unbounded wildcard: ?
    //      Wildcard with upper bound: ? extends Class/Interface
    //      Wildcard with lower bound: ? super Class/Interface
    // Inside method parameters and when constructing: works just like names suggest
    //
    // Unbounded and Upper Bounds will become immutable
    // ~ Every method where generic is used cannot be called ~
    //
    // Only Lower Bound can be changed
    // Types allowed for generic:
    //  Same class or subclass
    //  Not superclass
    //
    // When creating new object, type must be known -> no ? allowed
    // When returning type from method, type must be known -> no ? allowed
    //
    // Compiler prevent assigning: List<String> to List<Object>
    // Protects us from runtime exception
    public static void passAny(Generic<?> list){}
    public static void passUpper(Generic<? extends GenericInterface> list){}
    public static void passLower(Generic<? super Test01> list){}

    // Generic Methods: static and instance
    //  <T> - formal type parameter
    //  Generic<T> - return type
    public static <T> Generic<T> genericMethod(T t){
        return new Generic<>();
    }
}

// Same as classes. Ways to implement it:
//  Pass object directly when implementing
//  Pass generic from class to interface
//  Not using generic, instead Object
interface GenericInterface<X>{
    void method(X t);
}

// First way, compiler warning -> should be using generics
// For exam, have to known when warnings occur
class Test01 extends Super implements GenericInterface {
    public void method(Object t){}
}
// Second way
class Test02<T> implements GenericInterface<T>{
    public void method(T t){}
}
// Third way
class Test03 implements GenericInterface<Test01>{
    public void method(Test01 t){}
}

class Super{}
class Sub extends Test01{}

/* NOT OCP */

// reifiable - Types whose information is fully available at runtime
//
// Cannot be done with generics
//  Call the constructor, new T() not allowed
//  Create an array
//  Call instanceof, at runtime they would look the same
//  Use primitive as generic type
//  Create static variable as generic type
