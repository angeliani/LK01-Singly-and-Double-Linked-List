package SinglyLinkedList;

public class MainSLL {
    public static void main(String[] args) {
        SLL list = new SLL();

        System.out.println("================================");
        System.out.println("Singly Linked List (SLL)");
        System.out.println("================================");
        System.out.println("Nama : Angeliani Junitaviana H");
        System.out.println("NIM : 245150700111021");
        System.out.println("Kelas : ASD - C");
        System.out.println("================================");

        // tambah data
        list.addFirst(new NodeSLL("G"));
        list.addLast(new NodeSLL("E"));
        list.insertAt(0, "N");   // di depan
        list.insertAt(0, "A");   // di depan
        list.insertAt(4, "L");   // di belakang

        System.out.println("Isi Linked List:");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        list.printList();

        // cek contains & indexOf
        System.out.println("================================");
        System.out.println("Apakah mengandung 'C'? " + list.contains("C"));
        System.out.println("================================");
        System.out.println("Index dari 'D': " + list.indexOf("D"));
        System.out.println("Index dari 'Z': " + list.indexOf("Z"));

        // remove by index
        System.out.println("================================");
        System.out.println("Hapus di index 0 (hapus A)");
        list.removeAt(0);

        System.out.println("Isi Linked List setelah remove:");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("================================");
        list.printList();
        System.out.println("================================");
    }
}
