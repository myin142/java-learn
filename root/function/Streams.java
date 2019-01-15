package root.function;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


// Stream Pipeline: Operations that run on a stream, like assembly line
//      Finite Streams: Have a limit unlike infinite streams
//      Data in Streams are created when needed, then gone
//
//      Source: Where stream comes from
//      Intermediate Operations: transform stream into another, lazy evaluation -> runs when terminal operation runs
//      Terminal Operation: Produces a result, after operation -> stream no longer valid
public class Streams{
    
    public static void init(){
        List<String> list = new ArrayList<>();

        // Creating Streams:
        //      Stream.empty() | Stream.of(T...) | list.stream()
        //      Stream.generate(Supplier<T>) | Stream.iterate(T, UnaryOperator<T>)
        Stream<String> s1 = Stream.empty();
        Stream<Integer> s2 = Stream.of(1, 2);
        Stream<String> fromList = list.stream();
        Stream<Double> random = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

        // Common Terminal Operations: (always <? super T>)
        //      Reduction - operation where all contents are combined into single object
        //		Collect - mutable reduction, more efficient than regular reduction
		//
		//		long count() | Optional<T> min/max(Comparator) | Optional<T> findAny/findFirst()
		//		boolean allMatch/anyMatch/noneMatch(Predicate) | void forEach(Consumer)
		//
		//		T reduce(T identity, BinaryOperator<T> accumulator)
		//		Optiona<T> reduce(BinaryOperator<T> accumulator)
		//		<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinarOperator<U> combiner) - for parallel processing
		String reduced = Stream.of("w o l f".split(" ")).reduce("", String::concat, String::concat);
		System.out.println(reduced);
		//
		//		<R> R collect(Supplier<R>, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) - for parallel processing
		//		<R,A> R collect(Collector<? super T, A, R> collector)
		//
		//		Collectors.toCollection(Supplier) | Collectors.toSet()
		TreeSet<String> word = Stream.of("w o l f".split(" ")).collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(word);

		// Common Intermediate Operations: (All return Streams, always <? super T>)
		//		filter(Predicate) | distinct() | limit(int) | skip(int) | sorted() | sorted(Comparator)
		//		peek(Consumer) - useful for debugging, should not change values
		//
		//		map(Function<? super T, ? extends R> mapper) - one-to-one mapping
		//		flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) - flatten stream to one level
		Stream.of("w o l f".split(" ")).map(String::length).forEach(System.out::print);

		// Primitive Streams: IntStream | LongStream | DoubleStream
		//		Creation same as normal Stream
		//		+ range(int, int endExcluded) | rangeClosed(int, int endIncluded) -> only Int and Long
		//
		// Mapping to other Stream:
		// 					To Stream					To DoubleStream						To IntStream					To LongStream
		// Stream			map(Function)				mapToDouble(ToDoubleFunction)		mapToInt(ToIntFunction)			mapToLong(ToLongFunction)
		// DoubleStream		mapToObj(DoubleFunction)	map(DoubleUnaryOperator)			mapToInt(DoubleToIntFunction)	mapToLong(DoubleToLongFunction)
		// IntStream		mapToObj(IntFunction)		mapToDouble(IntToDoubleFunction)	map(IntUnaryOperator)			mapToLong(IntToLongFunction)
		// LongStream		mapToObj(LongFunction)		mapToDouble(LongToDoubleFunction)	mapToInt(LongToIntFunction)		map(LongUnaryOperator)
		//
		// Primitive Stream Methods: XXX = Double, Long, Int | xxx = double, long, int
		//		OptionalXXX max() | OptionalXXX min() | OptionalDouble average() | xxx sum()
		//		orElseGet(XXXSupplier) | optional.getAsXXX
		//
		//		XXXSummaryStatistics summaryStatistics()
		//			-> getAverage() | getCount() | getMax() | getMin() | getSum()
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
		double av = IntStream.iterate(1, i -> i + 1).limit(5)
			.mapToDouble(i -> i * 0.5).summaryStatistics().getAverage();
		System.out.println(av);

		// Advanced Stream Concepts:
		//		Linking Streams to Underlying data: Stream and Data are linked after creation
		//
		//		Chaining Optional: methods of optional instance
		//			Optional<U> map(Function<? super T, ? extends U>)
		//			Optional<U> flatMap(Function<? super T, Optional<U>>)
		//			Optional<T> filter(Predicate<? super T>)
		//
		//		Functional Interfaces do not throw exceptions -> Cannot use methods that throw checked exceptions
		//			E.g. When passing method reference -> compiler error
		//			Solution: wrapper method to catch exception
		//
		// Collectors: (static methods)															Return from collect()
		//		averagingXXX(ToXXXFunction)			calculate average for primitive types		Double
		//		counting()							counts number of elements					Long
		//		joining() / joining(CharSequence)	create single String (CS as delimiter)		String
		//		maxBy/minBy(Comparator)				finds largest/smallest elements				Optional<T>
		//		toList() / toSet()					Create list/set								List/Set
		//		toCollection(Supplier)				Crete collection of type supplier			Collection
		//		summarizingXXX(ToXXXFunction)		Get SummaryStatistics						XXXSummaryStatistics
		//		summingXXX(ToXXXFunction)			calculate sum of primitive types			XXX
		//
		//		mapping(Function, Collector)		Adds another level of collectors			Collector
		//
		Stream<String> stream = Stream.of("lions tigers bears".split(" "));
		Optional<Integer> result = stream.collect(Collectors.mapping(String::length, Collectors.maxBy(Comparator.naturalOrder())));
		System.out.println(result);
		//
		//		toMap(Function, Function)								/ Create map using function to map key/value
		//		toMap(Function, Function, BinaryOperator)				/ optional merge function (when keys overlapping)
		//		toMap(Function, Function, BinaryOperator, Supplier)		/ optional type
		//
		stream = Stream.of("lions tigers bears".split(" ")); // Need new stream, since old one was already used
		Map<Integer, String> map = stream.collect(
			Collectors.toMap(String::length, s->s, String::concat, TreeMap::new)); // Lambda s -> s can be written as Function.identity()
		System.out.println(map);
		//
		//		groupingBy(Function)							/ Create map grouping by specified function
		//		groupingBy(Function, Collector)					/ optional downstream collector
		//		groupingBy(Function, Supplier, Collector)		/ optional type
		//
		stream = Stream.of("lions tigers bears".split(" ")); // Need new stream, since old one was already used
		Map<Integer, Set<String>> group = stream.collect(
			Collectors.groupingBy(String::length, TreeMap::new, Collectors.toCollection(TreeSet::new)));
		System.out.println(group);
		//
		//		partitioningBy(Predicate)						/ Create map grouping by specified predicate (2 partitions)
		//		partitioningBy(Predicate, Collector)			/ optional downstream collector
		//
		stream = Stream.of("lions tigers bears".split(" ")); // Need new stream, since old one was already used
		Map<Boolean, Set<String>> partition = stream.collect(
			Collectors.partitioningBy(String::isEmpty, Collectors.toCollection(TreeSet::new)));
		System.out.println(partition);

		Stream<Integer> s = Stream.of(1);
		IntStream is = s.mapToInt(x -> x);
		DoubleStream ds = s.mapToDouble(x -> x);
		Stream<Integer> s2 = ds.mapToInt(x -> x);
		s2.forEach(System.out::print);

    }

}