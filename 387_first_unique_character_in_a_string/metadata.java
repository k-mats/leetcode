class Solution {
  /**
   * Record metadata
   * TC: O(n), SC: O(n)
   */
  public int firstUniqChar(String s) {
    Map<Character, MetaData> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        MetaData metaData = map.get(c);
        metaData.incrementCount();
        map.put(c, metaData);
      } else {
        MetaData metaData = new MetaData(c, i);
        map.put(c, metaData);
      }
    }

    int minIndex = Integer.MAX_VALUE;
    for (char c : map.keySet()) {
      MetaData metaData = map.get(c);
      if (metaData.count == 1 && metaData.firstIndex < minIndex) {
        minIndex = metaData.firstIndex;
      }
    }

    if (minIndex == Integer.MAX_VALUE) {
      return -1;
    } else {
      return minIndex;
    }
  }
}

class MetaData {
  char character;
  int firstIndex;
  int count;

  public MetaData(char character, int firstIndex) {
    this.character = character;
    this.firstIndex = firstIndex;
    count = 1;
  }

  public void incrementCount() {
    count++;
  }
}
