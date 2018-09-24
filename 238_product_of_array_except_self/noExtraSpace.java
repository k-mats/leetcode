class Solution {
  /**
   * Tricky way without extra space
   * TC: O(n)
   * SC: O(1)
   */
  public int[] productExceptSelf(int[] nums) {
    int[] answer = new int[nums.length];
    // L: 1 -> n0 -> n0 * n1 -> n0 * n1 * n2
    int l = 1;
    answer[0] = l;
    for (int i = 1; i < nums.length; i++) {
      l *= nums[i - 1];
      answer[i] = l;
    }

    // R: n1 * n2 * n3 <- n2 * n3 <- n3 <- 1
    int r = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      r *= nums[i + 1];
      answer[i] *= r;
    }

    return answer;
  }
}
