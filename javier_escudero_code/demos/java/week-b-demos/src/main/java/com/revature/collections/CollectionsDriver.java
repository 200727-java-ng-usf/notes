package com.revature.collections;

import com.revature.io.models.User;

import java.util.*;

public class CollectionsDriver {

    public static void main(String[] args) {

        /*
        Set

            - cannot contain duplicate values
            - models the mathematical concept of a "set"
            - contains only methods inherited from the Collection interface
            - adds a stronger contract on the behaviors of the .equals() and .hashcode() operations
            - have no implicit order
     */
        Set<User> userSet = new HashSet<>();
        User u = new User(1, "wsingleton", "password");
        userSet.add(u);
        userSet.add(new User(2, "skelsey", "manager"));
        userSet.add(new User(3, "rconnell", "rolltide"));
        userSet.add(new User(13, "tester", "test"));
        userSet.add(u); // compiles just fine, but it just doesn't add the duplicate
        User u2 = new User(1, "wsingleton", "password");
        userSet.add(u2); // different object, same values == duplicate
//        userSet.add(null);

        System.out.println(u.hashCode());
        System.out.println(u2.hashCode());
        System.out.println(u == u2);


        userSet.forEach(user -> System.out.println(user)); // no implicit order
        userSet.forEach(user -> System.out.println(user.hashCode())); // not even by hashcode value

        System.out.println("+--------------------------------+");

        /*
            Queue

                - follows the first-in, first-out strategy
                - adding to a queue using .add is also known as enqueueing
                - removing from a queue using .poll is also known as dequeuing
                - members in the middle of the queue are inaccessible

         */
        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(u);
        userQueue.add(new User(34, "njurzcak", "microservices"));
        userQueue.add(null);
        userQueue.add(u2);

        userQueue.forEach(user -> System.out.println(user));

        User someUser = userQueue.poll(); // poll removes the first value in the queue and returns it
        System.out.println(someUser);

        System.out.println("+-------------------+");
        userQueue.forEach(user -> System.out.println(user));

        System.out.println("+-------------------+");
        User anotherUser = userQueue.peek(); // peek returns the next value in the queue, but does not remove it
        System.out.println(anotherUser);

        System.out.println("+-------------------+");
        userQueue.forEach(user -> System.out.println(user));

        System.out.println("+-------------------+");

        /*
            Deques

                - "double-ended" queues
                - insert and removal operations can be performed on both ends of the structure

         */
        ArrayDeque<User> userDeque = new ArrayDeque<>();
        userDeque.add(u);
        userDeque.add(new User(35, "bkruppa", "javascript"));

        System.out.println("+-------------------------------+");

        /*
            Maps

                - NOT A PART OF THE COLLECTIONS API
                - "maps" a key to a value
                - conceptually similar to dictionaries in Python
                - cannot have duplicate keys (one key can map to, at most, one value)
                - in most implementations, keys are allowed to be null - so long as there is only one null key
                - values do not need to be unique
         */

        Map<String, User> userMap = new HashMap<>();
        userMap.put("wsingleton", u);
        userMap.put(null, null);
        userMap.put("skelsey", new User(42, "skelsey", "manager"));
        userMap.put("wsingleton", new User()); // this will override the previous value associated with "wsingleton"

        // this will also override that previously overridden value
        userMap.put(new String("wsingleton"), new User(123, "noone", "nope"));

        User thisUser = userMap.get("wsingleton");
        System.out.println(thisUser); // if a duplicate key is given the last value added is associated with the key

        // you cannot iterate over a map....directly at least, however:
        for (String key : userMap.keySet()) {
            System.out.println(userMap.get(key));
        }

        Iterator<Map.Entry<String, User>> mapEntries = userMap.entrySet().iterator();
        while (mapEntries.hasNext()) {
            System.out.println(mapEntries.next());
        }

    }


}
