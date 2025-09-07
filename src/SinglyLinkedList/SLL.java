package SinglyLinkedList;

public class SLL {
    NodeSLL head, tail;
    int size = 0;

    void inisialisasi() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(NodeSLL input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(NodeSLL input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void insertAfter(Object key, NodeSLL input) {
        NodeSLL temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) {
                input.next = temp.next;
                temp.next = input;
                size++;
                System.out.println("Insert data berhasil");
                break;
            }
            temp = temp.next;
        }
    }

    void insertBefore(Object key, NodeSLL input) {
        NodeSLL temp = head;
        while (temp != null) {
            if ((temp.data.equals(key)) && (temp == head)) {
                this.addFirst(input);
                System.out.println("Insert data berhasil");
                break;
            } else if (temp.next != null && temp.next.data.equals(key)) {
                input.next = temp.next;
                temp.next = input;
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
                NodeSLL temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
            System.out.println("RemoveLast berhasil");
        }
    }

    void remove(Object key) {
        if (!isEmpty()) {
            if (head.data.equals(key)) {
                removeFirst();
                return;
            }
            NodeSLL temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(key)) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    size--;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index=" + index + " size=" + size);
        }
    }

    public int indexOf(Object data) {
        NodeSLL current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removeElement;
        if (index == 0) {
            removeElement = head.data;
            head = head.next;
        } else {
            NodeSLL q = head;
            for (int i = 0; i < index - 1; i++)
                q = q.next;
            removeElement = q.next.data;
            q.next = q.next.next;
            if (q.next == null) {
                tail = q;
            }
        }
        size--;
        return removeElement;
    }

    public void add(int index, Object theElement) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        if (index == 0) {
            head = new NodeSLL(theElement, head);
            if (tail == null) tail = head;
        } else {
            NodeSLL p = head;
            for (int i = 0; i < index - 1; i++)
                p = p.next;
            p.next = new NodeSLL(theElement, p.next);
            if (p.next.next == null) tail = p.next;
        }
        size++;
    }

        // insert di index tertentu
        public void insertAt(int index, Object data) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index=" + index + " Size=" + size);
    
            NodeSLL newNode = new NodeSLL(data);
            if (index == 0) { // depan
                addFirst(newNode);
            } else if (index == size) { // belakang
                addLast(newNode);
            } else {
                NodeSLL temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
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
                NodeSLL temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
                size--;
            }
        }
    
        // ambil data di index
        public Object get(int index) {
            checkIndex(index);
            NodeSLL currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.data;
        }
    
        // mengecek apakah datanya ada
        public boolean contains(Object data) {
            return indexOf(data) != -1;
        }
        
        public void printList() {
            NodeSLL temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
            System.out.println("Ukuran list : " + size);
        }
    }
    
    
    