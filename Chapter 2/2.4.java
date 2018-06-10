package com.bhavik;

public class Main {
    /*
        Partition: Write code to partition a linked list around a value x, such that all nodes
        less than x come before all nodes greater than or equal to x. If x is contained within the
        list the values of x only need to be after the elements less than x (see below). The partition
        element x can appear anywhere in the "right partition"; it does not need to appear between the
        left and right partitions.
     */
    public static void main(String[] args) {
	// write your code here

        LinkedList list = new LinkedList(3);
        list.append(5);
        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);
        list.append(-1);
        list.printList();

        list.partitionList(5);
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

    /* Method to partition list */
    public void partitionList(int partition) {
        Node tail = head;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;

            if (current.data >= partition) {
                //move tail from previous location to current location
                tail.next = current;
                tail = current;
            } else {
                //make the next node the previous head, and assign the current node
                //the new head
                current.next = head;
                head = current;
            }

            current = next;
        }

        //to remove circular refrence
        tail.next = null;
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