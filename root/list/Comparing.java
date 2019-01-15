package root.list;

import java.util.Comparator;

// Exam: Numbers before Uppercase before Lowercase Letter
//      Shorter version before longer version
//      Will not be checking equality with null
public class Comparing implements Comparable<Comparing>, Comparator<Comparing>{
    private int id;
    public int getId(){ return id;}

    public Comparing(){
        // Comparable using lambda
        Comparable<Comparing> c = (other) -> id - other.id;
        System.out.println(c.compareTo(this));

        // Comparator using lambda
        Comparator<Comparing> cc = (a, b) -> a.id - b.id;
        System.out.println(cc.compare(this, this));

        // Comparator using anonymous inner class
        Comparator<Comparing> ccFull = new Comparator<Comparing>() {
            public int compare(Comparing a, Comparing b){
                return a.id - b.id;
            }
        };
        System.out.println(ccFull.compare(this, this));
    }

    // == 0, when object are equal
    // < 0, current object smaller
    // > 0, current object larger
    //
    // Comparable
    public int compareTo(Comparing other){
        return id - other.id;
    }
    // Comparator
    public int compare(Comparing a, Comparing b){

        // Used to combine multiple comparisons
        Comparator<Comparing> c = Comparator.comparingInt(x -> x.getId());
        c.thenComparing(x -> 0);

        return c.compare(a, b);
    }
}

// Must be implemented by a class
//
// java.lang
// public interface Comparable<T>{
//      public int compareTo(T o);
// }

// Can also be implemented by a class
// Common to use with lambda
//
// java.util
// public interface Comparator<T>{
//      public int compare(T t1, T t2);
// }
