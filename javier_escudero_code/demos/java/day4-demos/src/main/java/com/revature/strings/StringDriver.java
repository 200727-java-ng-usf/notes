package com.revature.strings;

/*
    Topics:
        - Memory management of Strings
        - String API (the public behaviors exposed by the String class)
        - StringBuilder class
        - StringBuffer class
 */
public class StringDriver {

    public static void main(String[] args) {

        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            String Pool

                - A special area inside of Heap memory that Java leverages to store String objects
                  with unique values (no duplicates!)

                - Not all Strings are stored in the Pool
                   + if you explicitly use "new"
                   + Strings returned from any String method are not in the Pool

                - If you use literal notation with the same value, a single String object
                  will be stored in the Pool
         */
        System.out.println(s1 == s2); // true; since we created two Strings using
                                      // literal notation with the same value, these
                                      // references point to the same object

        System.out.println(s1 == s3); // false; since we explicitly used the "new" keyword
                                      // a new String object was created

        System.out.println(s1.equals(s3)); // true; because .equals (in this case) is checking for value equivalence

        /*
            String interning is the act of moving a String object - which exists
            outside of the String pool - and "interning" or moving it into the
            String Pool.

            If a String object in the pool already exists with the same value, the
            reference simply points to that existing object. The former object is
            removed by the garbage collector. If no object exists, the a new object
            is created in the Pool, and the former object is kept. If no references
            point to the former String object it will be garbage collected, if references
            do point to it, then it will not be garbage.
         */
        String s5 = s3.intern();
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s1 == s5);

        /*
               The Immutability of Strings

                - String are immutable (their value cannot be changed once instantiated)
                    + implicitly thread-safe as a result of their immutability
                    + btw:
                        - initialization = the creation of a reference (variable) that may or may not have a value
                        - instantiation = the creation of an object in memory

         */

        String s6 = "hello";
        s6.concat(", world!");
        System.out.println(s6);

        s6 = s6.concat(", world!"); // all String API methods return a NEW STRING (outside of the Pool)
        System.out.println(s6);

        String s7 = "hello, world!";
        System.out.println(s6 == s7);

        String s8 = "hello" + ", world"; // still returns a new String that is outside of the String pool
        System.out.println(s6 == s8);

        //-----------------------------------------------------------
        System.out.println("+------------------------+");
        /*
            StringBuilder
                - it does NOT extend the String class!
                - mutable
                - cannot be instantiated used String literals
                - not thread-safe

            StringBuffer
                - it does NOT extend the String class!
                - mutable
                - cannot be instantiated used String literals
                - are thread-safe (slower than StringBuilder as a result)

         */
//        StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        System.out.println(sb2 == sb3); // false
        System.out.println(sb2.equals(sb3)); // false; because, for some reason, StringBuilder/Buffer does not override .equals

        sb2.append(" How's it going?");
        System.out.println(sb2); // StringBuilder/Buffer objects are mutable!

        String s9 = sb2.toString();
        System.out.println(s9);

        //-----------------------------------------------------------------------------

        System.out.println("+----------------------+");

        // On the subject of memory pools...let's talk about Integers (the wrapper class for ints)

        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2); // explicit use of new makes these separate objects

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4); // true!

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);

        Integer i7 = -129;
        Integer i8 = -129;
        System.out.println(i7 == i8);

        Integer i9 = i7 + 1;
        System.out.println(i7); // Integer objects are immutable, no methods exist to mutate them

        // You can still reassign the reference though
        i7 = i7 + 1;
        System.out.println(i7);
        System.out.println(i8);

    }

}
