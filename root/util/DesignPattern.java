package root.util;

// Focused on solving specific commonly occurring problem
public class DesignPattern{}

// For Exam: Singletons are always unique
//
// Create one object once and shared by multiple classes
class Singleton{
    // All constructor private to prevent creation of object outside of class
    private Singleton(){}

    // Private instance field
    private static final Singleton instance = new Singleton();

    // Returns instance field
    public static /* synchronized */ Singleton getInstance(){

        // Lazy Instantiation: Delay creation of object until first time use
        // Note: 'final' and 'new Singleton()' from field must be removed 
        //
        // Thread safety: safe execution by multiple thread at the same time
        // Here we need synchronized to make this thread-safe
        //
        // if(instance == null){
        //     instance = new Singleton();
        // }

        // Double-checked locking: first test if synchronization is needed before locking
        // Advantage: only synchronized the first time
        //
        // if(instance == null){
        //    synchronized(Singleton.class){
        //        if(instance == null){
        //          instance = new Singleton();
        //        }
        //    }
        // }

        return instance;
    }
}

// Create read-only objects that can be shared
//
// Use constructor to set all properties
// Mark all instance variables private and final
// Do not define any setter
// Do not allow referenced mutable object to be modified (never return direct reference)
// Prevent methods from being overridden
//
// Modify immutable by creating new instance from the values
final class Immutable{

    private final String text;
    private final int number;

    public Immutable(String text, int num){
        this.text = text;
        this.number = num;
    }

    public String getText(){ return text; }
    public int getNumber(){ return number; }

}

/* NOT IN OCP */

// anti-patterns - common solution to reoccurring problem -> unmanagable code
// telescoping constructor anti-pattern - constructor parameter gets longer and longer

// Create object needing numerous values at instantiation
// Often used in combination with immutable classes
// Setter Methods get chained to create builder at end
// At end final build can be returned
//
// Created with:
//  Immutable i = new Builder().setText("").setNumber(0).build();
//
// Tightly Coupling - Coupled classes are highly dependent, any minor change may greatly impact other class
// Loose Coupling - Coupled classes with minimum dependencies
class Builder{

    private String text;
    private int number;

    public Builder setText(String s){
        this.text = s;
        return this;
    }

    public Builder setNumber(int num){
        this.number = num;
        return this;
    }

    // Return final build of object
    public Immutable build(){
        return new Immutable(text, number);
    }

}

// Similar to builder but focused on supporting polymorphism
// Good Coding Practice: Postfix class name with 'Factory'
//
// Create objects -> exact type may be unknown until runtime
class FoodFactory{
    public static Food getFood(String animal){
        switch(animal){
            case "cow": return new Hay();
            case "cat": return new Fish();
        }

        // Good practice to throw exception if no matching subclass
        throw new UnsupportedOperationException("Unsupported Animal");
    }
}

interface Food{}
class Hay implements Food{}
class Fish implements Food{}
