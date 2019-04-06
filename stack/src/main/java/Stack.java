class EmptyStackException extends RuntimeException {

}

class Node<T> {

    T element;
    Node<T> next;

    Node(T element) {
        this.element = element;
    }
}

public class Stack<T> {

    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void add(T i) {
        if (top == null) {
            top = new Node(i);
        } else {
            Node newTop = new Node(i);
            newTop.next = top;
            top = newTop;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node taken = top;
        top = top.next;
        return (T) taken.element;
    }
}
