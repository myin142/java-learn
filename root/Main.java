package root;

import root.util.*;
import root.time.*;
import root.oop.*;
import root.basic.*;
import root.concur.*;
import root.function.*;
import root.list.*;
import root.io.*;

import root.oop.Class;
import root.basic.Enum;

import root.db.JDBC;

public class Main {

	// Entry point of program
	public static void main(String[] args){
		if(args.length < 1) return;

		System.out.println("Starting: " + args[0]);
		System.out.println();

		switch(args[0].toLowerCase()){
			case "defaultclass": new Class(); break;
			case "operation": Operations.init(); break;
			case "coreapi": new CoreApi(); break;
			case "advancedclass": new AdvancedClass(); break;

			case "designprinciple": new DesignPrinciple(); break;
			case "nestedclass": new NestedClass(); break;

			case "class": Class.init(); break;
			case "general": General.init(); break;
			case "enum": Enum.init(); break;

			case "io": IOStream.init(); break;
			case "nio": NIO2.init(); break;

			case "generic": Generic.init(); break;
			case "collection": Collection.init(); break;

			case "functional": Functional.init(); break;
			case "stream": Streams.init(); break;

			case "concurrency": Concurrency.init(); break;
			case "concurcollection": ConcurCollection.init(); break;
			case "parallelstream": ParallelStream.init(); break;

			case "database": JDBC.init(); break;
			case "exception": Exceptions.init(); break;
			case "localization": Localization.init(); break;
			case "datetime": DateTime.init(); break;

			default: System.out.println("No Default Program specified");
		}
	}
}
