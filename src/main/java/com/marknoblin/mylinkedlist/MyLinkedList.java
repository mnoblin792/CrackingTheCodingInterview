package com.marknoblin.mylinkedlist;

public class MyLinkedList<T> {
    public Node<T> head;

    public MyLinkedList() {
        head = null;
    }

    public MyLinkedList(T data) {
        head = new Node<>(data);
    }

    public void printList() {
        Node<T> current = head;

        while (current != null) {
            System.out.println(current.data);

            current = current.next;
        }
    }

    public boolean hasData (T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
}
