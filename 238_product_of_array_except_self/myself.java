class Solution {
  /**
   * Straitforward way: Use extra space for indices with zero
   * TC: O(n)
   * SC: O(n)
   */
  public int[] productExceptSelf(int[] nums) {
    int[] answer = new int[nums.length];
    int x = 1;
    Set<Integer> zeroNumIndices = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroNumIndices.add(i);
      } else {
        x *= nums[i];
      }
    }

    if (zeroNumIndices.size() == 0) {
      for (int i = 0; i < nums.length; i++) {
        answer[i] = x / nums[i];
      }
    } else if (zeroNumIndices.size() == 1) {
      for (int i = 0; i < nums.length; i++) {
        if (zeroNumIndices.contains(i)) {
          answer[i] = x;
        } else {
          answer[i] = 0;
        }
      }
    } else {
      // do nothing
    }

    return answer;
  }
}
