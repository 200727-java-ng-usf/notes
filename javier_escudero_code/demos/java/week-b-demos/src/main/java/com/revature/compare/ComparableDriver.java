package com.revature.compare;


import com.revature.compare.models.Box;

import java.util.Arrays;

/*
    Comparable

        - one method: int compareTo(T obj)
        - functional interface (one abstract method); can be used with lambdas
        - utility classes such as Arrays and Collections have sorting methods that take in Comparable types
        - uses a parameterized type (generics)
        - returns an int value which is either negative, zero, or positive (less than, equal to, or greater than)
 */
public class ComparableDriver {

    public static void main(String[] args) {

        Box myBox = new Box(50.0, "brown");
        Box yourBox = new Box(45.5, "white");

        Box[] ourBoxes = {myBox, new Box(3.5, "red"), yourBox, new Box(3.5, "blue")};

        for (Box box : ourBoxes) {
            System.out.println(box);
        }

        System.out.println("+--------------------+");

        Arrays.sort(ourBoxes);

        for (Box box : ourBoxes) {
            System.out.println(box);
        }





    }

}
