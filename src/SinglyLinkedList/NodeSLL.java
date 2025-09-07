package SinglyLinkedList;

public class NodeSLL {
    Object data;
    NodeSLL next; //atau pointer 

    NodeSLL() {}

    NodeSLL(Object data) {
        this.data = data;
    }

    NodeSLL(Object data, NodeSLL next) {
        this.data = data;
        this.next = next;
    }
}
