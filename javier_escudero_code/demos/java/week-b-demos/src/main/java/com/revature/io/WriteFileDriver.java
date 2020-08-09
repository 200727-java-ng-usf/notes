package com.revature.io;

import com.revature.io.models.User;

import java.io.*;

public class WriteFileDriver {

    public static void main(String[] args) {

        File userFile = new File("src/main/resources/users.txt");

        /*
            try-with-resources

                - introduced in Java 7
                - auto-closes objects declared as resources (more than one is allowed, just separate with a ;
                - only allows for the declaration of resources that implement the AutoCloseable interface
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {

            User newUser = new User(5, "mknighten", "rolltide");
            writer.write("\n" + newUser.toFileString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
