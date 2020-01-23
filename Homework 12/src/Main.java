import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new List<>();

        list.addLast(new Node<>(7));
        list.printList();

        list.addFirst(new Node<>(1));
        System.out.println("Add first element: ");
        list.printList();

        list.addFirst(new Node<>(2));
        System.out.println("Add first element: ");
        list.printList();

        list.addLast(new Node<>(3));
        System.out.println("Add last element: ");
        list.printList();

        list.add(new Node(4), 1);
        System.out.println("Add element to 1 index: ");
        list.printList();

        list.swapNodes(0, 3);
        System.out.println("Swap 0 and 3 elements: ");
        list.printList();

        System.out.println("Size of the list: " + list.size());
        list.deleteFirst();
        System.out.println("Delete first element: ");
        list.printList();

        list.deleteLast();
        System.out.println("Delete last element: ");
        list.printList();

        list.deleteNode(0);
        System.out.println("Delete 0 element: ");
        list.printList();
        
        System.out.println("Is list empty? " + list.isEmpty());

        String[] array = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List arrayList = new List(array);
        System.out.println("List from array:");
        arrayList.printList();
        System.out.println("Size of the array: " + arrayList.size());
    }
}
