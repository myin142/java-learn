package com.java.learn.java8;

import com.java.learn.java8.basic.General;
import com.java.learn.java8.basic.Operations;
import com.java.learn.java8.concur.ConcurCollection;
import com.java.learn.java8.concur.Concurrency;
import com.java.learn.java8.concur.ParallelStream;
import com.java.learn.java8.db.JDBC;
import com.java.learn.java8.function.Functional;
import com.java.learn.java8.function.Streams;
import com.java.learn.java8.io.IOStream;
import com.java.learn.java8.io.NIO2;
import com.java.learn.java8.basic.Enum;
import com.java.learn.java8.list.Collection;
import com.java.learn.java8.list.Generic;
import com.java.learn.java8.oop.AdvancedClass;
import com.java.learn.java8.oop.Class;
import com.java.learn.java8.oop.CoreApi;
import com.java.learn.java8.oop.NestedClass;
import com.java.learn.java8.time.DateTime;
import com.java.learn.java8.time.Localization;
import com.java.learn.java8.util.DesignPrinciple;
import com.java.learn.java8.util.Exceptions;

public class Java8 {

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
