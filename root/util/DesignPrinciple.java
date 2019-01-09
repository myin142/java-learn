package root.util;

public class DesignPrinciple{

    /* JavaBeans Naming Conventions for Encapsulation */

    // All fields are private, only modified via methods
    // -> maintain invariant, can set specific rules for values
    private boolean important;
    private int number;
    private Boolean boolObject;

    // All Getter/Setter are public
    //
    // boolean getter start with isXXX
    // non-boolean (including Boolean object) getter start with getXXX
    public boolean isImportant(){ return important; }
    public int getNumber(){ return number; }
    public Boolean getBoolObject(){ return boolObject; }

    // Setter start with getXXX
    //
    // followed by field name (first uppercase)
    public void setImportant(boolean b){ important = b; }
    public void setNumber(int i){ number = i; }
    public void setBoolObject(Boolean obj){ boolObject = obj; }

    /* Relationships */

    // Is-a Relationship - inheritance test
    // A is a B
    //  Any instance of A can be treated like B
    //  -> True for subclass with any parent (direct or distant)
    //
    // Cat is-a Feline
    // Cat is-a Animal
    // Cat is-a Pet

    // Has-a Relationship - object composition test
    // A has a B
    //  An instance of A has a member of type B
    //  -> Any subclass of A will have a B when member not private
    //
    // Human has-a Pet

    // Object Composition: alternative to inheritance
    //  Constructing class using refenrece to other class to access functionality
    //
    // Human Class can call members of Pet Classes
}

// Is-a Relationship Example
class Animal{}
class Feline extends Animal{}
class Cat extends Feline implements Pet{}
class Dog extends Animal implements Pet{}
class Tiger extends Feline{}
interface Pet{}

// Has-a Relationship Example
class Human{
    Pet pet;
}