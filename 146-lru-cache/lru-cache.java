class LRUCache {
    public int capG;
    public Map<Integer,Node> map;
    public Node head;
    public Node tail;
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int k, int v){
            this.key = k;
            this.value = v;
            this.next = null;
            this.prev = null;
        }
    }
    public LRUCache(int capacity) {
        capG = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            // update the LinkedList
            deleteFromLinkedList(map.get(key));
            addToLinkedList(map.get(key));
            return map.get(key).value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            map.put(key,node);
            // update the LinkedList
            deleteFromLinkedList(node);
            addToLinkedList(node);
        }
        else{
            if(capG == 0){
                deleteLeastRecentlyUsedNode();
                capG+=1;
            }
            Node node = new Node(key,value);
            map.put(key,node);
            //update the LinkedList
            addToLinkedList(node);
            capG-=1;
        }
    }
    public void addToLinkedList(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev = head;
    }
    public void deleteFromLinkedList(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void deleteLeastRecentlyUsedNode(){
        Node nodeToDelete = tail.prev;
        map.remove(nodeToDelete.key);
        deleteFromLinkedList(nodeToDelete);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */