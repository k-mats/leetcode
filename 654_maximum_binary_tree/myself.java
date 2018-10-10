/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 0) {
      return null;
    }
    int maxIndex = findMaxIndex(nums);
    TreeNode root = new TreeNode(nums[maxIndex]);

    int[] leftNums = new int[maxIndex];
    int[] rightNums = new int[nums.length - (maxIndex + 1)];
    for (int i = 0; i < nums.length; i++) {
      if (i < maxIndex) {
        leftNums[i] = nums[i];
      } else if (i > maxIndex) {
        rightNums[i - (maxIndex + 1)] = nums[i];
      }
    }
    TreeNode leftNode = constructMaximumBinaryTree(leftNums);
    TreeNode rightNode = constructMaximumBinaryTree(rightNums);
    root.left = leftNode;
    root.right = rightNode;

    return root;
  }

  private int findMaxIndex(int[] nums) {
    int maxNum = Integer.MIN_VALUE;
    int maxIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > maxNum) {
        maxNum = nums[i];
        maxIndex = i;
      }
    }

    return maxIndex;
  }
}
