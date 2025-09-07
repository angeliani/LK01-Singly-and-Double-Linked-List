package DoublyLinkedList;

public class NodeDLL {
    int data;
    NodeDLL next; //atau pointer
    NodeDLL previous; //prev

    NodeDLL() {}

    NodeDLL(int data) {
        this.data = data;
    }

    NodeDLL(int data, NodeDLL previous, NodeDLL next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }
}
