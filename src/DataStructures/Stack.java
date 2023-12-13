package DataStructures;

public class Stack<T> extends LinkedList<T> {

    public Stack() {
        super();
    }

    // UC1: add push method to stack
    public void push(T data) {
        super.add(data); // using add to last method of linked list
    }

    // UC2: adding peek and pop methods to stack
    public T peek() {
        if (super.isEmpty()) {
            System.out.println("The Stack is empty.");
            return null;
        }
        return super.tail.data;
    }

    public T pop() {
        if (super.isEmpty()) {
            System.out.println("The Stack is empty.");
            return null;
        }
        T data = super.tail.data;
        super.deleteLast();
        return data;
    }
}
