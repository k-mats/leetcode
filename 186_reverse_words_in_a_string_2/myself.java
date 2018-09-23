class Solution {

  /**
   * Simple way with extra space `reverse`
   * TC: O(n^2)
   * SC: O(n)
   */
  public void reverseWords(char[] str) {
    if (str.length < 2) {
      return;
    }

    char[] reverse = new char[str.length];
    for (int i = 0; i < str.length; i++) {
      reverse[i] = ' ';
    }

    int startIndex = 0;
    int endIndex = 1;
    while (endIndex <= str.length) {
      if (endIndex == str.length || str[endIndex] == ' ') {
        // Copy word to reverse
        for (int i = startIndex; i < endIndex; i++) {
          reverse[str.length - endIndex + (i - startIndex)] = str[i];
        }
        startIndex = endIndex + 1;
        endIndex = startIndex + 1;
      } else {
        endIndex++;
      }
    }

    // Update str by reverse
    for (int i = 0; i < str.length; i++) {
      str[i] = reverse[i];
    }
  }
}
