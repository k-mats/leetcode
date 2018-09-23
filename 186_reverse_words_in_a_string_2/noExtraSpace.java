class Solution {
  /**
   * No extra space
   * TC: O(nm), where m is the maximum length of words
   * SC: O(1)
   */
  public void reverseWords(char[] str) {
    if (str.length < 2) {
      return;
    }

    // Exceptional case: Do nothing if there is only one word
    boolean foundWhiteSpace = false;
    for (int i = 0; i < str.length; i++) {
      if (str[i] == ' ') {
        foundWhiteSpace = true;
        break;
      }
    }
    if (!foundWhiteSpace) {
      return;
    }

    // 1. Reverse the whole string
    reverse(str, 0, str.length - 1);

    // 2. Reverse each word
    int startIndex = 0;
    int endIndex = 0;
    while (endIndex <= str.length) {
      if (endIndex == str.length || str[endIndex] == ' ') {
        reverse(str, startIndex, endIndex - 1);
        startIndex = endIndex + 1;
        endIndex = startIndex + 1;
      } else {
        endIndex++;
      }
    }
  }

  private void reverse(char[] str, int start, int end) {
    while (start < end) {
      char tmp = str[start];
      str[start] = str[end];
      str[end] = tmp;
      start++;
      end--;
    }
  }
}
