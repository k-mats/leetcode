class Solution {
  public int maxSubArray(int[] nums) {
    // Exceptional case: Every num is negative or zero
    int maxNonPos = Integer.MIN_VALUE;
    boolean foundPosNum = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        foundPosNum = true;
        break;
      }
      if (nums[i] > maxNonPos) {
        maxNonPos = nums[i];
      }
    }
    if (!foundPosNum) {
      return maxNonPos;
    }

    // Kadane's algorithm
    int sum = 0;
    int maxSum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = Math.max(0, sum + nums[i]);
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }
}
