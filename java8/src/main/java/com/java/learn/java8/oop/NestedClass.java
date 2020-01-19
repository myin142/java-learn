package com.java.learn.java8.oop;

/* Nested Classes:
 *  Member Inner Class - same level as members and not static, also referred as just inner class
 *  Local Inner Class - inside a method
 *  Anonymous Inner Class - local inner class without a name
 *  Static Nested Class - static class in same level as static members
 */
public class NestedClass{
    private String secret = "Secret";
    
    public NestedClass(){
        MemberInnerClass inner = new MemberInnerClass(); // In static method not possible

        // Outer class instance can be used to create inner class
        MemberInnerClass.InnerInnerClass innerInner = inner.new InnerInnerClass();

        localInnerClass();
        anonymousInner();

        // Can access static class members
        StaticNested nested = new StaticNested();
        System.out.println(nested.secret);
    }

    // Member Inner Class:
    // Can have all access modifiers
    // Can extend any class and interface
    // Can be abstract or final
    // Cannot declare static members
    // Can access all members of outer class
    //
    // Inner Classes will be compiled to NestedClass$MemberInnerClass.class
    class MemberInnerClass{

        // Inner Class field names can be the same
        private String secret = "Inner Secret";

        class InnerInnerClass implements InnerInterface{
            private String secret = "Inner Inner Secret";

            public InnerInnerClass(){
                System.out.println(secret);
                System.out.println(this.secret);
                System.out.println(MemberInnerClass.this.secret);
                System.out.println(NestedClass.this.secret);
                test();
            }

            public void test(){
                System.err.println("Test");
            }
        }
    }

    // Interfaces can only be inside top-level classes or inside static inner class
    // And can be declared private
    private interface InnerInterface{
        void test();
    }

    private int length = 5;

    private void localInnerClass(){

        // Effectively final: when it still compiles if final was inserted before variable
        /* final */ int width = 20;

        // Local Inner Class:
        // They have no access specifiers
        // They cannot be static or have static members
        // They can access all members of outer class
        // They cannot access local variables unless they are (effectively) final
        class LocalInner{
            private void multiply(){
                System.out.println(length * width);
            }
        }

        new LocalInner().multiply();
    }

    abstract class AbstractClass{
        abstract void print();
    }

    private void anonymousInner(){

        // Anonymous Inner Class: (like Local Inner Class)
        // Define class definition directly after creating with new
        // Abstract classes and interfaces can directly be extended/implemented
        // Cannot extend class and implement interface at the same time
        // Can also be defined directly in method parameter
        AbstractClass a = new AbstractClass(){
            void print(){ System.out.println("Anonymous Inner Class"); }
        };

        a.print();
    }

    // Static Nested Class:
    // Is a static class defined at member level
    // Can be created without instance of Outer class
    //  -> cannot access outer class members
    // Creates a namespace inside outer class
    // Can be private or other access modifiers
    // Outer class can access the members
    //
    // Can also be imported like normal class or using static import
    //  import root.oop.NestedClass.StaticNested;
    //  import static root.oop.NestedClass.StaticNested;
    static class StaticNested{
        private String secret = "Static Secret";
    }
}
