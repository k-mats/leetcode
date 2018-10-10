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
    public int closestValue(TreeNode root, double target) {
      int answer = root.val;
      double diff = Math.abs((double)root.val - target);
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        TreeNode treeNode = queue.poll();
        double newDiff = Math.abs((double)treeNode.val - target);
        if (newDiff < diff) {
          diff = newDiff;
          answer = treeNode.val;
        }

        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        if (left != null) {
          queue.add(left);
        }
        if (right != null) {
          queue.add(right);
        }
      }

      return answer;
    }
}
