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
  Set<Integer> memo = new HashSet<>();

  /**
   * TC: O(n), SC: O(n)
   * If you traverse all nodes then put into memo first, the code becomes simpler
   */
  public boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      int wanted = k - node.val;
      if (wanted != node.val && findWanted(root, wanted)) {
        return true;
      }
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }

    return false;
  }

  private boolean findWanted(TreeNode root, int wanted) {
    if (memo.contains(wanted)) {
      return true;
    }

    TreeNode current = root;
    while (current != null) {
      memo.add(current.val);
      if (current.val == wanted) {
        return true;
      } else if (current.val > wanted) {
        current = current.left;
      } else {
        current = current.right;
      }
    }

    return false;
  }
}
