package DoublyLinkedList;

public class MainDLL {
    public static void main(String[] args) {
        DLL dll = new DLL();

        System.out.println("===================================");
        System.out.println("Doubly Linked List (DLL)");
        System.out.println("===================================");
        System.out.println("Nama : Angeliani Junitaviana H");
        System.out.println("NIM : 245150700111021");
        System.out.println("Kelas : ASD - C");
        System.out.println("===================================");

        // tambah data
        dll.addFirst(new NodeDLL(20));
        dll.addLast(new NodeDLL(40));
        dll.insertAt(0, 10); // depan
        dll.insertAt(2, 30); // tengah
        dll.insertAt(4, 50); // belakang

        System.out.println("Isi Doubly Linked List (forward):");
        for (int i = 0; i < dll.size; i++) {
            System.out.print(dll.get(i) + " ");
        }
        System.out.println();
        dll.printList();

        // cek contains & indexOf
        System.out.println("===================================");

        System.out.println("Apakah mengandung 30? " + dll.contains(30));
        System.out.println("===================================");

        System.out.println("Index dari 40: " + dll.indexOf(40));
        System.out.println("Index dari 99: " + dll.indexOf(99));

        // remove by index
        System.out.println("===================================");
        System.out.println("Hapus index 2 (hapus 30)");
        dll.removeAt(2);

        System.out.println("Isi Doubly Linked List setelah \nremove:");
        for (int i = 0; i < dll.size; i++) {
            System.out.print(dll.get(i) + " ");
        }
        System.out.println();
        System.out.println("===================================");
        dll.printList();
        System.out.println("===================================");

    }
}
