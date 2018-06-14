package com.company;

public class Main {
    /*
        Intersection: Given two (singly) linked lists, determine if the two lists intersect.
        Return the intersecting node. Note that the intersection is defined based on
        reference, not value. That is, if the kth node of the first linked
        list is the exact same node (by reference) as the jth node of the second
        linked list, then they are intersecting.
     */
    public static void main(String[] args) {
	// write your code here
        Node intersectNode = new Node(7);

        LinkedList list1 = new LinkedList(3);
        list1.append(1);
        list1.append(5);
        list1.append(9);
        list1.append(intersectNode);
        list1.append(2);
        list1.append(1);

        LinkedList list2 = new LinkedList(4);
        list2.append(6);
        list2.append(intersectNode);
        System.out.println(list1.listIntersection(list2).data);


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

    public void append (Node data) {
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = data;
    }

    /*
        Method to find if two singly linked lists intersect,
        Technique:  Traverse through both lists to find the sizes of the lists.
                    Both tails must be the same if lists intersect
                    Trim lists, so that both lists are the same size
                    Iterate through both lists until same node is found.
    */
    public Node listIntersection(LinkedList list) {
        Node list1 = list.head;
        Node list2 = head;
        int list1Size = 0;
        int list2Size = 0;

        while (list1 != null) {

            list1Size++;
            list1 = list1.next;
        }

        while (list2 != null) {

            list2Size++;
            list2 = list2.next;
        }

        //checking if tail is not the same
        if (list1 != list2) {
            return null;
        }
        list1 = list.head;
        list2 = head;

        if (list1Size > list2Size) {

            for (int i = 0; i < list1Size - list2Size; i++) {
                list1 = list1.next;
            }

        } else if (list1Size < list2Size) {

            for (int i = 0; i < list2Size - list1Size; i++) {
                list2 = list2.next;
            }
        }

        while (list1 != null) {

            if (list1 == list2) {
                return list1;
            }

            list1 = list1.next;
            list2 = list2.next;
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