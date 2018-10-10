class Solution {
  /**
   * Simple way; TC: O(n), SC: O(n)
   */
  public String reverseString(String s) {
    if (s == null) return null;
    int l = s.length();
    char[] reversed = new char[l];
    for (int i = 0; i < l; i++) {
      reversed[i] = s.charAt(l - 1 - i);
    }
    return new String(reversed);
  }
}
