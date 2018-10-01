/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
  int capacity;
  DoublyLinkedList list = new DoublyLinkedList();
  // Make the get operation fast
  Map<Integer, DoublyLinkedNode> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  // O(1)
  public int get(int key) {
    if (map.containsKey(key)) {
      DoublyLinkedNode node = map.get(key);
      list.moveToHead(node);
      return node.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      // Update existing node
      DoublyLinkedNode node = map.get(key);
      node.value = value;
      list.moveToHead(node);
    } else {
      DoublyLinkedNode node = new DoublyLinkedNode(key, value);
      map.put(key, node);
      list.addToHead(node);
      if (map.size() > capacity) {
        DoublyLinkedNode tail = list.popTail();
        map.remove(tail.key);
      }
    }
  }
}

class DoublyLinkedNode {
  int key;
  int value;
  DoublyLinkedNode prev;
  DoublyLinkedNode next;

  public DoublyLinkedNode(int key, int value) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

class DoublyLinkedList {
  // sentinel nodes
  DoublyLinkedNode head;
  DoublyLinkedNode tail;

  public DoublyLinkedList() {
    head = new DoublyLinkedNode(0, 0);
    tail = new DoublyLinkedNode(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  // Always add nodes to head in LRU
  public void addToHead(DoublyLinkedNode node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }

  public void remove(DoublyLinkedNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  // If the key/value is used, update it as "most recently used"
  public void moveToHead(DoublyLinkedNode node) {
    remove(node);
    addToHead(node);
  }

  // Remove least recently used node
  public DoublyLinkedNode popTail() {
    DoublyLinkedNode popped = tail.prev;
    remove(popped);
    return popped;
  }
}
