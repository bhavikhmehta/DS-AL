package com.bhavik;

import java.util.HashSet;

public class Main {
    /*
        Romove Dups: Write code to remove duplicates from an unsorted linked list.
     */

    public static void main(String[] args) {
	// write your code here
        LinkedList list = new LinkedList(5);
        list.append(5);
        list.append(3);
        list.append(3);
        list.append(4);
        list.append(4);
        list.append(2);
        list.append(3);
        list.append(1);
        list.append(1);
        list.append(3);
        list.printList();
        list.removeDups();
        list.printList();
    }
}

class LinkedList {

    Node head;

    public LinkedList(int data) {
        this.head = new Node(data);
    }

    public void append (int data) {
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(data);
    }

    /* Method to remove duplicate nodes */
    public void removeDups () {
        HashSet set = new HashSet();
        Node current = head;
        Node previous = head;

        while (current != null) {
            if (!set.contains(current.data)) {

                set.add(current.data);
                previous = current;
            } else {

                previous.next = current.next;
            }

            current = current.next;
        }
    }

    public void printList() {
        Node current = head;

        while (current != null) {

            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("");
    }
}

class Node {

    Node next;
    int data;

    public Node(int data) {

        this.data = data;
        next = null;
    }
}