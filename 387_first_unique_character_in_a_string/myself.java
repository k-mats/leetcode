class Solution {
  /**
   * Simple but not efficient
   * TC: O(n^2), SC: O(1)
   */
  public int firstUniqChar(String s) {
    for (int i = 0; i < s.length(); i++) {
      boolean found = false;
      for (int j = 0; j < s.length(); j++) {
        if (i != j && s.charAt(i) == s.charAt(j)) {
          found = true;
          break;
        }
      }
      if (!found) {
        return i;
      }
    }
    return -1;
  }
}
