package root.basic;

public class Object{

    // Called at most once, when garbage collecting
    // System.gc() - suggests garbage collection, but can be ignored
    // Will not be called when program closes before GC
    protected void finalize(){}

    /* OCP */

    // Automatically called when printing out object
    public String toString(){ return super.toString(); }

    // Implement to compare this object with another instead reference comparison
    // Contract:
    //  Reflective - x.equals(x) == true
    //  Symmetric - x.equals(y) == y.equals(x)
    //  Transitive - x.equals(y) &&  y.equals(z) => x.equals(z)
    //  Consistent - x.equals(y) always return same value
    //  Any non-null reference => x.equals(null) == false
    public boolean equals(Object obj){ return super.equals(obj); }

    // hashCode is a number, used to group objects (for key in a map)
    // Contract:
    //  Within same program, always return same value
    //  equals() == false => both hashCode does not have to return same value
    //  equals() == true => both hashCode() must return same value
    //  -> inside hashCode() the same variables or a subset of it has to be used
    public int hashCode(){ return super.hashCode(); }
}