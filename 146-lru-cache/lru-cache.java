class LRUCache {
    public int capacity;
    public DoublyLinkedList tail;
    public DoublyLinkedList head;
    public Map<Integer, DoublyLinkedList> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.tail = new DoublyLinkedList(-1,-1);
        this.head = new DoublyLinkedList(-1,-1);
        tail.prev = head;
        tail.next = null;
        head.prev = null;
        head.next = tail;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            this.removeNode(map.get(key));
            this.addNode(map.get(key));
            return map.get(key).value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            this.removeNode(map.get(key));
            this.addNode(map.get(key));
            map.get(key).value = value;
            map.put(key, map.get(key));
        }
        else{
            if(map.size() == capacity){
                DoublyLinkedList nodeToRemove = tail.prev;
                this.removeNode(nodeToRemove);
                map.remove(nodeToRemove.key);
            }
            DoublyLinkedList nodeToAdd = new DoublyLinkedList(key,value);
            this.addNode(nodeToAdd);
            map.put(key,nodeToAdd);
        }
    }
    public void removeNode(DoublyLinkedList curr){
        DoublyLinkedList prev = curr.prev;
        DoublyLinkedList next = curr.next;
        prev.next = next;
        next.prev = prev;
    }
    public void addNode(DoublyLinkedList curr){
        DoublyLinkedList prev = head;
        DoublyLinkedList next = head.next;
        curr.next = next;
        prev.next = curr;
        next.prev = curr;
        curr.prev = prev;
    }
}
class DoublyLinkedList{
    public int key;
    public int value;
    public DoublyLinkedList next;
    public DoublyLinkedList prev;
    public DoublyLinkedList(int key, int value){
        this.key = key;
        this.value = value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */