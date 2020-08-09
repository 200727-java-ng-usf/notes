package com.revature.generics;

import java.util.ArrayList;

public class GenericDriver {

    public static void main(String[] args) {

        ArrayList myList = new ArrayList();
        myList.add("string");
        myList.add(new Integer(4));
        myList.add(new AppUser());

        // works, but could be better - without an explicit cast
        String myString = (String) myList.get(0);
        System.out.println(myString);

        // throws ClassCastException
//        String maybeString = (String) myList.get(1);

        // both of the below are fine, but the first has more than is necessary
//        ArrayList<String> betterList = new ArrayList<String>();
        ArrayList<String> betterList = new ArrayList<>();

        // type safety! only strings can be added to betterList
//        betterList.add(new AppUser());


        betterList.add("another string"); // only allows Strings as input
        String definitelyString = betterList.get(0);


    }

}
