class Solution {
  // No extra space
  // TC: O(n)
  // SC: O(1)
  public int singleNumber(int[] nums) {
    int answer = 0;
    for (int i = 0; i < nums.length; i++) {
      answer ^= nums[i];
    }
    return answer;
  }
}
