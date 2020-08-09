package com.revature.structures.util;

/**
 * This is a custom implementation of a linked list data
 * structure, which vaguely mirrors the Java Collections
 * API implementation LinkedList.
 *
 * @param <T> a parameterized type
 * @author Wezley Singleton
 */
public class CustomLinkedList<T> {

    /**
     * The starting, or root, node of our linked list.
     */
    private Node<T> head;

    /**
     * The ending, or last, node of our linked list.
     */
    private Node<T> tail;

    /**
     * Inserts a new node, containing provided data, at the
     * end/tail of the linked list.
     */
    public void insert(T data) {

        // create a new node object, whose nextNode value is null and contains the provided data
        Node<T> newNode = new Node<>(data, null);

        // if the head of our list is null, then the new node will become the head and the tail
        if (head == null) {
            System.out.println("List is empty, adding first element.");
            head = newNode;
        }

        // if there is already elements in our list, then we will select the tail, setting its nextNode
        // value to the newNode we just created.
        else {
            System.out.println("List has existing elements, adding new node to the end.");
            tail.setNextNode(newNode);
        }

        tail = newNode;

    }

    /**
     * Returns, but does not remove, the data of first node in the list.
     */
    public T peek() {

        if (head != null) {
            return head.getData();
        }

        return null;

    }

    /**
     * Returns, and removes, the data of the first node in the list
     */
    public T poll() {

        if (head == tail) {
            tail = null;
        }

        if (head != null) {
            T data = head.getData();
            head = head.getNextNode();
            return data;
        }

        return null;

    }

    /**
     * Convenience method for printing out our list's contents
     */
    public void printList() {

        // Start with the head of the list
        Node<T> currentNode = this.head;

        // while the current node is not null, print node info and move on to the next node
        while (currentNode != null) {
            System.out.println("Node value: " + currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

    }

    /**
     * Removes the first occurrence of the provided data value in the linked list
     * @param key
     * @return a boolean value; true if a data node was removed and false if one was not
     */
    public boolean removeByKey(T key) {

        // handle the scenario where the list is empty
        if (this.head == null) {
            return false;
        }

        // Create a reference to hold the current node
        Node<T> currentNode = this.head;

        // Create a reference to hold the next node (after currentNode)
        Node<T> nextNode = currentNode.getNextNode();

        // If the first node contains data equal to the key, remove that node
        if (currentNode.getData().equals(key)) {
            this.head = nextNode;
            return true;
        }

        // iterate across the linked list while currentNode is not null
        while (currentNode != null) {

            // If the nextNode is not null and contains the data we want to delete
            // then have the currentNode point to the node after nextNode
            if (nextNode != null && nextNode.getData().equals(key)) {
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }

            // advance currentNode to the next node in the list
            currentNode = currentNode.getNextNode();

            // if nextNode is not null, then advance the next to the one after it
            if (nextNode != null) {
                nextNode = nextNode.getNextNode();
            }

        }

        return false;
    }
}
