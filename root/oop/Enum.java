package root.oop;

public class Enum{
    public Enum(){

        // Season.valueOf(String) gets enum from String, must be exact match
        // Otherwise throws IllegalArgumentException
        Season f = Season.valueOf("FALL");
        
        // Season.values() gets all enum items as array
        for(Season s : Season.values()){

            // toString() and name() gets name of enum
            // ordinal() gets ordinal number of enum value
            System.out.println(s + ", " + s.name() + ", " + s.ordinal());

        }

        // Only enum values allowed without Enum Class name
        switch(f){
            case WINTER:
            case SPRING:
            case SUMMER:
            case FALL:
                f.printCharacteristic();
        }
    }
}

// Set of Items whose types are known at compile-time -> constants
// Enum is a type and cannot be compared to int or be extended
enum Season{
    // Semicolon needed when using Constructor or Members
    WINTER("Cold"){
        public void printName(){} // Overriding abstract method
    }, SPRING("Natur"){
        public void printName(){}
    }, SUMMER("Hot"){
        public void printName(){}
    }, FALL("Windy"){
        public void printName(){}
    };

    private String characteristic;

    // Enum Constructor, has to be private or [default]
    // Will be constructed once when Enum is called the first time
    private Season(String character){
        this.characteristic = character;
        System.out.println(character + " enum is constructed");
    }

    public void printCharacteristic(){
        System.out.println(characteristic);
    }
    
    // Can have abstract methods
    // Overridden directly when creating enum value
    public abstract void printName();
}