package com.marknoblin.mylinkedlist;

public class Node<T> {
    public T data;
    public Node<T> next = null;

    public Node(T data) {
        this.data = data;
    }

    public void appendToTail(T data) {
        Node<T> end = new Node<T>(data);
        Node<T> n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node<T> deleteNode(Node<T> head, T data) {
        if (head == null) return null;
        Node<T> n = head;

        if (n.data == data) {
            return head.next;
        }

        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
