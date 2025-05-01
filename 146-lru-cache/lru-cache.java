import java.util.*;

class LRUCache {
    class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int cap;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int value = node.value;
        updateLL(key);
        return value;
    }

    public void updateLL(int key) {
        Node node = map.get(key);
        if (node == head) return;

        // 1) Unlink node from its current spot
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        // if it was the tail, move tail back one
        if (node == tail) {
            tail = node.prev;
        }

        // 2) Insert node at the head
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        // if list was empty before, tail should point here too
        if (tail == null) {
            tail = node;
        }
    }

    public void updateHead(int key) {
        Node node = map.get(key);
        // same insert logic as above
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    public void removeTail() {
        if (tail == null) return;

        // remove from map first
        map.remove(tail.key);

        // unlink the tail node
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            // it was the only node
            head = null;
            tail = null;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateLL(key);
        } else {
            if (map.size() >= cap) {
                removeTail();
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            updateHead(key);
        }
    }
}
