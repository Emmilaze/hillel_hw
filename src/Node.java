public class Node<T> {
    T item;
    Node<T> next;

    Node(T element) {
        this.item = element;
        this.next = null;
    }
}