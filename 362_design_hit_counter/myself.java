/**
 * We can execute `getHits(timestamp)` with any timestamp.
 */
class HitCounter {
  Map<Integer, Integer> counter;

  /** Initialize your data structure here. */
  public HitCounter() {
    counter = new HashMap<>();
  }

  /** Record a hit.
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    for (int t = timestamp; t < timestamp + 300; t++) {
      if (counter.containsKey(t)) {
        int count = counter.get(t);
        counter.put(t, count + 1);
      } else {
        counter.put(t, 1);
      }
    }
  }

  /** Return the number of hits in the past 5 minutes.
  * @param timestamp - The current timestamp (in seconds granularity).
  */
  public int getHits(int timestamp) {
    if (counter.containsKey(timestamp)) {
      return counter.get(timestamp);
    } else {
      return 0;
    }
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
