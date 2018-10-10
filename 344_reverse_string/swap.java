class Solution {
  /**
   * Simple way; TC: O(n), SC: O(n)
   */
  public String reverseString(String s) {
    if (s == null || s.length() == 1) return s;

    int length = s.length();
    char[] array = s.toCharArray();
    for (int i = 0; i < length / 2; i++) {
      int rightIndex = length - 1 - i;
      char l = array[i];
      char r = array[rightIndex];
      array[i] = r;
      array[rightIndex] = l;
    }

    return new String(array);
  }
}
