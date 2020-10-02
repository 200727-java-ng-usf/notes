# What is Multiplicity?


Technical definition:

**_a specification of the number of possible occurrences of a property, or the number of allowable elements that may participate in a given relationship_**

 

Simplified definition:

**_a concept that tells us the minimum and maximum number of times that two tables in our database can be related to each other_**

 

Minimums

If the relationship is mandatory: 1

If the relationship is optional: 0

 

Maximums

If a relationship is forbidden: 0

If a relationship is only one: 1

If a relationship can be many: *

 

We represent multiplicity in min/max pairs, such as:



*   **_0..1 (zero-to-one relationship)_**
*   **_0..* (zero-to-many relationship)_**
*   **_1..1 (one-to-one relationship)_**
*   **_1..* (one-to-many relationship)_**
*   **_*..* (many-to-many relationship)_**

 

**Examples:**

![alt_text](images/image1.png)


Reading our UML diagrams (Class diagrams, ERDs, etc.) as sentences, or even as stories, can help us to identify the number of relationships between various entities in our construct. So for OperatingRoom to Operation how can we read this?



*   **_An operating room is used to perform a minimum of X operations, and a maximum of Y operations._**

 

So, with this in mind what would the minimum and maximum be for this diagram?



*   Can an operating room never be used for any operations? (Defining the minimum) **_YES! --> 0_**
*   Can an operating room be used for multiple operations? (Defining the maximum) **_YES! --> *_**

 

Knowing this, we can fill in the min/max pair on the right side of our relationship line with **_0..*_**. So we can that the relationship between OperatingRoom and Operation is a zero-to-many relationship.

 

In addition to this, we also need to look at this relationship from the other perspective: from Operation to OperatingRoom.

 

How could we read this?



*   **_An operation is performed in a minimum of X operating rooms, and a maximum of Y operating rooms._**

 

This should be painfully clear to us, since it doesn't make any sense to perform on operation in multiple rooms, and any operation must be at least performed in one room. So, we can say that the relationship between Operation and OperatingRoom is a one-to-one (**_1..1_**) relationship.

 

So, building off of this hospital example we can assess the relationships between other tables in our DB as well:


![alt_text](images/image2.png)


## Multiplicity vs. Cardinality

 

Two often confused concepts are those of multiplicity and cardinality. Let's look at the definition of cardinality to better understand it, before we start comparing it to multiplicity:

 

##### Cardinality:

**_Denotes the maximum number of possible relationship occurrences in which a certain entity can participate in (in simple terms: at most)._**

 

Let's also define the concept of participation, to help draw the connection:

 

##### Participation:

**_Denotes if all or only some entity occurrences participate in a relationship (in simple terms: at least)._**

 

So, we can think of multiplicity and its relationship to cardinality and participation in this manner:

 

**_MULTIPLICITY = (PARTICIPATION + CARDINALITY)_**
