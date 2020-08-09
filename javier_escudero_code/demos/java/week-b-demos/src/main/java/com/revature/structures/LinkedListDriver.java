package com.revature.structures;

import com.revature.structures.util.CustomLinkedList;

public class LinkedListDriver {

    public static void main(String[] args) {

        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.insert("test1");
        stringList.insert("test3");
        stringList.insert("test2");
        stringList.insert("test3");
        stringList.insert("test4");
        stringList.insert("test5");
        stringList.insert("test5");
        stringList.insert("test6");
        stringList.insert("test3");
        stringList.insert("test3");

        stringList.printList();

        System.out.println("+-------------------+");

        System.out.println(stringList.peek()); // test1
        System.out.println(stringList.peek()); // test1
        System.out.println(stringList.poll()); // test1
        System.out.println(stringList.poll()); // test2

        String key = "test5";
        boolean wasRemoved = stringList.removeByKey(key);

        if (wasRemoved) {
            System.out.println("The first occurrence of value, " + key + " was removed.");
        } else {
            System.out.println("There was no value, " + key + ", eligible for removal");
        }

        stringList.printList();


    }

}
