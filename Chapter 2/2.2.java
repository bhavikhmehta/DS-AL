package com.company;

public class Main {
    /*
        Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
     */

    public static void main(String[] args) {
	// write your code here
        LinkedList list = new LinkedList(7);
        list.append(6);
        list.append(5);
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(1);
        list.printList();
        list.findKthToLast(3); // return 4
        list.findKthToLast(10); // return list is too small
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

    /*
        k = 0 is the last element, k = 1 is the second last element and so on...
        Method to find the Kth to last element in list
    */
    public void findKthToLast(int k) {
        Node follower = head;
        Node leader = head;
        for (int i = 0 ; i < k; i++) {
            if (leader != null){
                leader = leader.next;
            } else {
                System.out.println("List is too small");
                return;
            }
        }

        while (leader.next != null) {
            leader = leader.next;
            follower = follower.next;
        }

        System.out.println("Data in kth element: " + follower.data);
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