package com.marknoblin;

import com.marknoblin.myhashtable.MyHashTable;
import com.marknoblin.mylinkedlist.MyLinkedList;

public class CrackingTheCodingInterview {
     public static void main(String[] args) {

        System.out.println("My Hash Table:");
        // Run methods for my Hash Table implementation
        MyHashTable<String, Integer> table = new MyHashTable<>();

        table.add("this", 1);
        table.add("that", 2);
        table.add("the other", 3);
        table.add("that", 4);

        System.out.println(table.size());               // Expect size = 3
        System.out.println(table.get("this"));          // Expect value = 1
        System.out.println(table.get("that"));          // Expect value = 4
        System.out.println(table.remove("that"));  // Expect return value = 4
        System.out.println(table.remove("that"));  // Expect return value = null, since key = "that" no longer exists
        System.out.println(table.size());               // Expect size = 2
        System.out.println(table.isEmpty());            // Expect false since table still has 2 values


        System.out.println("My Linked List:");
        // Run methods for my Linked List implementation
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(0);

        linkedList.head.appendToTail(1);
        linkedList.head.appendToTail(3);
        linkedList.head.appendToTail(5);
        linkedList.head.appendToTail(3);
        linkedList.head.appendToTail(7);

        linkedList.printList();

        System.out.println(linkedList.hasData(3));
        System.out.println(linkedList.hasData(4));

        System.out.println(linkedList.head.deleteNode(linkedList.head, 5).data);
        System.out.println(linkedList.head.deleteNode(linkedList.head, 3).data);
        linkedList.printList();

    }
}
