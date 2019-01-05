/* Topics
 *	String API
 *	StringBuilder API
 *	Equals Comparison
 *	Arrays / List
 *	DateTime API
 */

package root.oop;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Summary
 * 
 * 	String are immutable and literals are pooled
 * 	StringBuilder are mutable. StringBuffer like StringBuilder only immutable -> thread-safe
 * 	== compares reference, equals() compares reference if it is not implemented
 * 	List has equals() implemented, list.toArray()
 * 	Arrays.asList() - Fixed sized list, backed with array
 * 	DateTime classes are immutable and invalid values will throw runtime exception
 * 
 */

public class CoreApi{
	
	public CoreApi(){
		stringApi();
		stringBuilderApi();
		equalsComparison();
		arrays();
		dateTimeApi();
	}

	private void stringApi(){
		// String is immutable: any changes has to be saved in a variable again
		String str = "String";

		// String concat from left to right (after concat String not literal anymore)
		//	both numeric -> addition
		//	either is String -> concat
		System.out.println(1 + 1 + " " + str);

		// Important String Methods
		// Note: all changes do not get saved because String is immutable
		int i0 = str.length();
		char c0 = str.charAt(0); 						// int
		boolean b0 = str.contains("S"); 				// String
		int i1 = str.indexOf("Str", 0);					// char/String, (optional) int startIndex
		String s0 = str.substring(0, 2);				// int startIndex, (optional) int endExluded
		String s1 = str.toLowerCase();
		String s2 = str.toUpperCase();
		boolean b1 = str.equals("String");				// String
		boolean b2 = str.equalsIgnoreCase("string");	// String
		boolean b3 = str.startsWith("Str");				// String
		boolean b4 = str.endsWith("ing");				// String
		String s3 = str.replace("St", "STR");			// char/CharSequence, char/CharSequence
		String s4 = str.trim();							// spaces, \t, \n, \r
	}

	private void equalsComparison(){
		// ==, used to compare references
		// String literal are pooled inside JVM
		// "String" == "String" is true if only literal are used
		String str = "String";
		if(str == "String"){
			System.out.println("Strings reference to same object inside String Pool");
		}

		// equals() used to compare content of Strings
		// if not implemented, it compares reference
		StringBuilder builder = new StringBuilder("String");
		if(builder.toString().equals("String")){
			System.out.println("Strings content is the same.");
		}
	}

	private void stringBuilderApi(){
		// StringBuilder is mutable: changes can directly affect Object
		// Size: number of characters currently in sequence
		// Capacity: number of characters a sequence can hold
		StringBuilder builder = new StringBuilder("String");		// CharSequence/int/String/void

		// Like StringBuilder only immutable, thus making it thread-safe
		StringBuffer buffer = new StringBuffer();

		// Important StringBuilder Methods
		// First methods like String, thus changes do not get saved
		builder.charAt(0); builder.indexOf("S"); builder.length(); builder.substring(1);
	
		StringBuilder b0 = builder.append("s");		// String/...
		StringBuilder b1 = builder.insert(0, "S");	// int, String/...
		StringBuilder b2 = builder.delete(0, 1);	// int startIndex, int endExcluded
		StringBuilder b3 = builder.deleteCharAt(0);	// int
		StringBuilder b4 = builder.reverse();
		String s0 = builder.toString();
	}

	private void arrays(){
		// Creating Array:
		// int numbers[] = new int[3];
		Integer[] numbers = new Integer[]{ 3, 1, 2 };
		// int[] numbers = { 3, 1, 2 }; // -> anonymous array, only in declaration allowed

		// Access array and get length
		int first = numbers[0];
		first = numbers.length;

		// Sorting Array. Sorts Strings alphabetically:
		// Uppercase before Lowercase
		// 10 before 100 before 9
		Arrays.sort(numbers);

		// Searching Array.
		// If found: returns index
		// If not found: return negative value of index where item should be placed -1
		Arrays.binarySearch(numbers, 5);

		// Multidimensional Array like normal array, just with more []

		/* ArrayList implements List */
		// List has equals() implemented
		// Non-generic version possible: all types can be saved inside
		// Generic on only one side allowed
		ArrayList<Integer> list = new ArrayList<>();	// int/List/void
		List l1 = new ArrayList();
		List l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList();

		// Important Methods
		// Number literals get autoboxed to Integer objects
		boolean b0 = list.add(1);						// E (Integer)
		list.add(0, 2);									// int, E
		boolean b1 = list.remove(new Integer(3));		// E (Note: if normal int literal is used, another function will get called)
		int i0 = list.remove(0);						// int
		int i1 = list.set(0, 2);						// int, E
		list.clear();
		boolean b2 = list.contains(2);					// int
		boolean b3 = list.equals(new ArrayList<>());	// List

		System.out.println(list);

		// Wrapper Classes: (except Character)
		// primitive = Wrapper.parseXXX(String)
		// Wrapper = Wrapper.valueOf(String);

		// Converting
		// If List fits inside passed array, it will use it directly
		Integer[] array = new Integer[2];
		list.toArray(array);	

		// It will be a backed list (changes affecting array) and is fixed sized
		List<Integer> fixedList = Arrays.asList(numbers); 
		fixedList.set(0, 10);

		for(int num : numbers){
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println(fixedList);

		// Sorting
		Collections.sort(fixedList);
	}

	private void dateTimeApi(){
		// Date and Time classes are immutable
		//
		// Creating: LocalDate, LocalTime, LocalDateTime
		// DATE = Year, Month, Day
		// TIME = Hour, Minute, Seconds, Nanoseconds
		// Invalid parameter type (invalid month) will throw runtime exception
		LocalDate date = LocalDate.of(2018, Month.DECEMBER, 29);	// DATE
		LocalTime time = LocalTime.of(20, 45, 00, 00);				// TIME
		LocalDateTime dateTime = LocalDateTime.of(date, time);		// DATE, TIME

		// Modify. Java knows leap years and also hides secs/nanos
		dateTime = dateTime.plusWeeks(1);							// plusXXX(int)
		date = date.minusDays(1);									// minusXXX(int)
		time = time.plusHours(1);

		// Period Class
		// When chaining methods, only last one is used
		// For time Duration Class is used (Not in OCA)
		Period period = Period.of(1, 1, 1);							// DATE
		Period everyWeek = Period.ofWeeks(1);						// ofXXX(int)
		dateTime.plus(period);
		date.minus(everyWeek);

		// DateTimeFormatter Class
		// FormatStyle.SHORT - 29/12/18 08:45 PM
		// FormatStyle.MEDIUM - Dec 29, 2018 08:45:00 PM
		DateTimeFormatter formatter = 								// ofLocalizedXXX(FormatStyle)
			DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(dateTime.format(formatter));

		formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm a");
		System.out.println(formatter.format(dateTime));

		// Parsing
		date = LocalDate.parse("December 29, 2018, 08:45 PM", formatter);
		System.out.println(date);
	}

}
