package DataStructures;

public class DeQueue<T> extends LinkedList<T> {
    public DeQueue() {
        super();
    }

    public void addFront(T data) {
        super.addFirst(data);
    }

    public void addRear(T data) {
        super.add(data);
    }

    public T removeFront() {
        if (super.isEmpty()) {
            return null;
        }
        T data = super.head.data;
        super.deleteFirst();
        return data;
    }

    public T removeRear() {
        if (super.isEmpty()) {
            return null;
        }
        T data = super.tail.data;
        super.deleteLast();
        return data;
    }
}
