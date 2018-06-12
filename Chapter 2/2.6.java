package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Case 1: Palindrome list
        LinkedList list = new LinkedList(2);
        list.append(1);
        list.append(0);
        list.append(1);
        list.append(2);
        list.printList();
        System.out.println(list.palindromeList());

        //Case 2: Non Palindrome list
        LinkedList list1 = new LinkedList(1);
        list1.append(2);
        list1.append(3);
        list1.append(4);
        list1.printList();
        System.out.println(list1.palindromeList());
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

    /* Method to identify if list is palindrome, using the technique to reverse list first */
    public boolean palindromeList() {

        Node currentList = head;
        Node reverseList = this.reverseList();

        while (currentList != null) {
            if (currentList.data != reverseList.data) {
                return false;
            }
            currentList = currentList.next;
            reverseList = reverseList.next;
        }

        return true;
    }

    public Node reverseList () {
        Node newList = null;
        Node currentNode = head;

        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
        }

        head = newList;
        return head;
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
