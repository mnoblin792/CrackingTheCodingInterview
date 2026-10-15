package com.marknoblin;

import com.marknoblin.myhashtable.MyHashTable;

public class CrackingTheCodingInterview {
     public static void main(String[] args) {
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
    }
}
