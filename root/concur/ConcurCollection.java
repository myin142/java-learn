package root.concur;

import java.util.concurrent.atomic.AtomicInteger;

// race condition: unexpected result of two tasks executing at the same time
// atomic: property of operation, carried out as single unit without interference of thread
// monitor/lock: property at most one thread is executing segment of code at a time
// memory consistency errors: two thread, inconsistent view of same data
public class ConcurCollection{

	// Synchronized Method
	public static synchronized void init(){

		// Atomic Classes: AtomicXXX | XXX = Boolean, Integer, IntergerArray, Long, LongArray, Reference, ReferenceArray
		// Methods: get() | set() | getAndSet() | incrementAndGet() | getAndIncrement() | decrementAndGet() | getAndDecrement()
		//
		AtomicInteger i = new AtomicInteger();
		//
		// Synchronization: protecting data integrity at the cost of performance
		//		Only one thread can call method at a time, other have to wait
		//		synchronized(Object){}	- object used as a lock, any object can be used
		synchronized(i){}

		// Concurrent Collections: when 2 threads modify same non-concurrent collection -> ConcurrentModificationException
		//
		//									Collection Interface					Ordered		Sorted		Blocking		
		//		ConcurrentHashMap			ConcurrentMap							No			No			No
		//		ConcurrentLinkedDeque		Deque									Yes			No			No
		//		ConcurrentLinkedQueue		Queue									Yes			No			No
		//		ConcurrentSkipListMap		ConcurrentMap,SortedMap,NavigableMap	Yes			Yes			No
		//		ConcurrentSkipListSet		SortedSet,NavigableSet					Yes			Yes			No
		//		CopyOnWriteArrayList		List									Yes			No			No
		//		CopyOnWriteArraySet			Set										No			No			No
		//		LinkedBlockingDeque			BlockingDeque, BlockingQueue			Yes			No			Yes
		//		LinkedBlockingQueue			BlockingQueue							Yes			No			Yes
		//
		// Blocking Queues: includes methods that will wait amount of time to complete operation (all throw InterruptedException)
		//		offer(E, long, TimeUnit) - return false if time elapsed before space available
		//		poll(long, TimeUnit) - return null if time elapsed before item available
		//
		// Blocking Deques: like Blocking Queues just for Deques
		//		offerFirst(E, long, TimeUnit) | offerLast(E, long, TimeUnit)
		//		pollFirst(long, TimeUnit) | pollLast(long, TimeUnit)
		//
		// SkipLists: SkipListSet = TreeSet & SkipListMap = TreeMap
		//
		// CopyOnWrite: All mutative operations make new copy of array
		//
		// Synchronized Collections: (do not synchronize access on iterators -> also throws ConcurrentModificationException)
		//		synchronizedCollection(Collection<T>)
		//		synchronizedList(List<T>)
		//		synchronizedMap(Map<K, V>)
		//		synchronizedNavigableMap(NavigableMap<K, V>)
		//		synchronizedNavigableSet(NavigableSet<T>)
		//		synchronizedSet(Set<T>)
		//		synchronizedSortedMap(SortedMap<K, V>)
		//		synchronizedSortedSet(SortedSet<T>)
	}

}