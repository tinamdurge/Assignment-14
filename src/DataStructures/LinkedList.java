package DataStructures;

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public T get(int index) {
        if (index > this.size()) {
            return null;
        }

        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    // UC9: delete given node from linkedlist
    public void deleteNode(T data) {
        // if linkedlist is empty
        if (head == null) {
            return;
        }

        // if node is head or tail
        if (head.data.equals(data)) {
            this.deleteFirst();
            return;
        }

        if (tail.data.equals(data)) {
            this.deleteLast();
            return;
        }

        // if the node is between head and tail
        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(data)) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    // UC8: method to add node after a given node
    public void insertAfterNode(T source_node_data, T new_node_data) {
        int index = this.search(source_node_data);
        if (index == -1) {
            System.out.println("Source node not found.");
            return;
        }
        this.insertAt(index + 1, new_node_data);
    }

    // UC7: method to search node in linkedlist
    public int search(T data) {
        // if linkedlist is empty
        if (head == null) {
            return -1;
        }

        Node<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    // UC6: method to delete last node in linkedlist
    public void deleteLast() {
        // if linkedlist is empty
        if (head == null) {
            return;
        }

        Node<T> temp = head;

        // check if there is only one node
        if (temp.next == null) {
            head = null;
            tail = null;
            return;
        }

        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    // UC5: method to delete first node in linkedlist
    public void deleteFirst() {
        // if linkedlist is empty
        if (head == null) {
            return;
        }

        Node<T> temp = head.next;
        head.next = null;
        head = temp;
    }

    // UC4: method to add new node at given index in linkedlist
    public void insertAt(int index, T data) {
        // check if index is valid
        if (index < 0 || index > this.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Node<T> node = new Node<>(data);
        if (index == 0) {
            this.addFirst(data);
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    // UC3: method to add new node at last of linkedlist
    public void add(T data) {
        Node<T> node = new Node<>(data);
        // if linkedlist is empty
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // UC2: method to add new node at head of linkedlist
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        // if linkedlist is empty
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    // method to get size of linkedlist
    public int size() {
        Node<T> node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    // method to return if list is empty
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        String listdata = "";
        Node<T> node = head;
        while (node != null) {
            listdata += node.data + " ";
            node = node.next;
        }
        return listdata;
    }
}