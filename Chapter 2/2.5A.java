package com.company;

public class Main {

    /*
        Sum Lists: You have two numbers represented by a linked list, where each node
        contains a single digit. The digits are stored in reverse order, such that the 1's
        digit is at the head of the list. Write a function that adds the two numbers
        and returns the sum as a linked list.
     */
    public static void main(String[] args) {
	// write your code here

        //Case1: Different Size
        LinkedList num1 = new LinkedList(1);
        num1.append(7);
        num1.append(1);
        num1.append(6);
        num1.printList();
        LinkedList num2 = new LinkedList(5);
        num2.append(9);
        num2.append(2);
        num2.printList();
        num1.sumReverseList(num2);

        //Case2: Same Size
        LinkedList num3 = new LinkedList(7);
        num3.append(1);
        num3.append(6);
        num3.printList();
        LinkedList num4 = new LinkedList(5);
        num4.append(9);
        num4.append(2);
        num4.printList();
        num3.sumReverseList(num4);

    }
}

class LinkedList {

    Node head;
    int size;

    public LinkedList(int data) {
        this.head = new Node(data);
        size = 1;
    }

    public void append (int data) {
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(data);
        size ++;
    }

    /*Method to sum two lists (reverse)*/
    public LinkedList sumReverseList(LinkedList num) {

        LinkedList summation = null;
        int carry = 0; //carry found by dividing value by 10
        int value; //value found by modding value by 10
        int rawValue;
        int maxSizeList = Math.max(num.size, size);
        Node nextList1 = head;
        Node nextList2 = num.head;

        for (int i = 0; i < maxSizeList; i++) {

            if (nextList1 == null) {
                nextList1 = new Node(0);
            } else if (nextList2 == null) {
                nextList2 = new Node(0);
            }
            rawValue = nextList2.data + nextList1.data + carry;
            value = rawValue % 10;
            carry = rawValue / 10;

            if (summation == null) {
                summation = new LinkedList(value);
            } else {
                summation.append(value);
            }
            nextList1 = nextList1.next;
            nextList2 = nextList2.next;
        }

        summation.printList();
        return summation;
    }

    public void printList() {
        Node current = head;

        while (current != null) {

            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("");
    }

    public int listSize() {
        return size;
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