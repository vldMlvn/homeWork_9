public class MyLinkedList{
    private Node head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    private class Node {
        private Object value;
        private Node next;
        private Node prev;

        public Node(Object value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }
    public void add(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            newNode.prev = lastNode;
        }
        size++;
    }
    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            if (currentNode.next != null) {
                currentNode.next.prev = currentNode.prev;
            }
        }
        size--;
    }
    public void clear() {
        head = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }
}
