package com.marknoblin.mydoublylinkedlist;

public class MyDoublyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    public int size;

    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyDoublyLinkedList(T data) {
        head = new Node<>(data);
        tail = head;
        size = 1;
    }

    public void appendToTail(T data) {
        Node<T> end = new Node<>(data);

        if (tail == null) {
            head = end;
            tail = head;
        } else {
            end.prev = tail;
            tail.next = end;
            tail = end;
        }
        size++;
    }

    public void prependToHead(T data) {
        Node<T> start = new Node<>(data);

        if (head == null) {
            head = start;
            tail = head;
        } else {
            start.next = head;
            head.prev = start;
            head = start;
        }
        size++;
    }

    public Node<T> deleteNode(Node<T> head, T data) {
        if (head == null) return null;
        Node<T> n = head;

        if (n.data == data) {
            size --;
            head.next.prev = null;
            return head.next;
        }

        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                n.next.prev = n;
                size --;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public void printList() {
        Node<T> n = head;

        while (n != null) {
            System.out.print(n.data + " ");

            n = n.next;
        }
        System.out.println();
    }

    public boolean hasData (T data) {
        Node<T> n = head;

        while (n != null) {
            if (n.data == data) {
                return true;
            }

            n = n.next;
        }

        return false;
    }
}
