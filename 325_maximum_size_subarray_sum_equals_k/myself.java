class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    /**
     * Simple way; TC: O(n^2), SC: O(1)
     */
     int answer = 0;
     for (int i = 0; i < nums.length; i++) {
       int sum = 0;
       for (int j = i; j < nums.length; j++) {
         sum += nums[j];
         if (sum == k && j - i + 1 > answer) {
           answer = j - i + 1;
         }
       }
     }
     return answer;
   }
 }
