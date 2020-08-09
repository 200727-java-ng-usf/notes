package com.revature.passbyvalue;

import java.util.Objects;

// All objects inherit from the Object class (either directly or indirectly)
// not necessary to declare "extends Object", as all objects implicitly extend Object
public class Person extends Object {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override // not technically needed, but good to include for other devs
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    /*
        differences between: == and .equals()

                == compares memory addresses of two objects (are they the same object?)

                .equals()
                    + by default it is the exact same as ==
                    + commonly overridden to compare the value equivalency of two objects
     */

    // The old ugly way of overriding the .equals() method (pre-Java 7)
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
//        return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;
//    }

    @Override
    public boolean equals(Object o) {

        // is this instance and o the exact same object? if so return true, since obviously their values are also equal
        if (this == o) return true;

        // is o null? is the class of o the same as the class of this instance? if not, they can never be equal so return false
        if (o == null || this.getClass() != o.getClass()) return false;

        // Cast o into a Person object, so that we can access the Person-specific fields and methods
        Person person = (Person) o;

        // Compare each value of this instance to the person and determine if all values are equal
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);

    }

    // the old ugly way of overriding .hashcode() (pre-Java 7)
//    @Override
//    public int hashCode() {
//        int result = firstName != null ? firstName.hashCode() : 0;
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        return result;
//    }

    // Generates a int value that is pseudo-unique to the object, plays a role in
    // data structures such as HashMaps and HashSets (more on that next week...)
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}
