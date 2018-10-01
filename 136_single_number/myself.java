class Solution {
  // Simple way: Use extra space
  // TC: O(n) because HashSet's set/get operations are O(1)
  // SC: O(n) because HashSet's maximum size is n/2 - 1
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        set.remove(nums[i]);
      } else {
        set.add(nums[i]);
      }
    }

    // This for-statement loops only once
    for (int num : set) {
      return num;
    }

    // Just to avoid compile error
    return -1;
  }
}
