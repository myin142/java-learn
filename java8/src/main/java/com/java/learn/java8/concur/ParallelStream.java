package com.java.learn.java8.concur;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream{

	public static void init(){
		// Creating Parallel Stream:
		//		parallel() from Stream
		//		parallelStream() from Collection
		//
		Stream<Integer> stream = Arrays.asList(3,4,1,2,6,5).parallelStream();
		//
		// Avoid Stateful Operations:
		//		stateful lambda expression - result depend on any state that might change during execution of pipeline
		//
		// Processing Tasks: (order based tasks may perform slower in parallel)
		//		forEachOrdered(Consumer)		calling items in order (for parallel streams)
		//		unordered()						create unordered stream, on parallel streams -> improves performance, called before making parallel
		//
		//		U reduce(U identitiy, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
		//			identity: for all elements in stream -> combiner.apply(identity, u) == u
		//			accumulator: associative and stateless
		//			combiner: associative and stateless, compatible with identity -> combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)
		//
		int i = stream.reduce(0, (a,b) -> a+b, (a,b) -> a+b);
		System.out.println(i);
		//
		//		R collect(Supplier<R>, BiConsumer<R, ? super T> accumulator, BiConsumer<R,R> combiner)
		//			accumulator and combiner like reduce()
		//
		stream = Arrays.asList(1,2,3,4,5,6).parallelStream();
		SortedSet<Integer> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
		System.out.println(set);
		//
		//		R collect(Collector<? super T, A, R> collector)
		//			stream is parallel
		//			parameter of collect operation has Collector.Characteristics.CONCURRENT
		//			either stream is unordered or collecter has Collector.Characteristics.UNORDERED
		//
		//			Get characteristics with collector.characteristics()
		//			Get Collectors with both characteristics:
		//				Collectors.toConcurrentMap()
		//				Collectors.groupingByConcurrent()
		//
		stream = Arrays.asList(1,2,3,4,5,6).parallelStream();
		ConcurrentMap<Integer, List<Integer>> map = stream.collect(Collectors.groupingByConcurrent(item -> item*item));
		System.out.println(map);
	}

}
