package com.java.learn.java8.time;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Localization{
    
    // Internationalization: design program to adapt, string in file, DateFormat read
    // Localization: support multiple locale, lang/country pair, translate strings
    // Abbreviation: i18n and l10n
    public static void init(){
        // Getting/Creating Locale: en_US
        //      language should be lowercase
        //      country should be uppercase
        //      underscore and country optional
        //
        // Get Default Locale
        // Use predefined static Locale
        // Create Locale with Constructor
        // Create Locale with Locale.Builder
        Locale currLocale = Locale.getDefault();
        Locale cnLocale = Locale.CHINA;
        Locale gerLocale = new Locale("de", "DE");
        Locale usLocale = new Locale.Builder() // Order of setter does not matter
            .setLanguage("en")
            .setRegion("US")
            .build();

        // Change Default Locale
        Locale.setDefault(cnLocale);
        System.out.println(currLocale);

        // Using ResourceBundle - need full package name
        //
        // Searches for Resource_en class or property file
        //      Always search .java before .properties
        //      Exact match before match without country
        //      Passed locale before default locale before no locale
        //      At end throws MissingResourceException
        //
        // When located a bundle -> will only be dropping parts of name to search for keys
        ResourceBundle bundle = ResourceBundle.getBundle("root.time.Bundle", Locale.US);
        
        // Get Key Value
        System.out.println(bundle.getString("key1"));
        System.out.println(bundle.getObject("key2"));

        // Using Stream to put values to Properties and print entries
        Properties prop = new Properties();
        bundle.keySet().stream().forEach(s -> prop.put(s, bundle.getObject(s)));
        prop.entrySet().stream().forEach(System.out::println);
        System.out.println(prop.getProperty("key1", "default")); // Properties support default values, or null if none specified
        System.out.println(prop.get("key1")); // No default value, if not found return null

        // Formatting: java.text.NumberFormat (all methods static and Locale parameter is optional)
        //      getInstance() | getNumberInstance() | getCurrencyInstance() | getPercentInstance()
        //      
        // Parsing stops after reaching character that cannot be parsed
        // ParseException, when beginning of String cannot be parsed
        //      String format(Number)
        //      Number parse(String) throws ParseException
        try{
            Number n = NumberFormat.getNumberInstance().parse(prop.getProperty("key1", "-1"));
            String s = NumberFormat.getCurrencyInstance().format(n);

            System.out.println("Number: " + n + ", String: " + s);
        }
        catch (ParseException e){}

    }

}
