public class List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public List() {
    }

    public List(T[] array) {
        first = new Node<>(array[0]);
        last = new Node<>(array[array.length - 1]);
        size++;
        for (int i = 1; i < array.length; i++) {
            addLast(new Node<>(array[i]));
        }
    }

    public void addFirst(Node<T> item) {
        if (last == null)
            last = item;
        item.next = first;
        first = item;
        size++;
    }

    public void addLast(Node<T> item) {
        if (last == null) {
            first = item;
            size++;
            return;
        }
        item.next = null;
        Node last = first;
        while (last.next != null)
            last = last.next;
        last.next = item;
        size++;
        return;
    }

    public void add(Node item, int index) {
        if (index <= size && index > 0) {
            Node currentNode = first;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.next;
            }
            item.next = currentNode.next;
            currentNode.next = item;
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
        Node firstNode = getNode(firstIndex);
        Node secondNode = getNode(secondIndex);
        if (firstNode == secondNode) return;
        Node prevX = null, currX = first;
        while (currX != null && currX.item != firstNode.item) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = first;
        while (currY != null && currY.item != secondNode.item) {
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

    public Node getNode(int index) {
        Node current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
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
}