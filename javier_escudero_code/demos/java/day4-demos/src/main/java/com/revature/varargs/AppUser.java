package com.revature.varargs;

import java.util.Arrays;

/*
    POJO = Plain Ol' Java Object

        - Design pattern that encapsulates the states and behaviors of a domain object

        - Synonyms: models, entities, beans

        - Characteristics:
            + have private fields/attributes/states
            + has one or more constructors for instantiating the class
            + exposes a getter and setter for each private field
            + overrides the Object class's .equals(), .hashcode(), and .toString() methods
 */
public class AppUser {

    private int id;
    private String username;
    private String password;
    private Role[] roles;

    public AppUser() {
        super(); // not required, it is implied; but Wezley doesn't like having empty constructors
    }

    public AppUser(String username, String pw, Role[] roles) {
        // use "this" to access instance scope variables that have the same name as method scoped variables
        this.username = username;

        // if there are no method scoped variables with the same name as the instance scoped ones, no need for "this"
        password = pw;

        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    /*
        Variable arguments

            - ... means you are taking in a variable number of arguments for this type

            - must be the last parameter in the method signature
                + which also means that you can only have 1 vararg parameter per method

     */
    public void addRoles(Role... newRoles) {

        // Make sure that roles is instantiated
        if (roles == null) {

            // If not, set roles to newRoles and return from the method early
            roles = newRoles;
            return; // doesn't actually return anything, just leaves this method early
        }

        // Make an int that holds the index position that we will start adding new roles
        int startingIndexForNewRoles = roles.length;

        // Make a copy of the existing roles array, but with a length equal to (newRoles.length + roles.length)
        roles = Arrays.copyOf(roles, newRoles.length + roles.length);

        // Loop across the newRoles and add each new role into the roles array starting at the index we obtained earlier
        for (int i = startingIndexForNewRoles, j = 0; j < newRoles.length; i++, j++) {
            roles[i] = newRoles[j];
        }

        /*
            Note that the above for loop is slightly different than a typical one
                - It has TWO initial variables declared in for loop
                - It is incrementing both i and j each time the loop makes an iteration
         */
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }

}
