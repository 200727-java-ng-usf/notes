package com.revature.io;

import com.revature.io.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ReadFileDriver {

    public static void main(String[] args) {

        // create a File object, and use the relative path of the text file
        File happyText = new File("src/main/resources/happy-text.txt");

        if (!happyText.exists()) {
            return;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(happyText));
            String currentLine = reader.readLine();

            // if currentLine == null, then we have reached the end of the file
            while (currentLine != null) {
                System.out.println(currentLine); // print out currentLine
                currentLine = reader.readLine(); // move to next line in file
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("An exception occurred while reading the file.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

        System.out.println("+-------------------------+");

        File users = new File("src/main/resources/users.txt");
        List<User> usersList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(users));
            String currentLine = reader.readLine();

            while (currentLine != null) {

                // read the line, split it into a String[] containing user field values
                String[] userFields = currentLine.split(":");

                // Create a user object and begin setting its field values using the String[]
                User user = new User();
                user.setId(Integer.parseInt(userFields[0]));
                user.setUsername(userFields[1]);
                user.setPassword(userFields[2]);

                // add the created user to our list of users
                usersList.add(user);

                // tell our reader to move to the next line
                currentLine = reader.readLine();

            }

            reader.close(); // good practice to release connection to the file

        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("An exception occurred while reading the file.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

        // iterate across our list of users and print each one out to the console

        // traditional for loop (any version of Java)
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i));
        }

        System.out.println("+-------------------------+");

        // for-each loop (aka enhanced for loop) (Java 5+)
        for (User u : usersList) {
            System.out.println(u);
        }

        System.out.println("+-------------------------+");

        // lambda expression syntax (Java 8+)
        // can only be used with functional interfaces (one and only one abstract method; static/defaults don't count)

        // A lambda expression is the inline implementation of a functional interface's one abstract method
        usersList.forEach(user -> System.out.println(user));

        System.out.println("+-------------------------+");

        // before Java 8, and the intro of lambda expressions; this is what we had to do before
        // this example leverages a "local anonymous class"
        // QC shouldn't ask about this; its an OCP topic (OPTIONAL)
        usersList.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });

        System.out.println("+-------------------------+");

        // same restrictions as the lambda expression
        usersList.forEach(System.out::println); // method reference syntax (Java 8+)

        System.out.println("+------------------------|+");

        Iterator<User> userIterator = usersList.iterator();

        while(userIterator.hasNext()) {
            System.out.println(userIterator.next());
        }
    }

}
