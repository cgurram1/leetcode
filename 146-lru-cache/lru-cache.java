class LRUCache {
    public int capacityG;
    public Map<Integer, Node> map = new HashMap<>();
    public Node head;
    public Node tail;
    class Node{
        int val;
        int key;
        Node next;
        Node prev;
        public Node(){
            this.next = null;
            this.prev = null;
            this.val = 0;
        }
    }

    public LRUCache(int capacity) {
        this.capacityG = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            add(map.get(key));
            return map.get(key).val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node currNode = map.get(key);
            currNode.val = value;
            remove(map.get(key));
            add(map.get(key));
        }
        else{
            if(capacityG == 0){
                map.remove(tail.prev.key);
                remove(tail.prev);
                capacityG+=1;
            }
            Node newNode = new Node();
            newNode.val = value;
            newNode.key = key;
            map.put(key, newNode);
            add(newNode);
            capacityG-=1;
        }
    }
    public void add(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */