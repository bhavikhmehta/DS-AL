package com.company;

public class Main {

    /*
        Delete Middle Node: Implement an algorithm to delete a node in the middle
        (i.e., any node but the first and last node, not necessarily the exact middle)
        of a singly linked list, given only access to that node.

        SOLUTION EXAMPLE
        Input: the node c from the linked list a- >b- >c - >d - >e- >f
        Result: nothing is returned, but the new linked list looks like a->b->d->e->f
     */
    public static void main(String[] args) {
	// write your code here

        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.printList();
        Node delete = list.retrieveNode(5);
        list.removeMiddle(delete);
        list.printList();
    }
}


class LinkedList {

    Node head;

    public LinkedList(int data) {
        this.head = new Node(data);
    }

    /* Method to remove middle node */
    public boolean removeMiddle(Node deleteNode) {

        if (deleteNode == head || deleteNode.next == null || deleteNode == null) {

            return false;
        } else {

            Node next = deleteNode.next;
            deleteNode.data = next.data;
            deleteNode.next = next.next;
            return true;
        }
    }

    public void append (int data) {
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(data);
    }

    public Node retrieveNode(int data) {

        Node currentNode = head;

        while (currentNode != null) {

            if (data == currentNode.data) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }

        return null;
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