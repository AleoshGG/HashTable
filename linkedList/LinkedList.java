package linkedList;

public class LinkedList {
    private int count;
    private Node head;

    public LinkedList() {
        this.count = 0;
        this.head = null;
    }

    public void push(Object data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node current = this.head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        this.count++;
    }

    public Object getAt(int index) {
        if (index >= 0 && index < this.count) {
            Node node = this.head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.getNext();
            }
            return node.getData();
        }
        return null;
    }

    public boolean isEmpty() {
        if (this.head != null) {
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        return this.count;
    }
}
