package DataStructures;

public class Queue<T> extends LinkedList<T> {
    public Queue() {
        super();
    }

    // UC3: add enqueue method for queue
    public void enqueue(T data) {
        super.add(data); // using add to last method of linkedlist
    }

    // UC4: add dequeue method
    public T dequeue() {
        if (super.isEmpty()) {
            return null;
        }
        T data = super.head.data;
        super.deleteFirst(); // delete first node, FIFO
        return data;
    }
}
