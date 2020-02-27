package WorkShop;//package WorkShop;
//
//public class DoublyLinkedList {
//    private class Node {
//        Node next;
//        Node prev;
//        int element;
//
//        Node(int element) {
//            this.next = null;
//            this.prev = null;
//            this.element = element;
//        }
//    }
//
//    private Node head;
//    private Node tail;
//    private int size;
//
//    public DoublyLinkedList() {
//        this.head = null;
//        this.tail = null;
//        this.size = 0;
//    }
//
//    public void addFirst(int element) {
//        if (this.head == null) {
//            this.addLast(element);
//        } else {
//            Node newNode = new Node(element);
//            newNode.next = head;
//            this.head.prev = newNode;
//            this.head = newNode;
//            this.size++;
//        }
//    }
//
//    public void addLast(int element) {
//        Node newNode = new Node(element);
//
//        if (this.head == null) {
//            this.head = this.tail = newNode;
//        } else {
//            this.tail.next = newNode;
//            newNode.prev = this.tail;
//            this.tail = newNode;
//        }
//        this.size++;
//
//    }
//
//    public int removeFirst() {
//        if (this.size == 0) {
//            throw new IndexOutOfBoundsException("Invalid remove from empty collection");
//        }
//
//        int value = this.head.element;
//
//        this.head = this.head.next;
//        this.head.prev = null;
//        this.size--;
//
//        return value;
//    }
//
//    public int removeLast() {
//
//    }
//
//    public int get(int index) {
//        if (index < 0 || index >= this.size) {
//            throw new IndexOutOfBoundsException(
//                    "Invalid index for value of " + index +
//                            " Collection size " + this.size
//            );
//        }
//        int counter = 0;
//
//        int value = 0;
//
//        Node currentNode = this.head;
//
//        while (currentNode != null) {
//            if (counter == index) {
//                value = currentNode.element;
//                break;
//            }
//            currentNode = currentNode.next;
//            counter++;
//        }
//
//        return value;
//    }
//
//    private void checkSize(int size) {
//        if (this.size == 0) {
//            throw new IndexOutOfBoundsException("Invalid remove from empty collection");
//
//        }
//    }
//}
