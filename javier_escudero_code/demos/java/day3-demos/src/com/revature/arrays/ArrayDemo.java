package com.revature.arrays;

import java.util.Arrays;

public class ArrayDemo {

    String someValue;

    public ArrayDemo() {
        super();
    }

    public ArrayDemo(String value) {
        someValue = value;
    }

    public void learningArrays() {

        boolean dontRun = true;

        if (dontRun) {
            return; // void methods cannot return values, but you can still use the return keyword
            // ends the method early
        }

        /*
            Array declarations

                int[] arr = new int[5];
                int []arr = new int[5];
                int arr[] = new int[5];
                int[] arr = {0, 0, 0, 0, 0}; <--- array literal notation

            Arrays are of a fixed size, meaning that once
            initialized (created) their size will never change.

         */
        int[] intArray = new int[5];

        // I call System.out.println(), "sysout" for short; IDE shortcut = sout
        System.out.println("String representation: " + intArray); // prints random pseudo-memory address

        /*
            Accessing and manipulating array values

                - Java primitive arrays start with an index position of: 0
                    + An array with 5 values in it, will have index positions: 0 through 4

                - Use "bracket notation" to access array values by their index position
         */
        System.out.println(intArray[0]);
        intArray[0] = 7861;
        System.out.println(intArray[0]);

        // throws a ArrayIndexOutOfBoundsException; for any value that is out of range: 0 to 4
//        System.out.println(intArray[-1]);
//        System.out.println(intArray[5]);

        // Easy access to last value if you don't know for sure how many values it has
        System.out.println(intArray[intArray.length - 1]);

        // See the length of the array (# of items in the array, not index positions)
        System.out.println(intArray.length);

        // Change last value in array
        intArray[intArray.length - 1] = 42;

        // traditional for-loop
//        printValues(intArray); // int[] cannot be automatically converted to Integer[]

        System.out.println("+---------------------------+");

        // for-each loop (aka "enhanced" for loop)
        // NOTE: no access to index position value
        for (int value : intArray) {
            System.out.println(value);
        }

        System.out.println("+---------------------------+");

        // Arrays are homogenous (cannot contain differing data types)
        String[] myStrings = {"this", "is", "an", "array", new String("literal")};

        printValues(myStrings);

        // Remember arrays are of a fixed size that cannot be changed, but can be copied into a new array
        // The Arrays class provided by the JRE is a utility class for doing such an operation, and others

        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
        System.out.println("intArray length: " + intArray.length);
        System.out.println("otherInts length: " + otherInts.length);

        printValues(otherInts);

        // Example of unboxing (Java automatically converting an Integer object into a primitive int)
        int[] anotherArray = { new Integer(4) };

        // Example of autoboxing (Java automatically converting a primitive int into an Integer object)
        Integer[] integerArray = { 123 };

        // Java is pretty smart, it knows what you meant most of the time
        System.out.println(new Integer(10) + new Integer(5));

        // If, for some reason, you want a heterogenous array (differing types): declare a higher-level type for the array
        Object[] randomArray = { 12, "test", false, 4.3, "93" };

//        int index0 = randomArray[0]; // Java gets mad, because everything in randomArray is an Object
        int index0 = (int) randomArray[0]; // explicitly cast the value at position 0 to an int
        System.out.println(index0);

        // but what if it wasn't an int?
//        int index1 = (int) randomArray[1]; // throws a ClassCastException

//        int index1 = Integer.parseInt((String) randomArray[1]);
//        System.out.println(index1); // NumberFormatException (because "test" can never be an int)

        // check to see what the instance type is
        System.out.println(randomArray[1].getClass());

        // conditionalize the operation to ensure that the value at index 1 is of type String
        if (randomArray[4] instanceof String) {
            int index1 = Integer.parseInt((String) randomArray[4]);
            System.out.println(index1);
        }

    } // <---- closing brace of the "learningArrays" method

    private void printValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*
        Method overloading

            - methods that have the same name, but differing return types or parameters
                + could have fewer or more parameters
                + could have parameters of different data types

            - compile-time polymorphism (more on that later...)
                + compile-time, because the method that you will use can be determined at compile time
     */
    private void printValues(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // We can reduce the redundancy of having two methods that do the same thing
    // by making our printValues method more "generic", does not work in the cases of
    // primitive type arrays (ex: int[] cannot be converted to Object[])
//    private void printValues(Object[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }

}
