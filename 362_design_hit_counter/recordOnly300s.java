/**
 * Record only 300 second old records
 */
class HitCounter {
  int[] count;
  int[] times;

  /** Initialize your data structure here. */
  public HitCounter() {
     count = new int[300];
     times = new int[300];
  }

  /** Record a hit.
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    int index = timestamp % 300;
    if (times[index] != timestamp) {
      times[index] = timestamp;
      count[index] = 1;
    } else {
      count[index]++;
    }
  }

  /** Return the number of hits in the past 5 minutes.
  * @param timestamp - The current timestamp (in seconds granularity).
  */
  public int getHits(int timestamp) {
    int total = 0;
    for (int i = 0; i < 300; i++) {
      if (timestamp - times[i] < 300) {
        total += count[i];
      }
    }
    return total;
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
