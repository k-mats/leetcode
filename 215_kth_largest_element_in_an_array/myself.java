import java.util.Arrays;

class Solution {
  /**
   * Use the a built-in sort method
   * Time: O(n*logn)
   * Space: O(1)
   */
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  /**
   * Use PriorityQueue to maintain a sorted list
   * Time: O(n*logk)
   * Space: O(k)
   */
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int n : nums) {
      pq.offer(n);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();
  }
}
