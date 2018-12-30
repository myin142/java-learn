/* Topics:
 *  Lambda
 */

package root.util;

import java.util.function.Predicate;

public class Lambda{

    public Lambda(){
        // Using own classes and interface
        System.out.println(checkNumber(new CheckOne(), 5));
        System.out.println(checkNumber(new CheckTwo(), 5));

        // Using predicate and lambdas
        System.out.println(checkNumberPredicate(i -> i < 10, 5));
        System.out.println(checkNumberPredicate(i -> i >= 10, 5));

        // Lambda Syntax
        // i -> i == 1                      // Simplest
        // (int i) -> { return i == 1; }    // Full
        //
        // Brackets in first are needed if 2 parameters
        // If type specified in one, both needs type

        // Note: ArrayList has removeIf(Predicate<T>)
    }

    private boolean checkNumberPredicate(Predicate<Integer> check, int value){
        return check.test(value);
    }

    private boolean checkNumber(Common check, int value){
        return check.test(value);
    }

}

// Example for Predicate and Lambdas
//
// Predicate<T>:
//  public interface Predicate<T>{
//      boolean test(T t);    
//  }
//
class CheckOne implements Common{
    public boolean test(int i){
        return i < 10;
    }
}
class CheckTwo implements Common{
    public boolean test(int i){
        return i >= 10;
    }
}
interface Common{
    boolean test(int i);
}