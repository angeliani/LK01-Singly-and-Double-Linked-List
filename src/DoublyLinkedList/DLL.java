package DoublyLinkedList;

public class DLL {
    NodeDLL head, tail;
    int size = 0;

    void inisialisasi() {
        head = tail = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void addFirst(NodeDLL input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head.previous = input;
            head = input;
        }
        size++;
    }

    void addLast(NodeDLL input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.previous = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void insertAfter(int key, NodeDLL input) {
        NodeDLL temp = head;
        while (temp != null) {
            if (temp.data == key) {
                input.previous = temp;
                input.next = temp.next;
                if (temp.next != null) {
                    temp.next.previous = input;
                } else {
                    tail = input;
                }
                temp.next = input;
                size++;
                System.out.println("Insert data berhasil");
                break;
            }
            temp = temp.next;
        }
    }

    void insertBefore(int key, NodeDLL input) {
        NodeDLL temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    this.addFirst(input);
                } else {
                    input.previous = temp.previous;
                    input.next = temp;
                    temp.previous.next = input;
                    temp.previous = input;
                    size++;
                }
                System.out.println("Insert data berhasil");
                break;
            }
            temp = temp.next;
        }
    }

    void removeFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            size--;
        } else {
            System.out.println("Data kosong!");
        }
    }

    void removeLast() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
            size--;
        } else {
            System.out.println("Data kosng!");
        }
    }

    void remove(int key) {
        NodeDLL temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    removeFirst();
                } else if (temp == tail) {
                    removeLast();
                } else {
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                    size--;
                }
                break;
            }
            temp = temp.next;
        }
    }
    public void insertAt(int index, Object data) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index=" + index + " Size=" + size);

        NodeDLL newNode = new NodeDLL((int) data);

        if (index == 0) { // depan
            addFirst(newNode);
        } else if (index == size) { // belakang
            addLast(newNode);
        } else {
            NodeDLL temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.previous = temp;
            if (temp.next != null) {
                temp.next.previous = newNode;
            }
            temp.next = newNode;
            size++;
        }
    }

    // hapus di index tertentu
    public void removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index=" + index + " Size=" + size);

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            NodeDLL temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.previous.next = temp.next;
            if (temp.next != null) {
                temp.next.previous = temp.previous;
            }
            size--;
        }
    }

    // ambil data di index
    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index=" + index + " Size=" + size);

        NodeDLL current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // mengecek apakah data ada
    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }

    // mencaari posisi data
    public int indexOf(Object data) {
        NodeDLL current = head;
        int index = 0;
        while (current != null) {
            if (current.data == (int) data) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void printList() {
        NodeDLL temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Ukuran list: " + size);
    }
}
