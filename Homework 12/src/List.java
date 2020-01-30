import java.util.Iterator;

public class List<T> implements Iterable<T>, Iterator {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;
    private Node<T> iteratorPointer = this.first;

    public List() {
    }

    public List(T[] array) {
        first = new Node<>(array[0]);
        last = new Node<>(array[array.length - 1]);
        size++;
        for (int i = 1; i < array.length; i++) {
            addLast(array[i]);
        }
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        if (last == null)
            last = newNode;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item);
        if (last == null && first == null) {
            first = newNode;
            last = newNode;
            size++;
            return;
        }

        last.next = newNode;
        last = newNode;
        size++;
        return;
    }

    public void add(T item, int index) {
        Node<T> newNode = new Node<T>(item);
        if (index <= size && index > 0) {
            Node currentNode = first;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }
    }

    public void deleteNode(int position) {
        if (isEmpty())
            return;
        Node temp = first;
        if (position == 0) {
            first = temp.next;
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;
        size--;
    }

    public void deleteFirst() {
        deleteNode(0);
        size--;
    }

    public void deleteLast() {
        deleteNode(size - 1);
        size--;
    }

    public void swapNodes(int firstIndex, int secondIndex) {
        T firstNode = getByIndex(firstIndex);
        T secondNode = getByIndex(secondIndex);
        if (firstNode == secondNode) return;
        Node prevX = null, currX = first;
        while (currX != null && currX.item != firstNode) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = first;
        while (currY != null && currY.item != secondNode) {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null) {
            return;
        }
        if (prevX != null) {
            prevX.next = currY;
        } else {
            first = currY;
        }
        if (prevY != null) {
            prevY.next = currX;
        } else {
            first = currX;
        }
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public boolean isEmpty() {
        return first == null && size == 0;
    }

    public T getByIndex(int index) {
        Node current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return (T) current.item;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public void printList() {
        Node tNode = first;
        while (tNode != null) {
            System.out.print(tNode.item + " ");
            tNode = tNode.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    private void resetIteratorPointer() {
        iteratorPointer=this.first;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if (iteratorPointer == null) {
            resetIteratorPointer();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public T next() {
        T data = iteratorPointer.item;
        iteratorPointer = iteratorPointer.next;
        return data;
    }

}
