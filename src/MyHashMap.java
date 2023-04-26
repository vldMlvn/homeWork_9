public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size;
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public MyHashMap() {
        buckets = new Node[16];
        size = 0;
    }
    public void put(K key, V value) {
        int hash = hash(key);
        Node<K, V> node = buckets[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node(key, value, buckets[hash]);
        buckets[hash] = newNode;
        size++;
    }
    public V get(K key) {
        int hash = hash(key);
        Node<K, V> node = buckets[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public void remove(K key) {
        int hash = hash(key);
        Node<K, V> node = buckets[hash];
        Node<K, V> prev = null;
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
    private int hash(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }
}
