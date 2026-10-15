package com.marknoblin.crackingthecodinginterview.myhashtable;

import java.util.ArrayList;
import java.util.Objects;

class HashNode<K, V> {
    K  key;
    V value;
    final long hashCode;

    // Reference to next node
    HashNode<K, V> next;

    // Constructor
    public HashNode(K key, V value, long hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

public class MyHashTable<K, V> {
    private ArrayList<HashNode<K, V>> table;
    private int bucketCount;
    private int size;

    // Constructor for new empty table; default 10 buckets and no values
    public MyHashTable() {
        table = new ArrayList<>();

        bucketCount = 10;
        size = 0;

        // Load each bucket with a null node to begin
        for (int i = 0; i < bucketCount; i++) {
            table.add(null);
        }
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // Generate a hash code for a given key of any type using builtin hashcode function
    private int hashCode(K key) {
        // In this case, for simplicity and handling, I'll be using java.util.objects#hashCode()
        // If the key handed over is null, this returns 0
        return Objects.hashCode(key);
    }

    // Use the hash function to find the index for a given key
    private int getIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % bucketCount;
        // We could end up with a negative index, so let's add the bucket count back to make it positive
        if (index < 0) {
            index += bucketCount;
        }
        return index;
    }

    // Remove a value from the table and return its value
    public V remove(K key) {
        int index = getIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = table.get(index);
        HashNode<K, V> prev = null;

        while (head != null) {
            // If we find the key...
            if (head.key.equals(key) && head.hashCode == hashCode) {
                break;
            }

            // ...otherwise let's iterate to the next value
            prev = head;
            head = head.next;
        }

        // If the key isn't present in the table, we have nothing to return
        if (head == null) {
            return null;
        }

        // Decrement the size to account for the removed node
        size--;

        // Here's where we actually remove the key
        if (prev != null) {
            prev.next = head.next;
        } else {
            table.set(index, head.next);
        }

        return head.value;
    }

    public V get(K key) {
        int index = getIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = table.get(index);

        while (head != null) {
            // If we find the key
            if (head.key.equals(key) && head.hashCode == hashCode) {
                return head.value;
            }
            head = head.next;
        }

        // We did not find the key, so we have no value to hand back
        return null;
    }

    public void add(K key, V value) {
        int index = getIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = table.get(index);

        while (head != null) {
            // If we find the key in the table, set the value and exit the method
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        // Increment the size to account for the added node
        size++;

        // We can add the new key into the chain at the relevant bucket
        head = table.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        table.set(index, newNode);

        // Check the load factor (75%) to see if we need to expand the size of the table
        // In the case we need to increase size, double the bucket count
        if ((1.0 * size / bucketCount) > 0.75) {
            ArrayList<HashNode<K, V>> tempTable = table;
            table = new ArrayList<>();

            bucketCount = 2 * bucketCount;
            size = 0;
            for (int i = 0; i < bucketCount; i++) {
                table.add(null);
            }

            for (HashNode<K, V> headNode : tempTable) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
