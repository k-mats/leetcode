/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// This solution passes 18/18 test cases, but TLE occurs
class LRUCache {
  Map<Integer, LRUInteger> map = new HashMap<>();
  int capacity = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  // O(n) because of `growOld`
  public int get(int key) {
    if (map.containsKey(key)) {
      growOld(key);
      return map.get(key).getValue();
    } else {
      return -1;
    }
  }

  // O(n) because of `findOldestKey` and `growOld`
  public void put(int key, int value) {
    if (map.containsKey(key)) {
      // Case of updating value
      map.get(key).setValue(value);
    } else {
      // Case of inserting value
      if (map.size() >= capacity) {
        int oldestKey = findOldestKey();
        map.remove(oldestKey);
      }
      LRUInteger lruInteger = new LRUInteger(value);
      map.put(key, lruInteger);
    }
    growOld(key);
  }

  // O(n)
  private void growOld(int usedKey) {
    for (int key : map.keySet()) {
      LRUInteger lruInteger = map.get(key);
      if (key == usedKey) {
        lruInteger.resetAge();
      } else {
        lruInteger.growOld();
      }
    }
  }

  // O(n)
  private int findOldestKey() {
    int oldestKey = -1;
    int oldestAge = -1;

    for (int key : map.keySet()) {
      LRUInteger lruInteger = map.get(key);
      if (lruInteger.getAge() > oldestAge) {
        oldestAge = lruInteger.getAge();
        oldestKey = key;
      }
    }

    return oldestKey;
  }
}

class LRUInteger {
  private int value = 0;
  private int age = 0;

  public LRUInteger(int value) {
    this.value = value;
    age = 0;
  }

  public void growOld() {
    age++;
  }

  public void resetAge() {
    age = 0;
  }

  public int getAge() {
    return age;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
