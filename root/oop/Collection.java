package root.oop;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.Queue;
import java.util.Set;

// Collection - group of objects contained in single object
//  List: Ordered collection, allows duplicates, accessed by int index
//  Set: Collection without duplicates
//  Queue: orders specific order for processing like FIFO
//  Map: Maps keys to values without duplicate keys
public class Collection{
    
    public Collection(){
        java.util.Collection<String> collection = new ArrayList<>();
        {
            // Common Collection Methods
            boolean b1 = collection.add("");
            boolean b2 = collection.remove("");
            boolean b3 = collection.isEmpty();
            boolean b4 = collection.contains("");
            int i1 = collection.size();
            collection.clear();
        }

        // List Implementation
        //  use for ordered collection with duplicates
        //  Items can be retrieved and inserted at specific positions (like array)
        //
        // Grows automatically, lookup constant time, add/remove slower
        ArrayList<String> l1 = new ArrayList<>();
        // Implements List and Queue, add/remove/access at start/end constant time
        // arbitrary index linear time, good if used like queue
        LinkedList<String> l2 = new LinkedList<>();
        // Old class before ArrayList, same as ArrayList just slower but thread-safe, not really used
        Vector<String> l3 = new Vector<>();
        // Add/remove from top of stack, extends Vector, not really used, instead ArrayDeque is used
        Stack<String> l4 = new Stack<>();
        
        List<String> list = (List<String>) collection;
        {
            // Common List Methods
            boolean b1 = list.add("");
            list.add(0, "");
            list.remove("");
            String s1 = list.get(0);
            String s2 = list.set(0, "");
            int i1 = list.indexOf("");          // Return -1 if not found
            int i2 = list.lastIndexOf("");      // Return -1 if not found
        }

        // Loop through Collections
        // Old way without generic needs casting
        Iterator<String> iter = collection.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        // Set Implementation
        //  Stores in hash table using hashCode(), add/check constant time
        //
        // Groups elements inside buckets if same hashCode
        HashSet<String> hs = new HashSet<>();
        // In sorted tree structure, always in sorted order, add/check O(log n), implements NavigableSet
        // Looping through will print out in natural order
        TreeSet<String> ts = new TreeSet<>();

        // No new set methods but collection methods is different for sets (add() can return false)
        //
        // NavigableSet Interface:
        //  E lower(E) - return greatest element < e, or null if no such element
        //  E floor(E) - return greatest element <= e, …
        //  E ceiling(E) - return smallest element >= e, ...
        //  E higher(E) - return smallest element > e, ...

        // Queue Implementation
        //  Elements added/removed in specific order
        //
        // Double-ended queue, implements List and Queue, not as efficient, has indexes
        LinkedList<String> ll = new LinkedList<>();
        // ‘pure’ double-ended queue, resizable array, more efficient
        ArrayDeque<String> ad = new ArrayDeque<>();

        Queue<String> q = ad;
        {
            // Queue Methods
            // Examine and Remove always head of queue
            // Insert always at end of queue
            //
            // Throws exception on failure
            boolean b1 = q.add("");
            String s1 = q.element();
            String s2 = q.remove();
            // Returns special value (null) on failure
            boolean b2 = q.offer("");
            String s3 = q.peek();
            String s4 = q.poll();

            // Common ArrayDeque Methods
            ad.push("");
            String s5 = ad.pop();

            // LinkedList like ArrayDeque
        }

        // Map Implementation: not implementing Collection
        //  Identify values by key
        //
        // Keys in hash table using hashCode(), add/retrieve constant time
        HashMap<String, String> hm = new HashMap<>();
        // same as HashMap only with an order
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
        // Keys in sorted tree structure, always sorted, add/check O(log n)
        TreeMap<String, String> tm = new TreeMap<>();
        // Like Vector, old and thread-safe, newer version: HashMap
        Hashtable<String, String> ht = new Hashtable<>();

        Map<String, String> m = hm;
        {
            // Common Map Methods, does not have Collection methods
            m.clear();
            boolean b1 = m.isEmpty();
            int i1 = m.size();

            String s1 = m.get("");                          // return value mapped by key or null if none
            String s2 = m.put("", "");                      // add or replace key/value pair, return previous value or null if none
            String s3 = m.remove("");                       // remove and return value mapped to key, null if none
            boolean b2 = m.containsKey("");
            boolean b3 = m.containsValue("");
            Set<String> s = m.keySet();
            java.util.Collection<String> c = m.values();
        }

        // Sorted Type cannot contain null.
        // TreeMap no null keys, TreeSet no null values

        // ArrayDeque no null values. Null values has special meaning
        // Hashtable no null values and keys. Just because. Too old.
    }

}