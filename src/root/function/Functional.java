package root.function;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

// Functional Interfaces: (Interface | Parameter | Return | Method)
//      Supplier<T>         0           T           get
//      Consumer<T>         1(T)        void        accept
//      BiConsumer<T,U>     2(T,U)      void        accept
//      Predicate<T>        1(T)        boolean     test
//      BiPredicate<T,U>    2(T,U)      boolean     test
//      Function<T,R>       1(T)        R           apply
//      BiFunction<T,U,R>   2(T,U)      R           apply
//      UnaryOperator<T>    1(T)        T           apply
//      BinaryOperator<T>   2(T,T)      T           apply 
//
// Exception: BooleanSupplier
// Functional Interface for Primitives: (Interface | Parameter | Return | Method)
//		XXXSupplier				0			xxx			getAsXXX
//		XXXConsumer				1(xxx)		void		accept
//		XXXPredicate			1(xxx)		boolean		test
//		XXXFunction<R>			1(xxx)		R			apply
//		XXXUnaryOperator		1(xxx)		xxx			applyAsXXX
//		XXXBinaryOperator		2(xxx,xxx)	xxx			applyAsXXX
//		ToXXXFunction<T>		1(T)		xxx			applyAsXXX
//		ToXXXBiFunction<T, U>	2(T, U)		xxx			applyAsXXX
//		XX1ToXX2Function		1(xx1)		xx2			applyAsXX2
//		ObjXXXConsumer<T>		2(T,xxx)	void		accept

// Functional Interface:
//      Interface with one abstract method
//      Others (static/default) still allowed
//
//      @FunctionalInterface interface FunctionalInterface{
//          void print(String s);
//      }
//
// Functional Interfaces do not throw exceptions -> Cannot use methods that throw checked exceptions
//		E.g. When passing method reference -> compiler error
//		Solution: wrapper method to catch exception
//

public class Functional{

    public static void init(){

        // Lambda Syntax
        // i -> i == 1                      // Simplest
        // (int i) -> { return i == 1; }    // Full
        //
        // Brackets in first are needed if 2 parameters or type specified
        // If type specified in one, both needs type
        // Code block {} treated as normal code with statement and return
        // Variable parameters cannot be redeclared
        //
        // Lambda can use (effectively) final variable
        //      effectively final: value never changed
        String text = "Functional Interface";

        // Note: Lamda Expressions rely on deferred execution
        //      Specify code now but runs later
        printText((String s) -> System.out.println(text));

        // Method reference: returns function interface, like lambda, deferred execution
        //      static: generic is parameter type
        //          Collections::sort | l -> Collections.sort(l)
        //      instance: generic is parameter type
        //          str::startsWith | s -> str.startsWith(s)
        //      unknown instance: generic is instance type
        //          String::isEmpty | s -> s.isEmpty()
        //      constructor: generic is class type
        //          String::new | () -> new String()
        printText(System.out::println);
		printText(String::startsWith);

        // Optional: might have value or might be empty
        //      static Optional<T> empty()
        //      static Optional<T> of(T)
        //      static Optional<T> ofNullable(T) - return empty if null
		//
		// Chaining Optional: methods of optional instance
		//		Optional<U> map(Function<? super T, ? extends U>)
		//		Optional<U> flatMap(Function<? super T, Optional<U>>)
		//		Optional<T> filter(Predicate<? super T>)
		//
        //
        //      Method                              Optional is Empty                   Optional has value
        //
        //      get()                               NoSuchElementException              Returns value
        //      ifPresent(Consumer)                 Does nothing                        Calls Consumer
        //      isPresent()                         Returns false                       Returns true
        //      orElse(T other)                     Returns other value                 Returns value
        //      orElseGet(Supplier<? extends T>)    Returns Supplier result             Returns value
        //      orElseThrow(Supplier)               Throw exception from supplier       Returns value
        Optional<Double> av = average(10, 20);
        av.ifPresent(System.out::println);
        av.orElse(Double.NaN);
        av.orElseGet(Math::random);
		av.orElseThrow(IllegalStateException::new);
    }

    private static void printText(Consumer<String> i){
        i.accept("Method Reference");
    }
    private static void printText(BiPredicate<String, String> i){
        System.out.println(i.test("Test", "T"));
    }

    private static Optional<Double> average(int... nums){
        if(nums.length == 0) return Optional.empty();

        int sum = 0;
        for(int i : nums){ sum += i; }
        return Optional.of((double) sum / nums.length);
    }

}

