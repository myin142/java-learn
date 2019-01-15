package root.list;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

import java.util.Comparator;
import java.util.Collections;

// Collection - group of objects contained in single object
//      List: Ordered collection, allows duplicates, accessed by int index
//      Set: Collection without duplicates
//      Queue: orders specific order for processing like FIFO
//      Map: Maps keys to values without duplicate keys
public class Collection{

    public static void init(){
        // Common Collection Methods
        //      boolean isEmpty() | int size() | void clear()
        //      boolean add(E) | boolean remove(Object)
        //      boolean.contains(Object)
        //      void forEach(Consumer)
        //      boolean removeIf(Predicate<? super E>)
        //      void replaceAll(UnaryOperator<E>)
        java.util.Collection<String> collection = new ArrayList<>();

        // List Implementation
        //      use for ordered collection with duplicates
        //      Items can be retrieved and inserted at specific positions (like array)
        //
        //      ArrayList:
        //      Grows automatically, lookup constant time, add/remove slower
        //
        //      LinkedList:
        //      Implements List and Queue, add/remove/access at start/end constant time
        //      arbitrary index linear time, good if used like queue
        //
        //      Vector:
        //      Old class before ArrayList, same as ArrayList just slower but thread-safe, not really used
        //
        //      Stack:
        //      Add/remove from top of stack, extends Vector, not really used, instead ArrayDeque is used
        
        // Common List Methods
        //      boolean add(E) | void add(int, E) | E get(int) | void remove(int) | E set(int, E)
        //      int indexOf(Object) | int lastIndexOf(Object) - both return -1 if not found
        List<String> list = (List<String>) collection;

        // Loop through Collections
        // Old way without generic -> needs casting
        Iterator<String> iter = collection.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        // Set Implementation
        //      Stores in hash table using hashCode(), add/check constant time
        //
        //      HashSet:
        //      Groups elements inside buckets if same hashCode
        //
        //      TreeSet:
        //      In sorted tree structure, always in sorted order, add/check O(log n), implements NavigableSet
        //      Looping through will print out in natural order

        // No new set methods but collection methods is different for sets (add() can return false)
        //
        // NavigableSet Interface:
        //  E lower(E) - return greatest element < e, or null if no such element
        //  E floor(E) - return greatest element <= e, ...
        //  E ceiling(E) - return smallest element >= e, ...
        //  E higher(E) - return smallest element > e, ...

        // Queue Implementation
        //      Elements added/removed in specific order
        //
        //      LinkedList:
        //      Double-ended queue, implements List and Queue, not as efficient, has indexes
        //
        //      ArrayDeque:
        //      ‘pure’ double-ended queue, resizable array, more efficient

        // Common Queue Methods
        //      Examine and Remove always head of queue
        //      Insert always at end of queue
        //
        //      Throws exception on failure
        //      boolean add(E) | E element() | E remove()
        //
        //      Returns special value (null) on failure
        //      boolean offer(E) | E peek() | E poll();

        // Common ArrayDeque Methods
        //      void push(E) | E pop()
        //
        // LinkedList like ArrayDeque

        // Map Implementation: (not implementing Collection)
        //      Identify values by key
        //
        //      HashMap:
        //      Keys in hash table using hashCode(), add/retrieve constant time
        //
        //      LinkedHashMap:
        //      same as HashMap only with an order
        //
        //      TreeMap:
        //      Keys in sorted tree structure, always sorted, add/check O(log n)
        //
        //      Hashtable:
        //      Like Vector, old and thread-safe, newer version: HashMap

        // Common Map Methods, does not have Collection methods
        //      void clear() | boolean isEmpty() | int size()
        //
        //      V get(Object)           return value mapped by key or null if none
        //      V put(K, V)             add or replace key/value pair, return previous value of null if none
        //      V remove(Object)        removes and return value mapped by key, null if none
        //
        //      boolean containsKey(Object) | boolean containsValue(Object)
        //      Set<K> keySet() | Collection<V> values()
        //
        //      V merge(K, V, BiFunction<? super V, ? super V, ? extends V>) - BiFunction decides which value saved to key
        //          If key does not exists or value == null -> new value will always be used, BiFunction not called
        //          If BiFunction return null -> key will be removed from map

        // Sorted Type cannot contain null.
        // TreeMap no null keys, TreeSet no null values
        //
        // ArrayDeque no null values. Null values has special meaning
        // Hashtable no null values and keys. Just because. Too old.
        //
        // Else throws NullPointerException

        /* Searching and Sorting */
        List<Comparing> cList = new ArrayList<>();

        // If no Comparator specified, List type has to implement Comparable
        // else compiler error
        Collections.sort(cList);
        Collections.sort(cList, new Comparator<Comparing>() {
            public int compare(Comparing t1, Comparing t2){ return 0; }
        });

        // Same as sorting
        // Warning: unsorted list results in undefined values
        Collections.binarySearch(cList, new Comparing());
        Collections.binarySearch(cList, new Comparing(), new Comparator<Comparing>() {
            public int compare(Comparing t1, Comparing t2){ return 0; }
        });

        // Same applies to sorted collections like: TreeSet, TreeMap
        // Comparator can be passed to constructor
        Set<Comparing> tSet = new TreeSet<>(new Comparator<Comparing>() {
            public int compare(Comparing t1, Comparing t2){ return 0; }
        });

        // Throw ClassCastException when adding class that is not implementing Comparable
        tSet.add(new Comparing());
    }

}