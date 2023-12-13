package DataStructures;

// UC10: creating an ordered list using linkedlist class
public class OrderedList<T extends Comparable<T>> extends LinkedList<T> {
    public OrderedList() {
        super();
    }

    public void add(T data) {
        // if list is empty
        if (this.head == null) {
            super.add(data);
            return;
        }

        // if data is smaller than head
        if (this.head.data.compareTo(data) > 0) {
            super.addFirst(data);
            return;
        }

        // if data is greater than tail
        if (this.tail.data.compareTo(data) < 0) {
            super.add(data);
            return;
        }

        Node<T> temp = head;
        int index = 0;
        while (temp.next.data.compareTo(data) < 0) {
            temp = temp.next;
            index++;
        }
        super.insertAt(index + 1, data);
    }
}