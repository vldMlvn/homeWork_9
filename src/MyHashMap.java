public class MyHashMap {

    private Node[] buckets;
    private int size;

    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        buckets = new Node[16];
        size = 0;
    }

    public void put(Object key, Object value) {
        int hash = hash(key);
        Node node = buckets[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value, buckets[hash]);
        buckets[hash] = newNode;
        size++;
    }

    public Object get(Object key) {
        int hash = hash(key);
        Node node = buckets[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(Object key) {
        int hash = hash(key);
        Node node = buckets[hash];
        Node prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    buckets[hash] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public void clear() {
        buckets = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }
}
