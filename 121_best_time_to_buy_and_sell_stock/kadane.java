class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int[] diffs = new int[prices.length];
    diffs[0] = 0;
    for (int i = 1; i < prices.length; i++) {
      diffs[i] = prices[i] - prices[i - 1];
    }

    // Find maximum subarray by Kadane's algorithm
    int currentMax = 0;
    int maxSoFar = 0;
    for (int i = 1; i < prices.length; i++) {
      currentMax = Math.max(0, currentMax + diffs[i]);
      maxSoFar = Math.max(maxSoFar, currentMax);
    }

    return maxSoFar;
  }
}
